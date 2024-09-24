package KlauserJava.Enumeration;

public class Main {
    public static void main(String[] args) {
        Country country = Country.getRandow();
        Country de = Country.getDefault();
        System.out.println(country);
        System.out.println(de);
        Country uk = Country.UK;
        System.out.println(uk);
    }
}
