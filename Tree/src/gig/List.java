package gig;


public interface List<T> extends Collection<T>, Iterable<T> {
    /**
     * Находит элемент в коллекции
     * @param element
     * @return индекс элемента, если он найден, -1 в противном случае
     */
    int indexOf(T element);

    /**
     * Получить элемент по индексу
     * @param index
     * @return элемент под заданным индексом
     */
    T get(int index);
}