/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa kortteja joiden
 * arvo on välillä 7-13. Pinoon voi laittaa vain yhden arvoista korttia kerrallaan, ensin
 * seiskaa, sitten kasia jne.
 */
package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;

public class Kulmapino extends Pino {

    private int arvo;

    /**
     * Konstruktori antaa attribuutille arvon seitsemän (7).
     */
    public Kulmapino() {
        this.arvo = 7;
    }

    /**
     * Metodi palauttaa attribuutin arvo.
     *
     * @return kokonaislukuarvoinen attribuutti
     */
    public int getArvo() {
        return this.arvo;
    }

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päälimmäiseksi ja
     * kasvattaa arvo-attribuuttia yhdellä, jos kortin arvo oikea. Kortin arvo
     * on oikea, jos se on sama kuin arvo-attribuutin arvo.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.getArvo() == arvo) {
            super.getKortit().add(0, kortti);
            arvo++;
        }
    }

    @Override
    public void tyhjenna() {
        super.getKortit().clear();
        arvo = 7;
    }
}
