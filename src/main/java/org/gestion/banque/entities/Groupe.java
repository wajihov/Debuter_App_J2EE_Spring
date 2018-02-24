package org.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@SuppressWarnings("serial")
public class Groupe implements Serializable {

	@Id
	@GeneratedValue
	private Long codeGroupe;
	private String nomGroupe;
	// un groupe contient plusieur employer
	@ManyToMany(mappedBy = "groupes")
	private Collection<Employer> employers;

	public Long getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Collection<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(Collection<Employer> employers) {
		this.employers = employers;
	}

	public Groupe() {
		super();
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

}