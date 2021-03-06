package vue.Tests;

import controleur.DonneesUtiles;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vue.ElementsVisuels.PaysanVue;
import vue.ElementsVisuels.UniteVue;
import vue.ecouteurs.MovementListener;

/**
 *
 * @author Christo Cette classe est le chantier du déplacement des unités, ce
 * sera une frame dans laquelle j'essairai de déplacer un paysan à l'aide des
 * flèches et des touches awsd
 */
public class Mouvements extends JFrame {

    // Données membres
    /*
     Je vais créer une liste pour tous les paysans
     Comme ça je vais pouvoir appliquer mes algorithmes
     de collision sur toute la liste de façon simple et
     rapide!
     */
    private ArrayList<UniteVue> paysans = new ArrayList<UniteVue>();
    // Un panneau pour bien contrôler le positionnement
    private JPanel panMouvements = new JPanel(new GridLayout(1, 1));
    // Un paysan
    private PaysanVue patientZero, patientDeux, patientTrois;

    // *************************************************************************
    // Constructeurs
    public Mouvements() {
        super();
        initComponents();
        initListeners();
        initFrame();
    }

    // *************************************************************************
    // Méthodes spécifiques
    public void initFrame() {
        this.setUndecorated(true);
        this.setTitle("The void");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setLayout(new GridLayout(100, 100));
        this.setVisible(true);
    }

    public void initComponents() {
        /*Je vais ajouter des paysans dans le panneau panMouvements pour
         observer le comportement des méthodes que j'ai développer dans la
         classe paysan
         */
        patientZero = new PaysanVue();
        patientDeux = new PaysanVue();
        // On doit définir manuellement les coordonnées des paysans
        patientZero.setLocation(0, 30);
        patientDeux.setLocation(0, 0);
        
        paysans.add(patientZero);
        paysans.add(patientDeux);
        
        for (UniteVue u : paysans){
            add(u);
            revalidate();
        }
    }

    public void initListeners() {
        // Déclaration d'un écouteur pour les touches directionnelles
        MovementListener ecoDirections = new MovementListener(paysans);
        
        // Ajout de l'écouteur au panneau de test
        getContentPane().addKeyListener(ecoDirections);
        this.addKeyListener(ecoDirections);
        
    }
    // *************************************************************************
    // Zone de test
    public static void main(String[] args) {
        new Mouvements();
    }
    
}
