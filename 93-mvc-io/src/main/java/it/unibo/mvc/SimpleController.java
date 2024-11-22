package it.unibo.mvc;

import java.util.List;
import java.util.Objects;

/**
 * That class implementing the interface Controller modelling a controller
 * for save and print string in standard output.
 *
 */
public final class SimpleController implements Controller {

    private String nextString = null;
    private final List<String> listOfPrintedString = null;

    /**
     * This methode set then next string to print.
     * 
     * @throws IllegalArgumentException if string is null
     */
    @Override
    public void setString(final String string) {
        if(string == null) {
            throw new NullPointerException("String can't be null");
        }
        try {
            if(string.equals("")) {
                throw new IllegalStateException("String can't be unsetted");
            }
        } catch (IllegalStateException e) {
            System.out.print("Error: " + e.getMessage());
        }
        this.nextString = string;
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
        return this.listOfPrintedString;
    }

    /**
     * This method print current string
     * @throws IllegalStateException if the current string is unset
     */
    @Override
    public void printCurrentString(final String string) {
        try {
            System.out.println(Objects.requireNonNull(string));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("The current string is unsetted");
        }
    }

}
