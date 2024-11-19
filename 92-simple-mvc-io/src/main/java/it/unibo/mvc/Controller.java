package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_NAME_FILE = "output.txt";

    private File file;

    public Controller() {
        this.file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + DEFAULT_NAME_FILE);
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    public void writeStringInFile (final String string) throws IOException {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(this.file))) {
            wr.write(string);
        } catch (IOException e) {
            throw new IOException("Error writing on file", e);
        }
    }

}
