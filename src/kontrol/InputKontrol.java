package kontrol;

public class InputKontrol {

	private String miktar;
	
	public InputKontrol(String miktar) {
		this.miktar=miktar;
	}
	
	public String miktarKontrolu() {
		if(miktar.isEmpty()) {
			return "boş";
		}else {
			char[] miktarKontrol=miktar.toCharArray();
			int harf=0;
			int bosluk=0;
			for(char i:miktarKontrol) {
				if(!Character.isDigit(i)) {
					harf++;
				}
				if(Character.isWhitespace(i)) {
					bosluk++;
				}
			}
			if(bosluk>0) {
				return "boşluk";
			}else{
				if(harf>0) {
					return "harf";
				}else {
					if(Integer.parseInt(miktar)>1000000000) {
						return "fazla";
					}else {
						return "";
					}
				}
			}
		}
	}
	
}
