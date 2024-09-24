package KlauserJava.Kopie;

import java.util.ArrayList;
import java.util.List;

public class Person implements Cloneable{
    public String name;
    public int age;
    public List<Kind> kinds;
    public List<String> autos;
    public Person(String name, List<Kind> kinds,List<String> autos){
        this.name = name;
    }
    public Person(Person person){
        this.name = person.name;
        this.age = person.age;
        this.kinds = new ArrayList<>();
        for(Kind kind : person.kinds){
            this.kinds.add(new Kind(kind));
        }
        this.autos = new ArrayList<>(person.autos);
    }
    public Person clone(){
        try{
            Person person = (Person) super.clone();
            person.kinds = new ArrayList<>();
            for(Kind kind : this.kinds){
                person.kinds.add(kind.clone());
            }
            person.autos = new ArrayList<>(this.autos);
            return person;
        }catch (Exception e){
            throw new AssertionError();
        }
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) && (age == person.age) &&kinds.equals(person.kinds) && autos.equals(person.autos);
    }
    public int hashCode(){
        return 31 * name.hashCode() + Integer.hashCode(age) + kinds.hashCode() + autos.hashCode();
    }
}
