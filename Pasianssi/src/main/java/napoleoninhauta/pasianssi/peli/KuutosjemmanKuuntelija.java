package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class KuutosjemmanKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public KuutosjemmanKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (alusta.palautaMuut().palautaKuutosJemma().palautaMaara() != 0
                && alusta.palautaMuut().palautaKeskipino().palautaArvo() == 6) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(alusta.palautaMuut().palautaKuutosJemma().otaKortti());
        }
    }
}
