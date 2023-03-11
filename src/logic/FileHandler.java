package logic;


import model.Note;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * FileHandler class saves the autonomously generated data as CVS
 */
public class FileHandler {
    //region Constants
    public static final String CSV_FILE_PATH = "notes.csv";
    public static final String DELIMITER = ";";
    //endregion

    //region Attributes
    private static FileHandler instance;
    //endregion

    //region Constructor
    private FileHandler() { System.out.println("File-handler generated!"); }
    //endregion

    //region Methods
    /**
     * Initialized by first call of an object of the class
     * @return {@link FileHandler} : Only instance of the class
     */
    public static synchronized FileHandler getInstance() {
        //check if the object exist
        if (instance == null) {
            //Create an instance in case of absence
            instance = new FileHandler();
        }
        //Instance return
        System.out.println("File-handler returned");
        return instance;
    }

    /**
     * Saving notes in CVS-String List
     * @param notesToSave : {@link List< Note >} : List of saved notes
     */
    public void saveNotesToCsvFile(List<Note> notesToSave) {
        //Create a data object
        File csvFile = new File(CSV_FILE_PATH);

        FileOutputStream fos = null;    // define a bridge to the file
        OutputStreamWriter osw = null;  // write in bytes and define the character-set
        BufferedWriter out = null;      // write a String and use the cache for it

        try {
            fos = new FileOutputStream(csvFile);                        // generate fos with data-object
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);  // generate osw with fos and character-set
            out = new BufferedWriter(osw);                              // generate out with osw

            // iterate through the list
            for (Note noteToSave : notesToSave) {
                out.write(noteToSave.getAttributesAsCsvLine()); // write all Notes as CVS-Strings in Data
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                out.flush();    // empty the cache
                out.close();    // close the bridge to the file
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Read the lines and generate a Note-object for each one and add it to a list.
     * @return {@link List<Note>} : List of Notes
     */
    public List<Note> readNotesFromCsvFile() {
        List<Note> noteList = new ArrayList<>();    // create an empty list
        File csvFile = new File(CSV_FILE_PATH);     // create a data-object

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader in = null;

        try {
            if (!csvFile.exists()) {        // check if data exist
                csvFile.createNewFile();    // if it's not exist, create one
            }

            fis = new FileInputStream(csvFile);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            in = new BufferedReader(isr);

            boolean eof = false;    // variable to get to the end of file

            while (!eof) {
                String csvLine = in.readLine();

                if (csvLine == null) {
                    eof = true;
                } else {
                    Note note = new Note(csvLine);
                    noteList.add(note);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                in.close();             // close the bridge to the file
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return noteList;    // return the list
    }
    //endregion
}
