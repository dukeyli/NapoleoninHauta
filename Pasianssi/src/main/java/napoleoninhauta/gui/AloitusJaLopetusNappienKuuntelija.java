package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class AloitusJaLopetusNappienKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JButton aloitus, lopetus;

    public AloitusJaLopetusNappienKuuntelija(Pelialusta alusta, Paivittaja paivittaja,
            JButton aloitus, JButton lopetus) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
        this.aloitus = aloitus;
        this.lopetus = lopetus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aloitus) {
            alusta.aloitaUusiPeli();
            paivittaja.paivitaAloitus();
        } else if (e.getSource() == lopetus) {
            System.exit(0);
        }
    }

}
