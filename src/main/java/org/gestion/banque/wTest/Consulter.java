package org.gestion.banque.wTest;

import java.util.List;

import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Operation;
import org.gestion.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consulter {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");

		Compte cp = metier.consulterCompte("CC1");
		System.out.println("le solde est : " + cp.getSolde());
		System.out.println("le date est : " + cp.getDateCreation());
		System.out.println("le client est : " + cp.getClient().getNomClient());
		System.out.println("l'employer est : " + cp.getEmployer().getNomEmployer());

		List<Operation> ops = metier.consulterOperation("CC1", 0, 5);
		for (Operation op : ops) {
			System.out.println("**********");
			System.out.println(op.getNumOperation());
			System.out.println(op.getDateOperation());
			System.out.println(op.getMontant());
			System.out.println(op.getEmployer().getNomEmployer());
			System.out.println(op.getClass().getSimpleName());// le nom de la classe
		}

	}

}
