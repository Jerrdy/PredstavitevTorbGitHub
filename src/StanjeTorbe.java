// dekleriramo javni razred StanjeTorbe ki razširja razred DehidracijskaTorba
public class StanjeTorbe extends DehidracijskaTorba {
	
	// vse lastnosti ki jih imajo ostale torbe
	// dodatne lastnosti ki veljajo le za stanje torbe
	private boolean poskodovana;
	
	// konstruktor
	// ustvarimo poškodovane torbe
	// vhodi: znamka, nosilnost, trenutna vsebina, materijal, prostornina meha za vodo, stanje
	//vrne: nov objekt tipa DehidracijskaTorba
	public StanjeTorbe (String z, int n, int v, String m, double l) {
		
		// pokličemo konstruktor nadrazreda
		super(z, n, v, m, l);
		
		// inicializiramo dodatne lastnosti
		poskodovana = false;
		
	}
	
	// deklariramo metoda ki popravi torbo
	// argumenti: /
	// vrača: stanje torbe
	public boolean popravimo() {
		
		// če je torba poskodovana
		if(poskodovana) {
			System.out.println("Torba je poskodovana! Popravljam torbo...");
			return false;
		}
		
		// če je torba v dobrem stanju
		else {
			System.out.println("Torba je v dobrem stanju!");
			poskodovana = true;
			return true;
			
		}		
	}
}