package src;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class FrameBuilder {

	public abstract Frame buildFrame() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException;

}
