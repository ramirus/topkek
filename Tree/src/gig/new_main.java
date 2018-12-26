package gig;

public class new_main {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(11);
        Node c = new Node(12);
        Node d = new Node(13);
        Node e = new Node(14);
        Node f = new Node(15);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        Node first;
        Node second;
        Node third;
        first = a;
        second = b;
        third = c;
        first.next = null;
        while(third!=null){
            second.next=first;
            first=second;
            second=third;
            third=third.next;
        }
        Node current = f;
        second.next = first;
        while (current != null) {
            System.out.print(" " + current.value);
            current = current.next;
        }
    }
}
