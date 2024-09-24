package KlauserJava.Serialisieren;

import java.io.Serializable;

public class KinderSerialisieren implements Serializable {
    private String name;
    private int alt;
    public KinderSerialisieren(){}
    @Override
    public String toString() {
        return "KinderSerialisieren{" +
                "name='" + name + '\'' +
                ", alt=" + alt +
                '}';
    }
    public KinderSerialisieren(String name, int alt){
        this.name = name;
        this.alt = alt;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int getAlt(){return alt;}
    public void setAlt(int alt){this.alt = alt;}
}
