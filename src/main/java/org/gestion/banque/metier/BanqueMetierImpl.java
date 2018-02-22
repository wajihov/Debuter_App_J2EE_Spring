package org.gestion.banque.metier;

import org.gestion.banque.dao.IBanqueDao;
import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IBanqueDao dao;

	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Compte addCompte(Compte cp) {
		return dao.addCompte(cp);
	}

}