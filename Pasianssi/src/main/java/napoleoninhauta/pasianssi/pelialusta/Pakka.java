
package napoleoninhauta.pasianssi.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pakka {
    
    private ArrayList<Kortti> kortit;
    
    public Pakka(ArrayList<Kortti> kortit) {
        this.kortit=kortit;
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
