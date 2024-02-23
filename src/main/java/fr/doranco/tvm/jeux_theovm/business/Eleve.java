package fr.doranco.tvm.jeux_theovm.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Eleve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nom;
	
	@Column(nullable = false, length = 50)
	private String prenom;
	
	@Column(nullable = false)
	//@PastOrPresent(message="\"La date de naissance doit être aujourd’’hui ou dans\n"+ "le passé")
	private LocalDate dateDeNaissance;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateHeureInscription;
	
	@Email(message = "Le format d'adresse n'est pas valide")
	@Column(unique = true, nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false, length = 128)
	@Size(min = 4, message = "Le mot de passe doit contenir au minimum 4 caractères")
	//@Pattern(regexp = ".*[A-Z].*", message = "Le mot de passe doit contenir au moins une majuscule")
	private String motDePasse;
	
	@ManyToOne
	private Niveau niveau;
	
	@ManyToMany(mappedBy="eleves")
	private List<Groupe> groupes;
	
	public Eleve() {
		dateHeureInscription = LocalDateTime.now();
	}
}
