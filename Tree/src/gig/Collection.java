package gig;

public interface Collection<T> {
    /**
     * Добавить в начало
     * @param element
     */
    void addToBegin(T element);

    /**
     * Добавить в конец
     * @param element
     */
    void add(T element);

    /**
     * Удалить элемент
     * @param element
     */
    void remove(T element);

    /**
     * Проверить, есть ли элемент в коллекции
     * @param element
     * @return true, если элемент есть, false - в противном случае
     */
    boolean contains(T element);

    /**
     * Количество элементов в коллекции
     * @return
     */
    int size();
}