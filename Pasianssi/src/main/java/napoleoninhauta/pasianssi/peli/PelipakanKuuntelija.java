package napoleoninhauta.pasianssi.peli;

import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PelipakanKuuntelija implements ActionListener {

    private Paivittaja paivittaja;
    private Pelialusta pelialusta;

    public PelipakanKuuntelija(Pelialusta alusta, Paivittaja paivittaja) {
        this.pelialusta = alusta;
        this.paivittaja = paivittaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pelialusta.getMuut().getPelipakka().palautaMaara() > 0) {
            pelialusta.nostaKorttiPakasta();
            paivittaja.paivita();
        }
    }

}
