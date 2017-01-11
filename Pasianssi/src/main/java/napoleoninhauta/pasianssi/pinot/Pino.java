/**
 * Abstrakti luokka, joka määrittelee pino-olion, johon voi liittyä kortti tai kortteja.
 * Pinolla on ylimmän kortin palauttava metodi sekä pinossa olevien korttien määrän
 * palauttava metodi.
 */
package napoleoninhauta.pasianssi.pinot;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;

public abstract class Pino {

    private ArrayList<Kortti> kortit;

    /**
     * Konstruktori alustaa kortit-attribuutin uudeksi ArrayListiksi.
     */
    public Pino() {
        this.kortit = new ArrayList();
    }

    /**
     * Metodi palauttaa pinon kortit listana. Metodi on periviä luokkia varten.
     *
     * @return yksityinen attribuutti, joka on lista kortteja
     */
    public ArrayList<Kortti> palautaKortit() {
        return this.kortit;
    }

    /**
     * Abstrakti metodi, jolla on erilaisia toteutuksia eri perivillä luokilla.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     */
    public abstract void asetaKortti(Kortti kortti);

    /**
     * Metodi palauttaa pinon päällimmäisen kortin String-esityksen, tai
     * "tyhja", jos pinossa ei ole kortteja.
     *
     * @return pinon päällimmäisen kortin String-esitys tai "tyhja"
     */
    public String palautaYlin() {
        if (!kortit.isEmpty()) {
            return this.kortit.get(0).toString();
        }
        return "tyhja";
    }

    /**
     * Metodi palauttaa pinossa olevien korttien lukumäärän.
     *
     * @return pinon koko
     */
    public int palautaMaara() {
        return this.kortit.size();
    }

    /**
     * Metodi palauttaa pinon ylimmän kortin arvon tai luvun 0, jos pinossa ei
     * ole korttia.
     *
     * @return pinon ylimmän kortin arvo tai 0
     */
    public int palautaYlimmanArvo() {
        if (!kortit.isEmpty()) {
            return this.kortit.get(0).getArvo();
        }
        return 0;
    }

    /**
     * Metodin toteutukset tyhjentävät pinon ja asettavat arvot alkuperäisiin
     * arvoihin.
     */
    public abstract void tyhjenna();

}
