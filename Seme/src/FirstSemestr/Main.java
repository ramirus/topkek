package FirstSemestr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyLinkedList2 list1;
        MyLinkedList2 list2;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int[] arr1 = new int[10];
        System.out.println("введите первый массив");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("введите второй массив");
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = sc.nextInt();
        }
        list1 = new MyLinkedList2(arr);
        list1.show();
        System.out.println(" ");
        list2 = new MyLinkedList2(arr1);
        list2.show();
        System.out.println(" ");
        list1.delete(43);
        System.out.println("удаление элемента ");
        list1.show();
        System.out.println(" ");
        list1.maxNum();
        MyLinkedList2 myLinked = list1.merge(list2);
        System.out.println("соединение:");
        myLinked.show();
        System.out.println(" ");
        list1.insert(12);
        System.out.println("добавление элемента: ");
        list1.show();
        MyLinkedList2 myLinkedList[] = list2.divide();
        System.out.println("");
        System.out.println("Разбитие");
        myLinkedList[0].show();
        myLinkedList[1].show();
        MyLinkedList2 newlist=list2.newList();
        System.out.println(" ");
        System.out.println("Новый лист");
        newlist.show();


    }
}
