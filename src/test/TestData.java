package test;

import model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a static Method to generate data
 */
public class TestData {
    //region Constants
    private static final int TEST_NOTE_AMOUNT = 6;
    //endregion

    //region Attributes
    //endregion

    //region Constructor
    private TestData() {}
    //endregion

    //region Methods
    /**
     * Generate test-notes and print them back
     * @return {@Link Note} : testNoteList ArrayList
     */
    public static List<Note> getTestNotes() {
        List<Note> testNoteList = new ArrayList<>();

        for (int i = 0; i < TEST_NOTE_AMOUNT; i++) {
            Note testNote = new Note("Test-Title " + i, "Test-Content " + i);
            if (i % 2 == 0) testNote.setImportant(true);
            testNoteList.add(testNote);
        }

        return testNoteList;
    }
    //endregion
}