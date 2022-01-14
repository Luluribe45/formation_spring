package com.cours.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cours.entities.Personne;
import com.cours.repository.PersonneRepository;

@Service("personneService")
public class PersonneService implements IPersonneService {

	private static final Log log = LogFactory.getLog(PersonneService.class);
	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}

	@Override
	public Personne createOrUpdate(Personne person) {
		return personneRepository.save(person);
	}

	@Override
	public boolean delete(Personne person) {
		personneRepository.delete(person);
		return !personneRepository.findById(person.getIdPersonne()).isPresent();
	}

	@Override
	public Optional<Personne> findById(Integer id) {
		return personneRepository.findById(id);
	}

	@Override
	public List<Personne> findByPrenom(String prenom) {
		return personneRepository.findByPrenom(prenom);
	}

	@Override
	public List<Personne> findByNom(String nom) {
		return personneRepository.findByNom(nom);
	}

	@Override
	public List<Personne> findByPrenomNom(String prenom, String nom) {
		return personneRepository.findByPrenomAndNom(prenom, nom);
	}

	@Override
	public List<Personne> findByCodePostal(String codePostal) {
		return personneRepository.findByCodePostal(codePostal);
	}

	@Override
	public List<Personne> findByVille(String ville) {
		return personneRepository.findByVille(ville);
	}

	@Override
	public List<Personne> findByPays(String pays) {
		return personneRepository.findByPays(pays);
	}

	@Override
	public Double getMoyennePoids(List<Personne> persons) {
		Double moyenne = 0.0;
		Double somme = 0.0;
		int compteur = 0;
		if (persons != null && persons.size() > 0) {
			for (Personne oneElement : persons) {
				somme += oneElement.getPoids();
				compteur++;
			}
			if (compteur > 0) {
				moyenne = somme / compteur;
			}
		}
		log.debug("moyenne : " + moyenne);
		return moyenne;
	}

	@Override
	public Double getEcartTypePoids(List<Personne> persons, Double moyenne) {
		Double carres = 0.0;
		Double ecartType = 0.0;
		int compteur = 0;
		if (persons != null && persons.size() > 0) {
			for (Personne oneElement : persons) {
				carres += Math.pow(oneElement.getPoids() - moyenne, 2);
				compteur++;
			}
		}
		if (compteur > 0) {
			ecartType = Math.sqrt(carres / compteur);
		}
		log.debug("ecartType : " + ecartType);
		return ecartType;
	}

}