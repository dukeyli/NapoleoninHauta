/**
 * Luokka luo neljä yhden kortin jemmaa pelialustaa varten. Luokka tarjoaa
 * metodeja, jotka koskevat kaikkia jemmoja.
 */
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pinot.YhdenKortinJemma;

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
        if (lansi.palautaKortti().equals("tyhja")
                || ita.palautaKortti().equals("tyhja")
                || etela.palautaKortti().equals("tyhja")
                || pohjoinen.palautaKortti().equals("tyhja")) {
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
        if (lansi.palautaKortti().equals("tyhja")) {
            lansi.asetaKortti(kortti);
            return true;
        }
        if (pohjoinen.palautaKortti().equals("tyhja")) {
            pohjoinen.asetaKortti(kortti);
            return true;
        }
        if (ita.palautaKortti().equals("tyhja")) {
            ita.asetaKortti(kortti);
            return true;
        }
        if (etela.palautaKortti().equals("tyhja")) {
            etela.asetaKortti(kortti);
            return true;
        }
        return false;
    }
}
