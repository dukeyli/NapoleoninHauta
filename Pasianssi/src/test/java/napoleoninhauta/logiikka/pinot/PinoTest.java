package napoleoninhauta.logiikka.pinot;

import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
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
        assertEquals(0, pinonPerivaPelipino.getMaara());
    }
    
    @Test
    public void palautaMaaraToimiiKorttejaLisatessa() {
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertEquals(1, pinonPerivaPelipino.getMaara());
    }
    
    @Test
    public void palautaKortitPalauttaaAluksiTyhjanListanKorteista() {
        ArrayList<Kortti> kortit = new ArrayList();
        assertTrue(pinonPerivaPelipino.getKortit().equals(kortit));
    }
    
    @Test
    public void palautaKortitPalauttaaOikeanYhdenKortinListan() {
        ArrayList<Kortti> kortit = new ArrayList();
        kortit.add(testikortti);
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertTrue(pinonPerivaPelipino.getKortit().equals(kortit));
    }
    
    @Test
    public void palautaKortitPalauttaaOikeanMonenKortinListan() {
        ArrayList<Kortti> kortit = new ArrayList();
        kortit.add(testikortti);
        kortit.add(0, new Kortti(5, Maa.RISTI));
        pinonPerivaPelipino.asetaKortti(testikortti);
        pinonPerivaPelipino.asetaKortti(new Kortti(5, Maa.RISTI));
        assertTrue(pinonPerivaPelipino.getKortit().equals(kortit));
    }
    
    @Test
    public void palautaYlinPalauttaaTyhjaJosJemmaOnTyhja() {
        assertEquals("tyhja", pinonPerivaPelipino.getYlin());
    }
    
    @Test
    public void palautaYlinPalauttaaKortinStringEsityksenJosPinossaOnKortteja() {
        pinonPerivaPelipino.asetaKortti(new Kortti(6, Maa.PATA));
        assertEquals("PATA_6", pinonPerivaPelipino.getYlin());
    }
    
    @Test
    public void palautaYlinPalauttaaPinonPaalimmaisenKortin() {
        pinonPerivaPelipino.asetaKortti(new Kortti(6, Maa.PATA));
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertEquals(testikortti.toString(), pinonPerivaPelipino.getYlin());
    }
    
    @Test
    public void palautaYlimmanArvoPalauttaaNollaJosPinoOnTyhja() {
        assertEquals(0, pinonPerivaPelipino.getYlimmanArvo());
    }
    
    @Test
    public void palautaYlimmanArvoPalauttaaPinonPaalimmaisenKortinArvon() {
        pinonPerivaPelipino.asetaKortti(new Kortti(2, Maa.RISTI));
        pinonPerivaPelipino.asetaKortti(testikortti);
        assertEquals(13, pinonPerivaPelipino.getYlimmanArvo());
    }
    
    @After
    public void tearDown() {
    }
    
}
