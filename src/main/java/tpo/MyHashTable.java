package tpo;

import javax.swing.plaf.PanelUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashTable {
    private List<Integer>[] innerShit = new List[13];

    public MyHashTable() {
        for (int i = 0; i < innerShit.length; ++i) {
            innerShit[i] = new ArrayList<>();
        }
    }
    public void addElem(Integer elem) {
        innerShit[elem % innerShit.length].add(elem);
    }

    public boolean findElem(Integer elem) {
        for (Integer ob : innerShit[elem % innerShit.length]) {
            if (ob.equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteElem(Integer elem) {
        if (innerShit[elem % innerShit.length].contains(elem)) {
            innerShit[elem % innerShit.length].remove(elem);
            return true;
        }
        return false;
    }

    public int getCountOfElems() {
        int result = 0;
        for (int i = 0; i < innerShit.length; ++i) {
            result += innerShit[i].size();
        }
        return result;
    }

    public void printStruct() {
        Integer[] sizes = new Integer[innerShit.length];
        int max = 0;
        for (int i = 0; i < innerShit.length; i++) {
            sizes[i] = innerShit[i].size();
            max = Math.max(max, sizes[i]);
        }

        for (int si = max; si > 0; si--) {
            System.out.print(si + " >>> |");
            for (int i = 0; i < innerShit.length; i++) {
                if (innerShit[i].size() >= si) {
                    System.out.print(rjust(innerShit[i].get(si-1).toString(), 8, ' '));
                } else {
                    System.out.print(rjust("", 8, ' '));
                }
            }
            System.out.println();
        }
        System.out.print("------+" + rjust("", innerShit.length * 8, '-'));
        System.out.println();
        System.out.print("      |");
        for (int i = 0; i < innerShit.length; i++) {
            System.out.print(rjust("↑", 8, ' '));
        }
        System.out.println();
        System.out.print("%13 = |");
        for (Integer i = 0; i < innerShit.length; i++) {
            System.out.print(rjust(i.toString(), 8, ' '));
        }
        System.out.println();

    }

    public static String rjust(String text, int width, char fillChar) {
        if (text.length() >= width) {
            return text;
        }

        String padding = new String(new char[width - text.length()]).replace('\0', fillChar);

        return padding + text;
    }

    public List<Integer> getBasketContent(int basketNum) {
        if (basketNum < 0 || basketNum > innerShit.length) {
            return null;
        }
        return new ArrayList<>(innerShit[basketNum]);
    }

}
