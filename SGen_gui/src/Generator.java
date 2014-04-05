import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Generator extends JFrame 
{
    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
    Color bijela = new Color(0xf5, 0xf5, 0xf5);
    Color svijetlo_plava = new Color (0x69, 0x91, 0xac);
    JTextArea gen_label2 = new JTextArea();
    JPanel generator_text2 = new JPanel();
    
// -------------------- PODACI ZA POVEZIVANJE -----------------------//
    
//string popis_razreda i smjena povezan je sa menijem kod rasporeda za izbor razreda
    String [] popis_razreda={"1.a)","2.a)","3.a)","4.a)","5.a)","6.a)","7.a)","8.a)"};
    String [] smjena = {"Prijepodne","Poslijepodne"};
    
    // ----------------- sat ne mijenjati --------------
    String [] sat = {"1.sat","2.sat","3.sat","4.sat","5.sat","6.sat","7.sat","8.sat"};
    // Zamjeniti podatke koji se zovu podatak sa vasim podacima iz matrice.
    // Zanemariti gdje pise sat[], to mora ostati tako za sada
    String [][] podaci = 
    		{
    		{sat[0],"podatak0pon","podatak0uto","podatak","podatak","podatak","podatak"},
			{sat[1],"podatak1pon","podatak1uto","podatak1...","podatak","podatak","podatak"},
			{sat[2],"podatak2pon","podatak2uto..","podatak","podatak","podatak","podatak"},
			{sat[3],"podatak3pon","podatak...","podatak","podatak","podatak","podatak"},
			{sat[4],"podatak...","podatak","podatak","podatak","podatak","podatak"},
			{sat[5],"podatak","podatak","podatak","podatak","podatak","podatak"}
			};
    //
    
    public Generator() {
    	setTitle("Schedule Generator v1.0");
    	setResizable(false);
    	UIManager.put("TabbedPane.selected", new Color(0x69, 0x91, 0xac));
    	Font obicni = new Font ("Times New Roman", Font.BOLD, 18);
    	Font naslov = new Font ("Times New Roman", Font.BOLD, 32);
        tabbedPane = new JTabbedPane();
        tabbedPane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        tabbedPane.setPreferredSize(new Dimension(1024, 768));
        
//--------------------- GLAVNI BANNER ------------------------------------------------------------------------//
        getContentPane().add(tabbedPane);
        JPanel glavni_banner = new JPanel();
        tabbedPane.add(glavni_banner, "");
        tabbedPane.setBackground(new Color(0x46, 0x59, 0x67));

//--------------------- GENERATOR ------------------------------------------------------------------------//
// SADRZAJ
        JPanel glavni_generator = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JScrollPane generator_panel_scroll = new  JScrollPane(glavni_generator,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        generator_panel_scroll.setPreferredSize(new Dimension(800,768));
        tabbedPane.add(generator_panel_scroll,"Generator"); 
        tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tabbedPane.setForeground(new Color(0xf5, 0xf5, 0xf5));
        
        JTextArea gen_label1 = new JTextArea();
        JLabel gen_naslov = new JLabel();
        gen_label1.setFont(obicni);
        gen_naslov.setFont(naslov);
        gen_label1.setLineWrap(true);
        gen_label1.setAlignmentX(LEFT_ALIGNMENT);
        gen_label1.setWrapStyleWord(true);
        gen_label1.setEditable(false);
        gen_label1.setSize(800,768);
        gen_label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gen_label1.setForeground(bijela);
        
        JLabel prijava=new JLabel("");
        Icon slika_prijava = new ImageIcon(getClass().getResource("/resources/prijava.png"));
        prijava.setIcon(slika_prijava); 
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=2;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.NORTHEAST;
        glavni_generator.add(prijava,gbc);
        
        JLabel naslov_gen=new JLabel("");
        Icon slika_naslov_gen = new ImageIcon(getClass().getResource("/resources/naslov_gen.png"));
        naslov_gen.setIcon(slika_naslov_gen); 
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        glavni_generator.add(naslov_gen,gbc);
        
        gen_label1.setText("Dobrodošli na stranicu SGen-a! SGen (Schedule Generator) je besplatan generator rasporeda za osnovne i srednje škole. SGen-u su, pri izradi rasporeda, u prvom planu upravo nastavnici. Nema više rasporeda sati u kojemu zbog 4 nastavna sata gubite cijeli dan. SGen vodi raèuna o velièinama i broju rupa u rasporedima nastavnika, pa možete imati najviše jedan slobodan sat koji možete iskoristiti za roditeljske informacije.\n\nSGen-u su, pri izradi rasporeda, u prvom planu upravo nastavnici. Nema više rasporeda sati u kojemu zbog 4 nastavna sata gubite cijeli dan. SGen vodi raèuna o velièinama i broju rupa u rasporedima nastavnika, pa možete imati najviše jedan slobodan sat koji možete iskoristiti za roditeljske informacije. SGen brine i o težinama pojedinih predmeta, tako da se neæe više dogaðati da svi predmeti koji su uèenicima najteži budu jedni iza drugih. Izradite raspored sati koji neæe rezultirati dnevnim preoptereæenjem uèenika.\n\n Za detaljni opis moguænosti kliknite na gumb 'više'.");
        JPanel generator_text = new JPanel();
        gbc.gridx=1;
        gbc.gridy=1; 
        gbc.weightx=1;
        gbc.weighty=1;

        glavni_generator.add(generator_text,gbc);
        gen_label1.setBackground(svijetlo_plava);
        generator_text.setBackground(svijetlo_plava);
        generator_text.add(gen_label1);
        
        gbc.anchor=GridBagConstraints.NORTHEAST;
        gbc.gridx=1;
        gbc.gridy=4; 
        gbc.weightx=1;
        gbc.weighty=5;
        
        JButton btn_vise = new JButton();
        btn_vise.setText("Više");
        btn_vise.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        glavni_generator.add(btn_vise,gbc);
        btn_vise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            if(!generator_text2.isVisible()) generator_text2.setVisible(true);
            
            else if(generator_text2.isVisible()) generator_text2.setVisible(false);
            }
         });
        
        gbc.gridx=1;
        gbc.gridy=3; 
        gbc.weightx=0;
        gbc.weighty=2;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        
        generator_text2.setVisible(false);
        glavni_generator.add(generator_text2,gbc);
        gen_label2.setBackground(svijetlo_plava);
        generator_text2.setBackground(svijetlo_plava);
        generator_text2.add(gen_label2);
        // Dopisati dodatni tekst koji se prikaze kada se klikne na gumb "više"
        gen_label2.setText("\n TODO: DODATNI TEKST \n");
        gen_label2.setFont(obicni);
        gen_naslov.setFont(naslov);
        gen_label2.setLineWrap(true);
        gen_label2.setAlignmentX(LEFT_ALIGNMENT);
        gen_label2.setWrapStyleWord(true);
        gen_label2.setEditable(false);
        gen_label2.setSize(800,768);
        gen_label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gen_label2.setForeground(bijela);
//---------------------------------------------------------------------------------------------//
        
//--------------------- NASTAVNICI -------------------------
        JTextField info = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(info, "Nastavnici");
        //---obrisati liniju koda ispod da se omoguci pristup meniju---
        tabbedPane.setEnabledAt(2, false);
//-----------------------------------------------------------------
        
//--------------------- PREDMET -------------------------        
        JTextField two = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(two, "Predmet");
        //---obrisati liniju koda ispod da se omoguci pristup meniju---
        tabbedPane.setEnabledAt(3, false);
//-----------------------------------------------------------------
        
//--------------------- RAZRED -------------------------   
        JTextField treci = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(treci, "Razred");
        //---obrisati liniju koda ispod da se omoguci pristup meniju---
        tabbedPane.setEnabledAt(4, false);
//-----------------------------------------------------------------
//----------------------UCIONICE---------------------------------
        JTextField cetvrti = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(cetvrti, "Uèionice");
        //---obrisati liniju koda ispod da se omoguci pristup meniju---
        tabbedPane.setEnabledAt(5, false);
//-----------------------------------------------------------------
//--------------------------RASPORED---------------------------
        JPanel glavni_raspored = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        JScrollPane raspored_panel_scroll = new  JScrollPane(glavni_raspored,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        raspored_panel_scroll.setPreferredSize(new Dimension(800,768));
        tabbedPane.add(raspored_panel_scroll,"Generator"); 
        tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tabbedPane.setForeground(new Color(0xf5, 0xf5, 0xf5));
        
        JLabel naslov_ras=new JLabel("");
        Icon slika_naslov_ras = new ImageIcon(getClass().getResource("/resources/naslov_ras.png"));
        naslov_ras.setIcon(slika_naslov_ras); 
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        glavni_raspored.add(naslov_ras,gbc);
        
        JLabel prijava1=new JLabel("");
        Icon slika_prijava1 = new ImageIcon(getClass().getResource("/resources/prijava.png"));
        prijava1.setIcon(slika_prijava1); 
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=2;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.NORTHEAST;
        glavni_raspored.add(prijava1,gbc);
        
        JPanel raspored_grid = new JPanel(new GridLayout(3,2,10,10));
        
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=20;
        gbc.fill = GridBagConstraints.NONE;
        glavni_raspored.add(raspored_grid,gbc);
        raspored_grid.setBackground(svijetlo_plava);
        raspored_grid.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10));
        
        JLabel ras_label1= new JLabel();
        ras_label1.setText("Razred: ");
        ras_label1.setFont(obicni);
        ras_label1.setForeground(bijela);
        raspored_grid.add(ras_label1);

        JComboBox box_popis_razreda = new JComboBox(popis_razreda);
        raspored_grid.add(box_popis_razreda);
        
        JLabel ras_label2= new JLabel();
        ras_label2.setFont(obicni);
        ras_label2.setForeground(bijela);
        ras_label2.setText("Smjena: ");
        raspored_grid.add(ras_label2);

        JComboBox box_smjena= new JComboBox(smjena);
        raspored_grid.add(box_smjena);
        
        JLabel ras_label3= new JLabel();
        ras_label3.setFont(obicni);
        ras_label3.setForeground(bijela);
        ras_label3.setText("Raspored vrijedi: od");
        raspored_grid.add(ras_label3);
        
        // ------------------------TABLICA-----------------------
        String [] raspored_dan={" ","Ponedjeljak","Utorak","Srijeda","Èetvrtak","Petak","Subota"};

        JPanel raspored_panel = new JPanel();
        raspored_panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10));
        raspored_panel.setLayout( new BorderLayout() );
		JTable raspored = new JTable(podaci,raspored_dan);
		JScrollPane scroll_raspored = new JScrollPane(raspored,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		raspored_panel.add(scroll_raspored , BorderLayout.CENTER );
		raspored.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//raspored_panel.setBackground(svijetlo_plava);
		raspored_panel.setBorder(BorderFactory.createLineBorder(svijetlo_plava, 5));
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 100.0;
		gbc.weightx = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth=2;
		//gbc.gridwidth=GridBagConstraints.REMAINDER;
        glavni_raspored.add(raspored_panel,gbc);
        
        raspored.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        //-------------------------- kraj tablice -------------------
        
        JButton btn_ispis_t = new JButton();
        btn_ispis_t.setText("Ispis tablice");
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=20;
        gbc.fill = GridBagConstraints.NONE;
        glavni_raspored.add(btn_ispis_t,gbc);
        
        btn_ispis_t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
           // Kod koji se izvodi kada se klikne "Ispis tablice"
            	
           // provjera  sto je odabrano u padajucem izborniku se radi pomocu:
           // npr. za popis razreda: box_popis_razreda.getSelectedItem();
            	
            }
         });
        

  // ---------------- promjena velicine stupca u tablici ---------------------------
		 raspored.setRowHeight(50);
		TableColumn column = null;
		 for (int i = 0; i < 7; i++)
		 {
			 column = raspored.getColumnModel().getColumn(i);
			 column.setPreferredWidth(115);
		 }
		
//---------------------KONTAKT-----------------------
        JTextField sest = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(sest, "Kontakt");
        //---obrisati liniju koda ispod da se omoguci pristup meniju---
        tabbedPane.setEnabledAt(7, false);
//-------------------------------------------------------
        //Ostatak menija - dodatni
        JTextField sedam = new JTextField("WORK IN PROGRESS");
        tabbedPane.add(sedam, "");
//-----------------------------------------------------------------
        
        //----- postavlja slike na glavnom meniju (tabovima) -----------------
        // ---- GLAVNI BANNER -----
        JLabel slika_glavniBanner=new JLabel("");
        Icon slika_glavni_banner = new ImageIcon(getClass().getResource("/resources/Sgen.png"));
        slika_glavniBanner.setIcon(slika_glavni_banner);
        tabbedPane.setTabComponentAt(0, slika_glavniBanner);
        
     // ---- Generator - menu -----
        JLabel slika_generator=new JLabel("");
        Icon ikona_generator = new ImageIcon(getClass().getResource("/resources/gen.png"));
        slika_generator.setIcon(ikona_generator);
        tabbedPane.setTabComponentAt(1, slika_generator);
        
        // ---- Nastavnici - menu -----
        JLabel slika_nastavnici=new JLabel("");
        Icon ikona_nastavnici = new ImageIcon(getClass().getResource("/resources/nastavnici.png"));
        slika_nastavnici.setIcon(ikona_nastavnici);
        tabbedPane.setTabComponentAt(2, slika_nastavnici);

        
        // ---- Predmet - menu -----
        JLabel slika_predmet=new JLabel("");
        Icon ikona_predmet = new ImageIcon(getClass().getResource("/resources/predmet.png"));
        slika_predmet.setIcon(ikona_predmet);
        tabbedPane.setTabComponentAt(3, slika_predmet);

        
        // ---- razred - menu -----
        JLabel slika_razred=new JLabel("");
        Icon ikona_razred = new ImageIcon(getClass().getResource("/resources/razred.png"));
        slika_razred.setIcon(ikona_razred);
        tabbedPane.setTabComponentAt(4, slika_razred);

        
        // ---- ucionice - menu -----
        JLabel slika_ucionice=new JLabel("");
        Icon ikona_ucionice = new ImageIcon(getClass().getResource("/resources/ucionice.png"));
        slika_ucionice.setIcon(ikona_ucionice);
        tabbedPane.setTabComponentAt(5, slika_ucionice);

        
        // ---- raspored - menu -----
        JLabel slika_raspored=new JLabel("");
        Icon ikona_raspored = new ImageIcon(getClass().getResource("/resources/raspored.png"));
        slika_raspored.setIcon(ikona_raspored);
        tabbedPane.setTabComponentAt(6, slika_raspored);
        
        // ---- kontakt - menu -----
        JLabel slika_kontakt=new JLabel("");
        Icon ikona_kontakt = new ImageIcon(getClass().getResource("/resources/kontakt.png"));
        slika_kontakt.setIcon(ikona_kontakt);
        tabbedPane.setTabComponentAt(7, slika_kontakt);
        
        // ---- version - menu -----
        JLabel slika_version=new JLabel("");
        Icon ikona_version = new ImageIcon(getClass().getResource("/resources/version.png"));
        slika_version.setIcon(ikona_version);
        tabbedPane.setTabComponentAt(8, slika_version);
      //-----------------------------------------------------------------
        tabbedPane.setEnabledAt(0, false);
        tabbedPane.setEnabledAt(8, false);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setSelectedIndex(1); 
    }
    
    public static void main(String args[]) 
    {
        Generator frame = new Generator();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}