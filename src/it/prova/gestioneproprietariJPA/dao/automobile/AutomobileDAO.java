package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {

	public List<Automobile> findAllByCodiceFiscaleProprietariIniziaCon(String codiceFiscale) throws Exception;
	
	public List<Automobile> findAllByErroreProprietariMinorenni() throws Exception;
	
}
