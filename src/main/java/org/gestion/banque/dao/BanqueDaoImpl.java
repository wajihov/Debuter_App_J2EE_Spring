package org.gestion.banque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Employer;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.entities.Operation;

public class BanqueDaoImpl implements IBanqueDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Employer addEmployer(Employer emp, Long codeSup) {
		if (codeSup != null) {
			Employer sup = em.find(Employer.class, codeSup);
			emp.setEmployerSup(sup);
		}
		em.persist(emp);
		return emp;
	}

	@Override
	public Groupe addGroupe(Groupe gr) {
		em.persist(gr);
		return gr;
	}

	@Override
	public void addEmployerToGroupe(Long codeEmp, Long codeGroup) {
		Employer emp = em.find(Employer.class, codeEmp);
		Groupe groupe = em.find(Groupe.class, codeGroup);
		emp.getGroupes().add(groupe);
		groupe.getEmployers().add(emp);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeClient, Long codeEmpl) {
		Client client = em.find(Client.class, codeEmpl);
		Employer employer = em.find(Employer.class, codeEmpl);
		cp.setClient(client);
		cp.setEmployer(employer);
		em.persist(cp);
		return cp;
	}

	@Override
	public Operation addOpeartion(Operation op, String codeCpte, Long codeEmpl) {
		Compte cp = consulterCompte(codeCpte);
		Employer employer = em.find(Employer.class, codeEmpl);
		op.setCompte(cp);
		op.setEmployer(employer);
		em.persist(op);
		return op;
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte compte = em.find(Compte.class, codeCpte);
		if (compte == null)
			throw new RuntimeException("Compte inexistent");
		return compte;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> consulterOperation(String compte) {
		Query query = em.createQuery("select o from Operation o where o.compte.codeCompte=:x");
		query.setParameter("x", compte);
		return query.getResultList();
	}

	@Override
	public Client consulterClient(Long codeClient) {
		Client client = em.find(Client.class, codeClient);
		if (client == null)
			throw new RuntimeException("Client Inexistent");
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> consulterClients(String mc) {
		Query query = em.createQuery("select c from Client c where c.nomClient like :x");
		query.setParameter("x", "%" + mc + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getComptesByClient(Long codeClt) {
		Query query = em.createQuery("select c from Compte c where c.client.codeClient = :x");
		query.setParameter("x", codeClt);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getComptesByEmployer(Long codeEmp) {
		Query query = em.createQuery("select c from Compte c where c.employer.codeEmployer = :x");
		query.setParameter("x", codeEmp);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employer> getEmployes() {
		Query query = em.createQuery("select e from Employer e");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> getGroupes() {
		Query query = em.createQuery("select g from Groupe g");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employer> getEmployerByGroupe(Long codeGr) {
		Query query = em.createQuery("select e from Employer e where e.groupes.codeGroupe = :x");
		query.setParameter("x", codeGr);
		return query.getResultList();
	}

}