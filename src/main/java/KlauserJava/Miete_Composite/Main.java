package KlauserJava.Miete_Composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Haus haus = new Haus(1700.0,"Sternbuschweg 33");
        Wohnung wohnung = new Wohnung(330.0,"Oststraße 170");
        doppeltWohnung doppeltWohnung = new doppeltWohnung(550.0,"Sternbuschweg 102");
        GesamtWohnung gesamtWohnung = new GesamtWohnung();
        gesamtWohnung.add(haus);
        gesamtWohnung.add(wohnung);
        gesamtWohnung.add(wohnung);
        gesamtWohnung.add(doppeltWohnung);
        gesamtWohnung.getMiete();
    }
}
