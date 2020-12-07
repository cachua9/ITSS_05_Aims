package aims.engine.gui.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import aims.engine.gui.HomeUI;
import aims.engine.gui.LoginUI;
import aims.engine.model.User;

public class LoginController {
	public static boolean login(String username, String password) {
		if (username.isEmpty() && password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username vs password is empty");
		}
		else if (username.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username is empty");
		}
		else if (password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Password is empty");
		}
		else {
			ArrayList<User> users = User.getData();
			for (User user : users) {
				if (user.checkLoginInfo(username, password)) {
					if (user.isAdmin()) {
						JOptionPane.showMessageDialog(null, "Login admin complete");
					}
					else {
						
						new HomeUI().setVisible(true);
//						JOptionPane.showMessageDialog(null, "Login customer complete");
					}
					return true;
				}
			}
			JOptionPane.showMessageDialog(null, "Login fail");
		}	
		return false;
	}
}
