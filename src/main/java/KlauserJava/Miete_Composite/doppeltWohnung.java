package KlauserJava.Miete_Composite;

public class doppeltWohnung implements Immobilien{
    private double miete;
    private String address;
    public doppeltWohnung(double miete,String address){
        this.miete = miete;
        this.address = address;
    }
    @Override
    public double getMiete() {
        return miete;
    }
    public void setMiete(double miete){this.miete = miete;}
}
