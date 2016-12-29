package napoleoninhauta.pasianssi.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelipakka {

    private ArrayList<Kortti> kortit;

    public Pelipakka(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }

    public int palautaMaara() {
        return this.kortit.size();
    }

    public Kortti nostaKortti() {
        if (!kortit.isEmpty()) {
            Kortti eka = kortit.get(0);
            kortit.remove(0);
            return eka;
        }
        return null;
    }

}
