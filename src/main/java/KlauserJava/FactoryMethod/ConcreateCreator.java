package KlauserJava.FactoryMethod;

public class ConcreateCreator extends Creator{
    @Override
    protected Product factoryMethod(){
        return new ConcreateProduct();
    }

}
