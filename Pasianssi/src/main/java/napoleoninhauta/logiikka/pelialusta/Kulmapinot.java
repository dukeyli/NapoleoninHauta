/**
 * Luokka luo neljä kulmapinoa pelialustaa varten.
 * Lisäksi luokka tarjoaa metodeja kaikkien kulmapinojen käsittelyyn.
 */
package napoleoninhauta.logiikka.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.logiikka.pinot.Kulmapino;

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
     * @return true tai false
     */
    public boolean laitaKorttiSopivaanPinoon(Kortti kortti) {
        if (luode.getArvo() == kortti.getArvo()) {
            luode.asetaKortti(kortti);
            return true;
        }
        if (koillinen.getArvo() == kortti.getArvo()) {
            koillinen.asetaKortti(kortti);
            return true;
        }
        if (kaakko.getArvo() == kortti.getArvo()) {
            kaakko.asetaKortti(kortti);
            return true;
        }
        if (lounas.getArvo() == kortti.getArvo()) {
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
        lista.add(luode.getArvo());
        lista.add(koillinen.getArvo());
        lista.add(kaakko.getArvo());
        lista.add(lounas.getArvo());
        return lista;
    }

    /**
     * Metodi palauttaa true, jos kaikissa kulmapinoissa on kortit 7-13.
     *
     * @return true tai false
     */
    public boolean kaikkiLapi() {
        if (luode.getArvo() == 14 && koillinen.getArvo() == 14
                && kaakko.getArvo() == 14 && lounas.getArvo() == 14) {
            return true;
        }
        return false;
    }

}
