package compteBancaire;
import javax.ejb.EJB;
import javax.ejb.Stateful;


@Stateful

@EJB
public class CompteBancaire implements CompteBancaireRemote, CompteBancaireLocal {

	private String nomPrenom;
	private int solde = 0;
	Comptes comptes;

	public String versement(String nomPrenom, int montant) {

		solde += montant;

		return "votre nouveau solde : " + solde;
	}

	public String retrait(String nomPrenom, int montant) {

		if (solde > montant) {
			solde -= montant;
		}
		
		return "votre nouveau solde : " + solde;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "CompteBancaire : nomPrenom=" + nomPrenom + " , nouveau solde= " + solde;
	}

}
