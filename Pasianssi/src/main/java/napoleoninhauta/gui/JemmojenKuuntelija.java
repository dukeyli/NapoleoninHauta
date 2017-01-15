/**
 * Luokka, joka kuuntelee pelialustan yhden kortin jemmoja ja suorittaa
 * näiden toiminnallisuuden.
 */
package napoleoninhauta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class JemmojenKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JButton ejemma, ijemma, pjemma, ljemma;

    /**
     * Konstruktori määrittää attribuutit parametreina annetuiksi olioksi.
     *
     * @param pelialusta pelialusta, jossa toiminallisuus tapahtuu
     * @param paivittaja päivittäjä, joka päivittää ulkoasun kuvat
     * @param ijemma itäjemman nappulla
     * @param ejemma eteläjemman nappula
     * @param pjemma pohjoisjemman nappula
     * @param ljemma länsijemman nappula
     */
    public JemmojenKuuntelija(Pelialusta pelialusta, Paivittaja paivittaja,
            JButton ijemma, JButton ejemma, JButton pjemma, JButton ljemma) {
        this.alusta = pelialusta;
        this.paivittaja = paivittaja;
        this.ijemma = ijemma;
        this.ejemma = ejemma;
        this.pjemma = pjemma;
        this.ljemma = ljemma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ijemma && !alusta.getJemmat().getIta().getKortti().equals("tyhja")) {
            alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getIta());
        } else if (e.getSource() == ejemma && !alusta.getJemmat().getEtela().getKortti().equals("tyhja")) {
            alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getEtela());
        } else if (e.getSource() == pjemma && !alusta.getJemmat().getPohjoinen().getKortti().equals("tyhja")) {
            alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getPohjoinen());
        } else if (e.getSource() == ljemma && !alusta.getJemmat().getLansi().getKortti().equals("tyhja")) {
            alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getLansi());
        }
        paivittaja.paivita();
    }

}
