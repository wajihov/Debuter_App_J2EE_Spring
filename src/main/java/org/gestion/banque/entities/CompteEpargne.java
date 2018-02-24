package org.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
@SuppressWarnings("serial")
public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne(String codeCompte, Date dateCreation, double solde, double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}