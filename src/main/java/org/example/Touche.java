package org.example;

import javax.swing.*;

public class Touche  extends JButton {
    private int midiNote;

    public Touche(String label, int midiNote) {
        super(label);
        this.midiNote = midiNote;
    }

    public int getMidiNote() {
        return midiNote;
    }
}
