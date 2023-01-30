package Modele.gestionBD;

public enum Profil {

	ADMINISTRATEURBANQUE ("ADMINISTRATEUR"),
	EmployeBANQUE ("Employe");
	
	private String name = "";
	   
	  //Constructeur
	Profil(String name){
	    	this.name = name;
	    }
	   
	public String toString(){
	    return name;
	}
	
	public static Profil getProfil(String profil){
		if(profil.equals("ADMINISTRATEUR"))
			return ADMINISTRATEURBANQUE;
		else return EmployeBANQUE;
		
		
	}
	
	public static String getNomProfil(Profil p){
		if(p.compareTo(ADMINISTRATEURBANQUE) == 0)
			return "ADMINISTRATEUR";	
		else	return "Employe";
		
	}


}
