package DOMAWKA;

import gig.ArrayList;
import gig.List;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.lang.ExceptionInInitializerError;
import java.util.Scanner;

public class Compiler {
    public static class Variable {
        private String st;
        private Number in;

        public Variable(String st, Number in) {
            this.st = st;
            this.in = in;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public Number getIn() {
            return in;
        }

        public void setIn(Number in) {
            this.in = in;
        }
    }

    public static void analyse(String input) {
        char[] toChar = input.toCharArray();
        int length = toChar.length;
        int state = 0;
        try {
            for (int c = 0; c < length; c++) {
                switch (state) {
                    case 0:
                        if (Character.isLetter(toChar[c++]) && Character.isDigit(toChar[c++])
                                && toChar[c++] == ':' && toChar[c] == '=') {
                            state++;
                            break;
                        } else {
                            throw new SyntaxException("ой");
                        }
                    case 1:
                        if (Character.isDigit(toChar[c]) || (toChar[c] == '-')) {
                            while (Character.isDigit(toChar[c + 1])) {
                                c++;
                            }
                            break;
                        }
                        if (Character.isLetter(toChar[c]) && Character.isDigit(toChar[c + 1])) {
                            c++;
                            break;
                        }
                        if ("+-/*".indexOf(toChar[c]) >= 0 && "+-/*".indexOf(toChar[c + 1]) < 0) {
                            break;
                        }
                        if (toChar[c] == ';') {
                            if (c == length - 1) {
                                state = -1;
                                System.out.println("нормальная строка");
                                break;
                            } else {
                                state = 0;
                                break;
                            }
                        }
                        throw new SyntaxException("ой");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SyntaxException("да все норм");
        }
    }

    public static List process(String input) {
        String[] strings = input.split(";");
        List<Variable> list = new ArrayList<>();
        if (input.length() > 4) {
            for (String a : strings) {
                int i = 0, state = 0;
                String name = "";
                switch (state) {
                    case 0:
                        try {
                            analyse(a);
                        } catch (SyntaxException e) {
                            continue;
                        }
                        a = a.trim();
                        if (Character.isLetter(a.charAt(i))) {
                            name += a.charAt(i);
                            i++;
                        }
                        while (a.charAt(i) != '=') {
                            name += a.charAt(i);
                            i++;
                        }
                        if (a.charAt(i) == '=') i++;
                    case 1:
                        String str = a.substring(i, a.length());
                        int arc;
                        try {
                            arc = Integer.parseInt(str);
                        } catch (NumberFormatException e) {
                            throw new ExceptionInInitializerError();
                        }
                        list.add(new Variable(name, arc));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        analyse(st);
        process(st);
    }
}
