package domaine;


import java.util.ArrayList;

/**
* @author  HEDI Ines, MORENO Beatriz
*
*/
/**
 * 
 * La classe domaine.Conseillerclientele represente un Conseillerclientele 
 */
public class ConseillerClientele extends Personne {

	// Attributs
	
	ArrayList<Client> listeClients;
	
	static int maxClients = 10;

	/**
	 * Initialise un objet ConseillerClientele avec les parametres specifies au moment de l'instantiation
	 */
	public ConseillerClientele() {
		super();
		this.listeClients = new ArrayList<Client>();
	}

	/**
	 * Initialise un objet ConseillerClientele avec les parametres specifies au moment de l'instantiation
	 */
	public ConseillerClientele(String nom, String prenom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
	}

	// Get/Set
	/**
	 * Methode pour recuperer la variable liste de client
	 */
	public ArrayList<Client> getListeClients() {
		return this.listeClients;
	}

	/**
	 * Methode pour attribuer une valeur à la variable liste de client
	 */
	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * Methode pour recuperer la variable maxClients
	 */
	public int getMaxClients() {
		return maxClients;
	}

	/**
	 * Methode pour attribuer une valeur à la variable maxclients
	 */
	public void setMaxClients(int maxClients) {
		this.maxClients = maxClients;
	}

	/**
	 * Methode toString: donne le nombre et la liste des clients si il y a lieu
	 */
	public String toString() {

		String message = "Conseiller clientele: [" + this.nom + " " + this.prenom + "]";
		if (!listeClients.isEmpty()) {
			message = message + "\nVous avez actuellement " + listeClients.size() + " client(s):";
			for (Client currentClient : listeClients) {
				message = message + "\n" + currentClient.toString();
			}
		} else {
			message = message + "\nVous n'avez aucun client.";
		}
		return message;
	}
}
