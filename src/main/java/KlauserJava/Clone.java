package KlauserJava;

import java.util.ArrayList;
import java.util.List;

public class Clone implements Cloneable{
    @Override
    public String toString() {
        return "Clone{" +
                "value=" + value +
                ", listClone=" + listClone +
                '}';
    }

    private int value;
    private List<String> listClone;
    public Clone(){}
    public Clone(Clone clone){
        this.value = clone.value;
        this.listClone = new ArrayList<>();
        for(String a : clone.listClone){
            this.listClone.add(new String(a));
        }
    }

    public boolean equals(Object o){
        if(this == o){return true;}
        if(!(o instanceof Clone)){
            return false;
        }
        Clone clone = (Clone) o;
        return value == clone.value && listClone.equals(clone.listClone);
    }
    @Override
    public Clone clone(){
        try{
            Clone clone = (Clone) super.clone();
            clone.listClone = new ArrayList<>();
            for(String c : listClone){
                clone.listClone.add(c);
            }
            return clone;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
    public static void main(String[] args){
        Clone clone = new Clone();
        clone.listClone = List.of("7777777777");
        Clone clone1 = new Clone(clone);
        System.out.println(clone1);
        System.out.println(clone.equals(clone1));
        clone.listClone = List.of("1234567");
        System.out.println(clone.listClone);
        System.out.println(clone.clone());
    }
}
