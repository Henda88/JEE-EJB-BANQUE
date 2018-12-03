package compteBancaire;
import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class CompteBancaire implements CompteBancaireRemote, CompteBancaireLocal {

	@EJB
	Comptes comptes;
	

	public String versement(String nomPrenom, int montant) {

		int montantFinal = 0;
		if(comptes.getMyCompte().get(nomPrenom) == null ) {
			 montantFinal = montant ;
		}else {
		    montantFinal = comptes.getMyCompte().get(nomPrenom) + montant;
		}
		comptes.getMyCompte().put(nomPrenom, montantFinal);
		comptes.setMyCompte(comptes.getMyCompte()); 

		return "votre nouveau solde : " + comptes.getMyCompte().get(nomPrenom);
	}

	public String retrait(String nomPrenom, int montant) {

		int montantFinal = 0;
		if(comptes.getMyCompte().get(nomPrenom) == null ) {
			 montantFinal = montant ;
		}else {
		    montantFinal = comptes.getMyCompte().get(nomPrenom) + montant;
		}
		comptes.getMyCompte().put(nomPrenom, montantFinal);
		comptes.setMyCompte(comptes.getMyCompte()); 

		return "votre nouveau solde : " + comptes.getMyCompte().get(nomPrenom);
	}


	public String versementPermanent(String nomPrenom, int montant ) {

		int retour = comptes.versement(nomPrenom, montant);

		return "votre nouveau solde : " + retour;
	}

	public String retraitPermanent(String nomPrenom, int montant) {

		int retour = comptes.retrait(nomPrenom, montant);

		return "votre nouveau solde : " + retour;
	}
}
