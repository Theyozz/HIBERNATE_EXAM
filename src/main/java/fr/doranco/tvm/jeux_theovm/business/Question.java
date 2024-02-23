package fr.doranco.tvm.jeux_theovm.business;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Question {
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String libelle;
	
	@Column(nullable = false, length = 255)
	private String bonneReponse;
	
	@ManyToOne
	private Categorie categorie;
	
	@OneToMany(mappedBy= "question")
	private List<Quiz> quizes;

}
