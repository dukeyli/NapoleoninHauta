package napoleoninhauta.pakka;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttiTest {

    private Kortti kortti1;
    private Kortti kortti2;

    @Before
    public void setUp() {
        this.kortti1 = new Kortti(2, Maa.RISTI);
        this.kortti2 = new Kortti(3, Maa.PATA);
    }

    @Test
    public void palautaMaaToimii() {
        assertEquals(Maa.PATA, kortti2.getMaa());
        assertEquals(Maa.RISTI, kortti1.getMaa());
    }

    @Test
    public void palautaArvoToimii() {
        assertEquals(3, kortti2.getArvo());
        assertEquals(2, kortti1.getArvo());
    }

    @Test
    public void toStringToimii() {
        assertEquals("PATA_3", kortti2.toString());
        assertEquals("RISTI_2", kortti1.toString());
    }
    
    @Test
    public void equalsEiToimiPelkanMaanPerusteella() {
        Kortti kortti = new Kortti(1, Maa.PATA);
        assertFalse(kortti.equals(kortti2));
    }
    
    @Test
    public void equalsEiToimiPelkanArvonPerusteella() {
        Kortti kortti = new Kortti(2, Maa.PATA);
        assertFalse(kortti.equals(kortti1));
    }
    
    @Test
    public void equalsToimiiMaanJaArvonPerusteella() {
        Kortti kortti = new Kortti(2, Maa.RISTI);
        assertTrue(kortti.equals(kortti1));
    }

    @After
    public void tearDown() {
    }

}
