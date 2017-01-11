package napoleoninhauta.pasianssi.pelialusta;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Paivittaja {

    private JButton pakka;
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
    private JLabel tulos;

    public Paivittaja(
            JButton pelipakka,
            Pelialusta alusta,
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
            JLabel keskipino,
            JLabel tulos) {

        this.pakka = pelipakka;
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
        this.tulos = tulos;
    }

    public void paivita() {
        paivitaJemmat();
        paivitaKulmapinot();
        paivitaMuut();
        if (alusta.getMuut().getPelipakka().palautaMaara() == 0) {
            pakka.setIcon(new ImageIcon());
            paivitaTulos();
        }
    }

    private void paivitaJemmat() {
        paivitaNappi(lansi, alusta.getJemmat().getLansi().palautaKortti());
        paivitaNappi(pohjoinen, alusta.getJemmat().getPohjoinen().palautaKortti());
        paivitaNappi(ita, alusta.getJemmat().getIta().palautaKortti());
        paivitaNappi(etela, alusta.getJemmat().getEtela().palautaKortti());
    }

    private void paivitaKulmapinot() {
        paivitaTeksti(luode, alusta.getKulmapinot().getLuode().palautaYlin());
        paivitaTeksti(koillinen, alusta.getKulmapinot().getKoillinen().palautaYlin());
        paivitaTeksti(kaakko, alusta.getKulmapinot().getKaakko().palautaYlin());
        paivitaTeksti(lounas, alusta.getKulmapinot().getLounas().palautaYlin());
    }

    private void paivitaMuut() {
        paivitaNappi(pelipino, alusta.getMuut().getPelipino().palautaYlin());
        paivitaTeksti(keskipino, alusta.getMuut().getKeskipino().palautaYlin());
        paivitaNappi(kuutosjemma, alusta.getMuut().getKuutosJemma().palautaYlin());
    }

    private void paivitaNappi(JButton pino, String kortti) {
        pino.setIcon(new ImageIcon(new ImageIcon("Images/" + kortti + ".png").getImage().getScaledInstance(164, 232, Image.SCALE_DEFAULT)));
    }

    private void paivitaTeksti(JLabel pino, String kortti) {
        pino.setIcon(new ImageIcon(new ImageIcon("Images/" + kortti + ".png").getImage().getScaledInstance(164, 232, Image.SCALE_DEFAULT)));
    }

    private void paivitaTulos() {
        if (alusta.getKulmapinot().kaikkiLapi() == true && alusta.getMuut().getKeskipino().palautaMaara() == 24) {
            tulos.setText("Voitit pelin!");
        } else if (alusta.meneekoMikaan() == false) {
            tulos.setText("Hävisit!");
        }
    }

    public void asetaPakanKuva() {
        pakka.setIcon(new ImageIcon(new ImageIcon("Images/pakka.jpg").getImage().getScaledInstance(164, 232, Image.SCALE_DEFAULT)));
    }
}
