package com.bajtek.travelgram.entity;

public enum Country {
    POLAND("Polska"),
    CZECH_REPUBLIC("Czechy"),
    NORWAY("Norwegia"),
    FINLAND("Finlandia"),
    GERMANY("Niemcy"),
    JAPAN("Japonia"),
    ITALY("Włochy"),
    AUSTRIA("Austria"),
    SWITZERLAND("Szwajcaria"),
    SLOVENIA("Słowenia"),
    USA("Stany Zjednoczone");

    //todo Dodać wszystkie państwa świata

    private final String displayName;

    Country(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}