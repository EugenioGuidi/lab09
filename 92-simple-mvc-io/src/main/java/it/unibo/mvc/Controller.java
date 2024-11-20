package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_NAME_FILE = "output.txt";

    private File file;

    /**
     * Constructor with 0 argument that set a file in user home.
     */
    public Controller() {
        this.file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + DEFAULT_NAME_FILE);
    }

    /**
     * set the file.
     * 
     * @param file
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * 
     * @return The current file, null if there isn't.
     */
    public File getFile() {
        return this.file;
    }

    /**
     * 
     * @return the path of the file.
     */
    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    /**
     * write the string in input inside the file, throw an exception if there is an error to write inside the file.
     * 
     * @param string
     * @throws IOException
     */
    public void writeStringInFile(final String string) throws IOException {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(this.file, StandardCharsets.UTF_8))) {
            wr.write(string);
        } catch (IOException e) {
            throw new IOException("Error writing on file", e);
        }
    }

}
