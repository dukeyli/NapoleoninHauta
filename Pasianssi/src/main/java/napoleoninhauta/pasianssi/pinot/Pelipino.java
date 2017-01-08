/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa ja josta voidaan
 * ottaa kortteja.
 */
package napoleoninhauta.pasianssi.pinot;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelipino extends Pino {

    public Pelipino() {
    }

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päällimmäiseksi, jos
     * pinossa ei ole jo kyseistä korttia.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    @Override
    public void asetaKortti(Kortti kortti) {
        if (!super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
        }
    }

    /**
     * Metodi palauttaa pinon päällimmäisen kortin ja poistaa sen pinosta, jos
     * pino ei ole tyhjä. Muulloin metodi ei tee muuta kuin palauttaa null.
     *
     * @return päällimmäinen kortti tai null
     */
    public Kortti otaKortti() {
        if (!super.palautaKortit().isEmpty()) {
            Kortti lappu = super.palautaKortit().get(0);
            super.palautaKortit().remove(0);
            return lappu;
        }
        return null;
    }
}
