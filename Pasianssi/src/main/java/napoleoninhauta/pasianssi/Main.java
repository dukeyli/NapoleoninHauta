
package napoleoninhauta.pasianssi;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pakka.Pakanluoja;
import napoleoninhauta.pasianssi.pelialusta.KuutosJemma;
import napoleoninhauta.pasianssi.pelialusta.Keskipino;
import napoleoninhauta.pasianssi.pelialusta.Kulmapino;
import napoleoninhauta.pasianssi.pelialusta.Pakka;
import napoleoninhauta.pasianssi.pelialusta.Pelipino;

public class Main {
    
    public static void main(String[] args) {

        Pakanluoja kortit = new Pakanluoja();
        Pakka pakka = new Pakka(kortit.alustaPakka());

        System.out.println(pakka.palautaMaara());
        System.out.println(pakka.nostaKortti());
        System.out.println(pakka.palautaMaara());

        Keskipino keskipino = new Keskipino();
        Kulmapino kulmapino = new Kulmapino();
        KuutosJemma jemma = new KuutosJemma();
        Pelipino pelipino = new Pelipino();

        int i = 1;

        while (i < 51) {
            Kortti kortti = pakka.nostaKortti();
            keskipino.asetaKortti(kortti);
            kulmapino.asetaKortti(kortti);
            jemma.asetaKortti(kortti);
            pelipino.asetaKortti(kortti);
            i++;
        }
        System.out.println(keskipino.palautaYlin());
        System.out.println(kulmapino.palautaYlin());
        System.out.println(jemma.palautaYlin());
        System.out.println(pelipino.palautaYlin());
    }
    
}
