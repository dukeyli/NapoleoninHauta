package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PelipakanKuuntelija implements ActionListener {

    private JButton pino;
    private Pelialusta pelialusta;

    public PelipakanKuuntelija(Pelialusta alusta, JButton pelipino) {
        this.pelialusta=alusta;
        this.pino=pelipino;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pelialusta.nostaKorttiPakasta();
        pino.setText(pelialusta.palautaMuut().palautaPelipino().palautaYlin());
    }

}
