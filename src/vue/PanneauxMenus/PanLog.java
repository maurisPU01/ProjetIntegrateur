package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 * ReCommenté par Christo Mondor
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PanLog extends PanElder {

    private JScrollPane scrollLog;
    private JTextArea textLog;
    private JPanel panHaut, panBas, panLog, cePanneau;
    private JButton bOK;

    public PanLog() {
        super();
        initComponents();
        initListeners();
        this.setSize(400, 250);
    }

    // Methodes spécifiques
    public void initComponents() {
        // Pour accéder à cet objet à partir des action listeners on déclare et on initie une variable globale à
        // la classe qui contient ce panneau
        this.cePanneau = this;
        // Un panneau 2 par un en grilayout pour contenir le tout
        panLog = new JPanel(new GridLayout(2, 1, 10, 10));
        // Un panneau qui contient le journal de bord du jeu (log)
        panHaut = new JPanel(new GridLayout(1, 1, 10, 10));
        // Panel bas qui contient le bouton de retour
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Messages");
        panLog.setBorder(titre);
        textLog = new JTextArea();
        textLog.setColumns(30);
        textLog.setLineWrap(true);
        textLog.setRows(5);
        textLog.setWrapStyleWord(true);
        textLog.setEditable(false);
        textLog.setText("Tous les messages in-game apparaissent ici. Si vous n'avez pas eu le temps de lire ou tout simplement manquez un peu de mmoire ;)");
        scrollLog = new JScrollPane(textLog);
        panHaut.add(scrollLog);
        bOK = new JButton("     OK     ");
        panBas.add(bOK);
        panLog.add(panHaut);
        panLog.add(panBas);
        add(panLog);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                disposerDuCadreDuPanneau(cePanneau);
            }
        });
    }
	
	public JTextArea getJTextAreaLog(){
        return textLog;
    }
	
    //MAIN POUR TESTER
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanLog());
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
