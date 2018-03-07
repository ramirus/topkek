package FirstSemestr;


import java.util.Iterator;

public interface List extends Collection, Iterable {

    int get(int index);

    MyLinkedList2[] divide();

    MyLinkedList2 merge(MyLinkedList2 linkedList2);


    int maxNum();

    void show();

    void delete(int k);

    /**
     * Находит элемент в коллекции
     *
     * @param element
     * @return индекс элемента, если он найден, -1 в противном случае
     */
    int indexOf(int element);

    void insert(int k);

    MyLinkedList2 newList();


    //MyLinkedList2 newList(MyLinkedList2 list);
}