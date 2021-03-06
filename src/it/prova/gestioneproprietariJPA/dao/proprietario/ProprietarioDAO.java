package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.Date;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {

	public Long countProprietariConAutomobileImmatricolataDal(int annoImmatricolazione) throws Exception;

}