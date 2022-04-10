package com.intiformation;

public class Medicament
{

	public Medicament()
	{
		
    	
	}
	
//ATTRIBUTS


	private String nom;
	private double prix;
	private int stock;
	
	
//CONSTRUCTEUR SURCHARGE:
	
	public Medicament(String nom, double prix, int stock)
	{
		super();
		
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}

//FONCTIONS
	
	
	
	
//TO STRING	
	
	@Override
	public String toString()
	{
		return "Medicament [ Nom =" + nom + ", prix =" + prix + "�, stock =" + stock + " unit�s ]";
	}

	
//GETTERS & SETTERS
	
	public String getNom()
	{
		return nom;
	}




	public void setNom(String nom)
	{
		this.nom = nom;
	}


	public double getPrix()
	{
		return prix;
	}


	public void setPrix(double prix)
	{
		this.prix = prix;
	}


	public int getStock()
	{
		return stock;
	}


	public void setStock(int stock)
	{
		this.stock = stock;
	}
	
	
	
}
