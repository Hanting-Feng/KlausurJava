package KlauserJava.Serialisieren;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialisierenMain {
    public static void main(String[] args) {
        List<KinderSerialisieren> kinder = new ArrayList<>(List.of(new KinderSerialisieren("Feng1",10)));
        PersonSerialisieren personSerialisieren = new PersonSerialisieren("Feng",20,List.of("Benzin","Porsche"),kinder);
        // 把一个对象写进文件里
        try(
                var fos = new FileOutputStream("person.ser");
                var oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(personSerialisieren);
            oos.flush();
            System.out.println(personSerialisieren + "   " + "write" );

        }catch (Exception e){e.printStackTrace();}
        // 把一个文件里的内容读成对象
        try(
                var fis = new FileInputStream("person.ser");
                var ois = new ObjectInputStream(fis)
        ){
            PersonSerialisieren personSerialisieren1 = (PersonSerialisieren) ois.readObject();
            System.out.println(personSerialisieren1 + "   " + "read");
        }catch (Exception e){e.printStackTrace();}
        // 把对象写进xml文件里
        try(
                var fos = new FileOutputStream("person.xml");
                var encoder = new XMLEncoder(fos);
        ){
            encoder.writeObject(personSerialisieren);
            encoder.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        // 把xml文件读成对象
        try(
                var fis = new FileInputStream("person.xml");
                var decoder = new XMLDecoder(fis);
        ){
            var o = (PersonSerialisieren) decoder.readObject();
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}