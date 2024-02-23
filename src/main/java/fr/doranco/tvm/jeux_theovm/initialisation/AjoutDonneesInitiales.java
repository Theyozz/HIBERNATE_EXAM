package fr.doranco.tvm.jeux_theovm.initialisation;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import fr.doranco.tvm.jeux_theovm.business.Categorie;
import fr.doranco.tvm.jeux_theovm.business.Eleve;
import fr.doranco.tvm.jeux_theovm.business.Groupe;
import fr.doranco.tvm.jeux_theovm.business.Jeu;
import fr.doranco.tvm.jeux_theovm.business.Multiplication;
import fr.doranco.tvm.jeux_theovm.business.Niveau;
import fr.doranco.tvm.jeux_theovm.business.Question;
import fr.doranco.tvm.jeux_theovm.business.Quiz;
import fr.doranco.tvm.jeux_theovm.dao.CategorieDao;
import fr.doranco.tvm.jeux_theovm.dao.EleveDao;
import fr.doranco.tvm.jeux_theovm.dao.GroupeDao;
import fr.doranco.tvm.jeux_theovm.dao.JeuDao;
import fr.doranco.tvm.jeux_theovm.dao.NiveauDao;
import fr.doranco.tvm.jeux_theovm.dao.QuestionDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {
	
	private CategorieDao categorieDao;
	private EleveDao eleveDao;
	private GroupeDao groupeDao;
	private JeuDao jeuDao;
	private NiveauDao niveauDao;
	private QuestionDao questionDao;

	private static Random random = new Random();
	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"),new RandomService());
	private static Faker faker = new Faker(new Locale("fr-FR"));
	
	@Override
	public void run(String... args) throws Exception {
		ajouterCategorie();
		ajouterGroupe();
		ajouterQuestion();
		ajouterNiveau();
		ajouterEleves();
		ajouterJeux();
	}
	
	private void ajouterCategorie() {
		if(categorieDao.count() == 0) {
			categorieDao.save(new Categorie("Catégorie 1"));
			categorieDao.save(new Categorie("Catégorie 2"));
			categorieDao.save(new Categorie("Catégorie 3"));
			categorieDao.save(new Categorie("Catégorie 4"));
		}
	}
	
	private void ajouterGroupe() {
		if(groupeDao.count() == 0) {
			groupeDao.save(new Groupe(faker.educator().course(),faker.lorem().sentence()));
			groupeDao.save(new Groupe(faker.educator().course(),faker.lorem().sentence()));
			groupeDao.save(new Groupe(faker.educator().course(),faker.lorem().sentence()));
			groupeDao.save(new Groupe(faker.educator().course(),faker.lorem().sentence()));
		}
	}
	
	private void ajouterQuestion() {
		if(questionDao.count() == 0) {
			List<Categorie> categories = categorieDao.findAll();
			for (int i = 0; i < 10; i++) {
                Question question = new Question();
                question.setBonneReponse(faker.lorem().sentence());
                question.setLibelle(faker.lorem().sentence());
                question.setCategorie(categories.get(random.nextInt(categories.size())));
                questionDao.save(question);
            }
		}
	}
	
	private void ajouterNiveau() {
		if(niveauDao.count() == 0) {
			niveauDao.save(new Niveau("CP"));
			niveauDao.save(new Niveau("CE1"));
			niveauDao.save(new Niveau("CE2"));
			niveauDao.save(new Niveau("CM1"));
			niveauDao.save(new Niveau("CM2"));
		}
	}
	
	private void ajouterEleves() {
		if(eleveDao.count() == 0) {
			List<Niveau> niveaux = niveauDao.findAll();
			List<Groupe> groupes = groupeDao.findAll();
			for(int i = 0; i < 50; i++) {
				Eleve eleve = new Eleve();
				eleve.setNom(faker.name().lastName());
				eleve.setPrenom(faker.name().firstName());
				eleve.setEmail(faker.internet().emailAddress());
				eleve.setMotDePasse(faker.internet().password(4, 12));
		        int year = random.nextInt(10) + 2008;
		        int month = random.nextInt(12) + 1;
		        int day = random.nextInt(28) + 1;
				eleve.setDateDeNaissance(LocalDate.of(year, month, day));
				eleve.setNiveau(niveaux.get(random.nextInt(niveaux.size())));
				eleve.setGroupes(groupes);
				eleveDao.save(eleve);
			}
		}
	}
	
	private void ajouterJeux() {
		if(jeuDao.count() == 0) {
			List<Eleve> eleves = eleveDao.findAll();
			List<Question> questions = questionDao.findAll();
			for(int i = 0; i < 25; i++) {
		        int num1 = faker.number().numberBetween(1, 10);
		        int num2 = faker.number().numberBetween(1, 10);		        
		        int resultat = num1 * num2;
		        
		        
		        Jeu jeu = new Multiplication(num1,num2,resultat);
		        jeu.setEleve(eleves.get(random.nextInt(eleves.size())));
		        jeuDao.save(jeu);
			}
			for(int i = 0; i < 25; i++) {
		        Jeu jeu = new Quiz("reponse",questions.get(random.nextInt(questions.size())));
		        jeu.setEleve(eleves.get(random.nextInt(eleves.size())));
		        jeuDao.save(jeu);
			}
		}
	}

}
