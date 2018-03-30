package domaine;


import service.IOperationsBancaires;

/**
 * @author User HEDI Ines, MORENO Beatriz
 *
 */

/**
 * La classe compteBanquaire est une classe asbraite qui implement
 * IOperationsBancaires
 *
 */
public abstract class CompteBancaire implements IOperationsBancaires {
	
	protected String numeroCompte;
	protected String dateOuverture;
	protected double solde;

	/**
	 * Methode pour recuperer la variable numero de compte
	 */

	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Methode pour attribuer une valeur � la variable numero de compte
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * Methode pour recuperer la variable date d'ouverture
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * Methode pour attribuer une valeur � la variable date d'ouverture
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * methode pour recuperer la variable solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * Methode pour attribuer une valeur � la variable solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * Implementation de la methode crediter de l'interface IOperationsBancaires
	 */
	@Override
	public boolean crediter(double montant) {
		// Credite le compte du montant choisi
		if (montant > 0) {
			this.setSolde(this.getSolde() + montant);
			return true;
		}
		return false;
	}

	/**
	 * 	Methode toString pour affichager les informations du compte
	 * 
	 */
	public String toString() {
		return "[Compte n�: " + this.getNumeroCompte() + "\t" + "Solde: " + this.getSolde() + " EUR\t"
				+ "Date d'ouverture: " + this.getDateOuverture() + "]";
	}

}
