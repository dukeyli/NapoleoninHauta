package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PeruNapinKuuntelija implements ActionListener {

    private Paivittaja paivittaja;
    private Pelialusta pelialusta;

    public PeruNapinKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.pelialusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pelialusta.getMuut().getPelipakka().palautaMaara() != 52
                && pelialusta.getMuut().getKeskipino().onkoPeliAvattu() == false) {
            Kortti kortti = pelialusta.getMuut().getPelipino().otaKortti();
            pelialusta.getMuut().getPelipakka().asetaKortti(kortti);
            paivittaja.paivita();
        }
    }

}
