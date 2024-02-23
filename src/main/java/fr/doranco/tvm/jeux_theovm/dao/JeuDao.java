package fr.doranco.tvm.jeux_theovm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.doranco.tvm.jeux_theovm.business.Jeu;

public interface JeuDao extends JpaRepository<Jeu, Long> {

}
