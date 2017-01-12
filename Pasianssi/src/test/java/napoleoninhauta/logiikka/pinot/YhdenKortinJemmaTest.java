package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
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
        assertEquals("tyhja", jemma.getKortti());
    }

    @Test
    public void tyhjaanjemmaanVoiLaittaaKortin() {
        jemma.asetaKortti(testikortti);
        assertTrue(jemma.getKortti() != null);
    }

    @Test
    public void palautaKorttiPalauttaaJemmanKortinStringEsityksen() {
        jemma.asetaKortti(testikortti);
        assertEquals(testikortti.toString(), jemma.getKortti());
    }

    @Test
    public void jemmaanEiVoiLaittaaKorttiaJosJemmassaOnKortti() {
        jemma.asetaKortti(testikortti);
        jemma.asetaKortti(new Kortti(6, Maa.RUUTU));
        assertEquals(testikortti.toString(), jemma.getKortti());
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
        assertEquals("tyhja", jemma.getKortti());
    }

    @Test
    public void palautaKortinArvoPalauttaaNollaJosJemmaOnTyhja() {
        assertEquals(0, jemma.getKortinArvo());
    }

    @Test
    public void palautaKortinArvoPalauttaaJemmassaOlevanKortinArvon() {
        jemma.asetaKortti(testikortti);
        assertEquals(1, jemma.getKortinArvo());
    }

    @Test
    public void tyhjennaTyhjentaaJemman() {
        jemma.asetaKortti(testikortti);
        jemma.tyhjenna();
        assertTrue(jemma.getKortti().equals("tyhja"));
    }

    @After
    public void tearDown() {
    }

}
