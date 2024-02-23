package fr.doranco.tvm.jeux_theovm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.doranco.tvm.jeux_theovm.business.Eleve;

public interface EleveDao extends JpaRepository<Eleve, Long> {

	//@Query("""
	//		FROM Eleve
	//		WHERE dateDeNaissance >= 2016-01-01 AND dateDeNaissance < 2017-01-01
	//		""")
	//List<Eleve> findAllElevesBornIn2016();

	@Query(value = """
			FROM Eleve
			WHERE nom like '%s'
			""")
	List<Eleve> findAllElevesNameStartingWithS();

	//@Query(value = """
	//		FROM Eleve
	//		ORDER BY groupes
	//		""")
	//List<Eleve> sortEleveByGroup();
	
	@Query("""
	        SELECT niveau, COUNT(*) as nombreEleves
	        FROM Eleve
	        GROUP BY niveau
	        """)
	List<Eleve> countElevesByNiveau();
	
	//@Query("""
	//        FROM Eleve
	//        WHERE date_heure_inscription >= 2013-01-01 AND date_heure_inscription < 2014-01-01
	//        """)
	//List<Eleve> findElevesInscribedIn2023();
	
}
