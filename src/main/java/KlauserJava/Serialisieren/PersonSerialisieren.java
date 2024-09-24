package KlauserJava.Serialisieren;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonSerialisieren implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int alt;
    private transient List<String> autos; // List 不需要深度序列化，只有List里类型也是类才需要
    private transient List<KinderSerialisieren> kind;
    public PersonSerialisieren(){}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}


    @Override
    public String toString() {
        return "PersonSerialisieren{" +
                "name='" + name + '\'' +
                ", alt=" + alt +
                ", autos=" + autos +
                ", kind=" + kind +
                '}';
    }

    public PersonSerialisieren(String name, int alt, List<String> autos, List<KinderSerialisieren> kind){
        this.name = name;
        this.alt = alt;
        this.autos = autos;
        this.kind = kind;
    }
    private void writeObject(ObjectOutputStream oos) throws Exception{
        oos.defaultWriteObject();
        oos.writeInt(alt);
        oos.writeObject(autos);
        oos.writeInt(kind.size());
        for(KinderSerialisieren kinderSerialisieren : kind){
            oos.writeObject(kinderSerialisieren);
        }
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        alt = ois.readInt();
        autos = (List<String>) ois.readObject();
        kind = new ArrayList<>();
        int size = ois.readInt();
        for(int i = 0; i < size; i++){
            kind.add((KinderSerialisieren) ois.readObject());
        }
    }
}
