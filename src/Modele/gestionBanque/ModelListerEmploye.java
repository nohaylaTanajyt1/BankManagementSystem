package Modele.gestionBanque;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modele.gestionBD.Employe;
import Modele.gestionBD.Profil;
//import Modele.gestionBD.Employe;

 /**
 * author nohayla
 * version 1
 * 
 */ 

public class ModelListerEmploye extends AbstractTableModel{
	
	private ArrayList<Employe> clients = new ArrayList<Employe>();
	private final String[] entete = new String[]{
			"CNI", "Nom ", "Prenom", "profil" 
	};
	
	public ModelListerEmploye(){
		super();
		this.clients = Employe.getAllEmploye();
	}

	

	@Override
	public int getRowCount() {
		
		return this.clients.size();
	}

	@Override
	public int getColumnCount() {
		
		return entete.length;
	}

	
	@Override
	public String getColumnName(int column) {
		
		return entete[column];
	}



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
			case 0 : return clients.get(rowIndex).getCNI();
			case 1 : return clients.get(rowIndex).getNom();
			case 2 : return clients.get(rowIndex).getPrenom();
			case 3 : return Profil.getNomProfil(clients.get(rowIndex).getProfil());
			default : return null;
		}
		
		//return null;
	}
	/* 
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, String.class 
			};
		return columnTypes[columnIndex];	
	}
	*/
	 /**
     * ajouter un employé
     * 
     */	
	public void addEmploye(Employe c){
		Employe.ajouterEmploye(c);
		clients.add(c);
		this.fireTableRowsInserted(clients.size()-1, clients.size()-1);
	}
	 /**
     * supprimer un employé
     * 
     */		
	public void removeEmploye(int rowIndex){
		Employe c = clients.get(rowIndex);//C.getClient(rowIndex);
		Employe.supprimerEmploye(c);
		//Compte.fermerCompte(c.getNumero());
		clients.remove(rowIndex);
		this.fireTableRowsDeleted(rowIndex, rowIndex);
		
	}
	public Employe getEmployeAt(int index){
		return this.clients.get(index);
	}
	
	
}
