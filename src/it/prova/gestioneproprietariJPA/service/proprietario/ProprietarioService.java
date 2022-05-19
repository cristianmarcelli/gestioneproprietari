package it.prova.gestioneproprietariJPA.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public interface ProprietarioService {

	public List<Proprietario> listAllProprietari() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Long idProprietarioInstance) throws Exception;

	public List<Proprietario> cercaTuttiIProprietariConNome(String nome) throws Exception;

	public List<Proprietario> cercaTuttiIProprietariConCognome(String cognome) throws Exception;

	public List<Proprietario> cercaTuttiIProprietariConTargaAutomobileIniziaCon(String targa) throws Exception;

	// per injection
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

}