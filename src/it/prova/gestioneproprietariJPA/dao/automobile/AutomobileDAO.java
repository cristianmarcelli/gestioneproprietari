package it.prova.gestioneproprietariJPA.dao.automobile;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {

	public List<Automobile> findAllByCodiceFiscaleProprietarioIniziaCon(String inizialeCodiceFiscale) throws Exception;

	public List<Automobile> findAllErroriProprietariAutomobiliMinorenni() throws Exception;
}
