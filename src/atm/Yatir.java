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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kontrol.InputKontrol;

public class Yatir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField miktarY;
	public String yatirmak;
	
	/**
	 * Create the frame.
	 */
	public Yatir(int girId, String girUsername, String girSifre, String girAd, String girSoyad, String girEgitim, String girDogum, int girBakiye) {

		setTitle("ATM Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
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
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 586, 100);
		panel.add(panel_1);
		
		JLabel lblParaYatr = new JLabel("PARA YATIR");
		lblParaYatr.setForeground(Color.WHITE);
		lblParaYatr.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblParaYatr.setBounds(219, 34, 193, 32);
		panel_1.add(lblParaYatr);
		
		JLabel lblNewLabel_1 = new JLabel("Miktar:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(161, 161, 112, 31);
		panel.add(lblNewLabel_1);
		
		miktarY = new JTextField();
		miktarY.setFont(new Font("Tahoma", Font.BOLD, 18));
		miktarY.setBounds(268, 161, 151, 31);
		panel.add(miktarY);
		miktarY.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(0, 311, 586, 52);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bakiyeniz:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(210, 120, 94, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel bakiyeY = new JLabel(String.valueOf(girBakiye));
		bakiyeY.setForeground(new Color(0, 0, 0));
		bakiyeY.setFont(new Font("Tahoma", Font.BOLD, 20));
		bakiyeY.setBounds(306, 120, 270, 31);
		
		JButton yatir = new JButton("YATIR");
		yatir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String miktar=miktarY.getText();
					InputKontrol kontrolI=new InputKontrol(miktar);
					if(kontrolI.miktarKontrolu()=="boş") {
						JOptionPane.showMessageDialog(panel, "Miktar kısmına herhangi bir sayı girmediniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="boşluk") {
						JOptionPane.showMessageDialog(panel, "Para miktarını boşluklu giremezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="harf") {
						JOptionPane.showMessageDialog(panel, "Para miktarı sadece sayı içerebilir.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="fazla") {
						JOptionPane.showMessageDialog(panel, "1000000000 (1 milyar) liradan fazla para gönderemezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
					}else if(kontrolI.miktarKontrolu()=="") {
						if(girBakiye+Integer.parseInt(miktar)>2000000000) {
							JOptionPane.showMessageDialog(panel, "2000000000 (2 milyar) liradan fazla para tutamazsınız.", "Hata!", JOptionPane.ERROR_MESSAGE);
						}else {
							bakiyeY.setText(String.valueOf(girBakiye+Integer.parseInt(miktar)));
							dispose();
							new Yatir(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, girBakiye+Integer.parseInt(miktar)).setVisible(true);
							Hareketler.setIslem(girId, girUsername, girAd, girSoyad, Integer.parseInt(bakiyeY.getText()), "yatır", miktar);
							miktarY.setText("");
						}
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(panel, "1000000000 (1 milyar) liradan fazla para gönderemezsiniz.", "Hata!", JOptionPane.ERROR_MESSAGE);
				}
		}});
		yatir.setForeground(new Color(0, 0, 255));
		yatir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		yatir.setBackground(new Color(255, 255, 255));
		yatir.setBounds(232, 233, 112, 32);
		panel.add(yatir);

		panel.add(bakiyeY);
		
		JButton btnNewButton_2_2_1 = new JButton("<-- GERİ");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu(girId, girUsername, girSifre, girAd, girSoyad, girEgitim, girDogum, Integer.parseInt(bakiyeY.getText())).setVisible(true);
			}
		});
		btnNewButton_2_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_2_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_2_2_1.setBackground(new Color(255, 0, 0));
		btnNewButton_2_2_1.setBounds(10, 10, 105, 32);
		panel_2.add(btnNewButton_2_2_1);
	}

}
