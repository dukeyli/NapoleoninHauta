/**
 * Luokka luo pelialustaa varten pelipakan, pelipinon, kuutosjemman ja keskipinon.
 */
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.PakanLuoja;
import napoleoninhauta.pasianssi.pinot.Keskipino;
import napoleoninhauta.pasianssi.pinot.KuutosJemma;
import napoleoninhauta.pasianssi.pinot.Pelipakka;
import napoleoninhauta.pasianssi.pinot.Pelipino;

public class PelialustanMuutPinot {

    private PakanLuoja luoja;
    private Pelipakka pelipakka;
    private Pelipino pelipino;
    private KuutosJemma kuutosjemma;
    private Keskipino keskipino;

    /**
     * Konstruktori alustaa uudet pinot ja pakan.
     */
    public PelialustanMuutPinot() {
        luoja = new PakanLuoja();
        luoja.alustaPakka();
        pelipakka = new Pelipakka(luoja.alustaPakka());
        pelipino = new Pelipino();
        kuutosjemma = new KuutosJemma();
        keskipino = new Keskipino();
    }

    public Pelipakka getPelipakka() {
        return this.pelipakka;
    }

    public Pelipino getPelipino() {
        return pelipino;
    }

    public KuutosJemma getKuutosJemma() {
        return kuutosjemma;
    }

    public Keskipino getKeskipino() {
        return keskipino;
    }
}
