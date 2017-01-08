package napoleoninhauta.pasianssi.peli;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
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

        JButton nostaKortti = new JButton("Pelipakka");
        JButton pelipino = new JButton("pelipino");
        JButton kuutosjemma = new JButton("Kuutosjemma");
        JButton pohjoisjemma = new JButton("pohjoisjemma");
        JButton lansijemma = new JButton("lansijemma");
        JButton itajemma = new JButton("itajemma");
        JButton etelajemma = new JButton("etelajemma");
        JLabel keskipino = new JLabel("Keskipino");
        JLabel koillinen = new JLabel("koillinen");
        JLabel kaakko = new JLabel("kaakko");
        JLabel lounas = new JLabel("lounas");
        JLabel luode = new JLabel("luode");

        PelipakanKuuntelija nostaja = new PelipakanKuuntelija();
        nostaKortti.addActionListener(nostaja);

        PelipinonKuuntelija pelinkuuntelija = new PelipinonKuuntelija();
        pelipino.addActionListener(pelinkuuntelija);

        container.add(nostaKortti);
        container.add(luode);
        container.add(pohjoisjemma);
        container.add(koillinen);
        container.add(pelipino);
        container.add(lansijemma);
        container.add(keskipino);
        container.add(itajemma);
        container.add(kuutosjemma);
        container.add(lounas);
        container.add(etelajemma);
        container.add(kaakko);

    }

    public JFrame getFrame() {
        return frame;
    }
}
