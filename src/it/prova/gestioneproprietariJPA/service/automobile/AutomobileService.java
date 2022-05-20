package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public interface AutomobileService {

	public List<Automobile> listAllAutomobili() throws Exception;

	public Automobile caricaSingolaAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;

	public List<Automobile> cercaTutteLeAutomobiliTramiteCodiceFiscaleProprietario(String codiceFiscale)
			throws Exception;

	public List<Automobile> cercaErroriProprietariAutomobiliMinorenni() throws Exception;

	// per injection
	public void setAutomobileDAO(AutomobileDAO automobileDAO);

}