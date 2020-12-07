package aims.engine.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import aims.engine.FileLoader;
import aims.engine.gui.controller.LoginController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField tfPassword;
	
	private Image iconImg = FileLoader.loadImage("/cobala.png");

	public LoginUI() {
		
		setTitle("Aims login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(200, 0, 400, 300);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbLogin = new JLabel("Login");
		lbLogin.setForeground(SystemColor.text);
		lbLogin.setFont(new Font("Arial", Font.BOLD, 30));
		lbLogin.setBounds(30, 30, 80, 35);
		panel.add(lbLogin);
		
		JLabel lblNewLabel_2 = new JLabel("User name:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(30, 111, 80, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(30, 162, 76, 14);
		panel.add(lblNewLabel_3);
		
		tfUserName = new JTextField();
		tfUserName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(LoginController.login(tfUserName.getText(), String.valueOf(tfPassword.getPassword()))) {
						setVisible(false);
					}
				}
			}
		});
		tfUserName.setBounds(132, 109, 200, 20);
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(LoginController.login(tfUserName.getText(), String.valueOf(tfPassword.getPassword()))) {
					setVisible(false);
				}
			}
		});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogin.setBounds(287, 239, 89, 23);
		panel.add(btnLogin);
		
		tfPassword = new JPasswordField();		
		tfPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(LoginController.login(tfUserName.getText(), String.valueOf(tfPassword.getPassword()))) {
						setVisible(false);
					}
				}
			}
		});
		tfPassword.setBounds(132, 160, 200, 20);
		panel.add(tfPassword);
		
		JLabel lbHideShowPw = new JLabel("[Show]");		
		lbHideShowPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(lbHideShowPw.getText().equals("[Show]")) {
					lbHideShowPw.setText("[Hide]");
					tfPassword.setEchoChar((char)0);
				}
				else {
					lbHideShowPw.setText("[Show]");
					tfPassword.setEchoChar('•');
				}
				lbHideShowPw.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lbHideShowPw.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbHideShowPw.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbHideShowPw.setForeground(Color.blue);
			}
		});
		lbHideShowPw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbHideShowPw.setForeground(Color.BLUE);
		lbHideShowPw.setBounds(342, 163, 45, 14);
		panel.add(lbHideShowPw);	
		
		JLabel lbIcon = new JLabel("");
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbIcon.setForeground(Color.GREEN);
		lbIcon.setFont(new Font("Arial", Font.BOLD, 20));
		lbIcon.setBounds(39, 95, 151, 151);
		contentPane.add(lbIcon);
		lbIcon.setIcon(new ImageIcon(iconImg.getScaledInstance(lbIcon.getWidth(), lbIcon.getHeight(), Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel = new JLabel("Aims copyright by Group 5");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(48, 275, 142, 14);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		//setUndecorated(true);	
		
	}
}
