package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class AloitusNapinKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JButton tulos;

    public AloitusNapinKuuntelija(Pelialusta alusta, Paivittaja paivittaja, JButton tulos) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
        this.tulos = tulos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alusta.aloitaUusiPeli();
        paivittaja.paivita();
        tulos.setText("");
        paivittaja.asetaPakanKuva();
    }

}
