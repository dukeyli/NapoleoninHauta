package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pinot.Kulmapino;

public class Kulmapinot {

    private Kulmapino luode;
    private Kulmapino koillinen;
    private Kulmapino kaakko;
    private Kulmapino lounas;

    public Kulmapinot() {
        luode = new Kulmapino();
        koillinen = new Kulmapino();
        kaakko = new Kulmapino();
        lounas = new Kulmapino();
    }

    public Kulmapino palautaLuode() {
        return luode;
    }

    public Kulmapino palautaKoillinen() {
        return koillinen;
    }

    public Kulmapino palautaKaakko() {
        return kaakko;
    }

    public Kulmapino palautalounas() {
        return lounas;
    }

    public boolean laitaKorttiSopivaanPinoon(Kortti kortti) {
        if (luode.palautaArvo() == kortti.palautaArvo()) {
            luode.asetaKortti(kortti);
            return true;
        }
        if (koillinen.palautaArvo() == kortti.palautaArvo()) {
            koillinen.asetaKortti(kortti);
            return true;
        }
        if (kaakko.palautaArvo() == kortti.palautaArvo()) {
            kaakko.asetaKortti(kortti);
            return true;
        }
        if (lounas.palautaArvo() == kortti.palautaArvo()) {
            lounas.asetaKortti(kortti);
            return true;
        }
        return false;
    }

}
