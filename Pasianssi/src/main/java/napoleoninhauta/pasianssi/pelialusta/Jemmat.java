package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pinot.YhdenKortinJemma;

public class Jemmat {

    private YhdenKortinJemma lansi;
    private YhdenKortinJemma pohjoinen;
    private YhdenKortinJemma ita;
    private YhdenKortinJemma etela;

    public Jemmat() {
        lansi = new YhdenKortinJemma();
        pohjoinen = new YhdenKortinJemma();
        ita = new YhdenKortinJemma();
        etela = new YhdenKortinJemma();
    }

    public YhdenKortinJemma palautaLansi() {
        return lansi;
    }

    public YhdenKortinJemma palautaPohjoinen() {
        return pohjoinen;
    }

    public YhdenKortinJemma palautaIta() {
        return ita;
    }

    public YhdenKortinJemma palautaEtela() {
        return etela;
    }

    public boolean onkoKaikkiJemmatTaynna() {
        if (lansi.palautaKortti().equals("tyhja")
                || ita.palautaKortti().equals("tyhja")
                || etela.palautaKortti().equals("tyhja")
                || pohjoinen.palautaKortti().equals("tyhja")) {
            return false;
        }
        return true;
    }
    
    public boolean laitaTyhjaanJemmaan(Kortti kortti) {
        if (lansi.palautaKortti().equals("tyhja")) {
            lansi.asetaKortti(kortti);
            return true;
        }
        if (pohjoinen.palautaKortti().equals("tyhja")) {
            pohjoinen.asetaKortti(kortti);
            return true;
        }
        if (ita.palautaKortti().equals("tyhja")) {
            ita.asetaKortti(kortti);
            return true;
        }
        if (etela.palautaKortti().equals("tyhja")) {
            etela.asetaKortti(kortti);
            return true;
        }
        return false;
    }

}
