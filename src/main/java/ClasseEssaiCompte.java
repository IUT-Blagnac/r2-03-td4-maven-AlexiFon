package main;

import tps.banque.Compte;
import tps.banque.exception.CompteException;

public class ClasseEssaiCompte {
	public static void mainExo1(String[] argv) throws Exception {
		
		Compte cUn;
		cUn =new Compte("010101", "Lepoisson Benoit");
		
		try {
		cUn.deposer(10000);
		cUn.retirer(5000);
		}catch(CompteException e){
			System.out.println(e);
		}
		cUn.setProprietaire("Alexi Fontanilles");
		cUn.afficher();
		//cUn = null;
		double solde= cUn.soldeCompte();
		String compte=cUn.toString();
		String numCompte=cUn.getNumCompte();
		String nomCompte=cUn.getProprietaire();
		
		System.out.println(numCompte);
		System.out.println(nomCompte);
		System.out.println(solde);
		System.out.println(compte);
		System.out.println(cUn);
		System.out.println(System.identityHashCode(cUn));
		// 4) On affiche toute les valeur de cUn le nom de compte la solde etc
		// 7) Cela ne marche pas car c'est un nombre négatif
		// 8) Cela ne marche pas car c'est un nombre négatif
		// 9) Cela fait comme la méthode afficher
		// 10) Cela affiche un nombre 1550089733
		// 12) Avec null cette commande renvoie une erreur
		// 13) Pareillement, en effet affecter null a cUn va vider cUn et donc il y a rien a afficher pour la méthode afficher
		}
	public static void main(String[] argv) throws Exception {
		/*Compte cUn;
		Compte cDeux;
		cUn= new Compte("010101", "Jean");
		cDeux = new Compte("020202","Marie");
		cUn.afficher();
		cDeux.afficher();
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		
		try {
			cUn.deposer(1);
			cDeux.deposer(1000);
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		//cUn.retirer(-100);
		//cDeux.deposer(-100);
		cDeux=cUn;
		cUn.afficher();
		cDeux.afficher();
		double solde=cUn.soldeCompte();
		double solde2=cDeux.soldeCompte();
		System.out.println(solde);
		System.out.println(solde2);
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		
		cUn.deposer(1000);
		cUn.afficher();
		cDeux.afficher();
		solde=cUn.soldeCompte();
		solde2=cDeux.soldeCompte();
		System.out.println(solde);
		System.out.println(solde2);
		
		Compte cTrois;
		Compte cQuatre;
		cTrois = cUn;
		cQuatre =cUn;
		cUn.afficher();
		cDeux.afficher();
		cTrois.afficher();
		cQuatre.afficher();
		
		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		System.out.println(System.identityHashCode(cTrois));
		System.out.println(System.identityHashCode(cQuatre));
		
		cTrois.deposer(500);
		cQuatre.retirer(200);
		cUn.afficher();
		cDeux.afficher();
		cTrois.afficher();
		cQuatre.afficher();
		
		cDeux.deposer(2000);
		
		cUn=null;
		System.out.println(cUn);
		
		//cUn.afficher();
		
		cDeux.afficher();*/
		
		Compte cUn;
		Compte cDeux;
		Compte cptTemp;

		cUn = new Compte ("010101", "Jean");
		cDeux = new Compte ("020202", "Marie");
		try {
		    cUn.deposer( 1000 );
		    cUn.retirer ( 500 );
		    cDeux.deposer( 2000 );
		    cDeux.retirer ( 200 );
		} catch (CompteException e) {
		        System.out.println("Erreur ...");
		}

		cptTemp = cUn;
		cUn = cDeux;
		cDeux = cptTemp;

		cUn.afficher(); 
		cDeux.afficher(); 
		// 3) Cela me dit que cUn n'est pas initialisé et ça m'affiche une erreur
		// 5) Cela me renvoie une erreur car impossible de retirer une somme négative
		// 6) Cela me renvoie une erreur car impossible de deposer une somme négative
		// 8) On peut voir que les compte sont devenue les même c'est a dire cDeux est devenue cUn avec exactement la meme reference, solde, nom de compte et numéro de compte 
		// 12) On peut voir que cTrois et cQuatre sont égale a cUn et cDeux les quatre compte sont donc les meme
		// 13) On peut voir que cTrois et cQuatre ont également la même réference que cUn et cDeux.
		// 14) Je pense que les quatre compte vont recevoir 500 et vont etre debite de 200 donc avoir un credit de 1500 et un debit de 200
		// 15) On peut voir qu'il se passe ce que j'avais dit au dessus il y a bien eu +500 au credit et un debit de 200
		// 16) J'arrive a dposer sur le compte cDeux cependant maintenant le propriétaire n'est plus marie mais c'est jean
		// 18) La commande System.out.println(cUn)affiche null car le compte cUn est maintenant vide et est rempli juste d'un null
		// 19) L'erreur  java.lang.NullPointerException arrive car cUn est null 
		// 20) On a affecter null a cUn et non cDeux meme si les deux sont les meme cela marche que pour cUn
		// Les deux compte se sont invérsé cUn est devenu cDeux et inversement
	}
}