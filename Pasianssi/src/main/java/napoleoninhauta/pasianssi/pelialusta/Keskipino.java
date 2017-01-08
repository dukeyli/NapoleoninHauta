/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa kortteja joiden
 * arvo on välillä 1-6. Pinoon voi laittaa vain yhden arvoista korttia kerrallaan, ensin
 * kuutosia, sitten viitosia jne.
 */
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Keskipino extends Pino {

    private int arvo;

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
        if (kortti.palautaArvo() == arvo && !super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
            arvo--;
        }
        if (this.arvo == 0) {
            this.arvo = 6;
        }
    }
}
