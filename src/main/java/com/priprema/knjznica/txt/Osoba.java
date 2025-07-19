package com.priprema.knjznica.txt;

public class Osoba {
    private final String ime;
    private final String prezime;
    private final int dob;

    public Osoba(String ime, String prezime, int dob) {
        this.ime = ime;
        this.prezime = prezime;
        this.dob = dob;
    }

    public static Osoba fromFileString(String line) {
        String[] parts = line.split(",");
        return new Osoba(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    public String toFileString() {
        return ime + "," + prezime + "," + dob;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + ", Prezime: " + prezime + ", Dob: " + dob;
    }
}