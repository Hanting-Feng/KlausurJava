package KlauserJava.FactoryMethod;

public abstract class Creator {
    protected abstract Product factoryMethod();
    public void anOPeration(){
        Product p = factoryMethod();
        p.use();
    }
}
