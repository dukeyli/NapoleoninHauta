package napoleoninhauta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;
import napoleoninhauta.pakka.Kortti;

public class PakanPinonJaKuutosJemmanKuuntelija implements ActionListener {

    private Paivittaja paivittaja;
    private Pelialusta alusta;
    private JButton pakka, pelipino, kuutosjemma, peru;

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
