package napoleoninhauta.pasianssi.pinot;

import napoleoninhauta.pasianssi.pinot.Keskipino;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pakka.Maa;
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
    public void arvoOnAluksiSeitsemanJaPalautaArvoToimii() {
        assertEquals(6, keskipino.palautaArvo());
    }

    @Test
    public void keskelleVoiLaittaaAluksiKuutosen() {
        keskipino.asetaKortti(testikortti);
        assertEquals(1, keskipino.palautaMaara());
    }

    @Test
    public void keskipinonArvoLaskeeKunSiihenLaitetaanKortti() {
        keskipino.asetaKortti(testikortti);
        assertEquals(5, keskipino.palautaArvo());
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
        assertEquals(4, keskipino.palautaArvo());
    }

    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.RUUTU));
        assertEquals("RUUTU 5", keskipino.palautaYlin());
    }

    @Test
    public void keskelleEiVoiLaittaaKorttiaJonkaArvoOnEriKuinKeskipinonArvo() {
        keskipino.asetaKortti(new Kortti(5, Maa.PATA));
        keskipino.asetaKortti(new Kortti(7, Maa.HERTTA));
        assertEquals(0, keskipino.palautaMaara());
    }

    @Test
    public void kunKeskelleLaittaaAssanArvoNouseeKuutoseen() {
        keskipino.asetaKortti(testikortti);
        keskipino.asetaKortti(new Kortti(5, Maa.PATA));
        keskipino.asetaKortti(new Kortti(4, Maa.PATA));
        keskipino.asetaKortti(new Kortti(3, Maa.PATA));
        keskipino.asetaKortti(new Kortti(2, Maa.PATA));
        keskipino.asetaKortti(new Kortti(1, Maa.PATA));
        assertEquals(6, keskipino.palautaArvo());
    }

    @After
    public void tearDown() {
    }
}
