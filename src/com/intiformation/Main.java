package com.intiformation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Client> listeClient = new ArrayList <Client>();
	static ArrayList<Medicament> listeMedoc = new ArrayList <Medicament>();
		

	public static void main(String[] args)
	{
		
	Medicament m1 = new Medicament("Doliprane", 2.00, 50);
	Medicament m2 = new Medicament("Aspirine",1.80, 120);
	listeMedoc.add(m1);
	listeMedoc.add(m2);

	
	Client c1 = new Client("Henry", 0);
	listeClient.add(c1);

	

	boolean stop = false;
	do
		{
		System.out.println("Veuillez sélectionner : \n 1 : pour afficher le client et ses crédits"
				+ " \n 2 : pour afficher un médicament et ses stocks"
				+ " \n 3 : pour l'approvisionnement"
				+ " \n 4 : pour l'achat"
				+ " \n 5 : pour ajouter un nouveau client"
				+ " \n 6 : pour ajouter une nouvelle référence de produit"
				+ " \n 7 : pour QUITTER");
		
		int key = sc.nextInt();
		switch (key) 
			{
			case 1 : 
				affichageClient();
				System.out.println("******************************************************************************\n");
				break;
			case 2 : 
				affichageMedoc();
				System.out.println("******************************************************************************\n");
				break;
				
			case 3 : 
				approvisionnement();
				System.out.println("******************************************************************************\n");
				break;
				
			case 4 :
				achat();
				System.out.println("******************************************************************************\n");
				break;	
				
			case 5 :
				ajoutClient();
				System.out.println("******************************************************************************\n");
				break;	
				
			case 6 :
				ajoutMedoc();
				System.out.println("******************************************************************************\n");
				break;	
				
			case 7 :
				quitter();
				stop = true;
				break;
				
			default: 
				stop = false;
				break;
			}
		
		}while(stop == false);
	
	}
	

	
	
	
	
	
	//FONCTIONS
	
	
	public static Client lireClient()
	{
		boolean verif = false;
		do {
		System.out.println("Veuillez saisir respectivement le nom du client et son identifiant : ");
		String nom_ecrit = sc.next();
		int id_ecrit = sc.nextInt();
		
		for(int i = 0; i < listeClient.size(); i++)
		{
		
			if((listeClient.get(i).getNom().contains(nom_ecrit)) && (listeClient.get(i).getId() == id_ecrit))
			{
				System.out.println("Le client est bien renseigné dans la base de donnée");
				verif = true;
				return listeClient.get(i);
				
			}
			else 
			{
				
				verif = false;
		
			}
		}
	
		}
		while (verif == false);

		return null;
		
	
	}
	
	public static Medicament lireMedicament()
	{
		boolean verif = false;
		do {
		System.out.println("Veuillez saisir le nom du médicament : ");
		String nom_ecrit = sc.next();
	
		for(int i = 0; i < listeMedoc.size(); i++)
		{
		
			if((listeMedoc.get(i).getNom().contains(nom_ecrit))) 
			{
				System.out.println("Le médicament est bien renseigné dans la base de donnée");
				verif = true;
				return listeMedoc.get(i);
				}
			else 
			{
				
				verif = false;
			}
		}
	
		}
		while (verif == false);
		
		return null;
		
		
		
	}

	
	public static void approvisionnement()
	{
		
			System.out.println("Saisir la quantité à ajouter au stock : ");
			int quantite = sc.nextInt();
			Medicament m = lireMedicament();
			m.setStock(quantite + m.getStock());
			System.out.println("L'approvisionnement a été effectué. \nLa nouvelle valeur du stock de " + m.getNom() + " est : " + 	m.getStock() );	
		
	}
	
	public static void achat()
	{
	
		System.out.println("Saisir la quantité du produit : ");
		int quantite = sc.nextInt();
		Medicament m = lireMedicament(); // il faut STOCKER notre objet créé par la fonction lire()
		Client c = lireClient();	
	    System.out.println("Le client a actuellement un crédit de : " + c.getCredit() + " €");
	    System.out.println("Saisir le montant délivré par le client : ");
	    double montant = sc.nextDouble();
	  
		m.setStock( m.getStock() - quantite);
		c.setCredit(c.getCredit() + quantite * m.getPrix() - montant);
	
		System.out.println("La transaction a été effectué avec SUCCES");
		
	}
	
	public static void affichageClient()
	{
		Client c = lireClient();
		System.out.println(c);
	}
	
	public static void affichageMedoc()
	{
		Medicament m = lireMedicament();
		System.out.println(m);
	}
	
	
	public static void quitter()
	{
		System.out.println("Fin de l'application !");
	}
	
	
	public static void ajoutClient()
	{
		System.out.println("Saisir le nom du nouveau client : ");
	
	
		String nom = sc.next();
		Client c = new Client(nom, 0);
		listeClient.add(c);
		System.out.println("Le client " + c.getNom() + " a été enregistré !");
		
	}
	
	
	public static void ajoutMedoc()
	{
		System.out.println("Saisir le nom du nouveau médicament : ");
	
		String nom = sc.next();
		
		System.out.println("Saisir à présent le prix unitaire du produit : ");
		double prix = sc.nextDouble();
		Medicament m = new Medicament(nom, prix, 0);
	
		listeMedoc.add(m);
		
		System.out.println("Le medicament " + m.getNom() + ", au prix unitaire de : " + m.getPrix() + " € a bien été enregistré !");
		
	}

	
	
}
