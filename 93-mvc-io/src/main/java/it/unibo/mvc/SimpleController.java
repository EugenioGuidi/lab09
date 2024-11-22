package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * That class implementing the interface Controller modelling a controller
 * for save and print string in standard output.
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> listOfPrintedString = new LinkedList<>();

    /**
     * This methode set then next string to print.
     * 
     * @throws IllegalArgumentException if string is null
     */
    @Override
    public void setString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("String can't be null");
        }
        if ("".equals(string)) {
            JOptionPane.showMessageDialog(null, "Error string can't be unsetted");
            throw new IllegalArgumentException("String can't be unsetted");
        }
        this.nextString = string;
        if (!"".equals(string)) {
            listOfPrintedString.add(string);
        }
    }

    /**
     * This method return the next string to print.
     * 
     * @return string
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * This method return the list of string.
     * 
     * @return listOfPrintedString
     */
    @Override
    public List<String> getListOfPrintedString() {
        return new LinkedList<>(this.listOfPrintedString);
    }

    /**
     * This method print current string.
     * @throws IllegalStateException if the current string is unset
     */
    @Override
    public void printCurrentString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("The current string is unsetted");
        }
        JOptionPane.showMessageDialog(null, string);
    }
}
