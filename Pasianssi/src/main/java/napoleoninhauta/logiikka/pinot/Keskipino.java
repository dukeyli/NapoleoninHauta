/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa kortteja joiden
 * arvo on välillä 1-6. Pinoon voi laittaa vain yhden arvoista korttia kerrallaan, ensin
 * kuutosia, sitten viitosia jne.
 */
package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;

public class Keskipino extends Pino {

    private int arvo;

    /**
     * Konstruktori antaa attribuutille arvon kuusi (6).
     */
    public Keskipino() {
        this.arvo = 6;
    }

    /**
     * Metodi palauttaa attribuutin nimeltä arvo.
     *
     * @return kokonaislukuarvoinen attribuutti
     */
    public int palautaArvo() {
        return this.arvo;
    }

    /**
     * Metodi kertoo onko peli avattu, eli ensimmäinen kuutonen laitettu.
     *
     * @return boolean true/false
     */
    public boolean onkoPeliAvattu() {
        if (super.palautaMaara() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päälimmäiseksi ja
     * pienentää arvo-attribuuttia yhdellä, jos kortin arvo oikea ja pinossa ei
     * ole jo kyseistä korttia. Kortin arvo on oikea, jos se on sama kuin
     * arvo-attribuutin arvo. Jos attribuutti arvo pienenee nollaan, se
     * asetetaan takaisin arvoon kuusi.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.getArvo() == arvo && !super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
            arvo--;
        }
        if (this.arvo == 0) {
            this.arvo = 6;
        }
    }

    @Override
    public void tyhjenna() {
        super.palautaKortit().clear();
        arvo = 6;
    }
}
