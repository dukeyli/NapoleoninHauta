/**
 * Luokka, joka määrittelee korttipakan, josta kortteja aletaan nostaa pelissä.
 * Pelipaksta voi vain nostaa kortin.
 */
package napoleoninhauta.pasianssi.pinot;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelipakka {

    private ArrayList<Kortti> kortit;

    public Pelipakka(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }

    /**
     * Metodi palauttaa pakassa olevien korttien lukumäärän.
     *
     * @return pakan koko
     */
    public int palautaMaara() {
        return this.kortit.size();
    }

    /**
     * Metodi palauttaa pakan päälimmäisen kortin ja poistaa sen pakasta. Jos
     * pakassa ei ole kortteja, metodi vain palauttaa null.
     *
     * @return päällimäinen kortti tai null
     */
    public Kortti nostaKortti() {
        if (!kortit.isEmpty()) {
            Kortti eka = kortit.get(0);
            kortit.remove(0);
            return eka;
        }
        return null;
    }

}
