package org.gestion.banque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.gestion.banque.entities.Compte;
import org.gestion.banque.entities.Operation;
import org.gestion.banque.metier.IBanqueMetier;
import org.gestion.banque.model.BanqueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("banqueForm", new BanqueForm());
		return "banque";
	}

	@RequestMapping(value = "/chargerCompte")
	public String charger(@Valid BanqueForm bf, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "banque";
		}
		chargerCompte(bf);
		model.addAttribute("banqueForm", bf);
		return "banque";
	}

	@RequestMapping(value = "/saveOperation")
	public String saveOp(@Valid BanqueForm bf, BindingResult bindingResult) {
		chargerCompte(bf);
		if (bindingResult.hasErrors()) {
			return "banque";
		}

		try {
			if (bf.getAction() != null) {
				if (bf.getTypeOperation().equals("VER")) {
					metier.verser(bf.getMontant(), bf.getCodeCompte(), 1L);
				} else if (bf.getTypeOperation().equals("RET")) {
					metier.retirer(bf.getMontant(), bf.getCodeCompte(), 1L);
				} else if (bf.getTypeOperation().equals("VIR")) {
					metier.virement(bf.getMontant(), bf.getCodeCompte(), bf.getCode2(), 1L);
				}
			}
			chargerCompte(bf);
		} catch (Exception e) {
			bf.setErreurExeption(e.getMessage());
		}

		return "banque";
	}

	public void chargerCompte(BanqueForm bf) {

		try {
			Compte cp;
			cp = metier.consulterCompte(bf.getCodeCompte());
			// cp.getClass().getSimpleName() retourne automatiquement le nom de la classe
			// Compte courant ou compte Epargne
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);

			int pos = bf.getNbrLigne() * bf.getPage();

			List<Operation> ops = metier.consulterOperation(bf.getCodeCompte(), pos, bf.getNbrLigne());
			bf.setOperations(ops);

			Long nbOperation = metier.getNbreOperation(bf.getCodeCompte());
			bf.setNbrePage((int) (nbOperation / bf.getNbrLigne()) + 1);

		} catch (Exception e) {
			bf.setErreurExeption(e.getMessage());
		}
	}
}