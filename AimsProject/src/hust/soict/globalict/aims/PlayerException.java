package hust.soict.globalict.aims;

import javax.swing.JOptionPane;import javax.swing.border.TitledBorder;

public class PlayerException extends java.lang.Exception{
	
	public PlayerException() {
		super();
	}
	
	public PlayerException(String string) {
		JOptionPane.showMessageDialog(null, string, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String [] args) {
		// TODO
	}
	
}
