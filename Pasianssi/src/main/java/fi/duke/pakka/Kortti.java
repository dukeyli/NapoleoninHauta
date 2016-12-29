package fi.duke.pakka;

import java.util.Objects;

public class Kortti {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    public String toString() {
        return "Maa: " + maa + ", arvo: " + arvo;
    }

    public Maa palautaMaa() {
        return maa;
    }

    public int palautaArvo() {
        return arvo;
    }

    @Override
    public boolean equals(Object o) {
        Kortti kortti = (Kortti) o;
        if (kortti.palautaArvo() == this.arvo && kortti.palautaMaa().equals(this.maa)) {
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
