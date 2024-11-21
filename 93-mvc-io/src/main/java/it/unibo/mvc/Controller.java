package it.unibo.mvc;

import java.util.List;

/**
 * This interface has methods thatt model a controller
 * for save and print string in standard output.
 */
public interface Controller {

    /**
     * This methode set then next string to print.
     * 
     * @throws IllegalArgumentException if string is null
     */
    public void setString();

    /**
     * This method return the next string to print.
     * 
     * @return string
     */
    public String getString();

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
    public void printCurrentString();

}
