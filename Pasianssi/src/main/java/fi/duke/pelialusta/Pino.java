package fi.duke.pelialusta;

import java.util.ArrayList;
import fi.duke.pakka.Kortti;

public abstract class Pino {

    private ArrayList<Kortti> kortit;

    public Pino() {
        this.kortit = new ArrayList();
    }

    public ArrayList<Kortti> palautaKortit() {
        return this.kortit;
    }

    public abstract void asetaKortti(Kortti kortti);

    public Kortti palautaYlin() {
        if (!kortit.isEmpty()) {
            return this.kortit.get(0);
        }
        return null;
    }

    public int palautaMaara() {
        return this.kortit.size();
    }

}
