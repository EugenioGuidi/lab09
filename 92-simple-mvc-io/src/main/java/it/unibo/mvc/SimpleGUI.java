package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
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
    private final Controller controller;

    public SimpleGUI(Controller controller) {
        this.controller = controller;
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea();
        canvas.add(new JScrollPane(textArea), BorderLayout.CENTER);
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
        Controller controller = new Controller();
        new SimpleGUI(controller).display();
     }

}
