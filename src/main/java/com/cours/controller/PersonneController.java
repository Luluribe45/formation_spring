package com.cours.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cours.entities.Personne;
import com.cours.service.IPersonneService;

@RestController
@RequestMapping("/api")
public class PersonneController {

	@Autowired
	private IPersonneService personneService;

	@GetMapping
	public List<Personne> findAll() {
		return personneService.findAll();
	}

	@GetMapping("/{id}")
	public Personne findById(@PathVariable Integer id) {
		return personneService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"La Personne id = " + id + " est introuvable."));
	}

	@GetMapping("/findByPrenom")
	public List<Personne> findByPrenom(@RequestParam String prenom) {
		List<Personne> personnes = personneService.findByPrenom(prenom);
		System.out.println("personnes : " + personnes);
		if (personnes == null || personnes.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucune Personne avec prenom = " + prenom + " n'a été trouvé.");
		}
		return personnes;
	}

	@GetMapping("/findByNom")
	public List<Personne> findByNom(@RequestParam String nom) {
		List<Personne> personnes = personneService.findByNom(nom);

		System.out.println("personnes : " + personnes);
		if (personnes == null || personnes.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucune Personne avec nom = " + nom + " n'a été trouvé.");
		}
		return personnes;
	}

	@GetMapping("/authenticate")
	public Personne authenticate(@RequestParam String prenom, @RequestParam String nom) {
		Personne person = null;
		List<Personne> personnes = personneService.findByPrenomNom(prenom, nom);
		System.out.println("personnes : " + personnes);
		if (personnes == null || personnes.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Aucune Personne avec prenom = " + prenom + " , " + "nom = " + nom + " n'a été trouvé.");
		} else if (personnes != null) {
			person = personnes.get(0);
		}
		System.out.println("person : " + person);
		return person;
	}

	@PostMapping
	public ResponseEntity<Personne> create(@RequestBody Personne person) {
		return createOrUpdate(person);
	}

	@PutMapping
	public ResponseEntity<Personne> update(@RequestBody Personne person) {
		return createOrUpdate(person);
	}

	public ResponseEntity<Personne> createOrUpdate(@RequestBody Personne person) {
		ResponseEntity<Personne> responseEntity = null;
		System.out.println("Param person : " + person);
		Personne requestPersonne = person;
		try {
			person = personneService.createOrUpdate(person);
			System.out.println("Created person : " + person);
			if (person == null) {
				throw new ResponseStatusException(HttpStatus.NO_CONTENT,
						"La création ou mise à jour de la Personne person = " + requestPersonne
								+ " a déclanché une erreur.");
			} else {
				responseEntity = new ResponseEntity<Personne>(person, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			System.out.println("e : " + e);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,
					"La création ou mise à jour de la Personne person = " + requestPersonne
							+ " a déclanché une erreur.");
		}

		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		try {
			Personne person = personneService.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"La Personne id = " + id + " est introuvable."));
			personneService.delete(person);
		} catch (Exception e) {
			System.out.println("e : " + e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La suppression de la Personne id = " + id
					+ " a déclanché un erreur, Exception : " + e.getMessage());
		}
		return ResponseEntity.ok("La suppression de la Personne id = " + id + " a reussi");
	}
}