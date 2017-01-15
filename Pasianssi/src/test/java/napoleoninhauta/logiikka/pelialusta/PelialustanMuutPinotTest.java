package napoleoninhauta.logiikka.pelialusta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelialustanMuutPinotTest {

    private PelialustanMuutPinot muutpinot;

    @Before
    public void setUp() {
        this.muutpinot = new PelialustanMuutPinot();
    }

    @Test
    public void konstruktoriLuoMuutPinotJaGetteritToimii() {
        assertEquals(0, muutpinot.getPelipino().getMaara());
        assertEquals(6, muutpinot.getKeskipino().getArvo());
        assertEquals(52, muutpinot.getPelipakka().getMaara());
        assertEquals("tyhja", muutpinot.getKuutosJemma().getYlin());
    }

    @After
    public void tearDown() {
    }

}
