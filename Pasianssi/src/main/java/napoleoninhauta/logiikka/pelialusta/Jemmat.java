/**
 * Luokka luo neljä yhden kortin jemmaa pelialustaa varten. Luokka tarjoaa
 * metodeja, jotka koskevat kaikkia jemmoja.
 */
package napoleoninhauta.logiikka.pelialusta;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.logiikka.pinot.YhdenKortinJemma;

public class Jemmat {

    private YhdenKortinJemma lansi;
    private YhdenKortinJemma pohjoinen;
    private YhdenKortinJemma ita;
    private YhdenKortinJemma etela;

    /**
     * Konstruktori alustaa uudet jemmat.
     */
    public Jemmat() {
        lansi = new YhdenKortinJemma();
        pohjoinen = new YhdenKortinJemma();
        ita = new YhdenKortinJemma();
        etela = new YhdenKortinJemma();
    }

    public YhdenKortinJemma getLansi() {
        return lansi;
    }

    public YhdenKortinJemma getPohjoinen() {
        return pohjoinen;
    }

    public YhdenKortinJemma getIta() {
        return ita;
    }

    public YhdenKortinJemma getEtela() {
        return etela;
    }

    /**
     * Metodi palauttaa true, jos kaikkissa jemmoissa on kortti, muulloin false.
     *
     * @return true tai false
     */
    public boolean onkoKaikkiJemmatTaynna() {
        if (lansi.getKortti().equals("tyhja")
                || ita.getKortti().equals("tyhja")
                || etela.getKortti().equals("tyhja")
                || pohjoinen.getKortti().equals("tyhja")) {
            return false;
        }
        return true;
    }

    /**
     * Metodi laittaa parametrina annetun kortin tyhjään jemmaan ja palauttaa
     * true, jos kaikki jemmat eivät ole täynnä. Metodi palauttaa false, jos
     * kaikki jemmat on täynnä.
     *
     * @param kortti pelipinosta otettava kortti
     *
     * @return true tai false
     */
    public boolean laitaTyhjaanJemmaan(Kortti kortti) {
        if (lansi.getKortti().equals("tyhja")) {
            lansi.asetaKortti(kortti);
            return true;
        }
        if (pohjoinen.getKortti().equals("tyhja")) {
            pohjoinen.asetaKortti(kortti);
            return true;
        }
        if (ita.getKortti().equals("tyhja")) {
            ita.asetaKortti(kortti);
            return true;
        }
        if (etela.getKortti().equals("tyhja")) {
            etela.asetaKortti(kortti);
            return true;
        }
        return false;
    }
}
