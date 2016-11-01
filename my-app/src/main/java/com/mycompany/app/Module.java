package com.mycompany.app;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Module implements Serializable 
{
	private int hCoursPrev, hCoursRea, hTpPrev, hTpRea, coefTest, coefCc;
	private String code, libelle, discipline;
	private Prof responsable;
	private Module modPere;
	
	
	//Accesseurs Modifieurs
	public int gethCoursPrev() 
	{
		return hCoursPrev;
	}
	public void sethCoursPrev(int hCoursPrev) 
	{
		this.hCoursPrev = hCoursPrev;
	}
	
	public int gethCoursRea() 
	{
		return hCoursRea;
	}
	public void sethCoursRea(int hCoursRea) 
	{
		this.hCoursRea = hCoursRea;
	}
	
	public int gethTpPrev() 
	{
		return hTpPrev;
	}
	public void sethTpPrev(int hTpPrev) 
	{
		this.hTpPrev = hTpPrev;
	}
	
	public int gethTpRea() 
	{
		return hTpRea;
	}
	public void sethTpRea(int hTpRea) 
	{
		this.hTpRea = hTpRea;
	}
	
	public int getCoefTest() 
	{
		return coefTest;
	}
	public void setCoefTest(int coefTest) 
	{
		this.coefTest = coefTest;
	}
	
	public int getCoefCc() 
	{
		return coefCc;
	}
	public void setCoefCc(int coefCc) 
	{
		this.coefCc = coefCc;
	}
	
	public String getCode() 
	{
		return code;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	
	public String getLibelle() 
	{
		return libelle;
	}
	public void setLibelle(String libelle) 
	{
		this.libelle = libelle;
	}
	
	public String getDiscipline() 
	{
		return discipline;
	}
	public void setDiscipline(String discipline) 
	{
		this.discipline = discipline;
	}
	
		
	public Prof getResponsable() 
	{
		return responsable;
	}
	public void setResponsable(Prof responsable) 
	{
		this.responsable = responsable;
	}
	
	public Module getModPere() 
	{
		return modPere;
	}
	
	public void setModPere(Module modPere) 
	{
		this.modPere = modPere;
	}
	
	//Surcharger toString()
	@Override
	public String toString() 
	{
		return "Module [hCoursPrev=" + hCoursPrev + ", hCoursRea=" + hCoursRea + ", hTpPrev=" + hTpPrev + ", hTpRea="
				+ hTpRea + ", coefTest=" + coefTest + ", coefCc=" + coefCc + ", code=" + code + ", libelle=" + libelle
				+ ", discipline=" + discipline + "]";
	}
	
	//Constructeur
	public Module()
	{

	}

	//Surchargement de hashCode()
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + coefCc;
		result = prime * result + coefTest;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + hCoursPrev;
		result = prime * result + hCoursRea;
		result = prime * result + hTpPrev;
		result = prime * result + hTpRea;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Module other = (Module) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (coefCc != other.coefCc)
			return false;
		if (coefTest != other.coefTest)
			return false;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (hCoursPrev != other.hCoursPrev)
			return false;
		if (hCoursRea != other.hCoursRea)
			return false;
		if (hTpPrev != other.hTpPrev)
			return false;
		if (hTpRea != other.hTpRea)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
	
}
