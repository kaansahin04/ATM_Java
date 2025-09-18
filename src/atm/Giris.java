package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import kontrol.GirisKontrol;

public class Giris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameG;
	private JPasswordField sifreG;
	public static int usernameGiris;

	/**
	 * Create the frame.
	 */
	public Giris() {
		setTitle("ATM Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 586, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(0, 0, 586, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATM YÖNETİM SİSTEMİ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(175, 34, 237, 32);
		panel_1.add(lblNewLabel);
		
		usernameG = new JTextField();
		usernameG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameG.setBounds(268, 161, 194, 34);
		panel.add(usernameG);
		usernameG.setColumns(10);
		
		sifreG = new JPasswordField();
		sifreG.setEchoChar('*');
		sifreG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sifreG.setColumns(10);
		sifreG.setBounds(268, 220, 194, 34);
		panel.add(sifreG);
		
		JLabel lblGiri = new JLabel("GİRİŞ");
		lblGiri.setForeground(new Color(0, 0, 255));
		lblGiri.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGiri.setBounds(256, 110, 64, 32);
		panel.add(lblGiri);
		
		JLabel lblKullancAd = new JLabel("Kullanıcı Adı:");
		lblKullancAd.setForeground(new Color(0, 0, 0));
		lblKullancAd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKullancAd.setBounds(135, 161, 129, 32);
		panel.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("Şifre:");
		lblifre.setForeground(new Color(0, 0, 0));
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblifre.setBounds(196, 220, 64, 32);
		panel.add(lblifre);
		
		JButton giris = new JButton("GİRİŞ YAP");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisKontrol kontrolG=new GirisKontrol(usernameG.getText(), sifreG.getText());
				if(kontrolG.bosKontrolu()) {
					JOptionPane.showMessageDialog(panel, "Boş alan bıraktınız.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}else {
					String usernameGir=usernameG.getText();
					String sifreGir=sifreG.getText();
					if(Main.username.contains(usernameGir)) {
						usernameGiris=Main.username.indexOf(usernameGir);
						if(kontrolG.esitlikKontrolu(usernameGiris, sifreGir)) {
							int girId=Main.id.get(usernameGiris);
							String girUsername=Main.username.get(usernameGiris);
							String girSifre=Main.sifre.get(usernameGiris);
							String girAd=Main.ad.get(usernameGiris);
							String girSoyad=Main.soyad.get(usernameGiris);
							String girEgitim=Main.egitim.get(usernameGiris);
							String girDogum=Main.dogum.get(usernameGiris);
							int girBakiye=Main.bakiye.get(usernameGiris);
							dispose();
							new Menu(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
						}else {
							JOptionPane.showMessageDialog(panel, "Kullanıcı adı ve şifre eşleşmedi.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(panel, "Böyle bir kullanıcı mevcut değil.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		giris.setForeground(Color.BLUE);
		giris.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		giris.setBounds(235, 285, 112, 32);
		panel.add(giris);
		
		JButton kayit = new JButton("KAYIT OL");
		kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Kayit().setVisible(true);
			}
		});
		kayit.setForeground(new Color(255, 0, 0));
		kayit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		kayit.setBounds(235, 325, 112, 32);
		panel.add(kayit);

	}
}
