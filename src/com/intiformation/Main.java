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
	approvisionner(m1);
	
	
	}

	
	
	
	
	
	//FONCTIONS
	
	
	public static boolean lireMedicament()
	{
		boolean verif = false;
		do {
		System.out.println("Veuillez saisir le nom du m�dicament : ");
		String nom_ecrit = sc.next();
	
		for(int i = 0; i < listeMedoc.size(); i++)
		{
		
			if((listeMedoc.get(i).getNom() == "Doliprane")) //marche pas avec nom_ecrit :/
			{
				System.out.println("Le m�dicament est bien renseign� dans la base de donn�e");
				verif = true;
				return true;
				//System.out.println("Voici les information de l'employ� avec l'identifiant : " + id + "\n " + ListeEmploye.get(i));
			}
			else 
			{
				verif = false;
				System.err.println("Pas de correspondance, recomman�ons");
			}
		}
	
		}
		while (verif == false);
		return true;
	}
	
	
	public static boolean lireClient()
	{
		boolean verif = false;
		do {
		System.out.println("Veuillez saisir respectivement le nom du client et son identifiant : ");
		String nom_ecrit = sc.next();
		int id_ecrit = sc.nextInt();
		
		for(int i = 0; i < listeClient.size(); i++)
		{
		
			if((listeClient.get(i).getNom() == nom_ecrit) && (listeClient.get(i).getId() == id_ecrit))
			{
				System.out.println("Le client est bien renseign� dans la base de donn�e");
				verif = true;
				return true;
				
				//System.out.println("Voici les information de l'employ� avec l'identifiant : " + id + "\n " + ListeEmploye.get(i));
			}
			else 
			{
				System.err.println("Pas de correspondance, recomman�ons");
				verif = false;
		
			}
		}
	
		}
		while (verif == false);
		return true;
	}
	
	
	public static void approvisionner( Medicament m )
	{
		if (lireMedicament() == true)
		{
			System.out.println("Saisir la quantit� � ajouter au stock : ");
			int quantite = sc.nextInt();
			m.setStock(quantite + m.getStock());
			System.out.println(" La nouvelle valeur du stock de " + m.getNom() + " est : " + 	m.getStock() );	
		}
	}
	
	
	
}
