package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pakka.Maa;
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
        assertEquals(1, pelipino.palautaMaara());
    }

    @Test
    public void pelipinoonVoiAsettaaKortteja() {
        pelipino.asetaKortti(testikortti);
        pelipino.asetaKortti(new Kortti(12, Maa.HERTTA));
        assertEquals(2, pelipino.palautaMaara());
    }
    
    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        pelipino.asetaKortti(testikortti);
        pelipino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(new Kortti(8, Maa.RUUTU), pelipino.palautaYlin());
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
        assertEquals(1, pelipino.palautaMaara());
    }

    @Test
    public void otaKorttiPoistaaPelipinonPaallimmaisenKortin() {
        pelipino.asetaKortti(new Kortti(6, Maa.HERTTA));
        pelipino.asetaKortti(testikortti);
        pelipino.otaKortti();
        assertEquals(new Kortti(6, Maa.HERTTA), pelipino.palautaYlin());
    }

    @Test
    public void otaKorttiTyhjentaaYhdenKortinPelipinon() {
        pelipino.asetaKortti(testikortti);
        pelipino.otaKortti();
        assertTrue(pelipino.palautaMaara() == 0);
    }

    @After
    public void tearDown() {
    }
}
