package domaine;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  HEDI Ines, MORENO Beatriz
 *
 */
/**
 * 
 *La classe domaine.compteEpargne represente un compteEpargne 
 */
public class CompteEpargne extends CompteBancaire {
	
	static double tauxRemuneration = 0.03;

	/**
	 * Methode pour generer de maniere alleatoire un numero de
	 * compte à 8 ou 9 chiffre ainsi qu'une date de creation.
	 *
	 */
	public CompteEpargne() {
		Double numRandom = (Math.random()) * Math.pow(10, 9);
		Integer intRandom = numRandom.intValue();
		this.numeroCompte = Integer.toString(intRandom);
		this.solde = 0.0;

		String format = "dd/MM/yyyy";
		SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
		Date date = new java.util.Date();
		this.dateOuverture = formater.format(date);
	}

	/**
	 * Implementation de la methode debiter de l'interface IOperationsBancaires
	 */
	@Override
	public boolean debiter(double montant) {
		
		if (montant > 0) {
			boolean operationAutorise;
			operationAutorise = (montant <= this.solde);

			if (operationAutorise) {
				this.setSolde(this.getSolde() - montant);
				return true;
			}
		}
		return false;
	}

}
