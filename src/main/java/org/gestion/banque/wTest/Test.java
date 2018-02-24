package org.gestion.banque.wTest;

import java.util.Date;

import org.gestion.banque.entities.Client;
import org.gestion.banque.entities.CompteCourant;
import org.gestion.banque.entities.CompteEpargne;
import org.gestion.banque.entities.Employer;
import org.gestion.banque.entities.Groupe;
import org.gestion.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		IBanqueMetier metir=(IBanqueMetier) context.getBean("metier");
		metir.addClient(new Client("C1", "ADD 1"));
		metir.addClient(new Client("C2", "ADD 2"));
		metir.addClient(new Client("C3", "ADD 3"));
		metir.addEmployer(new Employer("EMP 1"), null);
		metir.addEmployer(new Employer("EMP 2"), 1L);
		metir.addEmployer(new Employer("EMP 3"), 2L);
		metir.addEmployer(new Employer("EMP 4"), 1L);
		metir.addGroupe(new Groupe("Gr 1"));
		metir.addGroupe(new Groupe("Gr 2"));
		metir.addEmployerToGroupe(1L, 1L);
		metir.addEmployerToGroupe(2L, 2L);
		metir.addEmployerToGroupe(3L, 1L);
		
		metir.addCompte(new CompteCourant("CC1", new Date(), 1500, 8000), 1L, 2L);
		metir.addCompte(new CompteEpargne("CE2", new Date(), 1800, 5.5), 2L, 1L);
		
		metir.verser(1500, "CC1", 1L);
		metir.retirer(50, "CE2", 3L);
		
		metir.virement(50, "CC1", "CE2", 2L);
		
	}

}
