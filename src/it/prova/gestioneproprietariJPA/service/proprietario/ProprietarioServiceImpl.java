package it.prova.gestioneproprietariJPA.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {

	@Override
	public List<Proprietario> listAllProprietari() throws Exception {

		return null;
	}

	@Override
	public Proprietario caricaSingoloProprietario(Long id) throws Exception {

		return null;
	}

	@Override
	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
	}

	@Override
	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
	}

	@Override
	public void rimuovi(Long idProprietarioInstance) throws Exception {
	}

	@Override
	public List<Proprietario> cercaTuttiIProprietariConNome(String nome) throws Exception {

		return null;
	}

	@Override
	public List<Proprietario> cercaTuttiIProprietariConCognome(String cognome) throws Exception {

		return null;
	}

	@Override
	public List<Proprietario> cercaTuttiIProprietariConTargaAutomobileIniziaCon(String targa) throws Exception {

		return null;
	}

	@Override
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
	}

}