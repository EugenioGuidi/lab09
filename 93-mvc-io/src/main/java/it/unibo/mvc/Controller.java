package it.unibo.mvc;

import java.util.List;

/**
 * This interface has methods that model a controller
 * for save and print string in standard output.
 */
public interface Controller {

    /**
     * This methode set then next string to print.
     * 
     * @throws IllegalArgumentException if string is null
     */
    public void setString(final String string);

    /**
     * This method return the next string to print.
     * 
     * @return string
     */
    public String getNextString();

    /**
     * This method return the list of string.
     * 
     * @return listOfPrintedString
     */
    public List<String> getListOfPrintedString();

    /**
     * This method print current string
     * @throws IllegalStateException if the current string is unset
     */
    public void printCurrentString(final String string);

}
