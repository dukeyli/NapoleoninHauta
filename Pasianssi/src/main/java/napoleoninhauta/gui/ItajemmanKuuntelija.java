/**
 *
 */
package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class ItajemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public ItajemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.getJemmat().getIta().palautaKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    private void suorita() {
        int kortinArvo = alusta.getJemmat().getIta().palautaKortinArvo();
        if (kortinArvo == alusta.getMuut().getKeskipino().palautaArvo()) {
            alusta.getMuut().getKeskipino().asetaKortti(alusta.getJemmat().getIta().otaKortti());
        }
        if (alusta.getKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.getKulmapinot().laitaKorttiSopivaanPinoon(alusta.getJemmat().getIta().otaKortti());
        }
    }
}
