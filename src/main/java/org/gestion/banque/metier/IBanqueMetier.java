package org.gestion.banque.metier;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;

public interface IBanqueMetier {

	public Client addClient(Client c);

	public Compte addCompte(Compte cp);
}