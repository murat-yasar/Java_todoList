package model;

import logic.FileHandler;

/**
 * Note class is the Model class which has a titel, content and a flag,
 * which shows whether the note is important.
 */
public class Note {
    //region Constants
    public static final String DEF_STR_VAL = ">noData<";
    private static final boolean DEF_BOOL_VAL = false;
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_CONTENT = 1;
    public static final int INDEX_IS_IMPORTANT = 2;
    //endregion

    //region Attributes
    private String title;
    private String content;
    private boolean isImportant;
    //endregion

    //region Constructor
    /**
     * Standard Constructor with defined initial values
     */
    public Note() {
        title = DEF_STR_VAL;
        content = DEF_STR_VAL;
        isImportant = DEF_BOOL_VAL;
    }

    public Note(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content, boolean isImportant) {
        this.title = title;
        this.content = content;
        this.isImportant = isImportant;
    }

    /**
     * Overloaded constructor accepting a CSV line and initializing all attributes using a method.
     * @param csvLine : {@link String} CVS-line
     */
    public Note(String csvLine) {
        setAttributesFromCsvLine(csvLine);
    }
    //endregion

    //region Methods
    /**
     * Distribute Attributes as CVS
     * @return {@link String} : CVS-line
     */
    public String getAttributesAsCsvLine() {
        return title + FileHandler.DELIMITER + content + FileHandler.DELIMITER + isImportant + "\n";
    }

    /**
     * Fill out the attributes with CVS-Strings
     * @return csvLine : {@link String} : Csv-String with Attributes
     */

    public void setAttributesFromCsvLine(String csvLine) {
        String[] allAttributes = csvLine.split(FileHandler.DELIMITER);

        title = allAttributes[INDEX_TITLE];
        content = allAttributes[INDEX_CONTENT];
        isImportant = Boolean.parseBoolean(allAttributes[INDEX_IS_IMPORTANT]);
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public boolean isImportant() {return isImportant;}

    public void setImportant(boolean important) {isImportant = important;}

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isImportant=" + isImportant +
                '}';
    }
//endregion
}
