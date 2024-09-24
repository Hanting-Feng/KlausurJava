package KlauserJava.Compare;

public class MyCompareTo implements Comparable<MyCompareTo>{
    private String name;
    private int age;
    @Override
    public int compareTo(MyCompareTo o) {
        int n = this.name.compareTo(o.name);
        if(n == 0){
            n = (this.age - o.age);
        }
        return n; //先按名字排序
    }
}
