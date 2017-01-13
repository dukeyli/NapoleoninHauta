package napoleoninhauta.gui;

import napoleoninhauta.logiikka.pelialusta.Paivittaja;
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
        JButton tulos = new JButton("Lopeta");
        JButton aloitusNappi = new JButton("Aloita uusi peli");
        JButton peru = new JButton("Peru nosto");

        Paivittaja paivittaja = new Paivittaja(ppakka, pelialusta, ppino, kjemma, ljemma,
                pjemma, ijemma, ejemma, luode, koillinen, kaakko, lounas, kpino,
                tulos);

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

        AloitusNapinKuuntelija aloitus = new AloitusNapinKuuntelija(pelialusta, paivittaja, tulos);
        aloitusNappi.addActionListener(aloitus);

        PeruNapinKuuntelija perunK = new PeruNapinKuuntelija(pelialusta, paivittaja);
        peru.addActionListener(perunK);

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
        container.add(tulos);
        container.add(lounas);
        container.add(ejemma);
        container.add(kaakko);
        container.add(kjemma);

    }

    public JFrame getFrame() {
        return frame;
    }
}
