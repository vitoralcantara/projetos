package src;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					JFrameAbstraction frame1 = new JFrameImplementation(
							"javax.swing.plaf.metal.MetalLookAndFeel");
					frame1.setVisible(true);
					JFrameAbstraction frame2 = new JFrameImplementation(
							"com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
