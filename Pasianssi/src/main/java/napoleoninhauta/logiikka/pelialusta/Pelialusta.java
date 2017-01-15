/**
 * Luokka tarjoaa monia metodeja pinojen ja pakkojen väliseen toiminnallisuuteen.
 */
package napoleoninhauta.logiikka.pelialusta;

import napoleoninhauta.logiikka.pinot.YhdenKortinJemma;
import napoleoninhauta.pakka.Kortti;

public class Pelialusta {

    private Jemmat jemmat;
    private Kulmapinot kulmapinot;
    private PelialustanMuutPinot muut;

    /**
     * Konstruktori alustaa jemmat, kulmapinot ja muut pinot ja pakat.
     */
    public Pelialusta() {
        this.jemmat = new Jemmat();
        this.kulmapinot = new Kulmapinot();
        this.muut = new PelialustanMuutPinot();
    }

    public Jemmat getJemmat() {
        return this.jemmat;
    }

    public Kulmapinot getKulmapinot() {
        return this.kulmapinot;
    }

    public PelialustanMuutPinot getMuut() {
        return this.muut;
    }

    /**
     * Metodi nostaa kortin pelipakasta ja asettaa sen pelipinoon.
     */
    public void nostaKorttiPakasta() {
        if (muut.getPelipakka().getMaara() > 0) {
            Kortti kortti = muut.getPelipakka().nostaKortti();
            muut.getPelipino().asetaKortti(kortti);
        }
    }

    /**
     * Metodi suorittaa toiminnallisuuden pelipinon kortille, jos kyseinen
     * kortti sopii keskelle, kulmiin tai kuutosjemmaan. Kortin arvon ollessa
     * kuusi, ensisijainen pino on keskipino. Metodi käyttää privaatteja
     * apumetodeja kortin laittamiseen.
     *
     */
    public void suoritaPelipino() {
        if (muut.getPelipino().getMaara() > 0) {
            Kortti kortti = muut.getPelipino().otaKortti();
            if (muut.getKeskipino().onkoPeliAvattu() == false) {
                avaaPeli(kortti);
            } else {
                suoritaPelipinonTapaukset(kortti);
            }
        }
    }

    private void avaaPeli(Kortti kortti) {
        if (kortti.getArvo() == 6) {
            muut.getKeskipino().asetaKortti(kortti);
        } else {
            muut.getPelipino().asetaKortti(kortti);
        }
    }

    private void suoritaPelipinonTapaukset(Kortti kortti) {
        if (suoritaPelipinonMuutTapaukset(kortti) == true) {
            muut.getPelipino().asetaKortti(kortti);
        }
    }

    private boolean suoritaPelipinonMuutTapaukset(Kortti kortti) {
        boolean jatkuuko = true;
        jatkuuko = laitaKeskipinoonTaiKuutosjemmaanPelipinosta(kortti);
        if (jatkuuko == false) {
            return false;
        }
        jatkuuko = laitaKulmapinoonPelipinosta(kortti);
        if (jatkuuko == false) {
            return false;
        }
        return laitaJemmaanPelipinosta(kortti);
    }

    private boolean laitaKeskipinoonTaiKuutosjemmaanPelipinosta(Kortti kortti) {
        if (kortti.getArvo() == muut.getKeskipino().getArvo()) {
            muut.getKeskipino().asetaKortti(kortti);
            return false;
        }
        if (kortti.getArvo() == 6) {
            muut.getKuutosJemma().asetaKortti(kortti);
            return false;
        }
        return true;
    }

    private boolean laitaKulmapinoonPelipinosta(Kortti kortti) {
        if (kulmapinot.laitaKorttiSopivaanPinoon(kortti) == true) {
            return false;
        }
        return true;
    }

    private boolean laitaJemmaanPelipinosta(Kortti kortti) {
        if (jemmat.laitaTyhjaanJemmaan(kortti) == false) {
            return true;
        }
        return false;
    }

    /**
     * Metodi kertoo meneeko minkään pinon päällimmäinen kortti mihinkään peliä
     * edistävään pinoon tai jemmaan. Metodi käyttää apunaan yksityisiä
     * apumetodeja. Metodi palauttaa true, jos jäljellä on mahdollisia siirtoja
     * ja false jos ei.
     *
     * @return true tai false
     */
    public boolean meneekoMikaan() {
        if (muut.getKeskipino().onkoPeliAvattu() == true) {
            return meneekoJemmoistaTaiPelipinosta();
        } else if (muut.getPelipino().getYlimmanArvo() != 6) {
            return false;
        }
        return true;
    }

    private boolean meneekoJemmoistaTaiPelipinosta() {
        if (jemmat.onkoKaikkiJemmatTaynna() == true) {
            return meneekoMistaan();
        }
        return true;
    }

    private boolean meneekoMistaan() {
        if (meneekoJemmoista() == false) {
            return meneekoPelipinostaTaiKuutosjemmasta();
        }
        return true;
    }

    private boolean meneekoJemmoista() {
        if (meneekoMinnekkaan(jemmat.getEtela().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getIta().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getPohjoinen().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getLansi().getKortinArvo()) == false) {
            return false;
        }
        return true;
    }

    private boolean meneekoPelipinostaTaiKuutosjemmasta() {
        if (muut.getKuutosJemma().getYlimmanArvo() != muut.getKeskipino().getArvo()
                && meneekoMinnekkaan(muut.getPelipino().getYlimmanArvo()) == false
                && muut.getPelipino().getYlimmanArvo() != 6) {
            return false;
        }
        return true;
    }

    private boolean meneekoMinnekkaan(int arvo) {
        if (!kulmapinot.getArvot().contains(arvo) && muut.getKeskipino().getArvo() != arvo) {
            return false;
        }
        return true;
    }

    /**
     * Metodi alustaa uuden pelin, eli tyhjentaa pinot ja tekee uuden pakan
     * yksityisten apumetodien avulla.
     */
    public void aloitaUusiPeli() {
        muut.getPelipakka().alustaUusiPakka();
        muut.getKeskipino().tyhjenna();
        muut.getPelipino().tyhjenna();
        muut.getKuutosJemma().tyhjenna();
        tyhjennaMuut();
    }

    private void tyhjennaMuut() {
        jemmat.getEtela().tyhjenna();
        jemmat.getIta().tyhjenna();
        jemmat.getLansi().tyhjenna();
        jemmat.getPohjoinen().tyhjenna();
        kulmapinot.getKaakko().tyhjenna();
        kulmapinot.getKoillinen().tyhjenna();
        kulmapinot.getLounas().tyhjenna();
        kulmapinot.getLuode().tyhjenna();
    }

    /**
     * Metodi peruu noston pelipakasta, eli asettaa kortin pelipinosta takaisin
     * pelipakkaan. Metodia voi käyttää vain siihen asti, kun ensimmäinen
     * kuutonen on laitettu keskelle, eli peli on avattu.
     */
    public void peruNosto() {
        if (muut.getPelipakka().getMaara() != 52 && muut.getKeskipino().onkoPeliAvattu() == false) {
            Kortti kortti = muut.getPelipino().otaKortti();
            muut.getPelipakka().asetaKortti(kortti);
        }
    }

    /**
     * Metodi laittaa kuutosjemmasta kuutosen keskipinoon, jos mahdollista.
     */
    public void laitaKuutosjemmasta() {
        if (muut.getKuutosJemma().getMaara() != 0 && muut.getKeskipino().getArvo() == 6) {
            muut.getKeskipino().asetaKortti(muut.getKuutosJemma().otaKortti());
        }
    }

    /**
     * Metodi laittaa kortin parametrina annetusta yhden kortin jemmasta
     * keskelle tai kulmaan, jos mahdollista.
     *
     * @param mikaJemma yhden kortin jemma
     */
    public void suoritaYhdenKortinJemma(YhdenKortinJemma mikaJemma) {
        int kortinArvo = mikaJemma.getKortinArvo();
        if (kortinArvo == muut.getKeskipino().getArvo()) {
            muut.getKeskipino().asetaKortti(mikaJemma.otaKortti());
        }
        if (kulmapinot.getArvot().contains(kortinArvo)) {
            kulmapinot.laitaKorttiSopivaanPinoon(mikaJemma.otaKortti());
        }
    }
}
