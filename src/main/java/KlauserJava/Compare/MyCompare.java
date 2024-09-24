package KlauserJava.Compare;

import java.util.Comparator;

public class MyCompare implements Comparator<MyCompare> {
    String name;
    int age;
    @Override
    public int compare(MyCompare o1, MyCompare o2) {
        int n = o1.name.compareTo(o2.name);
        if(n == 0){
            n = Integer.compare(o1.age,o2.age);
        }
        return n;
    }
}
