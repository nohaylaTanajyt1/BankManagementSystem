package Vue.employe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.gestionBD.Employe;
import Modele.gestionBanque.ModelListerClient;
import Modele.gestionBanque.ModelListerCompte;
import Modele.gestionBanque.ModelListerEmploye;

public class VueEmploye extends JPanel {
	JPanel panel;
	JButton btnModifierButton;
	JButton btnAjouterEmploye;
	JButton btnFermetEmploye;
	JButton btnListerEmploye;
	JButton btnInformations;
	VueListeEmploye listeEmploye;
	VueModifierEmploye modifEmploye;
	VueAddEmploye addEmploye = new VueAddEmploye(this);
	Employe selectEmploye=new Employe();

	/**
	 * Create the panel.
	 */
	public VueEmploye() {
		//if(listeCompte == null )
		//initListeCompte();
		modifEmploye = new VueModifierEmploye(this, selectEmploye);
		listeEmploye = new VueListeEmploye(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {135, 25, 285, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Menu Employe");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Text", Font.BOLD, 17));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		btnAjouterEmploye = new JButton("Ajouter Employe");
		panel_3.add(btnAjouterEmploye);
		btnAjouterEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmploye = new VueAddEmploye(VueEmploye.this);
				((CardLayout)panel.getLayout()).show(panel, "add");
				
			}
		});
		
		btnModifierButton = new JButton("Modifier Employe");
		btnModifierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "modif");
			}
		});
		panel_3.add(btnModifierButton);
		
		btnFermetEmploye = new JButton("Supprimer Employe ");
		panel_3.add(btnFermetEmploye);
		btnFermetEmploye.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeEmploye.getTable().getSelectedRow();
				((ModelListerEmploye)listeEmploye.getTable().getModel()).removeEmploye(index);//.getCompteAt(index);
				JOptionPane.showMessageDialog(VueEmploye.this, "Employe supprimer avec succes");
				updateListe();
			
			}
		});
		
		btnListerEmploye = new JButton("Lister Employe  ");
		panel_3.add(btnListerEmploye);
		
		
		btnInformations = new JButton("Informations   ");
		panel_3.add(btnInformations);
		btnInformations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = listeEmploye.getTable().getSelectedRow();
				selectEmploye=((ModelListerEmploye)listeEmploye.getTable().getModel()).getEmployeAt(index);
				//Client c1 = Client.getClientByCompte(selectClient);
				if(selectEmploye.getPrenom() != null)
					JOptionPane.showMessageDialog(VueEmploye.this, "CNI : "+selectEmploye.getCNI()+"\n"
							+ "Nom : "+selectEmploye.getNom()+"\n"
									+ "Prenom : "+selectEmploye.getPrenom()+"\n"
											+ "Telephone : "+selectEmploye.getTelephone()+"\n"
													+ "Adresse : "+selectEmploye.getAdresse()+"\n"
															+ "Login : "+selectEmploye.getLogin()+"\n"
																+" mot de passe : " +selectEmploye.getPassword()
																	+ "Profil : "+selectEmploye.getProfil());
				else 
					JOptionPane.showMessageDialog(VueEmploye.this, "ce compte ce compte n'est associé a un client");
			}
		});
		
		panel = new JPanel(new CardLayout());
		panel.add(addEmploye, "add");
		panel.add(listeEmploye, "liste");
		panel.add(modifEmploye,"modif");
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		btnListerEmploye.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listerCompte();
				//((CardLayout)panel.getLayout()).show(panel, "liste");
			}
		});

	}
	public void desactiveBouton(){
		btnInformations.setEnabled(false);
		btnFermetEmploye.setEnabled(false);
		btnModifierButton.setEnabled(false);
	}
	
	public void activerBouton(){
		btnInformations.setEnabled(true);
		btnFermetEmploye.setEnabled(true);
		btnModifierButton.setEnabled(true);
	}

	public void listerCompte(){
		desactiveBouton();
		((CardLayout)panel.getLayout()).show(panel, "liste");
	}
	
	public void addEmploye(Employe c){
		((ModelListerEmploye)listeEmploye.getTable().getModel()).addEmploye(c);
		listerCompte();
	}
	
	public void updateListe(){
		listeEmploye.getTable().setModel(new ModelListerEmploye());// = 
	}
	public Employe getSelectEmploye() {
		return selectEmploye;
	}
	public void setSelectEmploye(Employe selectCompte) {
		this.selectEmploye = selectCompte;
		modifEmploye.setClient(selectCompte);
	}
	
	
}
