package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pelialusta.YhdenKortinJemma;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pakka.Maa;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class YhdenKortinJemmaTest {

    private YhdenKortinJemma jemma;
    private Kortti testikortti;

    @Before
    public void setUp() {
        this.jemma = new YhdenKortinJemma();
        this.testikortti = new Kortti(1, Maa.PATA);
    }

    @Test
    public void jemmaLuodaanJaPaikkaOnTyhja() {
        assertEquals(null, jemma.palautaKortti());
    }

    @Test
    public void tyhjaanjemmaanVoiLaittaaKortin() {
        jemma.asetaKortti(testikortti);
        assertTrue(jemma.palautaKortti() != null);
    }

    @Test
    public void palautaKorttiPalauttaaJemmanKortin() {
        jemma.asetaKortti(testikortti);
        assertEquals(testikortti, jemma.palautaKortti());
    }

    @Test
    public void jemmaanEiVoiLaittaaKorttiaJosJemmassaOnKortti() {
        jemma.asetaKortti(testikortti);
        jemma.asetaKortti(new Kortti(6, Maa.RUUTU));
        assertEquals(testikortti, jemma.palautaKortti());
    }

    @Test
    public void otaKorttiPalauttaaNullJosJemmaOnTyhja() {
        assertEquals(null, jemma.otaKortti());
    }

    @Test
    public void otaKorttiPalauttaaKortinJemmasta() {
        jemma.asetaKortti(testikortti);
        assertEquals(testikortti, jemma.otaKortti());
    }

    @Test
    public void otaKorttiTyhjentaaJemman() {
        jemma.asetaKortti(testikortti);
        jemma.otaKortti();
        assertEquals(null, jemma.palautaKortti());
    }

    @After
    public void tearDown() {
    }

}
