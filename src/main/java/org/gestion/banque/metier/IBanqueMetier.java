package org.gestion.banque.metier;

import java.util.List;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employer;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;

public interface IBanqueMetier {

	public Client addClient(Client c);

	public Employer addEmployer(Employer emp, Long codeSup);

	public Groupe addGroupe(Groupe gr);

	public void addEmployerToGroupe(Long codeEmp, Long codeGroup);

	public Compte addCompte(Compte cp, Long codeClient, Long codeEmpl);

	public void verser(double mt, String cpt, Long codeEmp);

	public void retirer(double mt, String cpt, Long codeEmp);

	public void virement(double mt, String cpt1, String cpt2, Long codeEmp);

	public Compte consulterCompte(String codeCpte);

	public List<Operation> consulterOperation(String codeCompte, int position, int nbOp);

	public Client consulterClient(Long codeClient);

	public List<Client> consulterClients(String mc);

	public List<Compte> getComptesByClient(Long codeClt);

	public List<Compte> getComptesByEmployer(Long codeEmp);

	public List<Employer> getEmployes();

	public List<Groupe> getGroupes();

	public List<Employer> getEmployerByGroupe(Long codeGr);
	
	public long getNbreOperation(String numCompte);
}