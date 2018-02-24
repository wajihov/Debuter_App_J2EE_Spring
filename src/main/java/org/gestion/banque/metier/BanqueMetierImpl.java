package org.gestion.banque.metier;

import java.util.Date;
import java.util.List;

import org.gestion.banque.dao.IBanqueDao;
import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employer;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;
import org.gestion.banque.entities.Retrait;
import org.gestion.banque.entities.Versement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IBanqueDao dao;

	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Employer addEmployer(Employer emp, Long codeSup) {
		return dao.addEmployer(emp, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe gr) {
		return dao.addGroupe(gr);
	}

	@Override
	public void addEmployerToGroupe(Long codeEmp, Long codeGroup) {
		dao.addEmployerToGroupe(codeEmp, codeGroup);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeClient, Long codeEmpl) {
		return dao.addCompte(cp, codeClient, codeEmpl);
	}

	@Override
	public void verser(double mt, String cpt, Long codeEmp) {
		dao.addOpeartion(new Versement(new Date(), mt), cpt, codeEmp);
		Compte compte = dao.consulterCompte(cpt);
		compte.setSolde(compte.getSolde() + mt);
	}

	@Override
	public void retirer(double mt, String cpt, Long codeEmp) {
		dao.addOpeartion(new Retrait(new Date(), mt), cpt, codeEmp);
		Compte compte = dao.consulterCompte(cpt);
		compte.setSolde(compte.getSolde() - mt);
	}

	@Override
	public void virement(double mt, String cpt1, String cpt2, Long codeEmp) {
		retirer(mt, cpt1, codeEmp);
		verser(mt, cpt2, codeEmp);
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperation(String compte) {
		return dao.consulterOperation(compte);
	}

	@Override
	public Client consulterClient(Long codeClient) {
		return dao.consulterClient(codeClient);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeClt) {
		return dao.getComptesByClient(codeClt);
	}

	@Override
	public List<Compte> getComptesByEmployer(Long codeEmp) {
		return dao.getComptesByEmployer(codeEmp);
	}

	@Override
	public List<Employer> getEmployes() {
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		return dao.getGroupes();
	}

	@Override
	public List<Employer> getEmployerByGroupe(Long codeGr) {
		return dao.getEmployerByGroupe(codeGr);
	}

}