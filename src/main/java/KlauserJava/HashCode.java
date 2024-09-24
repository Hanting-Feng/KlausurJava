package KlauserJava;

import java.util.ArrayList;
import java.util.List;

public class HashCode {
    public class Item{}
    private String item;
    private List<String> effects;
    private float number;

    @Override
    public int hashCode() {
        return 31 * item.hashCode() + effects.hashCode() + Float.hashCode(number);
    }

    public static void main(String[] args) {
        HashCode h = new HashCode();
        h.item = "AAA";
        //h.effects = new ArrayList<>(List.of("AAA"));
        h.effects = List.of("AAA");
        //h.effects = new ArrayList<>(List.of("BBB"));
        h.number = 18.0f;
        System.out.println(h.hashCode());
    }
}
