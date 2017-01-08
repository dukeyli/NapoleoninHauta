package napoleoninhauta.pasianssi.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pelialusta.Pelialusta;

public class PelipinonKuuntelija implements ActionListener {

    private Pelialusta alusta;
    private JButton pelipino;
    private JLabel keskipino;
    private JButton lansijemma;
    private JButton itajemma;
    private JButton pohjoisjemma;
    private JButton etelajemma;

    public PelipinonKuuntelija(Pelialusta alusta, JButton pino, JLabel keskip,
            JButton i, JButton e,
            JButton l, JButton p) {
        this.alusta = alusta;
        this.pelipino = pino;
        this.keskipino = keskip;
        this.lansijemma = l;
        this.itajemma = i;
        this.pohjoisjemma = p;
        this.etelajemma = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!alusta.palautaMuut().palautaPelipino().palautaYlin().equals("tyhja")) {
            Kortti kortti = alusta.palautaMuut().palautaPelipino().otaKortti();
            suorita(kortti);
        }
        paivita();
    }

    public void suorita(Kortti kortti) {
        if (alusta.palautaMuut().palautaKeskipino().onkoPeliAvattu() == false) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(kortti);
        } else {
            boolean eiMennyt = suoritaMuutTapaukset(kortti);
            if (eiMennyt == true) {
                alusta.palautaMuut().palautaPelipino().asetaKortti(kortti);
            }
        }
    }

    public boolean suoritaMuutTapaukset(Kortti kortti) {
        boolean jatkuuko = true;
        jatkuuko = laitaKeskipinoonTaiKuutosjemmaan(kortti);
        if (jatkuuko == false) {
            return false;
        }
        jatkuuko = laitaKulmapinoon(kortti);
        if (jatkuuko == false) {
            return false;
        }
        boolean palautusarvo = laitaJemmaan(kortti);
        return palautusarvo;
    }

    public boolean laitaKeskipinoonTaiKuutosjemmaan(Kortti kortti) {
        if (kortti.palautaArvo() == alusta.palautaMuut().palautaKeskipino().palautaArvo()) {
            alusta.palautaMuut().palautaKeskipino().asetaKortti(kortti);
            return false;
        }
        if (kortti.palautaArvo() == 6) {
            alusta.palautaMuut().palautaKuutosJemma().asetaKortti(kortti);
            return false;
        }
        return true;
    }

    public boolean laitaKulmapinoon(Kortti kortti) {
        boolean meneeko = alusta.palautaKulmapinot().laitaKorttiSopivaanPinoon(kortti);
        if (meneeko == true) {
            return false;
        }
        return true;
    }

    public boolean laitaJemmaan(Kortti kortti) {
        boolean meneeko = alusta.palautaJemmat().laitaTyhjaanJemmaan(kortti);
        if (meneeko == false) {
            return true;
        }
        return false;
    }

    public void paivita() {
        pelipino.setText(alusta.palautaMuut().palautaPelipino().palautaYlin());
        keskipino.setText(alusta.palautaMuut().palautaKeskipino().palautaYlin());
        lansijemma.setText(alusta.palautaJemmat().palautaLansi().palautaKortti());
        pohjoisjemma.setText(alusta.palautaJemmat().palautaPohjoinen().palautaKortti());
        itajemma.setText(alusta.palautaJemmat().palautaIta().palautaKortti());
        etelajemma.setText(alusta.palautaJemmat().palautaEtela().palautaKortti());
    }

}
