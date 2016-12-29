package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class YhdenKortinJemma {

    private Kortti paikka;

    public YhdenKortinJemma() {
    }

    public void asetaKortti(Kortti kortti) {
        if (paikka == null) {
            this.paikka = kortti;
        }
    }

    public Kortti otaKortti() {
        if (paikka != null) {
            Kortti kortti = paikka;
            paikka = null;
            return kortti;
        }
        return null;
    }

    public Kortti palautaKortti() {
        return this.paikka;
    }

}
