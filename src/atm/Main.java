package atm;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Integer> id;
	public static ArrayList<String> username;
	public static ArrayList<String> sifre;
	public static ArrayList<String> ad;
	public static ArrayList<String> soyad;
	public static ArrayList<String> egitim;
	public static ArrayList<String> dogum;
	public static ArrayList<Integer> bakiye;
	
	public static void main(String[] args) {
		id=new ArrayList<>();
		username=new ArrayList<>();
		sifre=new ArrayList<>();
		ad=new ArrayList<>();
		soyad=new ArrayList<>();
		egitim=new ArrayList<>();
		dogum=new ArrayList<>();
		bakiye=new ArrayList<>();
		
		id.add(1000);
		username.add("admin");
		sifre.add("Admin123");
		ad.add("Admin");
		soyad.add("Admin");
		egitim.add("Lisans");
		dogum.add("2004");
		bakiye.add(5000);
		
		Giris giris=new Giris();
		giris.setVisible(true);
	}

}
