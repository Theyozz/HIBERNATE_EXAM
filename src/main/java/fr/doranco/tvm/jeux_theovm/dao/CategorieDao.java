package fr.doranco.tvm.jeux_theovm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.doranco.tvm.jeux_theovm.business.Categorie;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

}
