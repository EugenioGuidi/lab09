package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "SIMPLE GUI APPLICATION";
    private static final int PROPORTION = 3;
    private static final int FONT_SIZE = 15;

    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canvas = new JPanel();

    /**
     * This is the constructor that also model the frame.
     * 
     * @param controller
     */
    public SimpleGUI(final SimpleController controller) {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JPanel canvasSouth = new JPanel();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        canvasSouth.add(print);
        canvasSouth.add(showHistory);
        this.canvas.add(textField, BorderLayout.NORTH);
        this.canvas.add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.canvas.add(canvasSouth, BorderLayout.SOUTH);
        this.frame.setContentPane(this.canvas);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        textField.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        textArea.setEditable(false);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(textField.getText());
                System.out.println(controller.getNextString()); // NOPMD: allowed as this is just an exercise
            }
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (controller.getListOfPrintedString().isEmpty()) {
                    JOptionPane.showMessageDialog(showHistory, "The history is empty");
                }
                final String string = String.join("\n", controller.getListOfPrintedString());
                textArea.setText(string);
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
     * That is the main that start the GUI.
     * 
     * @param strg
     */
    public static void main(final String... strg) {
        new SimpleGUI(new SimpleController()).display();
    }
}
