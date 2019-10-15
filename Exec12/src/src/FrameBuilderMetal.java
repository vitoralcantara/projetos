package src;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrameBuilderMetal extends FrameBuilder {

	public Frame buildFrame() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		Frame frame = new Frame();
		frame.setVisible(true);
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		SwingUtilities.updateComponentTreeUI(frame);
		return frame;
	}
}
