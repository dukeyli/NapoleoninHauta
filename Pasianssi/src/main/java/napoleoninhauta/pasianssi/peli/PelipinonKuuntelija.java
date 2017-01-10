package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PelipinonKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public PelipinonKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaMuut().palautaPelipino().palautaYlin().equals("tyhja")) {
            Kortti kortti = alusta.palautaMuut().palautaPelipino().otaKortti();
            boolean meniko = suorita(kortti);
            if (meniko == false) {
                alusta.palautaMuut().palautaPelipino().asetaKortti(kortti);
            }
            paivittaja.paivita();
        }
    }

    public boolean suorita(Kortti kortti) {
        if (alusta.palautaMuut().palautaKeskipino().onkoPeliAvattu() == false) {
            if (kortti.palautaArvo() == 6) {
                alusta.palautaMuut().palautaKeskipino().asetaKortti(kortti);
                return true;
            }
        } else if (suoritaMuutTapaukset(kortti) == false) {
            return true;
        }
        return false;
    }

    public boolean suoritaMuutTapaukset(Kortti kortti) {
        boolean jatkuuko = true;
        jatkuuko = laitaKeskipinoonTaiKuutosjemmaan(kortti);
        if (jatkuuko == false) {
            return false;
        }
        jatkuuko = laitaKulmapinoon(kortti);
        if (jatkuuko == false) {
            return false;
        }
        boolean palautusarvo = laitaJemmaan(kortti);
        return palautusarvo;
    }

    public boolean laitaKeskipinoonTaiKuutosjemmaan(Kortti kortti) {
        if (kortti.palautaArvo() == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(kortti);
            return false;
        }
        if (kortti.palautaArvo() == 6) {
            alusta.palautaMuut().palautaKuutosJemma().asetaKortti(kortti);
            return false;
        }
        return true;
    }

    public boolean laitaKulmapinoon(Kortti kortti) {
        boolean meneeko = alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(kortti);
        if (meneeko == true) {
            return false;
        }
        return true;
    }

    public boolean laitaJemmaan(Kortti kortti) {
        boolean meneeko = alusta.palautaJemmat().laitaTyhjaanJemmaan(kortti);
        if (meneeko == false) {
            return true;
        }
        return false;
    }

}
