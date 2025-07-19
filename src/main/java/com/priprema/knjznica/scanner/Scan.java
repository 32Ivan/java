package com.priprema.knjznica.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Ucenik> ucenici = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            int[] ocijene = new int[3];
            System.out.println("Unesi ime ucenika ");
            String ime = scanner.nextLine();

            System.out.println("Unesi Prezime ucenika ");
            String prezime = scanner.nextLine();
            Ucenik ucenik = new Ucenik(ime, prezime);

            System.out.println("Unesi ocijenu iz matematike");
            ocijene[0] = scanner.nextInt();

            System.out.println("Unesi ocijenu iz hrvatski");
            ocijene[1] = scanner.nextInt();

            System.out.println("Unesi ocijenu iz engleski");
            ocijene[2] = scanner.nextInt();

            ucenik.setOcijena(ocijene);
            ucenici.add(ucenik);

            scanner.nextLine();

        }
        System.out.println("Podatci o ucenicima");
        for (Ucenik ucenik : ucenici) {
            ucenik.prikaziPodatke();
        }

    }
}
