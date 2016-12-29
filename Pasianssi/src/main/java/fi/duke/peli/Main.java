
package fi.duke.peli;

import fi.duke.pakka.Kortti;
import fi.duke.pakka.PakanLuoja;
import fi.duke.pelialusta.KuutosJemma;
import fi.duke.pelialusta.Keskipino;
import fi.duke.pelialusta.Kulmapino;
import fi.duke.pelialusta.Pelipakka;
import fi.duke.pelialusta.Pelipino;

public class Main {
    
    public static void main(String[] args) {

        PakanLuoja kortit = new PakanLuoja();
        Pelipakka pakka = new Pelipakka(kortit.alustaPakka());

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
