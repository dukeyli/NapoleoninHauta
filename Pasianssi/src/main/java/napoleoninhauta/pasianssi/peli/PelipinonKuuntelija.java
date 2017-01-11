package napoleoninhauta.pasianssi.peli;

import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PelipinonKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public PelipinonKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.getMuut().getPelipino().palautaYlin().equals("tyhja")) {
            alusta.suoritaPelipino();
            paivittaja.paivita();
        }
    }

}
