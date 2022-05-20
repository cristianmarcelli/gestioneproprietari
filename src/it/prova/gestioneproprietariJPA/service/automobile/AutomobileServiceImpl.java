package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	@Override
	public List<Automobile> listAllAutomobili() throws Exception {

		return null;
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {

		return null;
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
	}

	@Override
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
	}

	@Override
	public List<Automobile> cercaTutteLeAutomobiliTramiteCodiceFiscaleProprietario(String codiceFiscale)
			throws Exception {

		return null;
	}

	@Override
	public List<Automobile> cercaErroriProprietariAutomobiliMinorenni() throws Exception {

		return null;
	}

}
