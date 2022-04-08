package com.intiformation;

public class Client
{
	public Client()
	{
		compteur ++;
    	this.id = compteur;
	}
	
//ATTRIBUTS
	private static int compteur = 0;
	private int id;
	private String nom;
	private double credit;
	
	
//CONSTRUCTEUR
	
	public Client(String nom, double credit)
	{
		super();
		compteur ++;
		this.id = compteur;
		this.nom = nom;
		this.credit = credit;
	}
	
	
//FONCTIONS
	


//TO STRING
	
	@Override
	public String toString()
	{
		return "Client [nom=" + nom + ", credit=" + credit + "]";
	}
	
//GETTERS & SETTERS
	
	public int getId()
	{
		return id;
	}




	public void setId(int id)
	{
		this.id = id;
	}


	public String getNom()
	{
		return nom;
	}


	public void setNom(String nom)
	{
		this.nom = nom;
	}


	public double getCredit()
	{
		return credit;
	}


	public void setCredit(double credit)
	{
		this.credit = credit;
	}

	

}
