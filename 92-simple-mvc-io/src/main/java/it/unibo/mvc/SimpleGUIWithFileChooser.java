package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
public final class SimpleGUIWithFileChooser {
    private static final String TITLE = "MINE SIMPLE GUI APPLICATION";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    private static final int FONT_SIZE = 15;

    /**
     * The constructor initialize the frame with a text area to enter a text to be saved inside the file when
     * the button save is clicked, helped by the controller, than is added at NORD of the frame a text field unmutable
     * that show the file path where the text will be wrote, helped by butto browse.
     * 
     * @param controller Is the controller that work to write to the file
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        canvas.add(new JScrollPane(textArea), BorderLayout.CENTER);

        final JPanel canvasNord = new JPanel();
        canvasNord.setLayout(new BorderLayout());
        canvas.add(canvasNord, BorderLayout.NORTH);
        final JTextField textBrowserField = new JTextField();
        textBrowserField.setEditable(false);
        canvasNord.add(textBrowserField, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse...");
        canvasNord.add(browse, BorderLayout.EAST);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int value = fileChooser.showSaveDialog(frame);
                if (value == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    textBrowserField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (value == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "No file founded");
                } else {
                    JOptionPane.showMessageDialog(frame, "An error has occurred!");
                }
            }
        });

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
     * The main start all the application initializing a new SimpleGUI object helped by a new Controller.
     * 
     * @param args that can be null
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
     }

}
