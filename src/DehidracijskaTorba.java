// dekleriramo javni razred DehidracijskaTorba ki razširja razred MainTorba
public class DehidracijskaTorba extends MainTorba {
	
	// vse lastnosti ki jih imajo ostale torbe
	// dodatne lastnosti ki veljajo le za pohodne torbe
	private String material;
	private double vodniMeh;			// v L
	private double kolVsebineMeha;   	// v L
	
	// konstruktor
	// ustvarimo torbe ki vsebujejo meh za vodo
	// vhodi: znamka, nosilnost, trenutna vsebina, materijal, prostornina meha za vodo
	//vrne: nov objekt tipa DehidracijskaTorba
	public DehidracijskaTorba (String z, int n, int v, String m, double l) {
		
		// pokličemo konstruktor nadrazreda
		super(z, n, v);
		
		// inicializiramo dodatne lastnosti
		material = m;
		vodniMeh = l;
		kolVsebineMeha = l;
		
	}
	
	// deklariramo metodo, ki zmanjša količino vsebine meha
	// parametri: količina ki jo želimo izprazniti
	// vrača: količina ki je še ostala
	public double praznenje(double g) {
			
		// če je v mehu dovolj tekočine
		if(kolVsebineMeha >= g) {
			
			//od količine vsebine odštejemo količino za praznenje
			kolVsebineMeha = kolVsebineMeha - g;
			System.out.println("Iz meha spijemo " + g + "L.");
		}
		
		// če v steklenici ni dovolj vsebine
		else {
			// izpraznimo vse kar je v steklenici
			kolVsebineMeha = 0;
			System.out.println("Meh za vodo je izpraznjen!");
		}

		// vrnemo količino ki je še ostala
		return kolVsebineMeha;
	}
	
	// deklariramo metodo, ki poveča količino vsebine meha
	// parametri: količina ki jo želimo dotočiti
	// vrača: količina ki je še ostala
	public double dotocimo(double f) {
			
		// če v meh za vodo želimo dotočiti večjo količino kot jo lahko
		if((kolVsebineMeha + f) > vodniMeh) {
			
			//izenačimo količino z prostornino meha
			kolVsebineMeha = vodniMeh;
			System.out.println("Želimo dotočiti " + f + "L tekočine. Meh za vodo je napolnjen!");
		}
		
		// če želimo dotočiti količino ki ne presega polne kapacitete
		else {
			// izenačimo količino z prostornino meha
			kolVsebineMeha = kolVsebineMeha + f;
			System.out.println("V meh za vodo smo dotočili " + f + "L tekočine!");
		}

		// vrnemo količino ki je še ostala
		return kolVsebineMeha;
	}
	
	// metoda vrne vsebino etikete
	// vhod: /
	// vrne: podatki na etiketi
	public String getEtiketa() {
		
		String ret = " === TORBA === \n";
		ret += " Znamka: " + getZnamka() + "\n";
		ret += " Nosilnost: " + getNosilnostTorbe() + "kg\n";
		ret += " Vsebina: " + getVsebina() + "kg\n";
		ret += " Material: " + material + "\n";
		ret += " Vodni meh: " + vodniMeh + "L\n";
		ret += " ==============\n";
		return ret;
	}
	
	// preverimo material torbe (getter metoda)
	public String getMaterial() {
		return material;
	}
	
	// preverimo preverimo prostornino meha za vodo (getter metoda)
	public double getVodniMeh() {
		return vodniMeh;
	}
	
	// preverimo trenutno količino vode v mehu (getter metoda)
	public double getKolVsebineMeha() {
		return kolVsebineMeha;
	}
	
}