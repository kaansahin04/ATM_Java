package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Hareketler extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea hareketler=new JTextArea("");
	private static String oncekiler;
	private static String yazi;
	private static String sakla;

	/**
	 * Create the frame.
	 */
	public Hareketler(int girId, String girUsername, String girSifre, String girAd, String girSoyad, String girEgitim, String girDogum, int girBakiye) {
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
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 586, 363);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLUE);
		panel_1_1.setBounds(0, 0, 586, 70);
		panel_1.add(panel_1_1);
		
		JLabel lblHesapHareketleri = new JLabel("HESAP HAREKETLERİ");
		lblHesapHareketleri.setForeground(Color.WHITE);
		lblHesapHareketleri.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHesapHareketleri.setBounds(168, 18, 264, 32);
		panel_1_1.add(lblHesapHareketleri);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(0, 311, 586, 52);
		panel_1.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 80, 524, 218);
		panel_1.add(scrollPane);
		
		hareketler.setEnabled(false);
		hareketler.setEditable(false);
		hareketler.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 18));
		scrollPane.setViewportView(hareketler);

		JButton btnNewButton_2_2_1 = new JButton("<-- GERİ");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye).setVisible(true);
			}
		});
		btnNewButton_2_2_1.setForeground(Color.WHITE);
		btnNewButton_2_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_2_2_1.setBackground(Color.RED);
		btnNewButton_2_2_1.setBounds(10, 10, 105, 32);
		panel_2.add(btnNewButton_2_2_1);
	}
	
	public static void setIslem(int girId, String girUsername, String girAd, String girSoyad, int girBakiye, String islem, String miktar) {
		oncekiler=hareketler.getText();
		if(islem.equals("yatır")) {
			yazi=girUsername+", "+girId+" - "+girAd+" "+girSoyad+" adlı müşteri, hesabına "+miktar+" TL yatırdı.\r\nToplam Bakiye: "+girBakiye+"\r\n"+oncekiler;
			hareketler.setText(yazi);
		}
		if(islem.equals("çek")) {
			yazi=girUsername+", "+girId+" - "+girAd+" "+girSoyad+" adlı müşteri, hesabından "+miktar+" TL çekti.\r\nKalan Bakiye: "+girBakiye+"\r\n"+oncekiler;
			hareketler.setText(yazi);
		}
	}
}
