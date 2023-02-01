package Controleur;

import Modele.gestionBanque.MdlConnexion;
import Vue.Main;
import Vue.MainGui;
import Vue.VueConnexion;

import javax.swing.*;
 /**
 * author nohayla
 * version 1
 * 
 */

public class CtlConnexion {
    private VueConnexion vue;
    private MdlConnexion model;

     public CtlConnexion(VueConnexion vue, MdlConnexion model) {
        this.vue = vue;
        this.model = model;
    }
     /**
     * S'authentifier
     * 
     */
    
    public void authentification()
    {
        if(model.authentifierAgent())
        {
            new Main(model.getProfil());
            vue.setVisible(false);
            vue.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(vue, "Erreur d'authentification! veuillez ressayer");
        }
    }




}
