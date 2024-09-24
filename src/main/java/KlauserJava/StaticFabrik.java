package KlauserJava;

public class StaticFabrik {

    private final String type;
    private StaticFabrik(String type){
        this.type = type;
    }
    public static StaticFabrik createAuto(){
        return new StaticFabrik("Benzin");
    }
    public static StaticFabrik createFahren(){
        return new StaticFabrik("Fahren");
    }

    public static void main(String[] args) {
        System.out.println(StaticFabrik.createFahren());
        System.out.println(StaticFabrik.createAuto());
    }
}
