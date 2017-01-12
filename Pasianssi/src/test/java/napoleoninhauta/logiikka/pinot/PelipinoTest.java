package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PelipinoTest {

    private Pelipino pelipino;
    private Kortti testikortti;

    @Before
    public void setUp() {
        this.pelipino = new Pelipino();
        this.testikortti = new Kortti(2, Maa.RUUTU);
    }

    @Test
    public void pelipinoonVoiAsettaaKortin() {
        pelipino.asetaKortti(testikortti);
        assertEquals(1, pelipino.getMaara());
    }

    @Test
    public void pelipinoonVoiAsettaaKortteja() {
        pelipino.asetaKortti(testikortti);
        pelipino.asetaKortti(new Kortti(12, Maa.HERTTA));
        assertEquals(2, pelipino.getMaara());
    }

    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        pelipino.asetaKortti(testikortti);
        pelipino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals("RUUTU_8", pelipino.getYlin());
    }

    @Test
    public void otaKorttiPalauttaaNullJosPelipinoOnTyhja() {
        assertEquals(null, pelipino.otaKortti());
    }

    @Test
    public void otaKorttiPalauttaaViimeiseksiLaitetunKortin() {
        pelipino.asetaKortti(new Kortti(6, Maa.HERTTA));
        pelipino.asetaKortti(testikortti);
        assertEquals(testikortti, pelipino.otaKortti());
    }

    @Test
    public void otaKorttiVahentaaPelipinonKorttienMaaraa() {
        pelipino.asetaKortti(new Kortti(6, Maa.HERTTA));
        pelipino.asetaKortti(testikortti);
        pelipino.otaKortti();
        assertEquals(1, pelipino.getMaara());
    }

    @Test
    public void otaKorttiPoistaaPelipinonPaallimmaisenKortin() {
        pelipino.asetaKortti(new Kortti(6, Maa.HERTTA));
        pelipino.asetaKortti(testikortti);
        pelipino.otaKortti();
        assertEquals("HERTTA_6", pelipino.getYlin());
    }

    @Test
    public void otaKorttiTyhjentaaYhdenKortinPelipinon() {
        pelipino.asetaKortti(testikortti);
        pelipino.otaKortti();
        assertTrue(pelipino.getMaara() == 0);
    }

    @Test
    public void nostaKorttiPalauttaaNullJosPakkaOnTyhja() {
        assertTrue(pelipino.otaKortti() == null);
    }

    @Test
    public void tyhjennaTyhjentaaPinon() {
        pelipino.asetaKortti(testikortti);
        pelipino.asetaKortti(new Kortti(2, Maa.RUUTU));
        pelipino.tyhjenna();
        assertEquals(0, pelipino.getMaara());
    }

    @After
    public void tearDown() {
    }
}
