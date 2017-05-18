package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Solution n) {
//        return n.first.equals(this.first) && n.last.equals(this.last);
//    }

    public int hashCode() {
        return ((first==null) ? 0 : first.hashCode()) + ((last==null) ? 0 : last.hashCode());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (!obj.getClass().equals(this.getClass()))
            return false;

        Solution n = (Solution) obj;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", null));
        System.out.println(s.contains(new Solution("Donald", null)));
    }
}
