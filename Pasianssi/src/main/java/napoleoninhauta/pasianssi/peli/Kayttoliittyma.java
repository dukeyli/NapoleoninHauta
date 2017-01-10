package napoleoninhauta.pasianssi.peli;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
        frame.setPreferredSize(new Dimension(700, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 4);
        container.setLayout(layout);

        JButton ppakka = new JButton("pelipakka");
        JButton ppino = new JButton("tyhja");
        JButton kjemma = new JButton("tyhja");
        JLabel kpino = new JLabel("tyhja");
        JButton pjemma = new JButton("tyhja");
        JButton ljemma = new JButton("tyhja");
        JButton ijemma = new JButton("tyhja");
        JButton ejemma = new JButton("tyhja");
        JLabel koillinen = new JLabel("tyhja");
        JLabel kaakko = new JLabel("tyhja");
        JLabel lounas = new JLabel("tyhja");
        JLabel luode = new JLabel("tyhja");

        Paivittaja paivittaja = new Paivittaja(pelialusta, ppino, kjemma, ljemma,
                pjemma, ijemma, ejemma, luode, koillinen, kaakko, lounas, kpino);

        PelipakanKuuntelija peliPaK = new PelipakanKuuntelija(pelialusta, ppino);
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

        container.add(ppakka);
        container.add(luode);
        container.add(pjemma);
        container.add(koillinen);
        container.add(ppino);
        container.add(ljemma);
        container.add(kpino);
        container.add(ijemma);
        container.add(kjemma);
        container.add(lounas);
        container.add(ejemma);
        container.add(kaakko);
    }

    public JFrame getFrame() {
        return frame;
    }
}
