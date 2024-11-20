package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 3;
    private final SimpleGUI simpleGUI;
    /**
     * The constructor initialize the frame with a text area to enter a text to be saved inside the file when
     * the button save is clicked, helped by the controller, than is added at NORD of the frame a text field unmutable
     * that show the file path where the text will be wrote, helped by butto browse.
     * 
     * @param controller Is the controller that work to write to the file
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        this.simpleGUI = new SimpleGUI(controller);

        final JPanel canvasNord = new JPanel();
        canvasNord.setLayout(new BorderLayout());
        simpleGUI.getCanvas().add(canvasNord, BorderLayout.NORTH);
        final JTextField textBrowserField = new JTextField();
        textBrowserField.setEditable(false);
        canvasNord.add(textBrowserField, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse...");
        canvasNord.add(browse, BorderLayout.EAST);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int value = fileChooser.showSaveDialog(simpleGUI.getFrame());
                if (value == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    textBrowserField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (value == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(simpleGUI.getFrame(), "No file founded");
                } else {
                    JOptionPane.showMessageDialog(simpleGUI.getFrame(), "An error has occurred!");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        simpleGUI.getFrame().setSize(sw / PROPORTION, sh / PROPORTION);
        simpleGUI.getFrame().setLocationByPlatform(true);
        simpleGUI.getFrame().setVisible(true);
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
