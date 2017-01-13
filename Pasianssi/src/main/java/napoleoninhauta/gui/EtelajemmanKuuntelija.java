/**
 *
 */
package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class EtelajemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public EtelajemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.getJemmat().getEtela().getKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    public void suorita() {
        int kortinArvo = alusta.getJemmat().getEtela().getKortinArvo();
        if (kortinArvo == alusta.getMuut().getKeskipino().getArvo()) {
            alusta.getMuut().getKeskipino().asetaKortti(alusta.getJemmat().getEtela().otaKortti());
        }
        if (alusta.getKulmapinot().getArvot().contains(kortinArvo)) {
            alusta.getKulmapinot().laitaKorttiSopivaanPinoon(alusta.getJemmat().getEtela().otaKortti());
        }
    }
}
