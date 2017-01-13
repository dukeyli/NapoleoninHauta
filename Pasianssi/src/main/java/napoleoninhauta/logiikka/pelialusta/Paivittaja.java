/**
 * Luokan tehtävä on päivittää näppäinten ja tekstikenttien kuvat ja tekstit.
 */
package napoleoninhauta.logiikka.pelialusta;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Paivittaja {

    private JButton pakka;
    private Pelialusta alusta;
    private JButton pelipino;
    private JButton kuutosjemma;
    private JButton lansi;
    private JButton pohjoinen;
    private JButton ita;
    private JButton etela;
    private JButton luode;
    private JButton koillinen;
    private JButton kaakko;
    private JButton lounas;
    private JButton keskipino;
    private JButton tulos;

    /**
     * Konstruktori alustaa pelialustan. näppäimet ja tekstit.
     *
     * @param pelipakka näppäin, jossa on pelipakka
     * @param alusta pelialusta, jossa on toiminnallisuus
     * @param pelipino näppäin, jossa on pelipino
     * @param kuutosjemma näppäin, jossa on kuutosjemma
     * @param lansi näppäin, jossa on yhden kortin jemma
     * @param pohjoinen näppäin, jossa on yhden kortin jemma
     * @param ita näppäin, jossa on yhden kortin jemma
     * @param etela näppäin, jossa on yhden kortin jemma
     * @param luode näppäin, jossa on kulmapino
     * @param koillinen näppäin, jossa on kulmapino
     * @param kaakko näppäin, jossa on kulmapino
     * @param lounas näppäin, jossa on kulmapino
     * @param keskipino näppäin, jossa on keskipino
     * @param tulos näppäin, jossa on pelin tulos
     */
    public Paivittaja(
            JButton pelipakka,
            Pelialusta alusta,
            JButton pelipino,
            JButton kuutosjemma,
            JButton lansi,
            JButton pohjoinen,
            JButton ita,
            JButton etela,
            JButton luode,
            JButton koillinen,
            JButton kaakko,
            JButton lounas,
            JButton keskipino,
            JButton tulos) {

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

    /**
     * Metodi päivittää näppäinten ja tekstikenttien kuvat oikeiksi. Metodi
     * käyttää yksityisiä apumetodeja päivittämään näppäimet ja tekstikentät.
     */
    public void paivita() {
        paivitaJemmat();
        paivitaKulmapinot();
        paivitaMuut();
        if (alusta.getMuut().getPelipakka().getMaara() == 0) {
            pakka.setIcon(new ImageIcon());
            paivitaTulos();
        }
    }

    private void paivitaJemmat() {
        paivitaNappi(lansi, alusta.getJemmat().getLansi().getKortti());
        paivitaNappi(pohjoinen, alusta.getJemmat().getPohjoinen().getKortti());
        paivitaNappi(ita, alusta.getJemmat().getIta().getKortti());
        paivitaNappi(etela, alusta.getJemmat().getEtela().getKortti());
    }

    private void paivitaKulmapinot() {
        paivitaNappi(luode, alusta.getKulmapinot().getLuode().getYlin());
        paivitaNappi(koillinen, alusta.getKulmapinot().getKoillinen().getYlin());
        paivitaNappi(kaakko, alusta.getKulmapinot().getKaakko().getYlin());
        paivitaNappi(lounas, alusta.getKulmapinot().getLounas().getYlin());
    }

    private void paivitaMuut() {
        paivitaNappi(pelipino, alusta.getMuut().getPelipino().getYlin());
        paivitaNappi(keskipino, alusta.getMuut().getKeskipino().getYlin());
        paivitaNappi(kuutosjemma, alusta.getMuut().getKuutosJemma().getYlin());
    }

    private void paivitaNappi(JButton pino, String kortti) {
        if (!kortti.equals("tyhja")) {
            ImageIcon icon = new ImageIcon(Paivittaja.class.getResource("Images/" + kortti + ".png"));
            Image img = icon.getImage().getScaledInstance(158, 224, Image.SCALE_DEFAULT);
            pino.setIcon(new ImageIcon(img));
        } else {
            pino.setIcon(new ImageIcon());
        }
    }

    private void paivitaTulos() {
        if (alusta.getKulmapinot().kaikkiLapi() == true && alusta.getMuut().getKeskipino().getMaara() == 24) {
            tulos.setText("Voitit pelin!");
        } else if (alusta.meneekoMikaan() == false) {
            tulos.setText("Hävisit!");
        }
    }

    /**
     * Metodi asettaa pakan kuvakkeen. Metodia käytetään aloittaessa uusi peli.
     */
    public void asetaPakanKuva() {
        ImageIcon icon = new ImageIcon(Paivittaja.class.getResource("Images/pakka.jpg"));
        Image img = icon.getImage().getScaledInstance(158, 224, Image.SCALE_DEFAULT);
        pakka.setIcon(new ImageIcon(img));
    }
}
