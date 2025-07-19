package com.priprema.knjznica.scanner;

public class Ucenik {
    private String ime;
    private String prezime;
    private int[] ocijena;

    public Ucenik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public double izracunajProsjek() {
        int sum = 0;
        for (int i : ocijena) {
            sum += i;
        }
        return (double) sum / 3;
    }

    public void prikaziPodatke() {
        System.out.println("Ime " + ime + " Prezime " + prezime + " Prosjecna ocijena " + izracunajProsjek());
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int[] getOcijena() {
        return ocijena;
    }

    public void setOcijena(int[] ocijena) {
        this.ocijena = ocijena;
    }
}
