package kontrol;

public class KayitKontrol {
	
	private String username, sifre, ad, soyad, egitim, dogum;
	
	public KayitKontrol(String username, String sifre, String ad, String soyad, String egitim, String dogum) {
		this.username=username;
		this.sifre=sifre;
		this.ad=ad;
		this.soyad=soyad;
		this.egitim=egitim;
		this.dogum=dogum;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEgitim() {
		return egitim;
	}

	public void setEgitim(String egitim) {
		this.egitim = egitim;
	}

	public String getDogum() {
		return dogum;
	}

	public void setDogum(String dogum) {
		this.dogum = dogum;
	}

	public boolean bosKontrolu(){
		if(username.isEmpty() || sifre.isEmpty() || ad.isEmpty() || soyad.isEmpty() || egitim.equals("Eğitim Düzeyiniz") || dogum.equals("Yıl")) {
			return false;
		}else {
			return true;
		}
	}
	
	public int adKontrolu() {
		char[] adKontrol=ad.toCharArray();
		int sayi=0;
		int bosluk=0;
		for(int i:adKontrol) {
			if(!Character.isLetter(i)) {
				sayi++;
			}
			if(Character.isWhitespace(i)) {
				bosluk++;
			}
		}
		if(sayi>bosluk) {
			return 1;
		}else {
			if(adKontrol.length>18) {
				return 2;
			}else {
				return 3;
			}
		}
	}
	
	public int soyadKontrolu() {
		char[] soyadKontrol=soyad.toCharArray();
		int sayi=0;
		int bosluk=0;
		for(char i:soyadKontrol) {
			if(!Character.isLetter(i)) {
				sayi++;
			}
			if(Character.isWhitespace(i)) {
				bosluk++;
			}
		}
		if(bosluk>1) {
			return 1;
		}else{
			if(sayi>bosluk) {
				return 2;
			}else {
				if(soyadKontrol.length>18) {
					return 3;
				}else {
					return 4;
				}
			}
		}
	}
	
	public String usernameKontrolu() {
		char[] usernameKontrol=username.toCharArray();
		int harf=0;
		int bosluk=0;
		int buyukHarf=0;
		for (char i:usernameKontrol){
			if(Character.isWhitespace(i)) {
				bosluk++;
			}
			if(Character.isLetter(i)) {
				harf++;
			}
			if(Character.isUpperCase(i)) {
				buyukHarf++;
			}
		}
		if(bosluk>0) {
			return "boşluk";
		}else {
			if(harf==0) {
				return "harf";
			}else {
				if(buyukHarf>0) {
					return "büyük harf";
				}else {
					if(usernameKontrol.length>13) {
						return "uzun";
					}else {
						return "";
					}
				}
			}
		}
	}
	
	public String sifreKontrolu() {
		char[] sifreKontrol=sifre.toCharArray();
		int harf=0;
		int kucukHarf=0;
		int buyukHarf=0;
		int sayi=0;
		int bosluk=0;
		for (char i:sifreKontrol){
			if(Character.isWhitespace(i)) {
				bosluk++;
			}
			if(Character.isDigit(i)) {
				sayi++;
			}
			if(Character.isLetter(i)) {
				harf++;
			}
			if(Character.isLowerCase(i)) {
				kucukHarf++;
			}
			if(Character.isUpperCase(i)) {
				buyukHarf++;
			}
		}
		if(bosluk>0) {
			return "boşluk";
		}else {
			if(sayi==0) {
				return "sayı";
			}else {
				if(harf==0) {
					return "harf";
				}else {
					if(kucukHarf==0) {
						return "küçük harf";
					}else {
						if(buyukHarf==0) {
							return "büyük harf";
						}else {
							if(sifreKontrol.length<6) {
								return "kısa";
							}else {
								if(sifreKontrol.length>16) {
									return "uzun";
								}else {
									return "";
								}
							}
						}
					}
				}
			}
		}
	}
	
}
