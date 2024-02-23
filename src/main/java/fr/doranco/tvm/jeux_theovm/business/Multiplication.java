package fr.doranco.tvm.jeux_theovm.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Multiplication extends Jeu{

	@Column(length = 255)
	private int nombre1;
	
	@Column(length = 255)
	private int nombre2;

	@Column(length = 255)
	private int reponse;
	
	public Multiplication(int nombre1, int nombre2, int reponse) {
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.reponse = reponse;
	}
}
