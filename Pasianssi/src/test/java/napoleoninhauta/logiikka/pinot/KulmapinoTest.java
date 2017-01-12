package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
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
        assertEquals(7, kulmapino.getArvo());
    }

    @Test
    public void kulmaanVoiAsettaaSeiskan() {
        kulmapino.asetaKortti(testikortti);
        assertEquals(1, kulmapino.getMaara());
    }

    @Test
    public void kulmanArvoNouseeKortinAsettamisenJalkeen() {
        kulmapino.asetaKortti(testikortti);
        assertEquals(8, kulmapino.getArvo());
    }

    @Test
    public void kulmaanVoiLaittaaOikeitaKortteja() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(2, kulmapino.getMaara());
    }

    @Test
    public void kulmanArvoNouseeKorttejaLisatessa() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals(9, kulmapino.getArvo());
    }

    @Test
    public void asetaKorttiLaittaaKortinPinonPaalimmaiseksi() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.asetaKortti(new Kortti(8, Maa.RUUTU));
        assertEquals("RUUTU_8", kulmapino.getYlin());
    }

    @Test
    public void kulmaanEiVoiLaittaaKorttiaJonkaArvoOnEriKuinKulmanArvo() {
        kulmapino.asetaKortti(new Kortti(6, Maa.PATA));
        kulmapino.asetaKortti(new Kortti(8, Maa.HERTTA));
        assertEquals(0, kulmapino.getMaara());
    }
    
    @Test
    public void tyhjennaAsettaaArvonSeitsemaan() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.tyhjenna();
        assertEquals(7, kulmapino.getArvo());
    }
    
    @Test
    public void tyhjennaTyhjentaaPinon() {
        kulmapino.asetaKortti(testikortti);
        kulmapino.tyhjenna();
        assertEquals(0, kulmapino.getMaara());
    }

    @After
    public void tearDown() {
    }
}
