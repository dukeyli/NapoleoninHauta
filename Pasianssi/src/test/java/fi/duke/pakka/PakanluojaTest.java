package fi.duke.pakka;

import fi.duke.pakka.Kortti;
import fi.duke.pakka.PakanLuoja;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class PakanluojaTest {

    private PakanLuoja luoja;

    @Before
    public void setUp() {
        this.luoja = new PakanLuoja();
    }

    @Test
    public void alustaPakkaLisaaPakkaan52Korttia() {
        assertEquals(52, luoja.alustaPakka().size());
    }

    @Test
    public void pakassaEiOleDuplikaatteja() {
        ArrayList<Kortti> testilista = new ArrayList();
        for (Kortti kortti : luoja.alustaPakka()) {
            if (!testilista.contains(kortti)) {
                testilista.add(kortti);
            }
        }
        assertEquals(52, testilista.size());
    }

    @Test
    public void pakkaEiOleJarjestyksessa() {
        ArrayList<Kortti> kortit = luoja.alustaPakka();
        assertFalse(1 == kortit.get(0).palautaArvo()
                && 2 == kortit.get(1).palautaArvo()
                && 3 == kortit.get(2).palautaArvo()
                && 4 == kortit.get(3).palautaArvo()
                && 5 == kortit.get(4).palautaArvo());
    }

    @Test
    public void pakkaVoidaanAlustaaMonestiMuuttamattaKorttienMaaraa() {
        luoja.alustaPakka();
        luoja.alustaPakka();
        assertEquals(52, luoja.alustaPakka().size());
    }

    @Test
    public void pakkaSekoitetaanJokaisellaAlustuksella() {
        ArrayList<Kortti> kortit = luoja.alustaPakka();
        assertFalse(kortit.get(0) == luoja.alustaPakka().get(0)
                && kortit.get(1) == luoja.alustaPakka().get(1)
                && kortit.get(2) == luoja.alustaPakka().get(2)
                && kortit.get(3) == luoja.alustaPakka().get(3)
                && kortit.get(4) == luoja.alustaPakka().get(4));
    }

    @After
    public void tearDown() {
    }
}
