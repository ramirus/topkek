package LAMBDA;

public class UpperCaseRule implements LineProcessRule {
    @Override
    public String process(String line) {
        // получили массив символов из строки
        char lineAsCharArray[] = line.toCharArray();
        // позволяет конкатенировать строки
        // без перевыделения памяти
        StringBuilder builder = new StringBuilder();
        // смотрим все символы строки
        for (int i = 0; i < line.length(); i++) {
            // если символ - маленькая буква
            if (Character.isLowerCase(lineAsCharArray[i])) {
                // делаем большой
                builder.append(Character.toUpperCase(lineAsCharArray[i]));
            } else {
                builder.append(lineAsCharArray[i]);
            }
        }
        return builder.toString();
    }
}