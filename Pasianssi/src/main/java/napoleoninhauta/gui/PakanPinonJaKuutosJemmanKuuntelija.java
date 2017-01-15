/**
 * Luokka kuuntelee pelipakka-, pelipino-, kuutosjemma- ja peru-näppäimiä ja
 * suorittaa näiden toiminnallisuuksia.
 */
package napoleoninhauta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class PakanPinonJaKuutosJemmanKuuntelija implements ActionListener {

    private Paivittaja paivittaja;
    private Pelialusta alusta;
    private JButton pakka, pelipino, kuutosjemma, peru;

    /**
     * Konstruktori määrittää attribuutit parametreina annetuiksi olioksi.
     * 
     * @param alusta pelialusta, jossa toiminnallisuus toteutetaan
     * @param paivittaja päivättäjä, joka päivittää ulkoasun kuvat
     * @param pakka näppäin, jossa on pelipakka
     * @param pino näppäin, jossa on pelipino
     * @param kjemma näppäin, jossa on kuutosjemma
     * @param peru näppäin, jossa on peru nosto -toiminnallisuus
     */
    public PakanPinonJaKuutosJemmanKuuntelija(Pelialusta alusta, Paivittaja paivittaja,
            JButton pakka, JButton pino, JButton kjemma, JButton peru) {
        this.alusta = alusta;
        this.paivittaja = paivittaja;
        this.pakka = pakka;
        this.pelipino = pino;
        this.kuutosjemma = kjemma;
        this.peru = peru;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pakka) {
            alusta.nostaKorttiPakasta();
        } else if (e.getSource() == pelipino) {
            alusta.suoritaPelipino();
        } else if (e.getSource() == kuutosjemma) {
            alusta.laitaKuutosjemmasta();
        } else if (e.getSource() == peru) {
            alusta.peruNosto();
        }
        paivittaja.paivita();
    }

}
