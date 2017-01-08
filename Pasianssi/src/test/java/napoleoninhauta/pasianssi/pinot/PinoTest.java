package napoleoninhauta.pasianssi.pinot;

import napoleoninhauta.pasianssi.pinot.Pelipino;
import java.util.ArrayList;
import napoleoninhauta.pasianssi.pakka.Kortti;
import napoleoninhauta.pasianssi.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PinoTest {

    private Pelipino pinonPerivaPelipino;
    private Kortti testikortti;

    @Before
    public void setUp() {
        pinonPerivaPelipino = new Pelipino();
        testikortti = new Kortti(13, Maa.RISTI);
    }

    @Test
    public void pinonMetodiPalautaMaaraToimii() {
        assertEquals(0, pinonPerivaPelipino.palautaMaara());
    }

    @Test
    public void palautaMaaraToimiiKorttejaLisatessa() {
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertEquals(1, pinonPerivaPelipino.palautaMaara());
    }

    @Test
    public void palautaKortitPalauttaaAluksiTyhjanListanKorteista() {
        ArrayList<Kortti> kortit = new ArrayList();
        assertTrue(pinonPerivaPelipino.palautaKortit().equals(kortit));
    }

    @Test
    public void palautaKortitPalauttaaOikeanYhdenKortinListan() {
        ArrayList<Kortti> kortit = new ArrayList();
        kortit.add(testikortti);
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertTrue(pinonPerivaPelipino.palautaKortit().equals(kortit));
    }
    
    @Test
    public void palautaKortitPalauttaaOikeanMonenKortinListan() {
        ArrayList<Kortti> kortit = new ArrayList();
        kortit.add(testikortti);
        kortit.add(0, new Kortti(5, Maa.RISTI));
        pinonPerivaPelipino.asetaKortti(testikortti);
        pinonPerivaPelipino.asetaKortti(new Kortti(5, Maa.RISTI));
        assertTrue(pinonPerivaPelipino.palautaKortit().equals(kortit));
    }

    @Test
    public void palautaYlinPalauttaaTyhjaJosJemmaOnTyhja() {
        assertEquals("tyhja", pinonPerivaPelipino.palautaYlin());
    }

    @Test
    public void palautaYlinPalauttaaKortinStringEsityksenJosPinossaOnKortteja() {
        pinonPerivaPelipino.asetaKortti(new Kortti(6, Maa.PATA));
        assertEquals("PATA 6", pinonPerivaPelipino.palautaYlin());
    }

    @Test
    public void palautaYlinPalauttaaPinonPaalimmaisenKortin() {
        pinonPerivaPelipino.asetaKortti(new Kortti(6, Maa.PATA));
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertEquals(testikortti.toString(), pinonPerivaPelipino.palautaYlin());
    }

    @After
    public void tearDown() {
    }

}
