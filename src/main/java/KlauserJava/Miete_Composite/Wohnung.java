package KlauserJava.Miete_Composite;

public class Wohnung implements Immobilien{
    private double miete;
    private String address;
    public Wohnung(double miete,String address){
        this.miete = miete;
        this.address = address;
    }
    @Override
    public double getMiete() {
        return miete;
    }
    public void setMiete(double miete){this.miete = miete;}
}
