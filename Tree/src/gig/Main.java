package gig;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        User anita = new User("Анита", 18, 172, 3);
        User dasha = new User("Даша", 18, 158, 5);
        User vladislav = new User("Владислав", 19, 195, 5);
        User ilyas = new User("Ильяс", 19, 175, 3);
        User andrey = new User("Андрей", 20, 175, 4);
        User marsel = new User("Марсель", 24, 185, 2);

        ArrayList<User> users = new ArrayList<>();
        users.add(anita);
        users.add(dasha);
        users.add(vladislav);
        users.add(ilyas);
        users.add(andrey);
        users.add(marsel);

        ArrayList.sort(users);
        System.out.println("По возрасту");
        for (User user : users) {
            System.out.println(user);
        }

        ByHeightComparator comparator = new ByHeightComparator();
        ArrayList.sort(users, comparator);
        System.out.println("По росту");
        for (User user : users) {
            System.out.println(user);
        }

        ArrayList.sort(users, (userA, userB) -> userA.getMark() - userB.getMark());
        System.out.println("По оценке");
        for (User user : users) {
            System.out.println(user);
        }

    }
}