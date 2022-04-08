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
	listeMedoc.add(m1);
//	approvisionner(m1);
	
	Client c1 = new Client("Henry", 0);
	listeClient.add(c1);
//	lireClient();
	
//	achat(c1, m1);
	

	boolean stop = false;
	do
		{
		System.out.println("Veuillez sélectionner : \n 1 : pour afficher le client et ses crédits"
				+ " \n 2 : pour afficher un médicament et ses stocks"
				+ " \n 3 : pour l'approvisionnement"
				+ " \n 4 : pour l'achat"
				+ " \n 5 : pour QUITTER");
		
		int key = sc.nextInt();
		switch (key) 
			{
			case 1 : 
				affichageClient();
				
				break;
			case 2 : 
				affichageMedoc();
				
				break;
				
			case 3 : 
				approvisionnement();
			
				break;
				
			case 4 :
				achat();
				
				break;	
				
			case 5 :
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
				System.err.println("Pas de correspondance, recommençons");
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
				
				System.err.println("Pas de correspondance, recommançons");
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
			System.out.println("L'approvisionnement est bien effectué. \n La nouvelle valeur du stock de " + m.getNom() + " est : " + 	m.getStock() );	
		
	}
	
	public static void achat()
	{
	
		System.out.println("Saisir la quantité du produit : ");
		int quantite = sc.nextInt();
		Medicament m = lireMedicament(); // il faut STOCKER notre objet créé par la fonction lire()
		Client c = lireClient();	
	
		m.setStock( m.getStock() - quantite);
		c.setCredit(c.getCredit() + quantite * m.getPrix());
	
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
	
//	public static boolean lireClient1ereversion()
//	{
//		boolean verif = false;
//		do {
//		System.out.println("Veuillez saisir respectivement le nom du client et son identifiant : ");
//		String nom_ecrit = sc.next();
//		int id_ecrit = sc.nextInt();
//		
//		for(int i = 0; i < listeClient.size(); i++)
//		{
//		
//			if((listeClient.get(i).getNom().contains(nom_ecrit)) && (listeClient.get(i).getId() == id_ecrit))
//			{
//				System.out.println("Le client est bien renseigné dans la base de donnée");
//				verif = true;
//				return true;
//				
//				//System.out.println("Voici les information de l'employé avec l'identifiant : " + id + "\n " + ListeEmploye.get(i));
//			}
//			else 
//			{
//				System.err.println("Pas de correspondance, recommançons");
//				verif = false;
//		
//			}
//		}
//	
//		}
//		while (verif == false);
//		return true;
//	}
	
//	public static void achat1ereversion(Client c, Medicament m)
//	{
//		if( lireClient() == true && lireMedicament() == true)
//		{
//			System.out.println("Saisir la quantité du produit " + m.getNom() +  " achetée : ");
//			int quantite = sc.nextInt();
//			m.setStock( m.getStock() - quantite);
//			c.setCredit(c.getCredit() + quantite * m.getPrix());
//			c.affichage();
//			m.affichage();
//		}
//	}
	

	
	
}
