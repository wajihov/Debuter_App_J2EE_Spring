package org.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
@SuppressWarnings("serial")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeClient;
	@Column(name = "NOM_CLIENT", length = 80)
	private String nomClient;
	@Column(name = "Asresse_CLIENT", length = 80)
	private String adresseClient;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client() {
		super();
	}

	public Client(String nomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}

}