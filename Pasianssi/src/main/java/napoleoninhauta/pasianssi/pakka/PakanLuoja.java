/**
 * Luokan tehtävänä on luoda perinteinen 52:n kortin korttipakka.
 */
package napoleoninhauta.pasianssi.pakka;

import java.util.ArrayList;
import java.util.Collections;

public class PakanLuoja {

    private ArrayList<Kortti> kortit;

    public PakanLuoja() {
        this.kortit = new ArrayList();
    }

    /**
     * Metodi palauttaa uuden sekoitetun pelipakan. Ensiksi metodi tyhjentää
     * listan mahdollisista vanhoista korteista. Sen jälkeen metodi käyttää
     * yksityisiä metodeja lisäämän listalle jokaisen neljän maan kortit 1-13.
     * Lopuksi metodi sekoittaa pakan.
     *
     * @return valmis sekoitettu pakka
     */
    public ArrayList<Kortti> alustaPakka() {
        kortit.clear();
        lisaaKortit();
        Collections.shuffle(kortit);
        return kortit;
    }

    private void lisaaKortit() {
        lisaaMaanKortit(Maa.HERTTA);
        lisaaMaanKortit(Maa.PATA);
        lisaaMaanKortit(Maa.RUUTU);
        lisaaMaanKortit(Maa.RISTI);
    }

    private void lisaaMaanKortit(Maa maa) {
        int i = 1;
        while (i < 14) {
            kortit.add(new Kortti(i, maa));
            i++;
        }
    }
}
