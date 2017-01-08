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

    public PelialustanMuutPinot() {
        luoja = new PakanLuoja();
        luoja.alustaPakka();
        pelipakka = new Pelipakka(luoja.alustaPakka());
        pelipino = new Pelipino();
        kuutosjemma = new KuutosJemma();
        keskipino = new Keskipino();
    }

    public Pelipakka palautaPelipakka() {
        return this.pelipakka;
    }

    public Pelipino palautaPelipino() {
        return pelipino;
    }

    public KuutosJemma palautaKuutosJemma() {
        return kuutosjemma;
    }

    public Keskipino palautaKeskipino() {
        return keskipino;
    }

}
