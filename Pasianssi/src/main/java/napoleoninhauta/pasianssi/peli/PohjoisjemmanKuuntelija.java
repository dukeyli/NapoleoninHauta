/**
 *
 */
package napoleoninhauta.pasianssi.peli;

import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PohjoisjemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public PohjoisjemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaJemmat().palautaPohjoinen().palautaKortti().equals("tyhja")) {
            suorita();
            paivittaja.paivita();
        }
    }

    public void suorita() {
        int kortinArvo = alusta.palautaJemmat().palautaPohjoinen().palautaKortinArvo();
        if (kortinArvo == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(alusta.palautaJemmat().palautaPohjoinen().otaKortti());
        }
        if (alusta.palautaKulmapinot().palautaArvot().contains(kortinArvo)) {
            alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(alusta.palautaJemmat().palautaPohjoinen().otaKortti());
        }
    }
}
