package atm;

import java.awt.EventQueue;
import kontrol.KayitKontrol;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Kayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameK;
	private JTextField adK;
	private JTextField soyadK;
	private JTextField sifreK;

	/**
	 * Create the frame.
	 */
	public Kayit() {
		setTitle("ATM Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 586, 70);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("ATM YÖNETİM SİSTEMİ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(173, 18, 237, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194, 194, 194));
		panel.setBounds(0, 70, 586, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		usernameK = new JTextField();
		usernameK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		usernameK.setBounds(130, 65, 94, 31);
		panel.add(usernameK);
		usernameK.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(23, 71, 105, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("İsim:");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(81, 126, 47, 18);
		panel.add(lblNewLabel_1_1);
		
		adK = new JTextField();
		adK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adK.setColumns(10);
		adK.setBounds(130, 120, 94, 31);
		panel.add(adK);
		
		JLabel lblNewLabel_1_2 = new JLabel("Soyisim:");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(55, 181, 73, 21);
		panel.add(lblNewLabel_1_2);
		
		soyadK = new JTextField();
		soyadK.setFont(new Font("Tahoma", Font.PLAIN, 11));
		soyadK.setColumns(10);
		soyadK.setBounds(130, 175, 94, 31);
		panel.add(soyadK);
		
		JLabel lblNewLabel_1_3 = new JLabel("Şifre:");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(354, 71, 47, 21);
		panel.add(lblNewLabel_1_3);
		
		sifreK = new JTextField();
		sifreK.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sifreK.setColumns(10);
		sifreK.setBounds(403, 65, 94, 31);
		panel.add(sifreK);
		
		JLabel lblNewLabel_1_4 = new JLabel("Eğitim Düzeyi:");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(283, 126, 116, 21);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Doğum Yılı:");
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(305, 181, 94, 21);
		panel.add(lblNewLabel_1_5);
		
		JComboBox<String> egitimK = new JComboBox<>();
		egitimK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		egitimK.setModel(new DefaultComboBoxModel<String>(new String[] {"Eğitim Düzeyiniz", "İlkokul Terk", "İlkokul Mezunu", "Ortaokul Terk", "Ortaokul Mezunu", "Lise Terk", "Lise Mezunu", "Ön Lisans", "Lisans", "Yüksek Lisans", "Doktora"}));
		egitimK.setBounds(403, 120, 161, 31);
		panel.add(egitimK);
		
		JComboBox<String> dogumK = new JComboBox<>();
		dogumK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dogumK.setModel(new DefaultComboBoxModel<String>(new String[] {"Yıl", "-1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007"}));
		dogumK.setBounds(403, 175, 94, 31);
		panel.add(dogumK);
		
		JButton gonder = new JButton("GÖNDER");
		gonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitKontrol kontrolK=new KayitKontrol(usernameK.getText(), sifreK.getText(), adK.getText(), soyadK.getText(), egitimK.getSelectedItem().toString(), dogumK.getSelectedItem().toString());
				if(!kontrolK.bosKontrolu()) {
					JOptionPane.showMessageDialog(panel, "Boş alan bıraktınız.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else {
					if(kontrolK.usernameKontrolu()=="boşluk") {
						JOptionPane.showMessageDialog(panel, "Kullanıcı adı boşluk içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolK.usernameKontrolu()=="harf") {
						JOptionPane.showMessageDialog(panel, "Kullanıcı adı harf içermeli.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolK.usernameKontrolu()=="büyük harf") {
						JOptionPane.showMessageDialog(panel, "Kullanıcı adı büyük harf içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolK.usernameKontrolu()=="uzun") {
						JOptionPane.showMessageDialog(panel, "Kullanıcı adı en fazla 13 haneli olabilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolK.usernameKontrolu()=="") {
						if(kontrolK.sifreKontrolu()=="boşluk") {
							JOptionPane.showMessageDialog(panel, "Şifre boşluk içeremez.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="sayı") {
							JOptionPane.showMessageDialog(panel, "Şifre sayı içermeli.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="harf") {
							JOptionPane.showMessageDialog(panel, "Şifre harf içermeli.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="küçük harf") {
							JOptionPane.showMessageDialog(panel, "Şifre küçük harf içermeli.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="büyük harf") {
							JOptionPane.showMessageDialog(panel, "Şifre büyük harf içermeli.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="kısa") {
							JOptionPane.showMessageDialog(panel, "Şifre 6 haneden kısa olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="büyük harf") {
							JOptionPane.showMessageDialog(panel, "Şifre 16 haneden uzun olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else if(kontrolK.sifreKontrolu()=="") {
							if(kontrolK.adKontrolu()==1) {
								JOptionPane.showMessageDialog(panel, "Adınız sadece harflerden oluşmalıdır.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kontrolK.adKontrolu()==2) {
								JOptionPane.showMessageDialog(panel, "Adınız 18 karakterden uzun olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
							}else if(kontrolK.adKontrolu()==3) {
								if(kontrolK.soyadKontrolu()==1) {
									JOptionPane.showMessageDialog(panel, "3 soyadınız olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kontrolK.soyadKontrolu()==2) {
									JOptionPane.showMessageDialog(panel, "Soyadınız sadece harflerden oluşmalıdır.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kontrolK.soyadKontrolu()==3) {
									JOptionPane.showMessageDialog(panel, "Soyadınız 18 karakterden uzun olamaz.", "Hata!", JOptionPane.ERROR_MESSAGE);
								}else if(kontrolK.soyadKontrolu()==4) {
									if(Main.username.contains(usernameK.getText())) {
										JOptionPane.showMessageDialog(panel, "Bu kullanıcı adı kullanımda.", "Hata!", JOptionPane.ERROR_MESSAGE);
									}else {
										int idLast=Main.id.getLast();
										Main.id.add(idLast+1);
										String usernameEkle=usernameK.getText();
										Main.username.add(usernameEkle);
										String sifreEkle=sifreK.getText();
										Main.sifre.add(sifreEkle);
										String adEkle=adK.getText().trim();
										Main.ad.add(adEkle);
										String soyadEkle=soyadK.getText().trim();
										Main.soyad.add(soyadEkle);
										String egitimEkle=egitimK.getSelectedItem().toString();
										Main.egitim.add(egitimEkle);
										String dogumEkle=dogumK.getSelectedItem().toString();
										Main.dogum.add(dogumEkle);
										Main.bakiye.add(5000);
										usernameK.setText("");
										sifreK.setText("");
										adK.setText("");
										soyadK.setText("");
										egitimK.setSelectedItem("Eğitim Düzeyiniz");
										dogumK.setSelectedItem("Yıl");
										JOptionPane.showMessageDialog(panel, "Kaydınız sisteme başarıyla eklendi.", "Hoş geldiniz!", JOptionPane.PLAIN_MESSAGE);
									}
								}
							}
						}
					}
				}
			}
		});
		gonder.setBackground(new Color(0, 0, 255));
		gonder.setForeground(new Color(255, 255, 255));
		gonder.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		gonder.setBounds(234, 235, 112, 32);
		panel.add(gonder);
		
		JLabel lblKayt = new JLabel("KAYIT");
		lblKayt.setForeground(new Color(255, 0, 0));
		lblKayt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKayt.setBounds(256, 10, 64, 32);
		panel.add(lblKayt);
		
		JButton btnNewButton_2_2_1 = new JButton("<-- GERİ");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Giris().setVisible(true);
			}
		});
		btnNewButton_2_2_1.setForeground(new Color(255, 0, 0));
		btnNewButton_2_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_2_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_2_1.setBounds(10, 250, 105, 32);
		panel.add(btnNewButton_2_2_1);

	}
}
