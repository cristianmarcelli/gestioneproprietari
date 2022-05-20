package it.prova.gestioneproprietariJPA.service.proprietario;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {

	private ProprietarioDAO proprietarioDAO;

	@Override
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}

	@Override
	public List<Proprietario> listAllProprietari() throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			proprietarioDAO.setEntityManager(entityManager);

			return proprietarioDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
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
	public int contaQuantiProprietariConAutomobileImmatricolataDal(Date dataImmatricolazione) throws Exception {

		return 0;
	}

}