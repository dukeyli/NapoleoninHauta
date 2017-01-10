/**
 *
 */
package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class LansijemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public LansijemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaJemmat().palautaLansi().palautaKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    public void suorita() {
        int kortinArvo = alusta.palautaJemmat().palautaLansi().palautaKortinArvo();
        if (kortinArvo == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(alusta.palautaJemmat().palautaLansi().otaKortti());
        }
        if (alusta.palautaKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(alusta.palautaJemmat().palautaLansi().otaKortti());
        }
    }
}