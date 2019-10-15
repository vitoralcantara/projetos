package src;

import java.awt.EventQueue;

import src.FrameBuilder;
import src.FrameBuilderMetal;
import src.FrameBuilderMotif;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBuilder fb1 = new FrameBuilderMetal();
					FrameBuilder fb2 = new FrameBuilderMotif();
					Frame frame1 = fb1.buildFrame();
					Frame frame2 = fb2.buildFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
