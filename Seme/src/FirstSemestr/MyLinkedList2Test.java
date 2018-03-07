package FirstSemestr;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyLinkedList2Test {
    private MyLinkedList2 test;

    @Before
    public void setUp() {
        test = new MyLinkedList2();
    }

    @Test
    public void firstValue() {//insert
        int[] arr = {43, 21, 13, 45};
        test=new MyLinkedList2(arr);
        test.insert(12);


    }

    @Test
    public void findDeleted() {//delete
        int[] arr = {43, 21, 13, 45};
        test=new MyLinkedList2(arr);
        test.delete(43);
        assertFalse(test.indexOf(43) != 0);
    }

    @Test
    public void testMax() {
        int[] arra = {43, 21, 13, 45};
        test=new MyLinkedList2(arra);
        int n = test.size();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = test.get(i);
        }
        int k = 0;
        int con = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int l = 0; l < arr.length; l++) {
                if (i != l && arr[i] == arr[l]) {
                    k++;
                }
            }
            if (k >= con) con = k;
            k = 0;
        }
        assertTrue(con == test.maxNum());
    }
}
