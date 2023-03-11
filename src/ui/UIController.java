package ui;

import logic.FileHandler;
import model.Note;
import settings.AppCommands;
import settings.AppTexts;
import test.TestData;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static settings.AppTexts.MSG_CHOOSE_INDEX_EDIT;

/**
 * Implement the interaction between user and the UI
 */
public class UIController {

    //region Attributes
    private final List<Note> noteList;
    private final UIInputInteraction inputInteraction;
    //endregion

    //region Constructor
    public UIController() {
        noteList = TestData.getTestNotes();
        sortByImportanceAndTitle();
        inputInteraction = new UIInputInteraction();
    }
    //endregion

    //region Methods
    public void startUI() {
        printAppName();
        interactWithUser();
    }

    private void printAppName() {
        System.out.println("""
                ====================
                     MyToDoList 
                ====================
                """);
    }

    /**
     * Print main menu, receive the user-input and calls the related methods
     * The interaction with main menu runs through a do-while loop
     */
    private void interactWithUser() {
        boolean endApp = false;

        while (!endApp) {
            //Show main menu
            printMainMenu();

            //Read user input
            Scanner scanObj = new Scanner(System.in);
            String userChoice = scanObj.nextLine();

            //Evaluate the user input and initiate the related method
            switch (userChoice) {
                case AppCommands.USER_CMD_SHOW -> show();
                case AppCommands.USER_CMD_CREATE -> create();
                case AppCommands.USER_CMD_EDIT -> edit();
                case AppCommands.USER_CMD_DELETE -> delete();
                case AppCommands.USER_CMD_EXIT -> endApp = true;
                default -> System.err.printf(AppTexts.MSG_INVALID_CHOICE);
            }
        }
    }

    private void printMainMenu() {
        System.out.println(AppTexts.MAIN_MENU_SHOW);
        System.out.println(AppTexts.MAIN_MENU_CREATE);
        System.out.println(AppTexts.MAIN_MENU_EDIT);
        System.out.println(AppTexts.MAIN_MENU_DELETE);
        System.out.println(AppTexts.MAIN_MENU_EXIT);
        System.out.printf(AppTexts.MSG_USER_CHOICE);
    }

    /**
     * Print all the notes to the console
     */
    private void show() {
        System.out.printf(AppTexts.FORMAT_STRING_NOTE_HEADER, AppTexts.INDEX, AppTexts.TITLE,
                AppTexts.CONTENT, AppTexts.IMPORTANT);
        for (int i = 0; i < noteList.size(); i++) {
            Note currentNote = noteList.get(i);
            System.out.printf(AppTexts.FORMAT_STRING_NOTE, i, currentNote.getTitle(),
                    currentNote.getContent(), currentNote.isImportant());
        }
    }

    /**
     * Add a new note to the list
     */
    private void create() {
        Note note = inputInteraction.getNoteFromUser();  //Read notes
        noteList.add(note); //Add notes to the list
        sortAndSaveListInCsvFile();
        System.out.println(AppTexts.MSG_NOTE_CREATION_SUCCESS);
    }

    /**
     * Let user choose a note to edit than read the new input and change the content
     */
    private void edit() {
        // Show list
        System.out.printf(MSG_CHOOSE_INDEX_EDIT);
        show();

        // Read index to edit
        Scanner scanInt = new Scanner(System.in);
        int indexToUpdate = scanInt.nextInt();

        // Check index
        if (indexToUpdate < noteList.size()) {
            Note note = inputInteraction.getNoteFromUser(); // Read new note
            noteList.set(indexToUpdate, note);              // replace the note
            System.out.println(AppTexts.MSG_NOTE_EDIT_SUCCESS);
        } else {
            System.err.printf(AppTexts.MSG_INVALID_CHOICE);    // Error Message
        }
    }

    /**
     * Get an input from user to delete an existing note
     */
    private void delete() {
        System.out.println(AppTexts.MSG_CHOOSE_INDEX_DELETE);   // Read the list
        show();

        // Read index to delete
        Scanner scanInt = new Scanner(System.in);
        int indexToDelete = scanInt.nextInt();

        // Check index validity
        if (indexToDelete < noteList.size()) {
            noteList.remove(indexToDelete);                     // Delete note
            System.out.println(AppTexts.MSG_DELETE_SUCCESS);
        } else {
            System.err.printf(AppTexts.MSG_INVALID_CHOICE);    // Error Message
        }
    }

    /**
     * Save the current List in CVS-Data after sorting
     */
    private void sortAndSaveListInCsvFile() {
        sortByImportanceAndTitle();
        FileHandler.getInstance().saveNotesToCsvFile(noteList);
    }

    public void sortByImportanceAndTitle() {

        noteList.sort((firstNote, secondNote) -> {

            //Sort the notes based on the importance
            Boolean firstNoteImportant = firstNote.isImportant();
            Boolean secondNoteImportant = secondNote.isImportant();

            int boolCompare = firstNoteImportant.compareTo(secondNoteImportant);

            if (boolCompare != 0) {
                return -boolCompare;
            }

            String firstNoteTitle = firstNote.getTitle();
            String secondNoteTitle = secondNote.getTitle();

            int stringCompare = firstNoteTitle.compareTo(secondNoteTitle);

            return stringCompare;
        });

        noteList.sort(new Comparator<Note>() {
            @Override
            public int compare(Note firstNote, Note secondNote) {

                // Sort according to the importance
                Boolean firstNoteImportant = firstNote.isImportant();
                Boolean secondNoteImportant = secondNote.isImportant();

                int boolCompare = firstNoteImportant.compareTo(secondNoteImportant);

                if (boolCompare != 0) {
                    return -boolCompare;
                }

                String firstNoteTitle = firstNote.getTitle();
                String secondNoteTitle = secondNote.getTitle();

                int stringCompare = firstNoteTitle.compareTo(secondNoteTitle);

                return -stringCompare;
            }
        });

    }
    //endregion
}