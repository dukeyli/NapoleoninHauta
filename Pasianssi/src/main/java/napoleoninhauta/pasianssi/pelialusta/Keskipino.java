package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Keskipino extends Pino{
    
    private int arvo;
    
    public Keskipino() {
        this.arvo = 6;
    }
    
    @Override
    public void asetaKortti(Kortti kortti) {
        if (kortti.getArvo() == arvo) {
            super.palautaKortit().add(0, kortti);
            arvo--;
        }
        if (this.arvo == 0) {
            this.arvo = 6;
        }
    }
}
