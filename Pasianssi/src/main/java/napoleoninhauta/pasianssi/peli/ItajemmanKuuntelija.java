/**
 *
 */
package napoleoninhauta.pasianssi.peli;

import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class ItajemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public ItajemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaJemmat().palautaIta().palautaKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    private void suorita() {
        int kortinArvo = alusta.palautaJemmat().palautaIta().palautaKortinArvo();
        if (kortinArvo == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(alusta.palautaJemmat().palautaIta().otaKortti());
        }
        if (alusta.palautaKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(alusta.palautaJemmat().palautaIta().otaKortti());
        }
    }
}
