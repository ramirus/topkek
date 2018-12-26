package gig;


public class User implements Comparable<User> {
    private String name;
    private int age;
    private int height;
    private int mark;

    public User(String name, int age, int height, int mark) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.height + " " + this.mark;
    }

    public int getMark() {
        return mark;
    }
}