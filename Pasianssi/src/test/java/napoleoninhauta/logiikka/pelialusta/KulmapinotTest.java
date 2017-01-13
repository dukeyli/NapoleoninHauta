package napoleoninhauta.logiikka.pelialusta;

import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KulmapinotTest {

    private Kulmapinot pinot;
    private Kortti kortti;

    @Before
    public void setUp() {
        this.pinot = new Kulmapinot();
        this.kortti = new Kortti(7, Maa.HERTTA);
    }

    @Test
    public void konstruktoriLuoNeljaTyhjaaKulmapinoaJaGetteritToimii() {
        assertEquals(7, this.pinot.getKaakko().getArvo());
        assertEquals(7, this.pinot.getKoillinen().getArvo());
        assertEquals(7, this.pinot.getLounas().getArvo());
        assertEquals(7, this.pinot.getLuode().getArvo());
    }

    @Test
    public void laitaKorttiSopivaanPinoonPalauttaaFalseJosKorttiEiSoviMihinkaanPinoon() {
        assertFalse(pinot.laitaKorttiSopivaanPinoon(new Kortti(5, Maa.PATA)));
    }

    @Test
    public void laitaKorttiSopivaanPinoonLaittaaKortinEnsisijaisestiLuoteeseen() {
        pinot.laitaKorttiSopivaanPinoon(kortti);
        assertEquals("HERTTA_7", pinot.getLuode().getYlin());
    }

    @Test
    public void laitaKorttiSopivaanPinoonPalauttaaTrueJosKorttiMeneeLuoteeseen() {
        assertTrue(pinot.laitaKorttiSopivaanPinoon(kortti));
    }

    @Test
    public void laitaKorttiSopivaanPinoonLaittaaKortinToissijaisestiKoilliseen() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        pinot.laitaKorttiSopivaanPinoon(kortti);
        assertEquals("HERTTA_7", pinot.getKoillinen().getYlin());
    }

    @Test
    public void laitaKorttiSopivaanPinoonPalauttaaTrueJosKorttiMeneeKoilliseen() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        assertTrue(pinot.laitaKorttiSopivaanPinoon(kortti));
    }

    @Test
    public void laitaKorttiSopivaanPinoonLaittaaKortinKolmantenaVaihtoehtonaKaakkoon() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RISTI));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        pinot.laitaKorttiSopivaanPinoon(kortti);
        assertEquals("HERTTA_7", pinot.getKaakko().getYlin());
    }

    @Test
    public void laitaKorttiSopivaanPinoonPalauttaaTrueJosKorttiMeneeKaakkoon() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RISTI));
        assertTrue(pinot.laitaKorttiSopivaanPinoon(kortti));
    }

    @Test
    public void laitaKorttiSopivaanPinoonLaittaaKortinNeljantenaVaihtoehtonaLounaaseen() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RUUTU));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RISTI));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        pinot.laitaKorttiSopivaanPinoon(kortti);
        assertEquals("HERTTA_7", pinot.getLounas().getYlin());
    }

    @Test
    public void laitaKorttiSopivaanPinoonPalauttaaTrueJosKorttiMeneeLounaaseen() {
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RUUTU));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.PATA));
        pinot.laitaKorttiSopivaanPinoon(new Kortti(7, Maa.RISTI));
        assertTrue(pinot.laitaKorttiSopivaanPinoon(kortti));
    }

    @Test
    public void palautaArvotPalauttaaKulmapinojenArvot() {
        ArrayList<Integer> oletuslista = new ArrayList();
        oletuslista.add(7);
        oletuslista.add(7);
        oletuslista.add(7);
        oletuslista.add(8);
        pinot.laitaKorttiSopivaanPinoon(kortti);
        assertTrue(oletuslista.containsAll(pinot.getArvot()));
    }

    @Test
    public void kaikkiLapiPalauttaaTrueJosKaikkissaPinoissaOnKaikkiVaaditutKortit() {
        int i = 0;
        while (i < 4) {
            int y = 7;
            while (y < 14) {
                pinot.laitaKorttiSopivaanPinoon(new Kortti(y, Maa.PATA));
                y++;
            }
            i++;
        }
        assertTrue(pinot.kaikkiLapi());
    }

    @Test
    public void kaikkiLapiPalauttaaFalseMuuten() {
        assertFalse(pinot.kaikkiLapi());
        int i = 0;
        while (i < 3) {
            int y = 7;
            while (y < 14) {
                pinot.laitaKorttiSopivaanPinoon(new Kortti(y, Maa.PATA));
                y++;
            }
            i++;
        }
        assertFalse(pinot.kaikkiLapi());
    }

    @After
    public void tearDown() {
    }

}