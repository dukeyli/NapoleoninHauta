package fi.duke.pelialusta;

import fi.duke.pelialusta.KuutosJemma;
import fi.duke.pakka.Kortti;
import fi.duke.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuutosJemmaTest {

    private KuutosJemma jemma;
    private Kortti testikortti;

    @Before
    public void setUp() {
        jemma = new KuutosJemma();
        testikortti = new Kortti(6, Maa.RISTI);
    }

    @Test
    public void jemmaanVoiLaittaaKuutosen() {
        jemma.asetaKortti(testikortti);
        assertEquals(1, jemma.palautaMaara());
    }

    @Test
    public void jemmaanVoiLaittaaLisaaKuutosia() {
        jemma.asetaKortti(testikortti);
        jemma.asetaKortti(new Kortti(6, Maa.RUUTU));
        assertEquals(2, jemma.palautaMaara());
    }

    @Test
    public void jemmaanEiVoiLaittaaMuitaKuinKuutosia() {
        jemma.asetaKortti(new Kortti(1, Maa.PATA));
        jemma.asetaKortti(new Kortti(8, Maa.HERTTA));
        assertEquals(0, jemma.palautaMaara());
    }

    @Test
    public void otaKorttiPalauttaaNullJosJemmaOnTyhja() {
        assertEquals(null, jemma.otaKortti());
    }

    @Test
    public void otaKorttiPalauttaaViimeiseksiLaitetunKortin() {
        jemma.asetaKortti(new Kortti(6, Maa.HERTTA));
        jemma.asetaKortti(testikortti);
        assertEquals(testikortti, jemma.otaKortti());
    }

    @Test
    public void otaKorttiVahentaaJemmanKorttienMaaraa() {
        jemma.asetaKortti(new Kortti(6, Maa.HERTTA));
        jemma.asetaKortti(testikortti);
        jemma.otaKortti();
        assertEquals(1, jemma.palautaMaara());
    }
    
    @Test
    public void otaKorttiPoistaaPaalimmaisenKortinJemmasta() {
        jemma.asetaKortti(new Kortti(6, Maa.HERTTA));
        jemma.asetaKortti(testikortti);
        jemma.otaKortti();
        assertEquals(new Kortti(6, Maa.HERTTA), jemma.palautaYlin());
    }

    @Test
    public void otaKorttiTyhjentaaYhdenKortinJemman() {
        jemma.asetaKortti(testikortti);
        jemma.otaKortti();
        assertTrue(jemma.palautaMaara() == 0);
    }

    @After
    public void tearDown() {
    }

}
