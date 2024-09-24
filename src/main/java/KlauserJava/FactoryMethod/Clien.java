package KlauserJava.FactoryMethod;

public class Clien {
    public static void main(String[] agrs){
        Creator creator = new ConcreateCreator();
        creator.anOPeration();
    }
}
