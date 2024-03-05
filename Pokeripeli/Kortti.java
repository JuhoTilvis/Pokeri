public class Kortti implements Comparable<Kortti> {
    private Maa maa;
    private int arvo;
    
    public Kortti(Maa maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    @Override
    public String toString() {
        String s = maa.toString() + " ";

        switch (arvo) {
            case 1:
                s += "Ässä";
                break;
            case 11:
                s += "Jätkä";
                break;   
            case 12:
                s += "Rouva";
                break;                                
            case 13:
                s += "Kunkku";
                break;

            default:
                s += Integer.toString(arvo);
                break;
        }

        return s;
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    @Override
    public int compareTo(Kortti other) {
        return this.arvo - other.arvo;
    }
    

    
}