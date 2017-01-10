package napoleoninhauta.pasianssi.peli;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelialusta pelialusta;

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

        JButton ppakka = new JButton(new ImageIcon(new ImageIcon("Images/pakka.jpg").getImage().getScaledInstance(164, 232, Image.SCALE_DEFAULT)));
        JButton ppino = new JButton();
        JButton kjemma = new JButton();
        JLabel kpino = new JLabel("keskipino");
        JButton pjemma = new JButton();
        JButton ljemma = new JButton();
        JButton ijemma = new JButton();
        JButton ejemma = new JButton();
        JLabel koillinen = new JLabel("Koillispino");
        JLabel kaakko = new JLabel("Kaakkoispino");
        JLabel lounas = new JLabel("Lounaispino");
        JLabel luode = new JLabel("Luoteispino");

        JButton aloitusnappi = new JButton();

        Paivittaja paivittaja = new Paivittaja(pelialusta, ppino, kjemma, ljemma,
                pjemma, ijemma, ejemma, luode, koillinen, kaakko, lounas, kpino);

        PelipakanKuuntelija peliPaK = new PelipakanKuuntelija(pelialusta, paivittaja);
        ppakka.addActionListener(peliPaK);

        PelipinonKuuntelija peliPiK = new PelipinonKuuntelija(pelialusta, paivittaja);
        ppino.addActionListener(peliPiK);

        LansijemmanKuuntelija ljemmanK = new LansijemmanKuuntelija(pelialusta, paivittaja);
        ljemma.addActionListener(ljemmanK);

        PohjoisjemmanKuuntelija pjemmanK = new PohjoisjemmanKuuntelija(pelialusta, paivittaja);
        pjemma.addActionListener(pjemmanK);

        ItajemmanKuuntelija ijemmanK = new ItajemmanKuuntelija(pelialusta, paivittaja);
        ijemma.addActionListener(ijemmanK);

        EtelajemmanKuuntelija ejemmanK = new EtelajemmanKuuntelija(pelialusta, paivittaja);
        ejemma.addActionListener(ejemmanK);

        KuutosjemmanKuuntelija kjemmaK = new KuutosjemmanKuuntelija(pelialusta, paivittaja);
        kjemma.addActionListener(kjemmaK);

        container.add(aloitusnappi);
        container.add(luode);
        container.add(pjemma);
        container.add(koillinen);
        container.add(ppakka);
        container.add(new JButton("Säännöt"));
        container.add(ljemma);
        container.add(kpino);
        container.add(ijemma);
        container.add(ppino);
        container.add(new JButton("Ei ole"));
        container.add(lounas);
        container.add(ejemma);
        container.add(kaakko);
        container.add(kjemma);

    }

    public JFrame getFrame() {
        return frame;
    }
}
