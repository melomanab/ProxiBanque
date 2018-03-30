package domaine;

/**
 * @author User HEDI Ines, MORENO Beatriz
 * 
 *  La classe personne est une classe abstraite.
 *  
 */
public abstract class Personne {
	
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String codePostal;
	protected String ville;
	protected String telephone;

	/** 
	 * Methode pour recuperer la variable nom
	 */

	public String getNom() {
		return nom;
	}

	/**
	 * Methode pour attribuer une valeur à la variable nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Methode pour recuperer la variable prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Methode pour attribuer une valeur à la variable prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Methode pour recuperer la variable adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Methode pour attribuer une valeur à la variable adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Methode pour recuperer la variable code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Methode pour attribuer une valeur à la variable code postal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Methode pour recuperer la variable ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Methode pour attribuer une valeur à la variable ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Methode pour recuperer la variable telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Methode pour attribuer une valeur à la variable telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
