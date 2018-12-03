package compteBancaire;

import java.util.HashMap;

import javax.ejb.Singleton;

@Singleton
public class Comptes {

	private HashMap<String, Integer> myCompte = new HashMap<String, Integer>();

	public Integer versement(String nomClient, int solde) {
		if (myCompte.containsKey(nomClient)) {
			int soldeActuel = myCompte.get(nomClient);
			myCompte.put(nomClient, soldeActuel + solde);
		} else {
			myCompte.put(nomClient, solde);
		}

		return myCompte.get(nomClient);
	}

	public Integer retrait(String nomClient, int solde) {
		if (myCompte.containsKey(nomClient)) {
			int soldeActuel = myCompte.get(nomClient);
			myCompte.put(nomClient, soldeActuel - solde);

			return myCompte.get(nomClient);
		}
		return 0;
	}

	public HashMap<String, Integer> getMyCompte() {
		return myCompte;
	}

	public void setMyCompte(HashMap<String, Integer> myCompte) {
		this.myCompte = myCompte;
	}
	
	
	
	
	

	
	
}
