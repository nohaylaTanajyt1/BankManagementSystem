package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Vue.admin.client.VueClientAdmin;
import Vue.compte.VueCompte;
import Vue.employe.VueEmploye;
import Vue.operation.VueOperations;

public class Main extends JFrame {

	private JPanel contentPane;
	private CardLayout layout;
	private JPanel principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Main(String profil ) {
		layout = new CardLayout(0, 0);
		System.out.println(profil);
		ihm(profil);
		accueil(profil);
		compte();
		client();
		this.principal.add(new VueOperations(),"operation");
		this.principal.add(new VueEmploye(),"employe");
	}
	
	public void addMenu(String profil){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccueil = new JMenu("Accueil");
		mnAccueil.setMnemonic('A');
		menuBar.add(mnAccueil);
		
		JMenuItem mntmDeconnexion = new JMenuItem("Déconnexion");
		mnAccueil.add(mntmDeconnexion);
		mntmDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		if(profil.equals("ADMINISTRATEUR") || profil.equals("EMPLOYE") ){
			JMenuItem mnEmploye = new JMenuItem("Employe");
			mnEmploye.setMnemonic('e');
			menuBar.add(mnEmploye);
			
			mnEmploye.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout)principal.getLayout()).show(principal, "employe");
					principal.repaint();
					principal.validate();
				}
			});
			
		}
		
		
		if(profil.equals("ADMINISTRATEUR") || profil.equals("EMPLOYE") )
		{
			JMenuItem mnAction = new JMenuItem("Comptes");
			mnAction.setMnemonic('c');
			menuBar.add(mnAction);
			
			
			JMenuItem mnClients = new JMenuItem("Clients");
			mnClients.setMnemonic('l');
			menuBar.add(mnClients);
			mnClients.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout)principal.getLayout()).show(principal, "client");
					principal.repaint();
					principal.validate();
					
				}
			});
			
			mnAction.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout)principal.getLayout()).show(principal, "compte");
					principal.repaint();
					principal.validate();
				}
			});
		}
		
		if(profil.equals("ADMINISTRATEUR") || profil.equals("EMPLOYE") )
		{
			JMenuItem mntmOperations = new JMenuItem("Operations");
			menuBar.add(mntmOperations);
			
			mntmOperations.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout)principal.getLayout()).show(principal, "operation");
					principal.repaint();
					principal.validate();
				}
			});
		}
		
		
		
		JMenuItem mnAPropos = new JMenuItem("A propos");
		mnAPropos.setMnemonic('p');
		menuBar.add(mnAPropos);
		
		JMenuItem mnAide = new JMenuItem("Aide ?");
		mnAide.setMnemonic('i');
		menuBar.add(mnAide);
		
		//listener
		mnAccueil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout)principal.getLayout()).show(principal, "Accueil");
				principal.repaint();
				principal.validate();
			}
		});
		
		
		
	}
	
	private void ihm(String profil){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Vue/images/logo.png")));
		setResizable(false);
		//setIconImage(new ImageIcon("images/logo.jpg").getImage());
		setTitle("    My Bank  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 478);
		setVisible(true);
		addMenu(profil);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Separator.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.activeCaption);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("    My Bank  ");
		lblNewLabel.setForeground(new Color(227, 115, 131));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 23));
		panel.add(lblNewLabel);
		
		principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		principal.setLayout(layout);
	}

	private void accueil(String profil){
		JPanel panel_2 = new JPanel();
		principal.add(panel_2, "Accueil");
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1));
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Main.class.getResource("/Vue/images/logo.png")));
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_4.add(panel_5);
		
		JLabel label_1 = new JLabel("Welcome");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel(" Your Bank  ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("Your way of life  ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(label_3);
		
		//JLabel label_4 = new JLabel("un suivi budgétaire de vos recettes et dépenses");
		//label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		final String debut;
		if(profil.equals("EMPLOYE"))
			 debut = "compte";
		else if(profil.equals("ADMINISTRATEUR") || profil.equals("EMPLOYE"))
				debut = "employe";
		else  debut = "operation";
		JButton button = new JButton("Begin");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)principal.getLayout()).show(principal, debut );
				principal.repaint();
				principal.validate();
			}
		});
		button.setForeground(new Color(227, 115, 131));
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(Color.PINK);
		panel_6.add(button);
	}

	private void compte(){
		this.principal.add(new VueCompte(),"compte");
	}
	private void client(){
		this.principal.add(new VueClientAdmin(),"client");
	}
	
}
