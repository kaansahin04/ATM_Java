package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu(int girId, String girUsername, String girSifre, String girAd, String girSoyad, String girEgitim, String girDogum, int girBakiye) {
		
		setTitle("ATM Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 586, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 586, 90);
		panel_1.setBackground(new Color(0, 0, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BANKAMATİK");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(229, 22, 127, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblHoGeldiniz = new JLabel("Hoş Geldiniz, "+girAd+" "+girSoyad+"!");
		lblHoGeldiniz.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoGeldiniz.setForeground(Color.WHITE);
		lblHoGeldiniz.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblHoGeldiniz.setBounds(47, 55, 494, 25);
		panel_1.add(lblHoGeldiniz);
		
		JLabel lblHesapNumaras = new JLabel("Hesap Numarası:");
		lblHesapNumaras.setForeground(new Color(0, 0, 255));
		lblHesapNumaras.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblHesapNumaras.setBounds(181, 121, 135, 25);
		panel.add(lblHesapNumaras);
		
		JButton paraYatir = new JButton("PARA YATIR");
		paraYatir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Yatir(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
			}
		});
		paraYatir.setForeground(new Color(0, 0, 255));
		paraYatir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		paraYatir.setBounds(135, 170, 131, 32);
		panel.add(paraYatir);
		
		JButton paraCek = new JButton("PARA ÇEK");
		paraCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Cek(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
			}
		});
		paraCek.setForeground(Color.BLUE);
		paraCek.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		paraCek.setBounds(330, 170, 125, 32);
		panel.add(paraCek);
		
		JButton HesapHareketleri = new JButton("HESAP HAREKETLERİ");
		HesapHareketleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Hareketler(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
			}
		});
		HesapHareketleri.setForeground(Color.BLUE);
		HesapHareketleri.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		HesapHareketleri.setBounds(81, 235, 185, 32);
		panel.add(HesapHareketleri);
		
		JButton Bakiye = new JButton("BAKİYE");
		Bakiye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Bakiye(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
			}
		});
		Bakiye.setForeground(Color.BLUE);
		Bakiye.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		Bakiye.setBounds(330, 235, 94, 32);
		panel.add(Bakiye);
		
		JLabel cikis = new JLabel("ÇIKIŞ YAP");
		cikis.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Giris().setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		cikis.setForeground(new Color(255, 0, 0));
		cikis.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		cikis.setBounds(255, 313, 100, 25);
		panel.add(cikis);
		
		JLabel hesapNo = new JLabel(String.valueOf(girId));
		hesapNo.setForeground(Color.BLUE);
		hesapNo.setFont(new Font("Sylfaen", Font.BOLD, 21));
		hesapNo.setBounds(313, 118, 135, 31);
		panel.add(hesapNo);
		
		JLabel lblEitimBilgisi = new JLabel("Eğitim Bilgisi: "+girEgitim);
		lblEitimBilgisi.setForeground(new Color(0, 0, 255));
		lblEitimBilgisi.setFont(new Font("Sylfaen", Font.ITALIC, 15));
		lblEitimBilgisi.setBounds(10, 294, 220, 25);
		panel.add(lblEitimBilgisi);
		
		JLabel lblEitimBilgisi_1 = new JLabel("Doğum Yılı: "+girDogum);
		lblEitimBilgisi_1.setForeground(Color.BLUE);
		lblEitimBilgisi_1.setFont(new Font("Sylfaen", Font.ITALIC, 15));
		lblEitimBilgisi_1.setBounds(10, 325, 220, 25);
		panel.add(lblEitimBilgisi_1);

	}
}
