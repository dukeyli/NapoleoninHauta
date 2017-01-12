
package napoleoninhauta.logiikka.pinot;

import napoleoninhauta.logiikka.pinot.Pelipakka;
import java.util.ArrayList;
import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import napoleoninhauta.pakka.PakanLuoja;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PakkaTest {
    
    private Pelipakka pakka;
    private PakanLuoja luoja;
    
    @Before
    public void setUp() {
        this.luoja = new PakanLuoja();
        this.pakka = new Pelipakka(luoja.alustaPakka());
    }
    
    @Test
    public void pakkaLuodaanJaSenKokoOnOikea() {
        assertEquals(52, pakka.palautaMaara());
    }
    
    @Test
    public void nostaKorttiVahentaaPakanKokoaYhdella() {
        pakka.nostaKortti();
        assertEquals(51, pakka.palautaMaara());
    }
    
    @Test
    public void nostaKorttiPalauttaaKortin() {
        assertTrue(pakka.nostaKortti().getClass()==Kortti.class);
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
        assertTrue(yhdenKortinPakka.palautaMaara()==0);
    }
    
    @After
    public void tearDown() {
    }
}
