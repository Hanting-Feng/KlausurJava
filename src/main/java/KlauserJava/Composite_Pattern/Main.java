package KlauserJava.Composite_Pattern;

public class Main {
    public static void main(String[] args) {
        File file1 = new File(1);
        File file2 = new File(5);
        Directory directory = new Directory();
        directory.add(file1);
        directory.add(file2);
        directory.getSize();
    }
}
