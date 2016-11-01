package com.mycompany.app;

import java.sql.*;
import java.util.ArrayList;

public class TestAsso1 
{
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-projectwinyoels.alwaysdata.net:3306/projectwinyoels_gestion_peda_mysql";
	static final String LOGIN = "113168";
	static final String PASSWORD = "zumbarumba";
	static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, MAT_SPEC "
							 + "FROM PROF ";
	static private PreparedStatement modStmt;
	static private Module getModuleByCode(String code) throws SQLException 
	{
        Module module = null;

        modStmt.setString(1, code);
        ResultSet RS = modStmt.executeQuery();

        if (RS.next()) 
        {
            module = new Module();
            module.setCode(RS.getString("CODE"));
            module.setLibelle(RS.getString("LIBELLE"));
            module.sethCoursPrev(RS.getInt("H_COURS_PREV"));
            module.sethCoursRea(RS.getInt("H_COURS_REA"));
            module.sethTpPrev(RS.getInt("H_TP_PREV"));
            module.setDiscipline(RS.getString("DISCIPLINE"));
            module.setCoefTest(RS.getInt("COEFF_TEST"));
            module.setCoefCc(RS.getInt("COEFF_CC"));
        }
		return module;
	}

	static ArrayList<Prof> listeProf = new ArrayList<Prof>();

	public static void main(String[] args) throws SQLException 
	{
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
				Prof prof = new Prof();

                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setAdrProf(rset.getString("ADR_PROF"));
                prof.setCpProf(rset.getString("CP_PROF"));
                prof.setVilleProf(rset.getString("VILLE_PROF"));
				prof.setSpecialite(getModuleByCode(rset.getString("MAT_SPEC")));
				
				listeProf.add(prof);
			}
			
			for(Prof prof : listeProf){System.out.println(prof.toString());}
			
			stmt.close();
			
		} 
		
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
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
