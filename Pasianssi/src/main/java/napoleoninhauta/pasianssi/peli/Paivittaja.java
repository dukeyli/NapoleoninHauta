package napoleoninhauta.pasianssi.peli;

import javax.swing.JButton;
import javax.swing.JLabel;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class Paivittaja {

    private Pelialusta alusta;
    private JButton pelipino;
    private JButton kuutosjemma;
    private JButton lansi;
    private JButton pohjoinen;
    private JButton ita;
    private JButton etela;
    private JLabel luode;
    private JLabel koillinen;
    private JLabel kaakko;
    private JLabel lounas;
    private JLabel keskipino;

    public Paivittaja(Pelialusta alusta,
            JButton pelipino,
            JButton kuutosjemma,
            JButton lansi,
            JButton pohjoinen,
            JButton ita,
            JButton etela,
            JLabel luode,
            JLabel koillinen,
            JLabel kaakko,
            JLabel lounas,
            JLabel keskipino) {

        this.alusta = alusta;
        this.pelipino = pelipino;
        this.kuutosjemma = kuutosjemma;
        this.lansi = lansi;
        this.pohjoinen = pohjoinen;
        this.ita = ita;
        this.etela = etela;
        this.luode = luode;
        this.koillinen = koillinen;
        this.kaakko = kaakko;
        this.lounas = lounas;
        this.keskipino = keskipino;
    }

    public void paivita() {
        paivitaJemmat();
        paivitaKulmapinot();
        paivitaMuut();
    }

    private void paivitaJemmat() {
        lansi.setText(alusta.palautaJemmat().palautaLansi().palautaKortti());
        pohjoinen.setText(alusta.palautaJemmat().palautaPohjoinen().palautaKortti());
        ita.setText(alusta.palautaJemmat().palautaIta().palautaKortti());
        etela.setText(alusta.palautaJemmat().palautaEtela().palautaKortti());
    }

    private void paivitaKulmapinot() {
        luode.setText(alusta.palautaKulmapinot().palautaLuode().palautaYlin());
        koillinen.setText(alusta.palautaKulmapinot().palautaKoillinen().palautaYlin());
        kaakko.setText(alusta.palautaKulmapinot().palautaKaakko().palautaYlin());
        lounas.setText(alusta.palautaKulmapinot().palautaLounas().palautaYlin());
    }

    private void paivitaMuut() {
        pelipino.setText(alusta.palautaMuut().palautaPelipino().palautaYlin());
        keskipino.setText(alusta.palautaMuut().palautaKeskipino().palautaYlin());
        kuutosjemma.setText(alusta.palautaMuut().palautaKuutosJemma().palautaYlin());
    }

}
