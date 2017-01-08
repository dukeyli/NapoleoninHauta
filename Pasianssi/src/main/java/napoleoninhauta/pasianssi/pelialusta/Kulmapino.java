/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa kortteja joiden
 * arvo on välillä 7-13. Pinoon voi laittaa vain yhden arvoista korttia kerrallaan, ensin
 * seiskaa, sitten kasia jne.
 */
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Kulmapino extends Pino {

    private int arvo;

    public Kulmapino() {
        this.arvo = 7;
    }

    /**
     * Metodi palauttaa attribuutin arvo.
     *
     * @return kokonaislukuarvoinen attribuutti
     */
    public int palautaArvo() {
        return this.arvo;
    }

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päälimmäiseksi ja
     * kasvattaa arvo-attribuuttia yhdellä, jos kortin arvo oikea ja pinossa ei
     * ole jo kyseistä korttia. Kortin arvo on oikea, jos se on sama kuin
     * arvo-attribuutin arvo.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.palautaArvo() == arvo && !super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
            arvo++;
        }
    }
}
