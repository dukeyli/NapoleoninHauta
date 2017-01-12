/**
 * Pinon perivä luokka, joka määrittelee pinon, johon voidaan laittaa ja josta voidaan
 * ottaa kortteja.
 */
package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;

public class Pelipino extends Pino {

    /**
     * Metodi laittaa parametrina annetun kortin pinoon päällimmäiseksi.
     *
     * @param kortti pinosta, pakasta tai jemmasta otettava kortti.
     *
     */
    @Override
    public void asetaKortti(Kortti kortti) {
        super.getKortit().add(0, kortti);
    }

    /**
     * Metodi palauttaa pinon päällimmäisen kortin ja poistaa sen pinosta, jos
     * pino ei ole tyhjä. Muulloin metodi ei tee muuta kuin palauttaa null.
     *
     * @return päällimmäinen kortti tai null
     */
    public Kortti otaKortti() {
        if (!super.getKortit().isEmpty()) {
            Kortti lappu = super.getKortit().get(0);
            super.getKortit().remove(0);
            return lappu;
        }
        return null;
    }

    @Override
    public void tyhjenna() {
        super.getKortit().clear();
    }

}
