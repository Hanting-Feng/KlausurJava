package KlauserJava.Miete_Composite;

public class Haus implements Immobilien{
    private double miete;
    private String address;
    public Haus(double miete,String address){
        this.miete = miete;
        this.address = address;
    }
    @Override
    public double getMiete() {
        return miete;
    }
    public void setMiete(double miete){
        this.miete = miete;
    }
}
