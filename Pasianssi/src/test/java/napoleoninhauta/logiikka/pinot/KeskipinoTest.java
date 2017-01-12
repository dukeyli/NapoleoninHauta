package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeskipinoTest {

    private Keskipino keskipino;
    private Kortti testikortti;

    @Before
    public void setUp() {
        keskipino = new Keskipino();
        testikortti = new Kortti(6, Maa.RISTI);
    }

    @Test
    public void arvoOnAluksiKuusiJaPalautaArvoToimii() {
        assertEquals(6, keskipino.getArvo());
    }

    @Test
    public void onkoPeliAvattuPalauttaaFalseJosPinoOnTyhja() {
        assertFalse(keskipino.onkoPeliAvattu());
    }

    @Test
    public void onkoPeliAvattuPalauttaaTrueJosPinossaOnKortti() {
        keskipino.asetaKortti(testikortti);
        assertTrue(keskipino.onkoPeliAvattu());
    }

    @Test
    public void keskelleVoiLaittaaAluksiKuutosen() {
        keskipino.asetaKortti(testikortti);
        assertEquals(1, keskipino.palautaMaara());
    }

    @Test
    public void keskipinonArvoLaskeeKunSiihenLaitetaanKortti() {
        keskipino.asetaKortti(testikortti);
        assertEquals(5, keskipino.getArvo());
    }

    @Test
    public void keskelleVoiLaittaaOikeitaKortteja() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.RUUTU));
        assertEquals(2, keskipino.palautaMaara());
    }

    @Test
    public void keskipinonArvoLaskeeKorttejaLisatessa() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.RUUTU));
        assertEquals(4, keskipino.getArvo());
    }

    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.RUUTU));
        assertEquals("RUUTU_5", keskipino.palautaYlin());
    }

    @Test
    public void keskelleEiVoiLaittaaKorttiaJonkaArvoOnEriKuinKeskipinonArvo() {
        keskipino.asetaKortti(new Kortti(5, Maa.PATA));
        keskipino.asetaKortti(new Kortti(7, Maa.HERTTA));
        assertEquals(0, keskipino.palautaMaara());
    }

    @Test
    public void keskelleEiVoiLaittaaKuutostaKunArvoEiOleKuusi() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(6, Maa.HERTTA));
        assertEquals("RISTI_6", keskipino.palautaYlin());
    }

    @Test
    public void kunKeskelleLaittaaAssanArvoNouseeKuutoseen() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.PATA));
        keskipino.asetaKortti(new Kortti(4, Maa.PATA));
        keskipino.asetaKortti(new Kortti(3, Maa.PATA));
        keskipino.asetaKortti(new Kortti(2, Maa.PATA));
        keskipino.asetaKortti(new Kortti(1, Maa.PATA));
        assertEquals(6, keskipino.getArvo());
    }

    @Test
    public void tyhjennaAsettaaArvonKuutoseen() {
        keskipino.asetaKortti(testikortti);
        keskipino.tyhjenna();
        assertEquals(6, keskipino.getArvo());
    }

    @Test
    public void tyhjennaTyhjentaaKeskipinon() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.PATA));
        keskipino.tyhjenna();
        assertEquals(0, keskipino.palautaMaara());
    }

    @After
    public void tearDown() {
    }
}
