package org.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
// pour l'heritage dans la meme table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// le nom de la colomn et le type
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 4)
@SuppressWarnings("serial")
public class Compte implements Serializable {

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	// compte apprtient a 1 client
	@ManyToOne
	@JoinColumn(name = "CODE_CLI")
	private Client client;
	// le compte a creer par un employer
	@ManyToOne
	@JoinColumn(name = "CODE_EMP")
	private Employer employer;
	// un compte peut sebir plusieur operations
	@OneToMany(mappedBy = "compte")
	private Collection<Operation> operations;

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public Compte() {
		super();
	}

	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}

}