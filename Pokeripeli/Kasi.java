import java.util.ArrayList;

public class Kasi {
    private ArrayList<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaaKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public void vaihdaKortti(int indeksi, Kortti uusiKortti) {
        if (indeksi >= 0 && indeksi < kortit.size()) {
            kortit.set(indeksi, uusiKortti);
        }
    }

    public void tyhjennaKasi() {
        kortit.clear();
    }

    @Override
    public String toString() {
        return kortit.toString();
    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
}
