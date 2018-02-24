package org.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
@SuppressWarnings("serial")
public class Versement extends Operation {

	public Versement() {
		super();
	}

	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
	}

}