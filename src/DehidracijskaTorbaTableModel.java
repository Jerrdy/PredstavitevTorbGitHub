// Avtor: Andrej Pirc

// uvozimo paket za delo s tabelami
import javax.swing.table.*;

// uvozimo paket za delo s pripomočki
import java.util.*;

//dekleriramo javni razred za model tabele
public class DehidracijskaTorbaTableModel extends DefaultTableModel {
	
	// deklariramo lastnosti
	private ArrayList<DehidracijskaTorba> torbe;
	
	// konstruktor
	public DehidracijskaTorbaTableModel() {
		super();
		
		// inicializiramo lastnosti
		torbe = new ArrayList<DehidracijskaTorba>();
		
		// dodamo stolpce
		addColumn("Znamka");
		addColumn("Nosilnost");
		addColumn("Vsebina");
		addColumn("Material");
		addColumn("Vodni meh");
	}
	
	// metoda, ki doda dehidracijsko torbo v model tabele
	public void addDehidracijskaTorba(DehidracijskaTorba dt) {
		
		// dodamo objekt v argument na seznam
		torbe.add(dt);
		
		// ustvarimo seznam objektov za vrstico v tabeli
		Object[] vrstica = new Object[]{dt.getZnamka(), dt.getNosilnostTorbe(), dt.getVsebina(), dt.getMaterial(), dt.getVodniMeh()};
		
		// dodamo vrstico v tabelo
		addRow(vrstica);
	}
}