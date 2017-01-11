/**
 * Luokka luo neljä kulmapinoa pelialustaa varten.
 * Lisäksi luokka tarjoaa metodeja kaikkien kulmapinojen käsittelyyn.
 */
package napoleoninhauta.pasianssi.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pinot.Kulmapino;

public class Kulmapinot {

    private Kulmapino luode;
    private Kulmapino koillinen;
    private Kulmapino kaakko;
    private Kulmapino lounas;

    /**
     * Konstruktori alustaa uudet kulmapinot.
     */
    public Kulmapinot() {
        luode = new Kulmapino();
        koillinen = new Kulmapino();
        kaakko = new Kulmapino();
        lounas = new Kulmapino();
    }

    public Kulmapino getLuode() {
        return luode;
    }

    public Kulmapino getKoillinen() {
        return koillinen;
    }

    public Kulmapino getKaakko() {
        return kaakko;
    }

    public Kulmapino getLounas() {
        return lounas;
    }

    /**
     * Laittaa parametrina annetun kortin sopivaan vapaaseen kulmapinoon ja
     * palauttaa true, jos kortti sopii johonkin kulmapinoista. Jos kortti ei
     * mene mihinkään pinoista, metodi palauttaa false.
     *
     * @param kortti pelipinosta tai jemmoista otettu kortti
     * @return
     */
    public boolean laitaKorttiSopivaanPinoon(Kortti kortti) {
        if (luode.palautaArvo() == kortti.getArvo()) {
            luode.asetaKortti(kortti);
            return true;
        }
        if (koillinen.palautaArvo() == kortti.getArvo()) {
            koillinen.asetaKortti(kortti);
            return true;
        }
        if (kaakko.palautaArvo() == kortti.getArvo()) {
            kaakko.asetaKortti(kortti);
            return true;
        }
        if (lounas.palautaArvo() == kortti.getArvo()) {
            lounas.asetaKortti(kortti);
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa listan kulmapinojen arvoista.
     *
     * @return ArrayList kulmapinojen arvoista
     */
    public ArrayList<Integer> palautaArvot() {
        ArrayList<Integer> lista = new ArrayList();
        lista.add(luode.palautaArvo());
        lista.add(koillinen.palautaArvo());
        lista.add(kaakko.palautaArvo());
        lista.add(lounas.palautaArvo());
        return lista;
    }

    /**
     * Metodi palauttaa true, jos kaikissa kulmapinoissa on kortit 7-13.
     *
     * @return true tai false
     */
    public boolean kaikkiLapi() {
        if (luode.palautaArvo() == 14 && koillinen.palautaArvo() == 14
                && kaakko.palautaArvo() == 14 && lounas.palautaArvo() == 14) {
            return true;
        }
        return false;
    }

}
