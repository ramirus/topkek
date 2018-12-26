package LAMBDA;

public interface LineProcessRule {
    // интерфейс с одним методом -> такой
    // интерфейс называется функциональным
    // для таких интерфейсов доступны лямбда выражения
    String process(String line);
}