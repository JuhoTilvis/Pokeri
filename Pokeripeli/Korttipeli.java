import java.util.Scanner;

public class Korttipeli {
    private Korttipakka pakka;
    private Kasi kasi;
    private int peliraha = 100;
    private int panos = 0;
    private int kerroin;
    private Scanner scanner = new Scanner(System.in);

    public Korttipeli() {
        pakka = new Korttipakka();
        pakka.Sekoita();
        kasi = new Kasi();
    }

    private void jaaKasi() {
        kasi.tyhjennaKasi();
        for (int i = 0; i < 5; i++) {
            kasi.lisaaKortti(pakka.nostaKortti());
        }
    }

    private void vaihdaKortit() {
        System.out.println("Kuinka monta korttia haluat vaihtaa (0-5)?");
        int maara = scanner.nextInt();
        if (maara > 0 && maara <= 5) {
            for (int i = 0; i < maara; i++) {
                System.out.println("Anna vaihdettavan kortin numero (1-5):");
                int korttiIndeksi = scanner.nextInt() - 1;
                kasi.vaihdaKortti(korttiIndeksi, pakka.nostaKortti());
            }
        }
        System.out.println("Uusi käsi: " + kasi);
    }

    private void asetaPanos() {
        System.out.println("Aseta panos (vähintään 1, enintään " + peliraha + "): ");
        panos = scanner.nextInt();
        while (panos < 1 && panos > peliraha) {
            System.out.println("Virheellinen panos! Aseta panos uudelleen: ");
            panos = scanner.nextInt();
        }
    }

    private void tarkistaKasiJaMaksaVoitot() {
        String kadenTyyppi = TarkistaKasi.tarkistaKadenTyyppi(kasi.getKortit());
        int voitto = kerroin * panos;
        switch (kadenTyyppi) {
            case "Värisuora":
                kerroin = 30;
                break;
            case "Neloset":
                kerroin = 15;
                break;
            case "Täyskäsi":
                kerroin = 10;
                break;
            case "Väri":
                kerroin = 5;
                break;
            case "Suora":
                kerroin = 4;
                break;
            case "Kolmoset":
            case "Kaksi paria":
                kerroin = 3;
                break;
        }
        
        if (voitto > 0) {
            peliraha += voitto;
            System.out.println("Voitit: " + voitto + " euroa! Rahaa jäljellä: " + peliraha + " euroa.");
        } else {
            System.out.println("Ei voittoa tällä kierroksella.");
        }
    }

    public void pelaa() {
        while (peliraha >= panos) {
            asetaPanos();
            peliraha -= panos;
            System.out.println("Pelaajan rahat: " + peliraha + " euroa.");
            jaaKasi();
            System.out.println("Jaettu käsi: " + kasi);
            vaihdaKortit();
            tarkistaKasiJaMaksaVoitot();
            System.out.println("Haluatko pelata uudelleen? (k/e)");
            scanner.nextLine();
            String vastaus = scanner.nextLine();
            if (!vastaus.equals("k")) {
                break;
            }
        }
        System.out.println("Peli päättyi. Pelaajan lopulliset rahat: " + peliraha + " euroa.");
    }

    public static void main(String[] args) {
        Korttipeli peli = new Korttipeli();
        peli.pelaa();
    }
}
