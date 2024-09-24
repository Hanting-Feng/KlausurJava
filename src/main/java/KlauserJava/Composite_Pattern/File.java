package KlauserJava.Composite_Pattern;

public class File implements Component{
    int size;
    public File(int size){this.size = size;}
    @Override
    public int getSize() {
        return size;
    }
}
