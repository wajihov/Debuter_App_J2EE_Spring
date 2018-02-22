package org.gestion.banque.dao;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;

public interface IBanqueDao {
	
	public Client addClient(Client c);
	public Compte addCompte(Compte cp); 

}
