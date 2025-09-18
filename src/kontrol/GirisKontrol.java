package kontrol;

import atm.Main;

public class GirisKontrol {
	private String username, sifre;
	
	public GirisKontrol(String username, String sifre) {
		this.username=username;
		this.sifre=sifre;
	}
	
	public boolean bosKontrolu() {
		if(username.isEmpty() || sifre.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esitlikKontrolu(int usernameGiris, String sifreGir) {
		if(Main.sifre.get(usernameGiris).equals(sifreGir)) {
			return true;
		}else {
			return false;
		}
	}
}
