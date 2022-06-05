// Avtor: Andrej Pirc

// Dekleriramo javni razred
public class MainTorba {
	
	// Deklariramo lastnosti
	private String znamka;
	private int nosilnostTorbe;			// v kg
	private int vsebina;				// v kg
	private boolean jeOdprta;
	
	// deklariramo javni konstruktor ki bo ustvaril novo torbo
	// ustvarimo zaprte torbe
	// parametri: znamka, nosilnost, trenutna vsebina
	// vrača: nov objekt razreda MainTorba
	public MainTorba (String z, int n, int v) {
		
		// inicializiramo lastnosti
		znamka = z;
		nosilnostTorbe = n;
		vsebina = v;
		jeOdprta = false;
		
		// izpišemo dogodek
		System.out.println("Ustvarjam torbo " + znamka + " z nosilnostjo " + nosilnostTorbe + "kg!");
	}
	
	// deklariramo metoda ki odpre torbo
	// argumenti: /
	// vrača: odprta ali zaprta
	public boolean odpremo() {
		
		// če je torba že odprta
		if(jeOdprta) {
			System.out.println("Torba je že odprta.");
			return false;
		}
		
		// če je torba še zaprta
		else {
			System.out.println("Odpiram torbo ...");
			jeOdprta = true;
			return true;
			
		}		
	}
	
	// deklariramo metoda ki odpre torbo
	// argumenti: /
	// vrača: odprta ali zaprta
	public boolean zapremo() {
		
		// če je torba že odprta
		if(jeOdprta == false) {
			System.out.println("Torba je že zaprta.");
			return false;
		}
		
		// če je torba še zaprta
		else {
			System.out.println("Zapiram torbo ...");
			jeOdprta = false;
			return false;
			
		}		
	}
	
	// deklariramo metodo, ki vstavlja stvari v torbo (zapolni vsebino)
	// parametri: količina ki jo želimo vstaviti
	// vrača: količina ki je še ostala
	public int vstavimo(int s) {
		
		// če je torba odprta
		if(jeOdprta == true) {
					
			// preverimo če lahko vstavimo želeno količino stvari v torbo
			if((vsebina + s) > nosilnostTorbe) {
			
				//izpišemo neizvedljivo vstavitev stvari
				vsebina = vsebina;
				System.out.println("Nosilnost torbe je premajhna za količino stvari, ki jih želite vstaviti!");
			}
		
			// če je v torbi dovolj prostora za željene stvari
			else {
				// vstavimo stvari v torbo
				vsebina = vsebina + s;
				System.out.println("V torbo vstavimo " + s + "kg stvari.");
			}
		}
		
		// če je torba zaprta
		else {
			System.out.println("Torba je zaprta!");
		}
		
		// vrnemo vsebino ki je še ostala
		return vsebina;
	}
	
	// deklariramo metodo, ki odstrsni stvari iz torbe
	// parametri: količina ki jo želimo odstraniti
	// vrača: količina ki je še ostala
	public int odstranimo(int o) {
		
		// če je torba odprta
		if(jeOdprta == true) {
			
			// če je v torbi še dovolj stvari
			if(vsebina >= o) {
			
				//izpišemo odstranitev željene količine stvari
				vsebina = vsebina - o;
				System.out.println("Iz torbe vzamemo " + o + "kg stvari in v torbi preostane še " + vsebina + "kg stvari.");
			}
		
			// če je v torbi manj stvari kot jih želimo odstraniti
			else {
				// odstranimo vse kar je v torbi
				vsebina = 0;
				System.out.println("Iz torbe vzamemo " + o + "kg stvari in torba je izpraznjena!");
			}	
		}
		
		// če je torba zaprta
		else {
			System.out.println("Torba je zaprta!");
		}
		
		// vrnemo vsebino ki je še ostala
		return vsebina;
	}
	
	// preverimo trenutno vsebino torbe (getter metoda)
	public int getVsebina() {
		return vsebina;
	}
	
	// preverimo znamko torbe (getter metoda)
	public String getZnamka() {
		return znamka;
	}
	
	// preverimo nosilnost torbe (getter metoda)
	public int getNosilnostTorbe() {
		return nosilnostTorbe;
	}
	
}	
	