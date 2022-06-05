// Avtor: Andrej Pirc

// uvozimo paket Swing
import javax.swing.*; 

// uvozimo paket za delo z dogotki
import java.awt.event.*;

//dekleriramo javni razred SeznamTorb razširja razred JFrame
public class SeznamTorb extends JFrame implements ActionListener {
	
	// dekleriramo lastnosti za uporabniški vmesnik
	private JPanel povrsina;
	
	private JLabel besediloZnamka;
	private JTextField vnosnoPoljeZnamka;
	private JLabel besediloNosilnost;
	private JTextField vnosnoPoljeNosilnost;
	private JLabel besediloVsebina;
	private JTextField vnosnoPoljeVsebina;
	private JLabel besediloMaterial;
	private JTextField vnosnoPoljeMaterial;
	private JLabel besediloVodniMeh;
	private JTextField vnosnoPoljeVodniMeh;
	
	private JButton gumb;
	private DehidracijskaTorbaTableModel modelTabele;
	private JTable tabela;
	
	// dekleriramo konstruktor
	public SeznamTorb(String s) {
		
		// kličemo konstruktor nadrazreda
		super(s);
		
		// inicializiramo lastnosti objekta
		povrsina = new JPanel();
		
		besediloZnamka = new JLabel("Znamka torbe");
		vnosnoPoljeZnamka = new JTextField(32);
		besediloNosilnost = new JLabel("Nosilnost torbe");
		vnosnoPoljeNosilnost = new JTextField(32);
		besediloVsebina = new JLabel("Količina trenutne vsebine");
		vnosnoPoljeVsebina = new JTextField(32);
		besediloMaterial = new JLabel("Material torbe");
		vnosnoPoljeMaterial = new JTextField(32);
		besediloVodniMeh = new JLabel("Prostornina vodnega meha");
		vnosnoPoljeVodniMeh = new JTextField(32);
		
		gumb = new JButton("Dodaj torbo!");
		modelTabele = new DehidracijskaTorbaTableModel();
		tabela = new JTable(modelTabele);
		
		// gumbu dodamo poslušalca dogodkov
		// kot vhodni podatek mu damo kazalec na samega sebe
		gumb.addActionListener(this);
		
		// površino dodamo v okno
		add(povrsina);
		
		// vnosna polja dodamo na površino
		povrsina.add(besediloZnamka);
		povrsina.add(vnosnoPoljeZnamka);
		povrsina.add(besediloNosilnost);
		povrsina.add(vnosnoPoljeNosilnost);
		povrsina.add(besediloVsebina);
		povrsina.add(vnosnoPoljeVsebina);
		povrsina.add(besediloMaterial);
		povrsina.add(vnosnoPoljeMaterial);
		povrsina.add(besediloVodniMeh);
		povrsina.add(vnosnoPoljeVodniMeh);
		
		// gumb in tabelo dodamo na površino
		povrsina.add(gumb);
		povrsina.add(tabela);
		
		// prikažemo okno - kličemo metodo nadrazreda
		setVisible(true);
		
		// nastavimo obnašanje gumbka za zapiranje - naj konča aplikacijo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// nastavimo privzeto velikost okna
		setSize(500, 400);
		
		System.out.println("Pripravljam seznam " + s);
	}
	
	// dekleriramo javno statično metod za zagon programa
	// vhodni: seznam nizov z argumenti za zagon
	// izhod: /
	public static void main(String[] args) {
		
		// če je podan argument ustvari objekt
		if(args.length > 0) {
			
			// Ustvarimo objekt (lokalno spremenljivko)
			SeznamTorb t = new SeznamTorb(args[0]);
		}
		// sicer javi, da je potrebno program zagnati z argumentom
		else {
			System.out.println("Ne morem pripraviti seznama brez naslova seznama");
			System.out.println("Namen:");	
			System.out.println("java SeznamTorb ...");
		}
	}

	// javna metoda, ki jo predpisuje vmesnik
	// se izvede ko je pritisnjen gumb
	public void actionPerformed(ActionEvent e) {
		System.out.println("Gumb pritisnjen!");
		
		// pretvorimo string v intiger
		int nos = Integer.parseInt(vnosnoPoljeNosilnost.getText());
		int vse = Integer.parseInt(vnosnoPoljeVsebina.getText());
		
		// pretvorimo string v double
		double vm = Double.parseDouble(vnosnoPoljeVodniMeh.getText());
		
		// dodamo nov zapis v tabelo
		modelTabele.addDehidracijskaTorba(new DehidracijskaTorba(vnosnoPoljeZnamka.getText(), nos, vse, vnosnoPoljeMaterial.getText(), vm));
	}
}