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
    private final int FONT_SIZE = 15;

    public SimpleGUIWithFileChooser(Controller controller) {
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

        browse.addActionListener (new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    textBrowserField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (fileChooser.showSaveDialog(frame) == JFileChooser.CANCEL_OPTION) {
                    // do nothing
                } else {
                    JOptionPane.showMessageDialog(frame, "An error has occurred!");
                }
            }
        });

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeStringInFile(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
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

    public static void main(final String... args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
     }

}
