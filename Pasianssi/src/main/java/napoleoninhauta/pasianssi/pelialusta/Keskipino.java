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
    
    public int palautaArvo() {
        return this.arvo;
    }

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
