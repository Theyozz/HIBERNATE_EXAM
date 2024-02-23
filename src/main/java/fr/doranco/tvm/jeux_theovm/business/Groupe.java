package fr.doranco.tvm.jeux_theovm.business;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nom;
	
	@Column(nullable = false, length = 255)
	private String description;
	
	@ManyToMany
	private List<Eleve> eleves;
	
	public Groupe(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
}
