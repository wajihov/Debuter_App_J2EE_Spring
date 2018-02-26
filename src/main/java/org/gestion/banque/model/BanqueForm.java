package org.gestion.banque.model;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Operation;
import org.hibernate.validator.constraints.NotEmpty;

public class BanqueForm {

	@NotEmpty
	@Size(min = 2, max = 10)
	private String codeCompte;
	private Compte compte;
	private String typeCompte;
	private String erreurExeption;
	private List<Operation> operations;
	private String typeOperation;
	@DecimalMin(value = "50")
	private double montant = 50;
	@NotEmpty
	@Size(min = 2, max = 10)
	private String code2 = "XXX";
	private String action;

	private int page = 0;
	private int nbrLigne = 5;
	private int nbrePage;

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getErreurExeption() {
		return erreurExeption;
	}

	public void setErreurExeption(String erreurExeption) {
		this.erreurExeption = erreurExeption;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbrLigne() {
		return nbrLigne;
	}

	public void setNbrLigne(int nbrLigne) {
		this.nbrLigne = nbrLigne;
	}

	public int getNbrePage() {
		return nbrePage;
	}

	public void setNbrePage(int nbrePage) {
		this.nbrePage = nbrePage;
	}

}