package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {
	
	public List<Automobile> findAllByMarca(String marca) throws Exception;
	
	public List<Automobile> findAllByModello(String modello) throws Exception;

	public List<Automobile> findAllByCodiceFiscaleProprietarioIniziaCon(String codiceFiscale) throws Exception;
	
}
