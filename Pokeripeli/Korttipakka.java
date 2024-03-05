import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Korttipakka {
    private ArrayList<Kortti> pakka;

    public Korttipakka() {
        luoPakka();
        Sekoita();
    }

    public void luoPakka()
    {
        this.pakka = new ArrayList<>();
        for (Maa maa : Maa.values()) {
            for (int j = 1; j <= 13; j++) {
                Kortti k = new Kortti(maa, j);
                this.pakka.add(k);
            }
        }
    }

    public List<Kortti> jaa(int n)
    {   
        List<Kortti> kasi = new ArrayList<>(this.pakka.subList(0, n));

        this.pakka.removeAll(kasi);

        return kasi;
    }

    public void Sekoita()
    {
        Collections.shuffle(pakka);
    }

    public void JarjestaOletusJarjestykseen()
    {
        Comparator<Kortti> vertailija = (k1, k2) -> { 
            int ret = k1.getMaa().compareTo(k2.getMaa());
            if (ret == 0)
                ret = k1.getArvo() - k2.getArvo();
            return ret;
        };
        Collections.sort(this.pakka, vertailija);
    }

    public void JarjestaMaanMukaan()
    {
        Collections.sort(this.pakka, (k1, k2) -> k1.getMaa().compareTo(k2.getMaa()));
    }  
    
    public void JarjestaArvonMukaan()
    {
        Comparator<Kortti> vertailija = (k1, k2) -> k1.getArvo() - k2.getArvo();

        Collections.sort(this.pakka, vertailija);
    }  

    public Kortti nostaKortti() {
        if (!this.pakka.isEmpty()) {
            return this.pakka.remove(0);
        }
        return null;
    }
    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Kortti kortti : pakka) {
            s.append(kortti.toString());
            s.append("\n");
        }

        return s.toString();
    } 
}
