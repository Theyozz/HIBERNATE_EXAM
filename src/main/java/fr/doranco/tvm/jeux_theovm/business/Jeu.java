package fr.doranco.tvm.jeux_theovm.business;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Jeu {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime dateHeureEnvoi;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime dateHeureReponse;
	
	@ManyToOne
	protected Eleve eleve;
	
	public Jeu() {
		dateHeureEnvoi = LocalDateTime.now();
	}
	
}
