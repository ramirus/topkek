package kek;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("1");
        strings.add("dva");
        strings.add("3");
        strings.add("chetire");
        strings.add("5");
        strings.add("wectb");
        List<String> newList = strings
                .stream()
                .filter(string -> {
                    if (string.length()) {

                    }
                    return list;
                })
                .collect(Collectors.toList());
        System.out.println(newList);
        System.out.println("-__-");
        List<Integer> newList2 = strings
                .stream()
                .map(string -> {
                    int sum = 0;
                    if (Character.isDigit(string.charAt(0))) {
                        sum = string.charAt(0);
                    } else {
                        sum = string.length();
                    }
                    return sum;
                })
                .collect(Collectors.toList());
        System.out.println(newList2);
        System.out.println("-__-");
        List<String> newList3 = strings
                .stream()
                .sorted((string1, string2) -> string1.compareTo(string2))
                .collect(Collectors.toList());
        System.out.println(newList3);
    }
}
