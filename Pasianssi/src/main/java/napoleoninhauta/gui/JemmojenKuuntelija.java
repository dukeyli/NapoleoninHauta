/**
 *
 */
package napoleoninhauta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;
import napoleoninhauta.logiikka.pinot.YhdenKortinJemma;

public class JemmojenKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private Paivittaja paivittaja;
    private JButton ejemma, ijemma, pjemma, ljemma;

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
            suorita(alusta.getJemmat().getIta());
        } else if (e.getSource() == ejemma && !alusta.getJemmat().getEtela().getKortti().equals("tyhja")) {
            suorita(alusta.getJemmat().getEtela());
        } else if (e.getSource() == pjemma && !alusta.getJemmat().getPohjoinen().getKortti().equals("tyhja")) {
            suorita(alusta.getJemmat().getPohjoinen());
        } else if (e.getSource() == ljemma && !alusta.getJemmat().getLansi().getKortti().equals("tyhja")) {
            suorita(alusta.getJemmat().getLansi());
        }
        paivittaja.paivita();
    }

    private void suorita(YhdenKortinJemma mikaJemma) {
        int kortinArvo = mikaJemma.getKortinArvo();
        if (kortinArvo == alusta.getMuut().getKeskipino().getArvo()) {
            alusta.getMuut().getKeskipino().asetaKortti(mikaJemma.otaKortti());
        }
        if (alusta.getKulmapinot().getArvot().contains(kortinArvo)) {
            alusta.getKulmapinot().laitaKorttiSopivaanPinoon(mikaJemma.otaKortti());
        }
    }
}
