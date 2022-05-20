package it.prova.gestioneproprietariJPA.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.model.Automobile;
import it.prova.gestioneproprietariJPA.service.MyServiceFactory;
import it.prova.gestioneproprietariJPA.service.automobile.AutomobileService;
import it.prova.gestioneproprietariJPA.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {
	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioDAOInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileDAOInstance();

		try {

			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

			System.out.println("In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size()
					+ " elementi.");

			testInserisciAutomobile(proprietarioService, automobileService);
			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");
			
			//STAMPO LA LISTA DELLE AUTOMOBILI PER VEDERE SE è STAT INSERITA CON IL METODO PRECEDENTE
			System.out.println(automobileService.listAllAutomobili());

//			testRimozioneAutomobile(proprietarioService, automobileService);
//			System.out.println(
//					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

	private static void testInserisciAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");
		
		Automobile nuovaAutomobile = new Automobile("Nissan", "Micra", "JM676AE", 2021);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente ");

		automobileService.inserisciNuovo(nuovaAutomobile);

		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}

}