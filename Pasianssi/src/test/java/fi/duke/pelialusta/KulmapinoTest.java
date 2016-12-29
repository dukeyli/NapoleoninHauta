package fi.duke.pelialusta;

import fi.duke.pelialusta.Kulmapino;
import fi.duke.pakka.Kortti;
import fi.duke.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KulmapinoTest {

    private Kulmapino kulmapino;
    private Kortti testikortti;

    @Before
    public void setUp() {
        kulmapino = new Kulmapino();
        testikortti = new Kortti(7, Maa.RISTI);
    }

    @Test
    public void arvoOnAluksiSeitsemanJaPalautaArvoToimii() {
        assertEquals(7, kulmapino.palautaArvo());
    }

    @Test
    public void kulmaanVoiAsettaaSeiskan() {
        kulmapino.asetaKortti(testikortti);
        assertEquals(1, kulmapino.palautaMaara());
    }

    @Test
    public void kulmanArvoNouseeKortinAsettamisenJalkeen() {
        kulmapino.asetaKortti(testikortti);
        assertEquals(8, kulmapino.palautaArvo());
    }

    @Test
    public void kulmaanVoiLaittaaOikeitaKortteja() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(2, kulmapino.palautaMaara());
    }

    @Test
    public void kulmanArvoNouseeKorttejaLisatessa() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(9, kulmapino.palautaArvo());
    }

    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(new Kortti(8, Maa.RUUTU), kulmapino.palautaYlin());
    }

    @Test
    public void kulmaanEiVoiLaittaaKorttiaJonkaArvoOnEriKuinKulmanArvo() {
        kulmapino.asetaKortti(new Kortti(6, Maa.PATA));
        kulmapino.asetaKortti(new Kortti(8, Maa.HERTTA));
        assertEquals(0, kulmapino.palautaMaara());
    }

    @After
    public void tearDown() {
    }
}
