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

public class Bakiye extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Bakiye(int girId, String girUsername, String girSifre, String girAd, String girSoyad, String girEgitim, String girDogum, int girBakiye) {

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
		
		JLabel lblBakiye = new JLabel("BAKİYE");
		lblBakiye.setForeground(Color.WHITE);
		lblBakiye.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBakiye.setBounds(243, 34, 169, 32);
		panel_1.add(lblBakiye);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(0, 311, 586, 52);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Bakiyeniz:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(155, 179, 146, 31);
		panel.add(lblNewLabel_1);
		
		JLabel bakiye = new JLabel(String.valueOf(girBakiye));
		bakiye.setForeground(new Color(0, 0, 0));
		bakiye.setFont(new Font("Tahoma", Font.BOLD, 28));
		bakiye.setBounds(294, 179, 282, 31);
		panel.add(bakiye);

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

}
