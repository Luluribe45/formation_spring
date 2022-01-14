package com.cours.service;

import java.util.List;
import java.util.Optional;

import com.cours.entities.Personne;

/**
 *
 * @author El hadji
 */
public interface IPersonneService {

	public List<Personne> findAll();

	public Personne createOrUpdate(Personne person);

	boolean delete(Personne person);

	public Optional<Personne> findById(Integer id);

	public List<Personne> findByPrenom(String prenom);

	public List<Personne> findByNom(String nom);

	public List<Personne> findByPrenomNom(String prenom, String nom);

	public List<Personne> findByCodePostal(String codePostal);

	public List<Personne> findByVille(String ville);

	public List<Personne> findByPays(String pays);

	public Double getMoyennePoids(List<Personne> persons);

	public Double getEcartTypePoids(List<Personne> persons, Double moyenne);
}
