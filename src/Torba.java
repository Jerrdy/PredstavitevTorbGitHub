// Avtor: Andrej Pirc

// vključimo paket za delo z vhodno/izhodnimi napravami
import java.io.*;

// Vključimo paket za delo s pripomočki
import java.util.*;

// Dekleriramo javni razred
public class Torba {
	
	// deklariramo lastnost za vnos iz konzole
	private static BufferedReader in;
	
	// deklariramo zasebno statično lastnost seznama rotb
	private static ArrayList<StanjeTorbe> torbe;
	
	// dekleriramo javno statično metodo main
	// prejem: seznam vhodnih parametrov
	// vrne: nič
	public static void main(String[] args) {
	
		// v konzolo izpišemo pozdrav
		System.out.println("Priprava torbe!");
		
		// inicializiramo prazen seznam torb
		torbe = new ArrayList<StanjeTorbe>();
	
		// inicializiramo objekt in
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// inicializiramo in dekleriramo objekt/spremenljivko znamke
		String[] inputZnamk = new String[3]; 
		String z1;
		String z2;
		String z3;
		
		//Skušamo vprašati uporabnika kakšna je znamka
		try {
			System.out.println("Kakšne naj bodo tri znamke torb (loci s presledkom)? ");
			inputZnamk = in.readLine().split(" ");
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			System.out.println("Prišlo je do napake pri vnosu znamke: " + e.toString());
		}
		
		z1 = inputZnamk[0];
		z2 = inputZnamk[1];
		z3 = inputZnamk[2];
		
		
		// inicializiramo in dekleriramo objekt/spremenljivko nosilnosti
		String[] input = new String[3]; 
		int a;
		int b;
		int d;
		
		//Skušamo vprašati uporabnika kakšna je nosilnost
		try {
			System.out.println("Kakšna je nosilnost torb v kg (loci s presledkom)? ");
			input = in.readLine().split(" ");
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			System.out.println("Prišlo je do napake pri vnosu nosilnosti: " + e.toString());
		}
		
		a = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);
		d = Integer.parseInt(input[2]);
		
		
		// inicializiramo in dekleriramo objekt/spremenljivko kolicine
		String[] input1 = new String[3]; 
		int kol1;
		int kol2;
		int kol3;
		
		//Skušamo vprašati uporabnika kakšna je vsebina
		try {
			System.out.println("Kakšna je vsebina stvari v torbah v kg (loci s presledkom)? ");
			input1 = in.readLine().split(" ");
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			System.out.println("Prišlo je do napake pri vnosu kolicine: " + e.toString());
		}
		
		kol1 = Integer.parseInt(input1[0]);
		kol2 = Integer.parseInt(input1[1]);
		kol3 = Integer.parseInt(input1[2]);
		
		// inicializiramo in dekleriramo objekt/spremenljivko materiala
		String[] inputMa = new String[3]; 
		String ma1;
		String ma2;
		String ma3;
		
		//Skušamo vprašati uporabnika kakšen je matrial
		try {
			System.out.println("Kakšni naj bodo materiali treh torb (loci s presledkom)? ");
			inputMa = in.readLine().split(" ");
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			System.out.println("Prišlo je do napake pri vnosu znamke: " + e.toString());
		}
		
		ma1 = inputMa[0];
		ma2 = inputMa[1];
		ma3 = inputMa[2];
		
		// inicializiramo in dekleriramo objekt/spremenljivko prostornine meha za vodo
		String[] inputKl = new String[3]; 
		double kl1;
		double kl2;
		double kl3;
		
		//Skušamo vprašati uporabnika kakšna je prostornina meha za vodo
		try {
			System.out.println("Kakšna je prostornina vseh torb v litrih (loci s presledkom)? ");
			inputKl = in.readLine().split(" ");
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			System.out.println("Prišlo je do napake pri vnosu nosilnosti: " + e.toString());
		}
		
		kl1 = Double.parseDouble(inputKl[0]);
		kl2 = Double.parseDouble(inputKl[1]);
		kl3 = Double.parseDouble(inputKl[2]);
	
		// ustvarimo objekt (ga dekleriramo in inicializiramo tipa MainTorba) 
		StanjeTorbe pohodnaTorba = new StanjeTorbe(z1, a, kol1, ma1, kl1);
		StanjeTorbe tekaskaTorba = new StanjeTorbe(z2, b, kol2, ma2, kl2);
		StanjeTorbe vojaskaTorba = new StanjeTorbe(z3, d, kol3, ma3, kl3);
		
		// obstoječe objekte oddamo na seznam
		torbe.add(pohodnaTorba);
		torbe.add(tekaskaTorba);
		torbe.add(vojaskaTorba);
		
		System.out.println("===========================");
		
		// izpišemo celoten seznam torb
		for(int c=0; c<torbe.size(); c++) {
			
			System.out.println(torbe.get(c).getEtiketa());
		}
		
		// poskusimo vstaviti 
		tekaskaTorba.vstavimo(15);
		
		// preveromo ali je torba odprta
		pohodnaTorba.odpremo();
		
		// preverimo vsebino torbe
		System.out.println("V pohodni torbi " + z1 + " je " + pohodnaTorba.getVsebina() + " kg pohodne opreme!");
		
		// poskusimo vstaviti
		pohodnaTorba.vstavimo(30);
		
		// vstavimo želeno količino stvari
		pohodnaTorba.vstavimo(10);
		
		// preverimo vsebino torbe
		System.out.println("V pohodni torbi " + z1 + " je " + pohodnaTorba.getVsebina() + " kg pohodne opreme!");
		
		// preveromo ali je torba zaprta
		pohodnaTorba.zapremo();
		
		// preveromo ali je torba odprta
		pohodnaTorba.odpremo();
		
		// odstranimo željeno količino stvari
		pohodnaTorba.odstranimo(8);
		
		// preverimo vsebino torbe
		System.out.println("V pohodni torbi " + z1 + " je " + pohodnaTorba.getVsebina() + " kg pohodne opreme!");
		
		// odstranimo željeno količino stvari
		pohodnaTorba.odstranimo(4);
		
		// vstavimo želeno količino stvari
		pohodnaTorba.vstavimo(10);
		
		// preverimo vsebino torbe
		System.out.println("V tekaski torbi " + z2 + " je " + tekaskaTorba.getVsebina() + " kg solskih stvari!");
		
		// preveromo ali je torba odprta
		tekaskaTorba.odpremo();
		
		// poskusimo vstaviti 
		tekaskaTorba.vstavimo(15);
		
		// poskusimo vstaviti 
		tekaskaTorba.vstavimo(1);
		
		// preverimo vsebino torbe
		System.out.println("V vojaski torbi " + z3 + " je " + vojaskaTorba.getVsebina() + " kg takticne opreme!");
		
		// vstavimo želeno količino stvari
		vojaskaTorba.vstavimo(22);
		
		// preveromo ali je torba odprta
		vojaskaTorba.odpremo();
		
		// vstavimo želeno količino stvari
		vojaskaTorba.vstavimo(30);
		
		// vstavimo želeno količino stvari
		vojaskaTorba.vstavimo(13);
		
		// preverimo vsebino torbe
		System.out.println("V pohodni torbi " + z1 + " je " + pohodnaTorba.getVsebina() + " kg opreme za v gore!");
		
		// preverimo vsebino torbe
		System.out.println("V tekaski torbi " + z2 + " je " + tekaskaTorba.getVsebina() + " kg stvari za tek!");
		
		// preverimo vsebino torbe
		System.out.println("V vojaski torbi " + z3 + " je " + vojaskaTorba.getVsebina() + " kg takticne opreme!");
		
		// spijemo količino tekočine iz meha
		vojaskaTorba.praznenje(0.5);
		
		// spijemo količino tekočine iz meha
		vojaskaTorba.praznenje(0.8);
		
		// dotočimo tekočino v meh za vodo
		vojaskaTorba.dotocimo(5.0);
		
		// preverimo stanje torbe
		vojaskaTorba.popravimo();
		
	}
}