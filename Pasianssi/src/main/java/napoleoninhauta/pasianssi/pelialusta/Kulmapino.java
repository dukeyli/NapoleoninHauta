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

    public int palautaArvo() {
        return this.arvo;
    }

    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.palautaArvo() == arvo && !super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
            arvo++;
        }
    }
}
