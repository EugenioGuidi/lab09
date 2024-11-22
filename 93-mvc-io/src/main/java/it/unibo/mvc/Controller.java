package it.unibo.mvc;

import java.util.List;

/**
 * This interface has methods that model a controller
 * for save and print string in standard output.
 */
public interface Controller {

    /**
     * /**
     * This methode set then next string to print.
     * 
     * @param string
     * @throws IllegalArgumentException if string is null
     */
    void setString(String string);

    /**
     * This method return the next string to print.
     * 
     * @return string
     */
    String getNextString();

    /**
     * This method return the list of string.
     * 
     * @return listOfPrintedString
     */
    List<String> getListOfPrintedString();

    /**
     * This method print current string.
     * 
     * @throws IllegalStateException if the current string is unset
     * @param string
     */
    void printCurrentString(String string);
}
