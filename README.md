# Mode d'emploi de l'application Java ProxiBanqueSI

## Pré-requis:
- Installer le JDK 9 sur la machine cible,
  - Téléchargé depuis: http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Machine cible dotée d'un systeme d'exploitation Windows.

## Execution :
- Copier le fichier .jar (ProxiBanqueSI.jar) en local sur la machine,
- Copier le path du répertoire parent contenant le fichier .jar,
- Ouvrir un invite de commande (cmd.exe)
- Taper "cd <path>" pour changer le repertoire de travail sur le répertoire parent, puis pressez entrée (avec <path> le path copié precedemment),
	      
			Ex: "cd C:\formationJava\livraison".

	    - Taper "java -jar <ProxiBanqueSI>.jar" et presser entrée. 
			La Demo Java ProxiBanqueSI s'execute sur l'invite de commandes.

## Consulter la documentation JavaDoc: 
	    - Double-cliquer sur le fichier <index.html> se trouvant dans le repertoire <ProxiBanque\doc> du repertoire parent.
		
## Consulter les diagrammes UML: 
		- Double-cliquer sur le fichier <UML_UCD_ProxiBanqueSI_ServiceGestionClientele_1.0.html> se trouvant dans le 
		répertoire parent pour consulter le Diagramme de Cas d'Utilisation correspondant au Service Gestion Clientele
		- Double-cliquer sur le fichier <UML_UCD_ProxiBanqueSI_ServiceOperationsBancaires_1.0.html> se trouvant dans le 
		répertoire parent pour consulter le Diagramme de Cas d'Utilisation correspondant au Service Operations Bancaires
		- Double-cliquer sur le fichier <UML_CD_ProxiBanqueSI_1.0.html> se trouvant dans le 
		répertoire parent pour consulter le Diagramme de Classes correspondant à l'application ProxiBanqueSI (version 1.0).
		Les fonctionnalitées prises en compte dans cette version apparaissent en couleur verte.

## Description de la Demo Java ProxiBanqueSI:	
	- Menu principal
		-adressé à un conseiller client 
			-L'etat [Nom, Prenom] du conseiller actuel est: [MBIANDOU Douglas]
			-Une liste de clients est rentrée en dur dans l'application, simulant le chargement d'une base de données Clients.
			Elle contient un total de 9 clients dont 2 fortunés.
		-affiche un message de bienvenue avec les options suivantes:
			0-Afficher la liste de clients
			1-Creer un client
			2-Modifier les informations d'un client
			3-Lire les informations d'un clien
			4-Supprimer un client
			5-Faire un virement compte à compte
			6-Proposer des placements (service reservé aux clients fortunés)
			7-Quitter
	- Option <0-Afficher la liste de clients>:
		- Affiche le conseiller client ainsi que la liste de clients à sa charge
	- Option <1-Creer un client>:
		- Demande au conseiller de rentrer le nom, prenom, adresse, code postal, ville et telephone du nouveau client et 
		le rajoute à la liste de clients. 
		- Si la liste de clients possède déjà 10 clients, il affiche l'imposibilité de rajouter de nouveau client.
	- Option <2-Modifier les informations d'un client>:
		- Demande au conseiller de selectionner un client, puis le champ à modifier. Apres qu'un champ a été modifié, 
		il demande s'il y a d'autres modifications à faire sur le client avant de revenir au menu principal et afficher
		les nouvelles informations du client.
	- Option <3-Lire les informations d'un client>:
		- Demande au conseiller de selectionner un client, puis affiche les informations complètes du client, incluant les 
		informations des comptes du client
	- Option <4-Supprimer un client>:
		- Demande au conseiller de selectionner un client, puis demande une confirmation avant de supprimer le client 
		selectionne de la liste de clients du conseiller
		- Si la liste est vide, affiche l'imposibilité de supprimer de clients
	- Option <5-Faire un virement compte à compte>:
		- Demande de selectionner le client titulaire du compte emeteur, puis le compte emeteur lui même (courant/epargne)
		- Demande de selectionner le montant du virement (en euros)
		- Demande de selectionner le client titulaire du compte beneficiaire, puis le compte beneficiaire lui même (courant/epargne)
		- Affiche un recapitulatif de la demande de virement
		- Affiche si le virement a été refusé ou validé
	- Option <6-Proposer des placements (service servé aux clients fortunés>:
		- Affiche les clients fortunés de la liste de clients, les seuls à pouvoir beneficier des services de gestion de patrimoine
	- Option <7-Quitter>:
		- Permet de quitter l'application
		
	
	
		
