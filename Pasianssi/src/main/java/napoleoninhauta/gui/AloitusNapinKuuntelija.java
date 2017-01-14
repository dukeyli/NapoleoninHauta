package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class AloitusNapinKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;

    public AloitusNapinKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alusta.aloitaUusiPeli();
        paivittaja.paivitaAloitus();
    }

}
