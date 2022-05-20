package it.prova.gestioneproprietariJPA.service.proprietario;

import java.util.Date;
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
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
	}

	@Override
	public int contaQuantiProprietariConAutomobileImmatricolataDal(Date dataImmatricolazione) throws Exception {

		return 0;
	}

}