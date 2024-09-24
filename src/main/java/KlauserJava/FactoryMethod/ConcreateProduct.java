package KlauserJava.FactoryMethod;

public class ConcreateProduct extends Product{
    @Override
    protected void use(){
        System.out.println("createProduct");
    }
}
