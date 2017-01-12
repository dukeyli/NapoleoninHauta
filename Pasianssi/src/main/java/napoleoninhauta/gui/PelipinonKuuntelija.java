package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class PelipinonKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public PelipinonKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.getMuut().getPelipino().getYlin().equals("tyhja")) {
            alusta.suoritaPelipino();
            paivittaja.paivita();
        }
    }

}
