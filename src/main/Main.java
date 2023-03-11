package main;

import ui.UIController;

public class Main {
    /**
     * Start Method of Main Program
     * @param args : {@link String[]} : Startparameter
     */
    public static void main(String[] args) {
        UIController uiControl = new UIController();
        uiControl.startUI();
    }
}