package fr.doranco.tvm.jeux_theovm.business;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Quiz extends Jeu{

	private String reponseQuestion;
	
	@ManyToOne
	private Question question;
	
	public Quiz(String reponseQuestion, Question question) {
		this.reponseQuestion = reponseQuestion;
		this.question = question;
	}
	
}
