package KlauserJava.Miete_Composite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GesamtWohnung implements Immobilien{
    List<Immobilien> immobilienList = new ArrayList<>();
    public void add(Immobilien immobilien){
        if(!immobilienList.contains(immobilien)){
            immobilienList.add(immobilien);
        }
    }
    public void remove(Immobilien immobilien){
        immobilienList.remove(immobilien);
    }

    @Override
    public double getMiete() {
        double gesamtmiete = 0;
        for (Immobilien immobilien : immobilienList){
            gesamtmiete += immobilien.getMiete();
        }
        System.out.println("Gesamt" + gesamtmiete);
        return gesamtmiete;
    }
}
