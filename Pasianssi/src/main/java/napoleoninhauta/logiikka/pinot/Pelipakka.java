/**
 * Luokka, joka määrittelee korttipakan, josta kortteja aletaan nostaa pelissä.
 * Pelipaksta voi vain nostaa kortin.
 */
package napoleoninhauta.logiikka.pinot;

import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.PakanLuoja;

public class Pelipakka {

    private ArrayList<Kortti> kortit;

    /**
     * Konstruktori määrittää attribuutin pelipakaksi annetun parametrin avulla.
     *
     * @param kortit Pakanluojan tekemä pakka
     */
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

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päällimmäiseksi. Metodi
     * on noston olemassa noston perumista varten.
     *
     * @param kortti kortti pelipakasta.
     *
     */
    public void asetaKortti(Kortti kortti) {
        kortit.add(0, kortti);
    }

    /**
     * Metodi alustaa pakan uudestaan Pakanluojan avulla.
     */
    public void alustaUusiPakka() {
        PakanLuoja luoja = new PakanLuoja();
        this.kortit = luoja.alustaPakka();
    }

}
