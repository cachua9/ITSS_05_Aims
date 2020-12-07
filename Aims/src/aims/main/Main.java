package aims.main;

import aims.engine.gui.LoginUI;
import aims.engine.model.DBConnection;

public class Main {
	public static void main(String[] args) {
		DBConnection.getConn();
		new LoginUI().setVisible(true);
	}
}
