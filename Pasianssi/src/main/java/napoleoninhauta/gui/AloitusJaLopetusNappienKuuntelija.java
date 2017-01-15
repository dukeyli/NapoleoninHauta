/**
 * Luokka kuuntelee aloitus- ja lopetus -nappuloita ja suorittaa
 * näiden toiminnallisuuden.
 */
package napoleoninhauta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class AloitusJaLopetusNappienKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JButton aloitus, lopetus;

    /**
     * Konstruktori määrittää attribuutit parametreina annetuiksi olioksi.
     * 
     * @param alusta pelialusta, jossa toiminnallisuus tapahtuu
     * @param paivittaja päivittäjä, joka päivittää kuvat
     * @param aloitus aloitus-nappula
     * @param lopetus lopetus-nappula
     */
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
