/**
 *
 */
package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class LansijemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public LansijemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.getJemmat().getLansi().getKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    public void suorita() {
        int kortinArvo = alusta.getJemmat().getLansi().getKortinArvo();
        if (kortinArvo == alusta.getMuut().getKeskipino().getArvo()) {
            alusta.getMuut().getKeskipino().asetaKortti(alusta.getJemmat().getLansi().otaKortti());
        }
        if (alusta.getKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.getKulmapinot().laitaKorttiSopivaanPinoon(alusta.getJemmat().getLansi().otaKortti());
        }
    }
}
