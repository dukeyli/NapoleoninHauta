package napoleoninhauta.pasianssi.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelipino extends Pino {

    private ArrayList<Kortti> kortit;

    public Pelipino() {
        this.kortit = new ArrayList();
    }

    @Override
    public void asetaKortti(Kortti kortti) {
        super.palautaKortit().add(0, kortti);
    }

    public Kortti otaKortti() {
        if (!kortit.isEmpty()) {
            Kortti lappu = super.palautaKortit().get(0);
            super.palautaKortit().remove(0);
            return lappu;
        }
        return null;
    }
}
