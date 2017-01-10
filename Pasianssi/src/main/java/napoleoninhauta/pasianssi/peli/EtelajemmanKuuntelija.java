/**
 *
 */
package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class EtelajemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public EtelajemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaJemmat().palautaEtela().palautaKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    public void suorita() {
        int kortinArvo = alusta.palautaJemmat().palautaEtela().palautaKortinArvo();
        if (kortinArvo == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(alusta.palautaJemmat().palautaEtela().otaKortti());
        }
        if (alusta.palautaKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(alusta.palautaJemmat().palautaEtela().otaKortti());
        }
    }
}
