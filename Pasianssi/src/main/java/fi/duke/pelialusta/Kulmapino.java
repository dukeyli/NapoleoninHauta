package fi.duke.pelialusta;

import fi.duke.pakka.Kortti;

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
