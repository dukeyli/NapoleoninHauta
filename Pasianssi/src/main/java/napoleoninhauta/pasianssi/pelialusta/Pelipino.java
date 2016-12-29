package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelipino extends Pino {

    public Pelipino() {
    }

    @Override
    public void asetaKortti(Kortti kortti) {
        if (!super.palautaKortit().contains(kortti)) {
            super.palautaKortit().add(0, kortti);
        }
    }

    public Kortti otaKortti() {
        if (!super.palautaKortit().isEmpty()) {
            Kortti lappu = super.palautaKortit().get(0);
            super.palautaKortit().remove(0);
            return lappu;
        }
        return null;
    }
}
