package org.gestion.banque.wTest;

import org.gestion.banque.entities.Client;
import org.gestion.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		IBanqueMetier metir=(IBanqueMetier) context.getBean("metier");
		metir.addClient(new Client("C1", "ADD 1"));
		metir.addClient(new Client("C2", "ADD 1"));
	}

}
