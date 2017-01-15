/**
 * Käyttöliittymäluokka, jossa luodaan komponentit ulkoasulle.
 */
package napoleoninhauta.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import napoleoninhauta.logiikka.pelialusta.Pelialusta;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelialusta pelialusta;

    /**
     * Konstruktori alustaa pelialustan.
     */
    public Kayttoliittyma() {
        this.pelialusta = new Pelialusta();
    }

    @Override
    public void run() {
        frame = new JFrame("Napoleonin hauta");
        frame.setPreferredSize(new Dimension(833, 726));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 5);
        container.setLayout(layout);

        JButton ppakka = new JButton();
        ppakka.setEnabled(false);
        JButton ppino = new JButton();
        JButton kjemma = new JButton();
        JButton kpino = new JButton();
        JButton pjemma = new JButton();
        JButton ljemma = new JButton();
        JButton ijemma = new JButton();
        JButton ejemma = new JButton();
        JButton koillinen = new JButton();
        JButton kaakko = new JButton();
        JButton lounas = new JButton();
        JButton luode = new JButton();
        JButton lopeta = new JButton("Lopeta");
        JButton aloitusNappi = new JButton("Aloita uusi peli");
        JButton peru = new JButton();

        Paivittaja paivittaja = new Paivittaja(pelialusta, ppakka, ppino, kjemma, ljemma,
                pjemma, ijemma, ejemma, luode, koillinen, kaakko, lounas, kpino,
                lopeta, peru);

        PakanPinonJaKuutosJemmanKuuntelija muidenK = new PakanPinonJaKuutosJemmanKuuntelija(pelialusta, paivittaja, ppakka, ppino, kjemma, peru);
        ppakka.addActionListener(muidenK);
        ppino.addActionListener(muidenK);
        kjemma.addActionListener(muidenK);
        peru.addActionListener(muidenK);

        JemmojenKuuntelija jemmK = new JemmojenKuuntelija(pelialusta, paivittaja, ijemma, ejemma, pjemma, ljemma);
        ijemma.addActionListener(jemmK);
        ljemma.addActionListener(jemmK);
        pjemma.addActionListener(jemmK);
        ejemma.addActionListener(jemmK);

        AloitusJaLopetusNappienKuuntelija aljalop = new AloitusJaLopetusNappienKuuntelija(pelialusta, paivittaja, aloitusNappi, lopeta);
        aloitusNappi.addActionListener(aljalop);
        lopeta.addActionListener(aljalop);

        container.add(aloitusNappi);
        container.add(luode);
        container.add(pjemma);
        container.add(koillinen);
        container.add(ppakka);
        container.add(peru);
        container.add(ljemma);
        container.add(kpino);
        container.add(ijemma);
        container.add(ppino);
        container.add(lopeta);
        container.add(lounas);
        container.add(ejemma);
        container.add(kaakko);
        container.add(kjemma);

    }

    public JFrame getFrame() {
        return frame;
    }
}
