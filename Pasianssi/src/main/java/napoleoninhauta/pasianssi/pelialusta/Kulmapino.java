
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pelialusta.Pino;

public class Kulmapino extends Pino {
    
    private int arvo;

    public Kulmapino() {
        this.arvo = 7;
    }

    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.getArvo() == arvo) {
            super.palautaKortit().add(0, kortti);
            arvo++;
        }
    }
    
    
    
}
