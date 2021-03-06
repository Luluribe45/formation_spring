package com.cours.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cours.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

}
