package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "MINE SIMPLE GUI APPLICATION";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canvas = new JPanel();
    private static final int FONT_SIZE = 15;

    /**
     * The constructor initialize the frame with a text area to enter a text to be saved inside the file when
     * the button save is clicked, helped by the controller.
     * 
     * @param controller Is the controller that work to write to the file
     */
    public SimpleGUI(final Controller controller) {
        this.canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        this.canvas.add(save, BorderLayout.SOUTH);
        this.frame.setContentPane(this.canvas);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea();
        this.canvas.add(new JScrollPane(textArea), BorderLayout.CENTER);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeStringInFile(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * joivhwdhvwpdbv.
     * @return frame
     */
    JFrame getFrame() {
        return this.frame;
    }

    /**
     * wjdwodbvwdv.
     * @return canvas
     */
    JPanel getCanvas() {
        return this.canvas;
    }
    /**
     * The main start all the application initializing a new SimpleGUI object helped by a new Controller.
     * 
     * @param args that can be null
     */
    public static void main(final String... args) {
        new SimpleGUI(new Controller()).display();
    }

}
