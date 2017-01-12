package napoleoninhauta.logiikka.pelialusta;

import napoleoninhauta.pakka.Kortti;
import napoleoninhauta.pakka.Maa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JemmatTest {

    private Jemmat jemmat;
    private Kortti testikortti;

    @Before
    public void setUp() {
        jemmat = new Jemmat();
        testikortti = new Kortti(6, Maa.PATA);
    }

    @Test
    public void jemmatLuoNeljaTyhjaaYhdenKortinJemmaaJaGetteritToimii() {
        assertEquals(null, jemmat.getEtela().otaKortti());
        assertEquals(null, jemmat.getIta().otaKortti());
        assertEquals(null, jemmat.getLansi().otaKortti());
        assertEquals(null, jemmat.getPohjoinen().otaKortti());
    }

    @Test
    public void onkoKaikkiJemmatTaynnaPalauttaaFalseJosPohjoinenOnTyhja() {
        jemmat.getEtela().asetaKortti(new Kortti(2, Maa.RISTI));
        jemmat.getIta().asetaKortti(testikortti);
        jemmat.getLansi().asetaKortti(testikortti);
        assertFalse(jemmat.onkoKaikkiJemmatTaynna());
    }

    @Test
    public void onkoKaikkiJemmatTaynnaPalauttaaFalseJosLansiOnTyhja() {
        jemmat.getEtela().asetaKortti(new Kortti(2, Maa.RISTI));
        jemmat.getIta().asetaKortti(testikortti);
        jemmat.getPohjoinen().asetaKortti(testikortti);
        assertFalse(jemmat.onkoKaikkiJemmatTaynna());
    }

    @Test
    public void onkoKaikkiJemmatTaynnaPalauttaaFalseJosItaOnTyhja() {
        jemmat.getEtela().asetaKortti(new Kortti(2, Maa.RISTI));
        jemmat.getPohjoinen().asetaKortti(testikortti);
        jemmat.getLansi().asetaKortti(testikortti);
        assertFalse(jemmat.onkoKaikkiJemmatTaynna());
    }

    @Test
    public void onkoKaikkiJemmatTaynnaPalauttaaFalseJosEtelaOnTyhja() {
        jemmat.getPohjoinen().asetaKortti(new Kortti(2, Maa.RISTI));
        jemmat.getIta().asetaKortti(testikortti);
        jemmat.getLansi().asetaKortti(testikortti);
        assertFalse(jemmat.onkoKaikkiJemmatTaynna());
    }

    @Test
    public void onkoKaikkiJemmatTaynnaPalauttaaTrueJosKaikkiJemmatTaynna() {
        jemmat.getIta().asetaKortti(testikortti);
        jemmat.getLansi().asetaKortti(testikortti);
        jemmat.getEtela().asetaKortti(testikortti);
        jemmat.getPohjoinen().asetaKortti(testikortti);
        assertTrue(jemmat.onkoKaikkiJemmatTaynna());
    }

    @Test
    public void laitaTyhjaanJemmaanLaittaaKortinEnsisijaisestiLansijemmaan() {
        jemmat.laitaTyhjaanJemmaan(testikortti);
        assertEquals("PATA_6", jemmat.getLansi().getKortti());
    }

    @Test
    public void laitaTyhjaanJemmaanPalauttaaTrueJosKorttiLaitetaanLansiJemmaan() {
        assertTrue(jemmat.laitaTyhjaanJemmaan(testikortti));
    }

    @Test
    public void laitaTyhjaanJemmaanLaittaaKortinToissijaisestiPohjoisJemmaan() {
        jemmat.laitaTyhjaanJemmaan(testikortti);
        jemmat.laitaTyhjaanJemmaan(new Kortti(1, Maa.PATA));
        assertEquals("PATA_1", jemmat.getPohjoinen().getKortti());
    }

    @Test
    public void laitaTyhjaanJemmaanPalauttaaTrueJosKorttiLaitetaanPohjoinenJemmaan() {
        jemmat.laitaTyhjaanJemmaan(new Kortti(5, Maa.PATA));
        assertTrue(jemmat.laitaTyhjaanJemmaan(testikortti));
    }

    @Test
    public void laitaTyhjaanJemmaanLaittaaKolmantenaVaihtoehtonaItaJemmaan() {
        jemmat.laitaTyhjaanJemmaan(testikortti);
        jemmat.laitaTyhjaanJemmaan(new Kortti(7, Maa.RISTI));
        jemmat.laitaTyhjaanJemmaan(new Kortti(1, Maa.PATA));
        assertEquals("PATA_1", jemmat.getIta().getKortti());
    }

    @Test
    public void laitaTyhjaanJemmaanPalauttaaTrueJosKorttiLaitetaanItaJemmaan() {
        jemmat.laitaTyhjaanJemmaan(new Kortti(5, Maa.PATA));
        jemmat.laitaTyhjaanJemmaan(new Kortti(2, Maa.RUUTU));
        assertTrue(jemmat.laitaTyhjaanJemmaan(testikortti));
    }

    @Test
    public void laitaTyhjaanJemmaanLaittaaNeljantenaVaihtoehtonaEtelaJemmaan() {
        jemmat.laitaTyhjaanJemmaan(testikortti);
        jemmat.laitaTyhjaanJemmaan(new Kortti(7, Maa.RISTI));
        jemmat.laitaTyhjaanJemmaan(new Kortti(8, Maa.RISTI));
        jemmat.laitaTyhjaanJemmaan(new Kortti(1, Maa.PATA));
        assertEquals("PATA_1", jemmat.getEtela().getKortti());
    }

    @Test
    public void laitaTyhjaanJemmaanPalauttaaTrueJosKorttiLaitetaanEtelaJemmaan() {
        jemmat.laitaTyhjaanJemmaan(new Kortti(5, Maa.PATA));
        jemmat.laitaTyhjaanJemmaan(new Kortti(2, Maa.RUUTU));
        jemmat.laitaTyhjaanJemmaan(new Kortti(12, Maa.HERTTA));
        assertTrue(jemmat.laitaTyhjaanJemmaan(testikortti));
    }

    @Test
    public void laitaTyhjaanPalauttaaFalseJosJemmatOnTaynna() {
        jemmat.laitaTyhjaanJemmaan(testikortti);
        jemmat.laitaTyhjaanJemmaan(new Kortti(7, Maa.RISTI));
        jemmat.laitaTyhjaanJemmaan(new Kortti(8, Maa.RISTI));
        jemmat.laitaTyhjaanJemmaan(new Kortti(1, Maa.PATA));
        assertFalse(jemmat.laitaTyhjaanJemmaan(new Kortti(8, Maa.HERTTA)));
    }

    @After
    public void tearDown() {
    }

}
