package com.mycompany.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class TestAsso2 
{
	// Chaine de connexion
		static final String CONNECT_URL = "jdbc:mysql://mysql-projectwinyoels.alwaysdata.net:3306/projectwinyoels_gestion_peda_mysql";
		static final String LOGIN = "113168";
		static final String PASSWORD = "zumbarumba";
		// La requete de test
		static final String req = "SELECT ANNEE, ET.NUM_ET, P.NUM_PROF, PRENOM_PROF, NOM_PROF, M.CODE, LIBELLE "
				  + "FROM ENSEIGNT E JOIN ETUDIANT ET ON E.NUM_ET = ET.NUM_ET "
				  + "JOIN MODULE M ON M.CODE = E.CODE "
				  + "JOIN PROF P ON P.NUM_PROF = E.NUM_PROF"
				  + "WHERE E.GROUPE = 1";       
		static ArrayList<Enseignt> listeEnseignt = new ArrayList<>();
		
		public static void main(String[] args) throws SQLException 
		{
			// Objet materialisant la connexion a la base de donnees
			Connection conn = null;
			try 
			{
				// Connexion a la base
				System.out.println("Connexion a " + CONNECT_URL);
				conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
				System.out.println("Connecte\n");
				// Creation d'une instruction SQL
				Statement stmt = conn.createStatement();
				// Execution de la requete
				System.out.println("Execution de la requete : " + req );
				ResultSet rset = stmt.executeQuery(req);
				// Affichage du resultat
				while (rset.next())
				{	
					Enseignt ensgt = new Enseignt();
	                Etudiant etudiant = new Etudiant();
	                Module mod = new Module();
	                Prof prof = new Prof();

	                etudiant.setNumET(rset.getInt("ET.NUM_ET"));
	                etudiant.setAnnee(rset.getInt("ANNEE"));
	                mod.setCode(rset.getString("CODE"));
	                mod.setLibelle(rset.getString("LIBELLE"));
	                prof.setNumProf(rset.getInt("NUM_PROF"));
	                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
	                prof.setNomProf(rset.getString("NOM_PROF"));

	                ensgt.setEtudiant(etudiant);
	                ensgt.setModule(mod);
	                ensgt.setProf(prof);

	                etudiant.addEnseignement(ensgt);
	                prof.addEnseignement(ensgt);

	                listeEnseignt.add(ensgt);
				}
				
				Set<Enseignt> ensPremAnnee = new HashSet<Enseignt>();
	            for(Enseignt ens : listeEnseignt)
	            {
	                if(ens.getEtudiant().getAnnee() == 1) 
	                	ensPremAnnee.add(ens);
	            }
	            
	            for(Enseignt ens : ensPremAnnee) 
	            {
	                System.out.println("Module : " + ens.getModule().getCode() + " (" + ens.getModule().getLibelle()
	                        + "), Prof n° " + ens.getProf().getNumProf() + " (" + ens.getProf().getPrenomProf() + " " + ens.getProf().getNomProf() +")");
	            }
				// Fermeture de l'instruction (liberation des ressources)
				stmt.close();
				System.out.println("\nOk.\n");
			} 
			
			catch (SQLException e) 
			{
				e.printStackTrace();// Arggg!!!
				System.out.println(e.getMessage() + "\n");
			} 
			
			finally 
			{
				if (conn != null) 
				{
					// Deconnexion de la base de donnees
					conn.close();
				}
			}
		}
}
