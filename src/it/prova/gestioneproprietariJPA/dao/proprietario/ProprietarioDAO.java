package it.prova.gestioneproprietariJPA.dao.proprietario;

import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietariJPA.dao.IBaseDAO;
import it.prova.gestioneproprietariJPA.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {

	public List<Proprietario> contaQuantiProprietariConAutomobileImmatricolataDal(Date dataImmatricolazione)
			throws Exception;
}
