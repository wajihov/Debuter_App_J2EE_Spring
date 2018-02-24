package org.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "R")
@SuppressWarnings("serial")
public class Retrait extends Operation {

	public Retrait() {
		super();
	}

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
	}

}