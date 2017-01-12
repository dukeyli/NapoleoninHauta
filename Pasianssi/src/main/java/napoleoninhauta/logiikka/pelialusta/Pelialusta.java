/**
 * Luokka tarjoaa monia metodeja pinojen ja pakkojen väliseen toiminnallisuuteen.
 */
package napoleoninhauta.logiikka.pelialusta;

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
        Kortti kortti = muut.getPelipakka().nostaKortti();
        muut.getPelipino().asetaKortti(kortti);
    }

    /**
     * Metodi suorittaa toiminnallisuuden pelipinon kortille, jos kyseinen
     * kortti sopii keskelle, kulmiin tai kuutosjemmaan. Kortin arvon ollessa
     * kuusi, ensisijainen pino on keskipino. Metodi käyttää privaatteja
     * apumetodeja kortin laittamiseen.
     *
     */
    public void suoritaPelipino() {
        Kortti kortti = muut.getPelipino().otaKortti();
        if (muut.getKeskipino().onkoPeliAvattu() == false) {
            avaaPeli(kortti);
        } else {
            suoritaPelipinonTapaukset(kortti);
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
     * edistävään pinoon. Metodi käyttää apunaan yksityisiä apumetodeja. Metodi
     * palauttaa true, jos jäljellä on mahdollisia siirtoja ja false jos ei.
     *
     * @return true tai false
     */
    public boolean meneekoMikaan() {
        int arvo = muut.getPelipino().getYlimmanArvo();
        if (arvo == 6) {
            return true;
        }
        if (meneekoMinnekkaan(arvo) == false) {
            return meneekoJemmat();
        }
        return true;
    }

    private boolean meneekoMinnekkaan(int arvo) {
        if (arvo == 0) {
            return true;
        }
        if (!kulmapinot.palautaArvot().contains(arvo) && muut.getKeskipino().getArvo() != arvo) {
            return false;
        }
        return true;
    }

    private boolean meneekoJemmat() {
        if (meneekoMinnekkaan(jemmat.getEtela().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getIta().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getPohjoinen().getKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.getLansi().getKortinArvo()) == false) {
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
}
