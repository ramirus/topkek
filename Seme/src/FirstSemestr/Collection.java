package FirstSemestr;


public interface Collection {

    void show();

    void add(int element);

    MyLinkedList2 newList();


    int maxNum();

    MyLinkedList2[] divide();

    MyLinkedList2 merge(MyLinkedList2 linkedList2);

    void insert(int k);

    /**
     * Удалить элемент
     *
     * @param
     */
    void delete(int k);

    int indexOf(int element);


    int get(int index);
    /**
     * Проверить, есть ли элемент в коллекции
     * @param element
     * @return true, если элемент есть, false - в противном случае
     */

    /**
     * Количество элементов в коллекции
     *
     * @return
     */
    int size();


}