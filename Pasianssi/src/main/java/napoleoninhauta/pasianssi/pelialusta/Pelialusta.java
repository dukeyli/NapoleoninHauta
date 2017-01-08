
package napoleoninhauta.pasianssi.pelialusta;

import napoleoninhauta.pasianssi.pakka.Kortti;

public class Pelialusta {
    
    private Jemmat jemmat;
    private Kulmapinot kulmapinot;
    private PelialustanMuutPinot muut;
    
    public Pelialusta() {
        this.jemmat=new Jemmat();
        this.kulmapinot = new Kulmapinot();
        this.muut = new PelialustanMuutPinot();
    }
    
    public Jemmat palautaJemmat() {
        return this.jemmat;
    }
    
    public Kulmapinot palautaKulmapinot() {
        return this.kulmapinot;
    }
    
    public PelialustanMuutPinot palautaMuut() {
        return this.muut;
    }
    
    public void nostaKorttiPakasta() {
        Kortti kortti = muut.palautaPelipakka().nostaKortti();
        muut.palautaPelipino().asetaKortti(kortti);
    }
    
}
