package service;

import java.util.ArrayList;

import domaine.Client;
import domaine.ConseillerClientele;
/**
 * @author HEDI Ines, MORENO Beatriz
 * La classe service.ServiceGestionPatrimoine represente les services propose pour la gestion du patrimoine
 */
public class ServiceGestionPatrimoine {

	
	static double seuilPatrimoine = 500000.0;

	/**
	 * @param monConseiller
	 * Methode pour calculer le solde total des clients et leur attribuer la variable fortune si il entre dans les criteres
	 */
	public void calculPatrimoineClientele(ConseillerClientele monConseiller) {
		
		ArrayList<Client> listeClients = monConseiller.getListeClients();

		for (int i = 0; i < listeClients.size(); i++) {
			Client client = monConseiller.getListeClients().get(i);
			double soldeCC = client.getcCourant().getSolde();
			double soldeCE = client.getcEpargne().getSolde();
			double patrimoine = soldeCC + soldeCE;
			if (patrimoine >= seuilPatrimoine) {
				client.setFortune(true);
			}
		}
	}

	/**
	 * @param monConseiller
	 * @return
	 * Methode pour indiquer au  conseille les clients qui sont dit fortune dans sa liste afin de pouvoir leurs proposer des placements
	 */
	public String propositionsPlacements(ConseillerClientele monConseiller) {
		// Propose un service de placements uniquement aux clients fortunés
		String message = "Vous pouvez proposer les Services de Gestion de Patrimoine " +
				"aux clients suivants (fortunés):\n";
		ArrayList<Client> listeClients = monConseiller.getListeClients();
		for (int i = 0; i < listeClients.size(); i++) {
			Client client = monConseiller.getListeClients().get(i);
			if (client.isFortune() == true) {
				message += client.toString() + "\n";
			}
		}
		return message;
	}
}
