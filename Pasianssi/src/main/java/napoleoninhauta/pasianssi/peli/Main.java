package napoleoninhauta.pasianssi.peli;

import javax.swing.SwingUtilities;
import napoleoninhauta.pasianssi.pelialusta.Jemmat;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

//        Jemmat jemmat = new Jemmat();
//        System.out.println(jemmat.onkoKaikkiJemmatTaynna());
    }

}
