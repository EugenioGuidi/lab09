package it.unibo.mvc;

import java.util.List;

/**
 * That class implementing the interface Controller modelling a controller
 * for save and print string in standard output.
 *
 */
public final class SimpleController implements Controller {

    private final List<String> listOfPrintedString = null;

    /**
     * This methode set then next string to print.
     * 
     * @throws IllegalArgumentException if string is null
     */
    @Override
    public void setString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setString'");
    }

    /**
     * This method return the next string to print.
     * 
     * @return string
     */
    @Override
    public String getString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getString'");
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
    public void printCurrentString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printCurrentString'");
    }

}
