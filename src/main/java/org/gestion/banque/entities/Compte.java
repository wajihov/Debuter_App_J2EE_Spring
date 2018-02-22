package org.gestion.banque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Compte implements Serializable {

	@Id
	private String codeCompte;
	private String adresseCompte;

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public String getAdresseCompte() {
		return adresseCompte;
	}

	public void setAdresseCompte(String adresseCompte) {
		this.adresseCompte = adresseCompte;
	}

	public Compte() {
		super();
	}

	public Compte(String codeCompte, String adresseCompte) {
		super();
		this.codeCompte = codeCompte;
		this.adresseCompte = adresseCompte;
	}

}
