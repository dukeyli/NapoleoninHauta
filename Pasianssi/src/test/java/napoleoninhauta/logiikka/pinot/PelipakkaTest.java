package napoleoninhauta.logiikka.pinot;

import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import napoleoninhauta.pakka.PakanLuoja;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PelipakkaTest {

    private Pelipakka pakka;
    private PakanLuoja luoja;

    @Before
    public void setUp() {
        this.luoja = new PakanLuoja();
        this.pakka = new Pelipakka(luoja.alustaPakka());
    }

    @Test
    public void pakkaLuodaanJaSenKokoOnOikea() {
        assertEquals(52, pakka.getMaara());
    }

    @Test
    public void nostaKorttiVahentaaPakanKokoaYhdella() {
        pakka.nostaKortti();
        assertEquals(51, pakka.getMaara());
    }

    @Test
    public void nostaKorttiPalauttaaKortin() {
        assertTrue(pakka.nostaKortti().getClass() == Kortti.class);
    }

    @Test
    public void nostaKorttiPalauttaaPaalimmaisenKortin() {
        ArrayList<Kortti> lista = new ArrayList();
        lista.add(new Kortti(1, Maa.HERTTA));
        Pelipakka yhdenKortinPakka = new Pelipakka(lista);
        assertEquals(new Kortti(1, Maa.HERTTA), yhdenKortinPakka.nostaKortti());
    }

    @Test
    public void nostaKorttiTyhjentaaPakanKunSiitaNostetaanViimeinenKortti() {
        ArrayList<Kortti> lista = new ArrayList();
        lista.add(new Kortti(1, Maa.HERTTA));
        Pelipakka yhdenKortinPakka = new Pelipakka(lista);
        yhdenKortinPakka.nostaKortti();
        assertTrue(yhdenKortinPakka.getMaara() == 0);
    }

    @Test
    public void nostaKorttiPalauttaaNullJosPakkaOnTyhja() {
        ArrayList<Kortti> lista = new ArrayList();
        Pelipakka tyhjaPakka = new Pelipakka(lista);
        assertTrue(tyhjaPakka.nostaKortti() == null);
    }

    @Test
    public void asetaKorttiAsettaaKortinPakkaan() {
        Pelipakka pelipakka = new Pelipakka(new ArrayList());
        pelipakka.asetaKortti(new Kortti(5, Maa.PATA));
        assertEquals(1, pelipakka.getMaara());
    }

    @Test
    public void asetaKorttiAsettaaKortinPakanPaallimmaiseksi() {
        Pelipakka pelipakka = new Pelipakka(new ArrayList());
        pelipakka.asetaKortti(new Kortti(5, Maa.PATA));
        assertEquals("PATA_5", pelipakka.nostaKortti().toString());
    }

    @Test
    public void alustaUusiPakkaAlustaaUudenPelipakan() {
        Pelipakka pelipakka = new Pelipakka(new ArrayList());
        pelipakka.alustaUusiPakka();
        assertEquals(52, pelipakka.getMaara());
    }

    @After
    public void tearDown() {
    }
}
