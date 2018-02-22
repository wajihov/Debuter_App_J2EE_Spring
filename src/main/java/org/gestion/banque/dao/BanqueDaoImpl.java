package org.gestion.banque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;

public class BanqueDaoImpl implements IBanqueDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Compte addCompte(Compte cp) {
		em.persist(cp);
		return cp;
	}

}
