package com.mycompany.app;

import java.sql.*;
import java.util.ArrayList;

public class TestEntite 
{
	// Chaine de connexion
			static final String CONNECT_URL = "jdbc:mysql://mysql-projectwinyoels.alwaysdata.net:3306/projectwinyoels_gestion_peda_mysql";
			static final String LOGIN = "113168";
			static final String PASSWORD = "zumbarumba";
			// La requete de test
			static final String req = "SELECT * " +
			                          "FROM ETUDIANT ";
			static ArrayList<Etudiant> etd = new ArrayList<Etudiant>();
			
			public static void main(String[] args) throws SQLException {
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
						Etudiant etu = new Etudiant();
						etu.setNumET(rset.getInt("NUM_ET"));
						etu.setNomEt(rset.getString("NOM_ET"));
						etu.setPrenomEt(rset.getString("PRENOM_ET"));
						etu.setAnnee(rset.getInt("ANNEE"));
						etu.setGroupe(rset.getInt("GROUPE"));
						etu.setVilleEt(rset.getString("VILLE_ET"));
						etu.setCpEt(rset.getString("CP_ET"));						
						etd.add(etu);
					}
					
					for (Etudiant et : etd)
					{
						System.out.println(et.toString());
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

