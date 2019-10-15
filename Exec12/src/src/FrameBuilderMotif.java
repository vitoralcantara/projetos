package src;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrameBuilderMotif extends FrameBuilder {

	@Override
	public Frame buildFrame() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		Frame frame = new Frame();
		frame.setVisible(true);
		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		SwingUtilities.updateComponentTreeUI(frame);
		return frame;
	}

}
