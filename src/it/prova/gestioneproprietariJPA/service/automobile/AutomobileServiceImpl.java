package it.prova.gestioneproprietariJPA.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDAO;

	@Override
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;
	}

	@Override
	public List<Automobile> listAllAutomobili() throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			automobileDAO.setEntityManager(entityManager);

			return automobileDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			automobileDAO.setEntityManager(entityManager);

			return automobileDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			automobileDAO.setEntityManager(entityManager);

			automobileDAO.update(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			automobileDAO.setEntityManager(entityManager);

			automobileDAO.insert(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			automobileDAO.setEntityManager(entityManager);

			automobileDAO.delete(automobileDAO.get(idAutomobileInstance));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Automobile> cercaTutteLeAutomobiliTramiteInizialeCodiceFiscaleProprietario(String inizialeCodiceFiscale)
			throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			automobileDAO.setEntityManager(entityManager);

			return automobileDAO.findAllByCodiceFiscaleProprietarioIniziaCon(inizialeCodiceFiscale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Automobile> cercaErroriProprietariAutomobiliMinorenni() throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			automobileDAO.setEntityManager(entityManager);

			return automobileDAO.findAllErroriProprietariAutomobiliMinorenni();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

}
