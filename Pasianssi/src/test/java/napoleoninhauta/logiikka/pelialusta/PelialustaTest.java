package napoleoninhauta.logiikka.pelialusta;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelialustaTest {

    private Pelialusta alusta;
    private Kortti testikortti1;
    private Kortti testikortti2;

    @Before
    public void setUp() {
        this.alusta = new Pelialusta();
        this.testikortti1 = new Kortti(6, Maa.PATA);
        this.testikortti2 = new Kortti(7, Maa.HERTTA);
    }

    @Test
    public void alustaLuoJemmatKulmapinotJaMuutPinotJaGetteritToimii() {
        assertTrue(alusta.getJemmat().laitaTyhjaanJemmaan(testikortti1));
        assertFalse(alusta.getKulmapinot().kaikkiLapi());
        assertEquals(6, alusta.getMuut().getKeskipino().getArvo());
    }

    @Test
    public void nostaKorttiPakastaNostaaKortinPelipakasta() {
        alusta.nostaKorttiPakasta();
        assertEquals(51, alusta.getMuut().getPelipakka().getMaara());
    }

    @Test
    public void nostaKorttiPakastaLaittaaNostetunKortinPelipinoon() {
        alusta.nostaKorttiPakasta();
        assertEquals(1, alusta.getMuut().getPelipino().getMaara());
    }

    @Test
    public void nostaKorttiToimiiPakanViimeisellaKortilla() {
        int i = 0;
        while (i < 52) {
            alusta.nostaKorttiPakasta();
            i++;
        }
        assertEquals(0, alusta.getMuut().getPelipakka().getMaara());
        assertEquals(52, alusta.getMuut().getPelipino().getMaara());
    }

    @Test
    public void nostaKorttiEiTeeMitaanJosPakkaOnTyhja() {
        int i = 0;
        while (i < 53) {
            alusta.nostaKorttiPakasta();
            i++;
        }
        assertEquals(0, alusta.getMuut().getPelipakka().getMaara());
    }

    @Test
    public void suoritaPelipinoEiTeeMitaanJosPelipinoOnTyhja() {
        alusta.suoritaPelipino();
        assertEquals("tyhja", alusta.getMuut().getPelipino().getYlin());
    }

    @Test
    public void suoritaPelipinoLaittaaKuutosenEnsisijaisestiKeskipinoon() {
        alusta.getMuut().getPelipino().asetaKortti(testikortti1);
        alusta.suoritaPelipino();
        assertEquals(0, alusta.getMuut().getPelipino().getMaara());
        assertEquals("PATA_6", alusta.getMuut().getKeskipino().getYlin());
    }

    @Test
    public void suoritaPelipinoLaittaaKuutosenJemmaanJosKeskelleEiMene() {
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(6, Maa.RISTI));
        alusta.getMuut().getPelipino().asetaKortti(testikortti1);
        alusta.suoritaPelipino();
        assertEquals(0, alusta.getMuut().getPelipino().getMaara());
        assertEquals("PATA_6", alusta.getMuut().getKuutosJemma().getYlin());
    }

    @Test
    public void suoritaPelipinoLaitaaKeskipinoonJosPeliAvattuJaMahdollista() {
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(5, Maa.RISTI));
        alusta.getMuut().getPelipino().asetaKortti(testikortti1);
        alusta.suoritaPelipino();
        alusta.suoritaPelipino();
        assertEquals("RISTI_5", alusta.getMuut().getKeskipino().getYlin());
    }

    @Test
    public void suoritaPelipinoEiLaitaMuitaKorttejaEteenpainJosPeliaEiOleAvattu() {
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(8, Maa.RISTI));
        alusta.suoritaPelipino();
        assertEquals(1, alusta.getMuut().getPelipino().getMaara());
        alusta.getMuut().getPelipino().asetaKortti(testikortti2);
        alusta.suoritaPelipino();
        assertEquals(2, alusta.getMuut().getPelipino().getMaara());
    }

    @Test
    public void suoritaPelipinoLaittaaSeiskanKulmapinoonJosPeliOnAvattu() {
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(6, Maa.RISTI));
        alusta.getMuut().getPelipino().asetaKortti(testikortti2);
        alusta.suoritaPelipino();
        assertEquals("HERTTA_7", alusta.getKulmapinot().getLuode().getYlin());
    }

    @Test
    public void suoritaPelipinoLaittaaKulmapinoihinMuutenkinJosPeliAvattu() {
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(6, Maa.RISTI));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(8, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(testikortti2);
        alusta.suoritaPelipino();
        alusta.suoritaPelipino();
        assertEquals(0, alusta.getMuut().getPelipino().getMaara());
        assertEquals("PATA_8", alusta.getKulmapinot().getLuode().getYlin());
    }

    @Test
    public void suoritaPelipinoLaittaaJemmaanJosPeliAvattuJaEivatSoviPinoihin() {
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(6, Maa.RISTI));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(8, Maa.HERTTA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(9, Maa.HERTTA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(10, Maa.HERTTA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(11, Maa.HERTTA));
        alusta.suoritaPelipino();
        alusta.suoritaPelipino();
        alusta.suoritaPelipino();
        alusta.suoritaPelipino();
        assertTrue(alusta.getJemmat().onkoKaikkiJemmatTaynna());
    }

    @Test
    public void meneekoMikaanPalauttaaFalseJosEiMahdollisiaSiirtoja1() {
        alusta.getMuut().getPelipino().asetaKortti(testikortti2);
        assertFalse(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaFalseJosEiMahdollisiaSiirtoja2() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getMuut().getKuutosJemma().asetaKortti(new Kortti(6, Maa.RUUTU));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(8, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(9, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(12, Maa.PATA));
        assertFalse(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaTrueJosMahdollisiaSiirtojaAloittaa() {
        alusta.getMuut().getPelipino().asetaKortti(testikortti1);
        assertTrue(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaTrueJosMahdollisiaSiirtojaKulmaan() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getMuut().getKuutosJemma().asetaKortti(new Kortti(6, Maa.RUUTU));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(7, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(9, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(12, Maa.PATA));
        assertTrue(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaTrueJosMahdollisiaSiirtojaKeskelle() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getMuut().getKuutosJemma().asetaKortti(new Kortti(6, Maa.RUUTU));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(8, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(5, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(12, Maa.PATA));
        assertTrue(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaTrueJosMahdollisiaSiirtojaKuutosjemmasta() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(5, Maa.PATA));
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(4, Maa.PATA));
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(3, Maa.PATA));
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(2, Maa.PATA));
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(1, Maa.PATA));
        alusta.getMuut().getKuutosJemma().asetaKortti(new Kortti(6, Maa.RUUTU));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(9, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(8, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(12, Maa.PATA));
        assertTrue(alusta.meneekoMikaan());
    }

    @Test
    public void meneekoMikaanPalauttaaTrueJosMahdollisiaSiirtojaJemmoihin() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(9, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        assertTrue(alusta.meneekoMikaan());
    }

    @Test
    public void aloitaUusiPeliAlustaaUudenPakan() {
        alusta.nostaKorttiPakasta();
        assertEquals(51, alusta.getMuut().getPelipakka().getMaara());
        alusta.aloitaUusiPeli();
        assertEquals(52, alusta.getMuut().getPelipakka().getMaara());
    }

    @Test
    public void aloitaUusiPeliTyhjentaaMuutPinotJaJemmat() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getMuut().getKuutosJemma().asetaKortti(new Kortti(6, Maa.RUUTU));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(8, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(5, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(10, Maa.PATA));
        alusta.getJemmat().laitaTyhjaanJemmaan(new Kortti(11, Maa.PATA));
        alusta.getMuut().getPelipino().asetaKortti(new Kortti(12, Maa.PATA));
        alusta.getKulmapinot().laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        alusta.getKulmapinot().laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RUUTU));
        alusta.getKulmapinot().laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RISTI));
        alusta.getKulmapinot().laitaKorttiSopivaanPinoon(new Kortti(7, Maa.HERTTA));

        alusta.aloitaUusiPeli();

        assertEquals("tyhja", alusta.getMuut().getKeskipino().getYlin());
        assertEquals("tyhja", alusta.getMuut().getKuutosJemma().getYlin());
        assertEquals("tyhja", alusta.getMuut().getPelipino().getYlin());
        assertEquals("tyhja", alusta.getJemmat().getEtela().getKortti());
        assertEquals("tyhja", alusta.getJemmat().getIta().getKortti());
        assertEquals("tyhja", alusta.getJemmat().getLansi().getKortti());
        assertEquals("tyhja", alusta.getJemmat().getPohjoinen().getKortti());
        assertEquals("tyhja", alusta.getKulmapinot().getKaakko().getYlin());
        assertEquals("tyhja", alusta.getKulmapinot().getKoillinen().getYlin());
        assertEquals("tyhja", alusta.getKulmapinot().getLounas().getYlin());
        assertEquals("tyhja", alusta.getKulmapinot().getLuode().getYlin());
    }

    @Test
    public void peruNostoAsettaaKortinPelipinostaPakkaanJosPeliEiAvattu() {
        alusta.nostaKorttiPakasta();
        String kortti = alusta.getMuut().getPelipino().getYlin();
        alusta.peruNosto();
        assertEquals(kortti, alusta.getMuut().getPelipakka().nostaKortti().toString());
    }

    @Test
    public void peruNostoToimiessaanPoistaaKortinPelipinosta() {
        alusta.nostaKorttiPakasta();
        alusta.peruNosto();
        assertEquals(0, alusta.getMuut().getPelipino().getMaara());
    }

    @Test
    public void peruNostoEiAsetaKorttiaTakaisinPakkaanJosPeliOnAvattu() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.nostaKorttiPakasta();
        String kortti = alusta.getMuut().getPelipino().getYlin();
        alusta.peruNosto();
        assertNotEquals(kortti, alusta.getMuut().getPelipakka().nostaKortti().toString());
    }

    @Test
    public void laitaKuutosjemmastaToimiiJosJemmassaKorttiJaSeSopiiKeskelle() {
        alusta.getMuut().getKuutosJemma().asetaKortti(testikortti1);
        alusta.laitaKuutosjemmasta();
        assertEquals(0, alusta.getMuut().getKuutosJemma().getMaara());
        assertEquals(1, alusta.getMuut().getKeskipino().getMaara());
    }

    @Test
    public void laitaKuutosjemmastaEiToimiJosJemmanKorttiEiSoviKeskelle() {
        alusta.getMuut().getKeskipino().asetaKortti(new Kortti(6, Maa.HERTTA));
        alusta.getMuut().getKuutosJemma().asetaKortti(testikortti1);
        alusta.laitaKuutosjemmasta();
        assertEquals(1, alusta.getMuut().getKuutosJemma().getMaara());
        assertEquals("HERTTA_6", alusta.getMuut().getKeskipino().getYlin());
    }

    @Test
    public void suoritaYhdenKortinJemmaEiLaitaKorttiaMihinkaanJosEiMahdollista() {
        alusta.getJemmat().getEtela().asetaKortti(new Kortti(12, Maa.PATA));
        alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getEtela());
        assertEquals("PATA_12", alusta.getJemmat().getEtela().getKortti());
    }

    @Test
    public void suoritaYhdenKortinJemmaLaittaaKortinKeskelleJosMahdollista() {
        alusta.getJemmat().getEtela().asetaKortti(testikortti1);
        alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getEtela());
        assertEquals("tyhja", alusta.getJemmat().getEtela().getKortti());
        assertEquals("PATA_6", alusta.getMuut().getKeskipino().getYlin());
    }

    @Test
    public void suoirtaYhdenKortinJemmaLaittaaKortinKulmaanJosMahdollista() {
        alusta.getMuut().getKeskipino().asetaKortti(testikortti1);
        alusta.getJemmat().getEtela().asetaKortti(testikortti2);
        alusta.suoritaYhdenKortinJemma(alusta.getJemmat().getEtela());
        assertEquals("tyhja", alusta.getJemmat().getEtela().getKortti());
        assertEquals("HERTTA_7", alusta.getKulmapinot().getLuode().getYlin());
    }

    @After
    public void tearDown() {
    }

}
