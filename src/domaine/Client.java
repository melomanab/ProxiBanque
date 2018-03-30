package domaine;

/**
 * @author  HEDI Ines, MORENO Beatriz
 *       
 */
import java.util.ArrayList;

/**
 * La classe domaine.Client represente un client 
 *  
 *
 */
public class Client extends Personne {
	
	
	private CompteCourant cCourant;
	private CompteEpargne cEpargne;
	private boolean fortune;

	/**
	 * Initialise un objet Client avec les parametres specifies au moment de l'instantiation
	 *
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.cCourant = new CompteCourant();
		this.cEpargne = new CompteEpargne();
		this.fortune = false;
	}

	/**
	 * Initialise un objet Client avec les parametres specifies au moment de l'instantiation 
	 * 
	 */
	public Client(String nom, String prenom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = "pas renseigné";
		this.codePostal = " ";
		this.ville = " ";
		this.telephone = "pas renseigné";
		this.cCourant = new CompteCourant();
		this.cEpargne = new CompteEpargne();
	}

	// Methodes getter/setter pour comptes bancaires
	/**
	 * Methode qui permet de recuperer la variable Compte courant
	 */
	public CompteCourant getcCourant() {
		return cCourant;
	}

	/**
	 * Methode qui permet d'attribuer une valeur à la variable Compte courant
	 */
	public void setcCourant(CompteCourant cCourant) {
		this.cCourant = cCourant;
	}

	/**
	 * Methode qui permet de recuperer la variable Compte Epargne
	 */
	public CompteEpargne getcEpargne() {
		return cEpargne;
	}

	/**
	 * Methode qui permet d'attribuer une valeur à la variable Compte Epargne
	 */
	public void setcEpargne(CompteEpargne cEpargne) {
		this.cEpargne = cEpargne;
	}

	/**
	 * Methode qui permet de recuperer la variable fortune
	 */

	public boolean isFortune() {
		return this.fortune;
	}

	/**
	 * Methode qui permet d'attribuer une valeur à la variable fortune
	 */
	public void setFortune(boolean fortune) {
		this.fortune = fortune;
	}

	// Methode toString()
	/**
	 * Methode toString pour affichager de nom et prenom du client
	 * 
	 */
	public String toString() {
		return "[" + this.nom + ", " + this.prenom + "]";
	}

	/**
	 * Méthode pour afficher les informations du client dans sont
	 * intégralité.
	 */

	public String infosClient() {
		return "[NOM-Prenom: " + this.nom + " " + this.prenom + "\t" + "Adresse: " + this.adresse + " "
				+ this.codePostal + " " + this.ville + "\tTelephone: " + this.telephone + "]";
	}

	/**
	 * Methode pour affichager les informationS sur les comptes du
	 * client
	 */
	public String infosComptes() {
		return "[Compte courant n°: " + this.cCourant.getNumeroCompte() + "\t" + "Solde: " + this.cCourant.getSolde()
				+ " EUR\t" + "Date d'ouverture: " + this.cCourant.getDateOuverture() + "\n" + "Compte epargne n°: "
				+ this.cEpargne.getNumeroCompte() + "\t" + "Solde: " + this.cEpargne.getSolde() + " EUR\t"
				+ "Date d'ouverture: " + this.cEpargne.getDateOuverture() + "]";
	}
}
