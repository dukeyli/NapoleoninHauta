package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelialusta {

    private Jemmat jemmat;
    private Kulmapinot kulmapinot;
    private PelialustanMuutPinot muut;

    public Pelialusta() {
        this.jemmat = new Jemmat();
        this.kulmapinot = new Kulmapinot();
        this.muut = new PelialustanMuutPinot();
    }

    public Jemmat palautaJemmat() {
        return this.jemmat;
    }

    public Kulmapinot palautaKulmapinot() {
        return this.kulmapinot;
    }

    public PelialustanMuutPinot palautaMuut() {
        return this.muut;
    }

    public void nostaKorttiPakasta() {
        Kortti kortti = muut.palautaPelipakka().nostaKortti();
        muut.palautaPelipino().asetaKortti(kortti);
    }

    public boolean suoritaPelipino(Kortti kortti) {
        if (muut.palautaKeskipino().onkoPeliAvattu() == false) {
            if (kortti.palautaArvo() == 6) {
                muut.palautaKeskipino().asetaKortti(kortti);
                return true;
            }
        } else if (suoritaPelipinonMuutTapaukset(kortti) == false) {
            return true;
        }
        return false;
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
        if (kortti.palautaArvo() == muut.palautaKeskipino().palautaArvo()) {
            muut.palautaKeskipino().asetaKortti(kortti);
            return false;
        }
        if (kortti.palautaArvo() == 6) {
            muut.palautaKuutosJemma().asetaKortti(kortti);
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

    public boolean meneekoMikaan() {
        if (meneekoMinnekkaan(muut.palautaPelipino().palautaYlimmanArvo()) == false) {
            return meneekoJemmat();
        }
        return true;
    }

    private boolean meneekoMinnekkaan(int arvo) {
        if (arvo == 0) {
            return false;
        }
        if (!kulmapinot.palautaArvot().contains(arvo) && muut.palautaKeskipino().palautaArvo() != arvo) {
            return false;
        }
        return true;
    }

    private boolean meneekoJemmat() {
        if (meneekoMinnekkaan(jemmat.palautaEtela().palautaKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.palautaIta().palautaKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.palautaPohjoinen().palautaKortinArvo()) == false
                && meneekoMinnekkaan(jemmat.palautaLansi().palautaKortinArvo()) == false) {
            return false;
        }
        return true;
    }

    public void aloitaUusiPeli() {
        muut.palautaPelipakka().alustaUusiPakka();
        muut.palautaKeskipino().tyhjenna();
        muut.palautaPelipino().tyhjenna();
        muut.palautaKuutosJemma().tyhjenna();
        tyhjennaMuut();
    }

    private void tyhjennaMuut() {
        jemmat.palautaEtela().tyhjenna();
        jemmat.palautaIta().tyhjenna();
        jemmat.palautaLansi().tyhjenna();
        jemmat.palautaPohjoinen().tyhjenna();
        kulmapinot.palautaKaakko().tyhjenna();
        kulmapinot.palautaKoillinen().tyhjenna();
        kulmapinot.palautaLounas().tyhjenna();
        kulmapinot.palautaLuode().tyhjenna();
    }
}
