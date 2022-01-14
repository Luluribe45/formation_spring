package com.cours.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cours.entities.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

	List<Personne> findByPrenom(String prenom);

	List<Personne> findByNom(String nom);

	List<Personne> findByPrenomAndNom(String prenom, String nom);

	List<Personne> findByPrenomOrNom(String prenom, String nom);

	List<Personne> findByCodePostal(String codePostal);

	List<Personne> findByVille(String ville);

	List<Personne> findByPays(String pays);
}