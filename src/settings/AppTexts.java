package settings;

/**
 * This class contains all the texts and messages of the program
 */
public class AppTexts {
    //region Constants
    public static final String MAIN_MENU_SHOW = "\n[\t" + AppCommands.USER_CMD_SHOW + "\t] Show all notes";
    public static final String MAIN_MENU_CREATE = "[\t" + AppCommands.USER_CMD_CREATE + "\t] Create a note";
    public static final String MAIN_MENU_EDIT = "[\t" + AppCommands.USER_CMD_EDIT + "\t] Edit a note";
    public static final String MAIN_MENU_DELETE = "[\t" + AppCommands.USER_CMD_DELETE + "\t] Delete a note";
    public static final String MAIN_MENU_EXIT = "[\t" + AppCommands.USER_CMD_EXIT + "\t] End the program";

    public static final String MSG_USER_CHOICE = "\nSelect your option: ";
    public static final String MSG_INVALID_CHOICE = "Invalid Selection!\n";

    public static final String MSG_CHOOSE_INDEX_DELETE = "\nSelect a note to delete: ";
    public static final String MSG_DELETE_SUCCESS = "\nYour note has been successfully deleted.";
    public static final String MSG_INPUT_NOTE_DATA = "\nPlease, enter the following information... ";

    public static final String MSG_INPUT_TITLE = "Titel: ";
    public static final String MSG_INPUT_CONTENT = "Content: ";
    public static final String MSG_INPUT_IMPORTANT = "Is this note important? ( Y / N ) : ";
    public static final String MSG_CHOOSE_INDEX_EDIT = "\nPlease, select the note, you want to edit: ";

    public static final String MSG_INVALID_TITLE = "\nInvalid Titel! The Titel must have %d to %d characters.\n";
    public static final String MSG_INVALID_CONTENT = "\nInvalid Content! The content can have max %d characters.\n";
    public static final String MSG_INVALID_IMPORTANCE = "\nInvalid input! Please enter 'Y' for yes or 'N' for no!\n";
    public static final String MSG_NOTE_CREATION_SUCCESS = "\nYour note has been successfully created.";
    public static final String MSG_NOTE_EDIT_SUCCESS = "\nYour note has been successfully updated.";

    public static final String FORMAT_STRING_NOTE_HEADER = "\n%5s %20s %40s %10s\n";
    public static final String FORMAT_STRING_NOTE = "%5d %20s %40s %10s\n";

    public static final String INDEX = "Index";
    public static final String CONTENT = "Content";
    public static final String IMPORTANT = "Important";
    public static final String TITLE = "Titel";
    //endregion

    //region Attributes
    //endregion

    /**
     * Private constructor to prevent creation of a new object from outside
     */
    //region Constructor
    private AppTexts() {}
    //endregion

    //region Methods
    //endregion
}
