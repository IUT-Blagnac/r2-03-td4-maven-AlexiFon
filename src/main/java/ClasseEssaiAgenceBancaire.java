package main;

import tps.banque.Compte;
import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteNullException;
import tps.banque.AgenceBancaire;

public class ClasseEssaiAgenceBancaire {
	public static void main(String[] argv) throws Exception{
		AgenceBancaire monAg;
		monAg= new AgenceBancaire("CaisseAlex","Lacaune");
		monAg.afficher();
		Compte cUn;
		Compte cDeux;
		Compte cTrois;
		cUn= new Compte("0101", "prop1");
		cDeux= new Compte("0202", "prop2");
		cTrois= new Compte("0303", "prop2");
		try {
			monAg.addCompte(cUn);
			monAg.addCompte(cDeux);
			monAg.addCompte(cTrois);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		monAg.afficher();
		/*if (monAg.getCompte("9999")==null) {
			System.out.print("Pas de compte trouvé");
		}else {
			System.out.print("Compte trouvé");
		}*/
		Compte c = monAg.getCompte("0101");
		if (c != null) {
		    c.afficher();
		    c.deposer (1000);  // modifier le compte référencé par c (deposer 1000€)
		    c.afficher();
		}
		//
		c = monAg.getCompte("0101");
		if (c != null) {
		    c.afficher();
		}
		Compte[] Comptes=monAg.getComptesDe("Absent");
		Compte test;
		/*if (Comptes.length != 0) {
			for(int i=0; i<Comptes.length;i++) {
				test=Comptes[i];
				test.afficher();
			}
		}else {
			System.out.print("Pas de compte trouvé");		
			}*/
		cDeux.deposer(2000);
		cTrois.deposer(3000);
		if (Comptes.length != 0) {
			for(int i=0; i<Comptes.length;i++) {
				test=Comptes[i];
				test.afficher();
			}
		}
		else {
			System.out.println("Pas de compte trouvé");		
		}
		try {
			c = null;
			monAg.addCompte(c);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		
		monAg.removeCompte("0202");
		//monAg.removeCompte("9999");
		
		Compte cQuatre;
		cQuatre = new Compte("0101","prop99");
		monAg.addCompte(cQuatre);

		// 14) Ca a joute l'argent au compte cDeux et a cTrois
		// 16) Cela me renvoit Erreur ajout Compte 'null' dans l'agence CaisseAlex (Lacaune) car on ne peut pas rentrer de compte sans nom de propriétaire ou numéro
		// 19) cela me renvoit une erreur car le compte 0101 existe deja

	}
}
