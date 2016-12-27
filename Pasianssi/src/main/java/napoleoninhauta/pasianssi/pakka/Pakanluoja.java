package napoleoninhauta.pasianssi.pakka;

import java.util.ArrayList;
import java.util.Collections;

public class Pakanluoja {

    private ArrayList<Kortti> kortit;

    public Pakanluoja() {
        this.kortit = new ArrayList();
    }

    public void alustaPakka() {
        kortit.clear();
        lisaaKortit();
        Collections.shuffle(kortit);
    }

    public void lisaaKortit() {
        lisaaMaanKortit(Maa.HERTTA);
        lisaaMaanKortit(Maa.PATA);
        lisaaMaanKortit(Maa.RUUTU);
        lisaaMaanKortit(Maa.RISTI);
    }

    public void lisaaMaanKortit(Maa maa) {
        int i = 1;
        while (i < 14) {
            kortit.add(new Kortti(i, maa));
            i++;
        }
    }
    
    public ArrayList<Kortti> palautaPakka() {
        return this.kortit;
    }
    
}
