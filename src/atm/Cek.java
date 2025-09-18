package atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontrol.InputKontrol;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Cek extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField miktarC;
	public String cekmek;

	/**
	 * Create the frame.
	 */
	public Cek(int girId, String girUsername, String girSifre, String girAd, String girSoyad, String girEgitim, String girDogum, int girBakiye) {
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
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 586, 363);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLUE);
		panel_1_1.setBounds(0, 0, 586, 100);
		panel_1.add(panel_1_1);
		
		JLabel lblParaek = new JLabel("PARA ÇEK");
		lblParaek.setForeground(Color.WHITE);
		lblParaek.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblParaek.setBounds(229, 34, 183, 32);
		panel_1_1.add(lblParaek);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bakiyeniz:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(210, 120, 94, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Miktar:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(161, 161, 112, 31);
		panel_1.add(lblNewLabel_1);
		
		miktarC = new JTextField();
		miktarC.setFont(new Font("Tahoma", Font.BOLD, 18));
		miktarC.setColumns(10);
		miktarC.setBounds(268, 161, 151, 31);
		panel_1.add(miktarC);

		JLabel bakiyeC = new JLabel(String.valueOf(girBakiye));
		bakiyeC.setForeground(Color.BLACK);
		bakiyeC.setFont(new Font("Tahoma", Font.BOLD, 20));
		bakiyeC.setBounds(306, 120, 270, 31);
		
		JButton cek = new JButton("ÇEK");
		cek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String miktar=miktarC.getText();
					InputKontrol kontrolI=new InputKontrol(miktar);
					if(kontrolI.miktarKontrolu()=="boş") {
						JOptionPane.showMessageDialog(panel, "Miktar kısmına herhangi bir sayı girmediniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="boşluk") {
						JOptionPane.showMessageDialog(panel, "Para miktarını boşluklu giremezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="harf") {
						JOptionPane.showMessageDialog(panel, "Para miktarı sadece sayı içerebilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="fazla") {
						JOptionPane.showMessageDialog(panel, "Tek seferde 1000000000 (1 milyar) liradan fazla para çekemezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="") {
						if(girBakiye-Integer.parseInt(miktar)<0) {
							JOptionPane.showMessageDialog(panel, "Yeterli bakiyeniz yok.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else {
							bakiyeC.setText(String.valueOf(girBakiye-Integer.parseInt(miktar)));
							dispose();
							new Cek(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye-Integer.parseInt(miktar)).setVisible(true);
							Hareketler.setIslem(girId, girUsername, girAd, girSoyad, Integer.parseInt(bakiyeC.getText()), "çek", miktar);
							miktarC.setText("");
						}
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel, "Tek seferde 1000000000 (1 milyar) liradan fazla para çekemezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cek.setForeground(Color.BLUE);
		cek.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		cek.setBackground(Color.WHITE);
		cek.setBounds(232, 233, 112, 32);
		panel_1.add(cek);

		panel_1.add(bakiyeC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(0, 311, 586, 52);
		panel_1.add(panel_2);
		
		JButton btnNewButton_2_2_1 = new JButton("<-- GERİ");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, Integer.parseInt(bakiyeC.getText())).setVisible(true);
			}
		});
		btnNewButton_2_2_1.setForeground(Color.WHITE);
		btnNewButton_2_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_2_2_1.setBackground(Color.RED);
		btnNewButton_2_2_1.setBounds(10, 10, 105, 32);
		panel_2.add(btnNewButton_2_2_1);

	}

}
