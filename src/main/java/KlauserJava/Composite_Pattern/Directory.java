package KlauserJava.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component{
    private final List<Component> components = new ArrayList<>();
    public void add(Component c){
        if(! components.contains(c)){
            components.add(c);
        }

    }
    public void remove(Component c){
        components.remove(c);
    }
    @Override
    public int getSize() {
        int totalSize = 0;
        for(Component c : components){
            totalSize += c.getSize();
        }
        System.out.println(totalSize);
        return totalSize;
    }
}
