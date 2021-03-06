/**
 * Luokka määrittelee pinon, johon voi liittyä tasan yksi kortti kerrallaan.
 * Paikkaan voi laittaa kortin ja paikasta voi ottaa kortin pois, jolloin
 * paikka vapautuu.
 */
package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;

public class YhdenKortinJemma {

    private Kortti paikka;

    /**
     * Metodi laittaa parametrina annetun kortin jemmaan, jos jemmassa ei ole
     * ennestään korttia.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    public void asetaKortti(Kortti kortti) {
        if (paikka == null) {
            this.paikka = kortti;
        }
    }

    /**
     * Jos jemma ei ole tyhja, metodi palauttaa jemman kortin ja poistaa sen
     * jemmasta, eli laittaa jemmaan arvon null. Muulloin metodi vain palauttaa
     * null.
     *
     * @return jemman kortti tai null
     */
    public Kortti otaKortti() {
        if (paikka != null) {
            Kortti kortti = paikka;
            paikka = null;
            return kortti;
        }
        return null;
    }

    /**
     * Metodi palauttaa jemman kortin String-esityksen, tai "tyhja", jos jemma
     * on tyhjä.
     *
     * @return jemman kortin String-esitys tai "tyhja"
     */
    public String getKortti() {
        if (paikka == null) {
            return "tyhja";
        }
        return this.paikka.toString();
    }

    /**
     * Metodi palauttaa jemman kortin arvon, jos jemmassa on kortti.
     *
     * @return kortin arvo kokonaislukuna tai nolla
     */
    public int getKortinArvo() {
        if (paikka == null) {
            return 0;
        }
        return paikka.getArvo();
    }

    /**
     * Metodi asettaa paikalle alkuperäisen arvon, eli null.
     */
    public void tyhjenna() {
        this.paikka = null;
    }

}
