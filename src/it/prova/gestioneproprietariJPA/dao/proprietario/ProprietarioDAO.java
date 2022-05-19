package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {

	public List<Proprietario> findAllByNome(String nome) throws Exception;

	public List<Proprietario> findAllByCognome(String cognome) throws Exception;

	public List<Proprietario> findAllByTargaAutomobileIniziaCon(String targa) throws Exception;
}