package org.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class Employer implements Serializable {

	@Id
	@GeneratedValue
	private Long codeEmployer;
	private String nomEmployer;
	@ManyToOne
	@JoinColumn(name = "CODE_EMP_SUP")
	private Employer employerSup;
	// un employer appartient a plusieurs groupes
	@ManyToMany()
	// on peut ne pas mettre les parametres et le hibernate fait seulement par
	// defaut
	@JoinTable(name = "EMP_GR", joinColumns = @JoinColumn(name = "CODE_EMP"), inverseJoinColumns = @JoinColumn(name = "CODE_GR"))
	private Collection<Groupe> groupes;

	public Long getCodeEmployer() {
		return codeEmployer;
	}

	public void setCodeEmployer(Long codeEmployer) {
		this.codeEmployer = codeEmployer;
	}

	public String getNomEmployer() {
		return nomEmployer;
	}

	public void setNomEmployer(String nomEmployer) {
		this.nomEmployer = nomEmployer;
	}

	public Employer getEmployerSup() {
		return employerSup;
	}

	public void setEmployerSup(Employer employerSup) {
		this.employerSup = employerSup;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Employer() {
		super();
	}

	public Employer(String nomEmployer) {
		super();
		this.nomEmployer = nomEmployer;
	}

	public Employer(String nomEmployer, Employer employerSup) {
		super();
		this.nomEmployer = nomEmployer;
		this.employerSup = employerSup;
	}

}