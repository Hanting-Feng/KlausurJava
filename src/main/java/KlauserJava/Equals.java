package KlauserJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Equals {
    class SpecialEffect{
        private String name;
        private float factor;
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof SpecialEffect)) return false;
            SpecialEffect sp = (SpecialEffect) o;
            return name.equals(sp.name) && (factor == sp.factor); // String 类型用equals, float 用 ==
        }

    }
    public static void main(String[] args){
        String s1= "AAA";
        String s2 = "AAA";
        String s3 = new String("AAA");
        String s4 = new String("AAA");
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));
    }
}
