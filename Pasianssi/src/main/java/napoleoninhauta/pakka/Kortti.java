/**
 * Luokka määrittelee pelikortin, johon liittyy lukuarvo ja maa.
 */
package napoleoninhauta.pakka;

import java.util.Objects;

public class Kortti {

    private int arvo;
    private Maa maa;

    /**
     * Konstruktori asettaa parametrina annetut arvot attribuuttien arvoiksi.
     *
     * @param arvo kokonaisluku, joka kertoo kortin arvon
     * @param maa kortin maa
     */
    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + "_" + arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Kortti kortti = (Kortti) o;
            if (kortti.getArvo() == this.arvo && kortti.getMaa().equals(this.maa)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.arvo;
        hash = 89 * hash + Objects.hashCode(this.maa);
        return hash;
    }

}
