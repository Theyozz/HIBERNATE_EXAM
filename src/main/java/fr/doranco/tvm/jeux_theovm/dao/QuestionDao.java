package fr.doranco.tvm.jeux_theovm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.doranco.tvm.jeux_theovm.business.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {
	
	

}
