package fr.doranco.tvm.jeux_theovm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.doranco.tvm.jeux_theovm.business.Niveau;

public interface NiveauDao extends JpaRepository<Niveau, Long> {

}
