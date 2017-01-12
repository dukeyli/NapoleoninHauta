package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class KuutosjemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public KuutosjemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (alusta.getMuut().getKuutosJemma().palautaMaara() != 0
                && alusta.getMuut().getKeskipino().palautaArvo() == 6) {
            alusta.getMuut().getKeskipino().asetaKortti(alusta.getMuut().getKuutosJemma().otaKortti());
            paivittaja.paivita();
        }
    }
}
