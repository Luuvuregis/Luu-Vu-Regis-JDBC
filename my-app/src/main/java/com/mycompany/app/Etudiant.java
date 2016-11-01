package com.mycompany.app;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Etudiant implements Serializable
{
	//Données-membres
	private int numET, annee, groupe;
	private String nomEt, prenomEt, cpEt, villeEt;
	private Set<Enseignt> enseignement = new HashSet<>();
	
	//Accesseurs Modifieurs
	public int getNumET() 
	{
		return numET;
	}
	public void setNumET(int numET) 
	{
		this.numET = numET;
	}
	
	public int getAnnee() 
	{
		return annee;
	}
	public void setAnnee(int annee) 
	{
		this.annee = annee;
	}
	
	public int getGroupe() 
	{
		return groupe;
	}
	public void setGroupe(int groupe) 
	{
		this.groupe = groupe;
	}
	
	public String getNomEt() 
	{
		return nomEt;
	}
	public void setNomEt(String nomEt) 
	{
		this.nomEt = nomEt;
	}
	
	public String getPrenomEt() 
	{
		return prenomEt;
	}
	public void setPrenomEt(String prenomEt) 
	{
		this.prenomEt = prenomEt;
	}
	
	public String getCpEt() 
	{
		return cpEt;
	}
	public void setCpEt(String cpEt) 
	{
		this.cpEt = cpEt;
	}
	
	public String getVilleEt() 
	{
		return villeEt;
	}
	public void setVilleEt(String villeEt) 
	{
		this.villeEt = villeEt;
	}
	
	public void addEnseignement(Enseignt enseignement) 
	{
		this.enseignement.add(enseignement);
    }
	
	//Constructeurs
	public Etudiant()	
	{
		
	}
	
	//Surchargement de toString()
	public String toString() 
	{
		return "Etudiant [numET=" + numET + ", annee=" + annee + ", groupe=" + groupe + ", nomEt=" + nomEt
				+ ", prenomEt=" + prenomEt + ", cpEt=" + cpEt + ", villeEt=" + villeEt + "]";
	}
	
	//Surchargement de hashCode()
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((cpEt == null) ? 0 : cpEt.hashCode());
		result = prime * result + groupe;
		result = prime * result + ((nomEt == null) ? 0 : nomEt.hashCode());
		result = prime * result + numET;
		result = prime * result + ((prenomEt == null) ? 0 : prenomEt.hashCode());
		result = prime * result + ((villeEt == null) ? 0 : villeEt.hashCode());
		return result;
	}

	//Surchargement de equals()
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (annee != other.annee)
			return false;
		if (cpEt == null) {
			if (other.cpEt != null)
				return false;
		} else if (!cpEt.equals(other.cpEt))
			return false;
		if (groupe != other.groupe)
			return false;
		if (nomEt == null) {
			if (other.nomEt != null)
				return false;
		} else if (!nomEt.equals(other.nomEt))
			return false;
		if (numET != other.numET)
			return false;
		if (prenomEt == null) {
			if (other.prenomEt != null)
				return false;
		} else if (!prenomEt.equals(other.prenomEt))
			return false;
		if (villeEt == null) {
			if (other.villeEt != null)
				return false;
		} else if (!villeEt.equals(other.villeEt))
			return false;
		return true;
	}
	
	
	
	
	
}

