package it.unibo.mvc;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "MINE SIMPLE GUI APPLICATION";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUI() {
        
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        new SimpleGUI().display();
     }

}
