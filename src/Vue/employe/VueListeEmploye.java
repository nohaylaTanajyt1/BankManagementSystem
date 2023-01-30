package Vue.employe;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modele.gestionBanque.ModelListerClient;
import Modele.gestionBanque.ModelListerEmploye;

public class VueListeEmploye extends JPanel {
	private JTable table;
	public static ModelListerEmploye modelListe;
	private VueEmploye parent;
	//private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public VueListeEmploye(VueEmploye p) {
		this.parent = p;
		//if(modelListe==null)
			modelListe = new ModelListerEmploye();
		table = new JTable(modelListe);
		//table.setTableHeader();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		//table.setModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.setAutoCreateRowSorter(true);
		add(new JScrollPane(table));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//if()
				
				parent.setSelectEmploye(((ModelListerEmploye)table.getModel()).getEmployeAt(table.getSelectedRow()));
				parent.activerBouton();
			}
		});

	}
	
	public JTable getTable(){
		return this.table;
	}
	
	
	
	

}
