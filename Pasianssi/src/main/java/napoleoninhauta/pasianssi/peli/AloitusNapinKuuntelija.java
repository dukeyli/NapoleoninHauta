package napoleoninhauta.pasianssi.peli;

import napoleoninhauta.pasianssi.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class AloitusNapinKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JLabel tulos;

    public AloitusNapinKuuntelija(Pelialusta alusta, Paivittaja paivittaja, JLabel tulos) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
        this.tulos = tulos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alusta.aloitaUusiPeli();
        paivittaja.paivita();
        tulos.setText("");
    }

}
