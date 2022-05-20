package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietariJPA.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore in input");
		}
		automobileInstance = entityManager.merge(automobileInstance);
	}

	@Override
	public void insert(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(automobileInstance);
	}

	@Override
	public void delete(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(automobileInstance));
	}

	@Override
	public List<Automobile> findAllByCodiceFiscaleProprietarioIniziaCon(String inizialeCodiceFiscale) throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery(
				"select distinct a from Automobile a join a.proprietario p where codiceFiscale like ?1",
				Automobile.class);
		return query.setParameter(1, inizialeCodiceFiscale + "%").getResultList();
	}

	@Override
	public List<Automobile> findAllErroriProprietariAutomobiliMinorenni() throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery(
				"select distinct a from Automobile a join a.proprietario p where p.dataNascita > '2004-01-01'",
				Automobile.class);
		return query.getResultList();
	}

}
