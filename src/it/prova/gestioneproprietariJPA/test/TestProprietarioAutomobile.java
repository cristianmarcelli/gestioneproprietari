package it.prova.gestioneproprietariJPA.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.model.Automobile;
import it.prova.gestioneproprietariJPA.model.Proprietario;
import it.prova.gestioneproprietariJPA.service.MyServiceFactory;
import it.prova.gestioneproprietariJPA.service.automobile.AutomobileService;
import it.prova.gestioneproprietariJPA.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {
	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioDAOInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileDAOInstance();

		try {

			// TEST METODI AUTOMOBILE
			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

			testInserisciAutomobile(proprietarioService, automobileService);
			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

			// STAMPO LA LISTA DELLE AUTOMOBILI PER VEDERE SE è STAT INSERITA CON IL METODO
			// PRECEDENTE
			System.out.println(automobileService.listAllAutomobili());

			testRimozioneAutomobile(proprietarioService, automobileService);
			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

			testAggiornaAutomobile(proprietarioService, automobileService);
			System.out.println(automobileService.listAllAutomobili());

			testCercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario(proprietarioService, automobileService);

			testCercaErroriProprietariAutomobiliMinorenni(proprietarioService, automobileService);

			// TEST METODI PROPRIETARIO
			System.out.println("In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size()
					+ " elementi.");

			testInserisciProprietario(proprietarioService);
			System.out.println(proprietarioService.listAllProprietari());

			testRimozioneProprietario(proprietarioService);
			System.out.println(proprietarioService.listAllProprietari());

			testAggiornaProprietario(proprietarioService);
			System.out.println(proprietarioService.listAllProprietari());

			testContaQuantiProprietariConAutomobileImmatricolataDal(proprietarioService, automobileService);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

	// TEST METODI AUTOMOBILE
	private static void testInserisciAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");

		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException("testInserisciAutomobile fallito: non ci sono proprietari a cui collegarci ");

		Automobile nuovaAutomobile = new Automobile("Nissan", "Micra", "JM676AE", 2021);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente ");

		automobileService.inserisciNuovo(nuovaAutomobile);
		nuovaAutomobile.setProprietario(listaProprietariPresenti.get(0));

		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}

	private static void testRimozioneAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testRimozioneAutomobile inizio.............");

		List<Proprietario> listaProprietarioiPresenti = proprietarioService.listAllProprietari();
		if (listaProprietarioiPresenti.isEmpty())
			throw new RuntimeException("testRimozioneAutomobile fallito: non ci sono automobili a cui collegarci ");

		Automobile nuovaAutomobile = new Automobile("Ferrari", "G50", "MH729HN", 2008);

		nuovaAutomobile.setProprietario(listaProprietarioiPresenti.get(0));

		automobileService.inserisciNuovo(nuovaAutomobile);

		Long idAAutomobileInserito = nuovaAutomobile.getId();
		automobileService.rimuovi(idAAutomobileInserito);

		if (automobileService.caricaSingolaAutomobile(idAAutomobileInserito) != null)
			throw new RuntimeException("testRimozioneAutomobile fallito: record non cancellato ");
		System.out.println(".......testRimozioneAutomobile fine: PASSED.............");
	}

	private static void testAggiornaAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testAggiornaAutomobile inizio.............");

		List<Automobile> listaAutomobiliiPresenti = automobileService.listAllAutomobili();

		Automobile automobileDaAggiornare = listaAutomobiliiPresenti.get(0);
		automobileDaAggiornare.setTarga("JJ999JJ");

		automobileService.aggiorna(automobileDaAggiornare);

		System.out.println(".......testAggiornaAutomobile fine.............");
	}

	private static void testCercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario(
			ProprietarioService proprietarioService, AutomobileService automobileService) throws Exception {
		System.out.println(
				".......testCercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario inizio.............");

		System.out.println(automobileService.cercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario("GRN"));

		System.out
				.println(".......testCercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario fine.............");
	}

	private static void testCercaErroriProprietariAutomobiliMinorenni(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testCercaErroriProprietariAutomobiliMinorenni inizio.............");

		System.out.println(automobileService.cercaErroriProprietariAutomobiliMinorenni());

		System.out.println(".......testCercaErroriProprietariAutomobiliMinorenni fine.............");

	}

	// TEST METODI PROPRIETARIO
	private static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testInserisciProprietario inizio.............");

		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("17-05-1970");

		Proprietario nuovoProprietario = new Proprietario("Franco", "Marietti", "FRNMRT", dataNascita);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		proprietarioService.inserisciNuovo(nuovoProprietario);

		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}

	private static void testRimozioneProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testRimozioneProprietario inizio.............");

		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("17-05-1956");

		Proprietario nuovoProprietario = new Proprietario("Andrea", "Corsetti", "ANDCRS", dataNascita);

		proprietarioService.inserisciNuovo(nuovoProprietario);

		Long idProprietarioInserito = nuovoProprietario.getId();
		proprietarioService.rimuovi(idProprietarioInserito);

		if (proprietarioService.caricaSingoloProprietario(idProprietarioInserito) != null)
			throw new RuntimeException("testRimozioneProprietario fallito: record non cancellato ");
		System.out.println(".......testRimozioneProprietario fine: PASSED.............");
	}

	private static void testAggiornaProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testAggiornaProprietario inizio.............");

		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();

		Proprietario proprietarioDaAggiornare = listaProprietariPresenti.get(0);
		proprietarioDaAggiornare.setNome("Alberto");

		proprietarioService.aggiorna(proprietarioDaAggiornare);

		System.out.println(".......testAggiornaProprietario fine.............");
	}

	private static void testContaQuantiProprietariConAutomobileImmatricolataDal(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testContaQuantiProprietariConAutomobileImmatricolataDal inizio.............");

		System.out.println(proprietarioService.contaQuantiProprietariConAutomobileImmatricolataDal(1980));

		System.out.println(".......testContaQuantiProprietariConAutomobileImmatricolataDal fine.............");
	}

}