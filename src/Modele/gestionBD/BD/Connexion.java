package Modele.gestionBD.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * author nohayla
 * version 1
 * 
 */ 

public class Connexion {
/**
 * Connextion à la bse de données
 * 
 * 
 */  
	private static Connection cnx;
	
	public static Connection getConnection(){
		try{
			Class.forName(Variables.DRIVER);
			cnx = (Connection)DriverManager.getConnection("jdbc:mysql://"+Variables.SERVEUR+":"+Variables.PORT+"/"+Variables.NOMBD,Variables.USER,Variables.MOTDEPASS);
			if( cnx!=null){ System.out.println(("You are connected to the Database"));}
		}catch(Exception e){
			System.out.println("erreur connexion  à la base de données !!! ");
		}
		return cnx;
	}
	
	

 

}


