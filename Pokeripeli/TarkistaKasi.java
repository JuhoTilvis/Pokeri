import java.util.Collections;
import java.util.List;

public class TarkistaKasi {
    public static String tarkistaKadenTyyppi(List<Kortti> pokerikasi) {
        Collections.sort(pokerikasi); 

        if (onVärisuora(pokerikasi)) {
            return "Värisuora";
        }
        if (onNeloset(pokerikasi)) {
            return "Neloset";
        }
        if (onTayskasi(pokerikasi)) {
            return "Täyskäsi";
        }
        if (onVari(pokerikasi)) {
            return "Väri";
        }
        if (onSuora(pokerikasi)) {
            return "Suora";
        }
        if (onKolmoset(pokerikasi)) {
            return "Kolmoset";
        }
        if (onKaksiParia(pokerikasi)) {
            return "Kaksi paria";
        }
        if (onPari(pokerikasi)) {
            return "Pari";
        }

        return "Hai";
    }

    private static boolean onPari(List<Kortti> pokerikasi) {
        for (int i = 0; i < pokerikasi.size() - 1; i++) {
            if (pokerikasi.get(i).getArvo() == pokerikasi.get(i + 1).getArvo()) {
                return true;
            }
        }
        return false;
    }

    private static boolean onKaksiParia(List<Kortti> pokerikasi) {
        int parienLaskuri = 0;
        for (int i = 0; i < pokerikasi.size() - 1; i++) {
            if (pokerikasi.get(i).getArvo() == pokerikasi.get(i + 1).getArvo()) {
                parienLaskuri++;
                i++; 
            }
        }
        return parienLaskuri == 2;
    }

    private static boolean onKolmoset(List<Kortti> pokerikasi) {
        for (int i = 0; i < pokerikasi.size() - 2; i++) {
            if (pokerikasi.get(i).getArvo() == pokerikasi.get(i + 1).getArvo()
                    && pokerikasi.get(i).getArvo() == pokerikasi.get(i + 2).getArvo()) {
                return true;
            }
        }
        return false;
    }

    private static boolean onSuora(List<Kortti> pokerikasi) {
        for (int i = 0; i < pokerikasi.size() - 1; i++) {
            if (pokerikasi.get(i).getArvo() != pokerikasi.get(i + 1).getArvo() - 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean onVari(List<Kortti> pokerikasi) {
        for (int i = 0; i < pokerikasi.size() - 1; i++) {
            if (pokerikasi.get(i).getMaa() != pokerikasi.get(i + 1).getMaa()) {
                return false;
            }
        }
        return true;
    }

    private static boolean onTayskasi(List<Kortti> pokerikasi) {
        return (onPari(pokerikasi) && onKolmoset(pokerikasi));
    }

    private static boolean onNeloset(List<Kortti> pokerikasi) {
        for (int i = 0; i < pokerikasi.size() - 3; i++) {
            if (pokerikasi.get(i).getArvo() == pokerikasi.get(i + 1).getArvo()
                    && pokerikasi.get(i).getArvo() == pokerikasi.get(i + 2).getArvo()
                    && pokerikasi.get(i).getArvo() == pokerikasi.get(i + 3).getArvo()) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean onVärisuora(List<Kortti> pokerikasi) {
        return (onVari(pokerikasi) && onSuora(pokerikasi));
    }
}
    // käden tarkastus logiikka otettu https://stackoverflow.com/questions/20578974/checking-poker-hands