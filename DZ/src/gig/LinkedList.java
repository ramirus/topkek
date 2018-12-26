package gig;

import java.util.Scanner;

import java.util.Iterator;


/**
 * Реализация списка на основе узлов (связного списка)
 */
public class LinkedList<T>  implements List<T> {


    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    private int count;

    public LinkedList() {
        this.count = 0;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T get(int index) {
        if (index >= count) {
            throw new IllegalArgumentException();
        }
        Node current = this.head;
        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    // TODO: реализовать
    @Override
    public void addToBegin(T element) {
        Node newNode = new Node(element);
        newNode.next=head;
        head=newNode;
        count++;
    }

    @Override
    public void add(T element) {
//        Node newNode = new Node(element);
//
//        if (head == null) {
//            head = newNode;
//        } else {
//            // создаем переменную, которая указывает
//            //  на начало списка
//            Node current = head;
//            // пока следующий после текущего есть
//            while (current.next != null) {
//                // идем дальше
//                current = current.next;
//            }
//            current.next = newNode;
//        }
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

    @Override
    public void remove(T element) {

    }

    // TODO: реализовать
    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

   /* public static LinkedList merge(LinkedList listFirst, LinkedList listSecond) {
        LinkedList<String> list = new LinkedList<>();
        if (listFirst.size() == 0) {
            return listSecond;
        } else {
            return listFirst;
        }
        if (listFirst.size() == 1) {
            Node currentF = listFirst.head;
            Node currentS = listSecond.head;
            while (currentS != null) {
                currentF.equals(currentS);
                currentS=currentS.next;
            }
        } else {

        }
        return list;
    }*/

    private class LinkedListIterator implements Iterator<T> {
        private Node current;

        public LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T result = current.value;
            current = current.next;
            return result;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


}