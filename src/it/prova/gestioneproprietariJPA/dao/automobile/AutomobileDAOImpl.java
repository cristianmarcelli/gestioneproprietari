package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietariJPA.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	@Override
	public List<Automobile> list() throws Exception {
		
		return null;
	}

	@Override
	public Automobile get(Long id) throws Exception {
		
		return null;
	}

	@Override
	public void update(Automobile o) throws Exception {
	}

	@Override
	public void insert(Automobile o) throws Exception {
	}

	@Override
	public void delete(Automobile o) throws Exception {
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
	}

	@Override
	public List<Automobile> findAllByCodiceFiscaleProprietariIniziaCon(String codiceFiscale) throws Exception {
		
		return null;
	}

	@Override
	public List<Automobile> findAllByErroreProprietariMinorenni() throws Exception {
		
		return null;
	}


}
