package org.example.model;

public class CombBoxModel {

    private String displayText;
    private int id;

    public CombBoxModel(String displayText, int id) {
        this.displayText = displayText;
        this.id = id;
    }

    @Override
    public String toString() {
        return displayText;
    }

    public int getId() {
        return id;
    }
}
