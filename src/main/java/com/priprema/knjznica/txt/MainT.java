package com.priprema.knjznica.txt;


import java.io.*;
import java.util.Scanner;

public class MainT {
    private static final String FILE_NAME = "osobe.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean radi = true;

        while (radi) {
            System.out.println("\n1. Dodaj osobu\n2. Prikaži sve osobe\n3. Izlaz");
            System.out.print("Odaberi opciju: ");
            int opcija = scanner.nextInt();
            scanner.nextLine(); // "pojedi" enter

            switch (opcija) {
                case 1:
                    dodajOsobu(scanner);
                    break;
                case 2:
                    prikaziOsobe();
                    break;
                case 3:
                    radi = false;
                    break;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }

        scanner.close();
    }

    private static void dodajOsobu(Scanner scanner) {
        System.out.print("Unesi ime: ");
        String ime = scanner.nextLine();
        System.out.print("Unesi prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("Unesi dob: ");
        int dob = scanner.nextInt();
        scanner.nextLine(); // "pojedi" enter

        Osoba osoba = new Osoba(ime, prezime, dob);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(osoba.toFileString());
            writer.newLine();
            System.out.println("Osoba dodana.");
        } catch (IOException e) {
            System.out.println("Greška pri pisanju u datoteku.");
        }
    }

    private static void prikaziOsobe() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Datoteka ne postoji.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Osoba osoba = Osoba.fromFileString(line);
                System.out.println(osoba);
            }
        } catch (IOException e) {
            System.out.println("Greška pri čitanju datoteke.");
        }
    }
}