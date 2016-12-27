package napoleoninhauta.pasianssi.pakka;

import java.util.Objects;

public class Kortti {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + " " + arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    @Override
    public boolean equals(Object o) {
        Kortti kortti = (Kortti) o;
        if (kortti.getArvo() == this.arvo && kortti.getMaa().equals(this.maa)) {
            return true;
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