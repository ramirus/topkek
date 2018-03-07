package FirstSemestr;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class MyLinkedList2 implements List {

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    private int count;

    public MyLinkedList2() {
        this.count = 0;
    }

    @Override
    public int indexOf(int element) {
        Node newNode = head;
        for (int i = 0; i < count; i++) {
            if (head.value == element) {
                return i;
            }
            newNode = newNode.next;
        }
        return 0;
    }

    @Override
    public void insert(int k) {
        //addToBegin
        Node newNode = new Node(k);
        newNode.next = head;
        head = newNode;
        count++;
    }

    @Override
    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void add(int element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public MyLinkedList2[] divide() {
        MyLinkedList2 list[] = new MyLinkedList2[2];
        list[0] = new MyLinkedList2();
        list[1] = new MyLinkedList2();
        Node current = head;
        int n = 10;
        for (int i = 0; i < n; i++) {
            int k = current.value;
            if (current.value % 3 == 0) {
                list[0].add(k);
            } else {
                list[1].add(k);
            }
            current = current.next;
        }
        return list;
    }

    public MyLinkedList2 merge(MyLinkedList2 linkedlist2) {
        MyLinkedList2 result = new MyLinkedList2();
        if (head == null && linkedlist2.head == null) {
            System.out.println("псс, подумай");
        }
        if (head == null) return linkedlist2;
        if (linkedlist2.head == null) {
            Node node = head;
            while (node.next != null) {
                int current = node.value;
                result.add(current);
                node = node.next;
            }
        }
        Node node1 = head;
        while (node1.next != null) {
            int current = node1.value;
            result.add(current);
            node1 = node1.next;
        }
        if (linkedlist2.head != null) {
            Node newnode = linkedlist2.head;
            while (newnode.next != null) {
                int current = newnode.value;
                result.add(current);
                newnode = newnode.next;
            }
        }
        return result;
    }

    public MyLinkedList2(int[] arr) {
        //сортировка массива
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int max = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = max;
                }
            }
        }
        MyLinkedList2 list = new MyLinkedList2();
        for (int anArr : arr) {
            list.add(anArr);
        }
        head = list.head;
        tail = list.tail;
    }

    public int maxNum() {
        int lot = 0;
        int lot2 = 0;
        Node loot = head;
        while (loot.next != null) {
            Node loot2 = head;
            while (loot2.next != null) {
                if (loot.value == loot2.value) {
                    lot++;
                }
                loot2 = loot2.next;
            }
            if (lot >= lot2) {
                lot2 = lot;
            }
            lot = 0;
            loot = loot.next;
        }
        System.out.println("максимальное число одинаковых:" + lot2);
        return lot2;
    }

    public void decode() {
        File setFile = new File("file.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(setFile.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Node newNode = head;
        while (newNode.next != null) {
            if (out != null) {
                out.write(newNode.value + " ");
            }
            newNode = newNode.next;
        }
    }

    @Override
    public void show() {
        Node newNode = head;
        while (newNode != null) {
            System.out.print(newNode.value + " ");
            newNode = newNode.next;
        }
    }

    @Override
    public void delete(int k) {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            count = 0;
            return;
        }
        if (head.value == k) {
            head = head.next;
            return;
        }
        Node newNode = head;
        while (newNode.next != null) {
            if (newNode.next.value == k) {
                if (tail == newNode.next) {
                    tail = newNode;
                }
                newNode.next = newNode.next.next;
                return;
            }
            newNode = newNode.next;
        }
    }

    public MyLinkedList2 newList() {
        int n = 0;
        Node nodeOne = head;
        while (nodeOne.next != null) {
            n++;
            nodeOne = nodeOne.next;
        }
        int[] arr = new int[n + 1];
        Node node = head;
        int i = 0;
        while (node.next != null) {
            arr[i] = node.value;
            i++;
            node = node.next;
        }
        arr[n]=tail.value;
        MyLinkedList2 resultList = new MyLinkedList2();
        int[] current = new int[n+1];
        for (int j = 0; j < arr.length && arr[j] != 0; j++) {
            current[j] = arr[j] * arr[n - j];
        }
        for (int j = current.length - 1; j > 0; j--) {
            for (int k = 0; k < j; k++) {
                if (current[k] > current[k + 1]) {
                    int max = current[k];
                    current[k] = current[k + 1];
                    current[k + 1] = max;
                }
            }
        }
        for (int j = 0; j < current.length; j++) {
            resultList.add(current[j]);
        }
        return resultList;
    }

    @Override
    public int size() {
        return 0;
    }

    private class LinkedListIterator implements Iterator {
        private Node current;

        public LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            current = current.next;
            return current;
        }
    }


    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }


}
