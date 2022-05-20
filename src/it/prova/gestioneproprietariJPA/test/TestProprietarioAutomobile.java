package it.prova.gestioneproprietariJPA.test;

import it.prova.gestioneproprietariJPA.dao.EntityManagerUtil;
import it.prova.gestioneproprietariJPA.service.MyServiceFactory;
import it.prova.gestioneproprietariJPA.service.automobile.AutomobileService;
import it.prova.gestioneproprietariJPA.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {
	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioDAOInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileDAOInstance();

		try {

			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

}