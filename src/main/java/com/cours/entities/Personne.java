/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ElHadji
 */
@Entity
@Table(name = "Personne")
@XmlRootElement
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idPersonne")
	private Integer idPersonne;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "poids")
	private Double poids;
	@Column(name = "taille")
	private Double taille;
	@Column(name = "rue")
	private String rue;
	@Column(name = "codePostal")
	private String codePostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "pays")
	private String pays;
	@Column(name = "version")
	private Integer version;

	public Personne() {
	}

	public Personne(String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal,
			String pays) {
		this.prenom = prenom;
		this.nom = nom;
		this.poids = poids;
		this.taille = taille;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Personne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue,
			String ville, String codePostal, String pays) {
		this.idPersonne = idPersonne;
		this.prenom = prenom;
		this.nom = nom;
		this.poids = poids;
		this.taille = taille;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Personne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public Double getTaille() {
		return taille;
	}

	public void setTaille(Double taille) {
		this.taille = taille;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPersonne != null ? idPersonne.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Personne)) {
			return false;
		}
		Personne other = (Personne) object;
		if ((this.idPersonne == null && other.idPersonne != null)
				|| (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"[idPersonne=%s, prenom=%s, nom=%s, poids=%s, taille=%s, rue=%s, codePostal=%s , ville=%s,  pays=%s, version=%s]",
				idPersonne, prenom, nom, poids, taille, rue, codePostal, ville, pays, version);
	}
}
