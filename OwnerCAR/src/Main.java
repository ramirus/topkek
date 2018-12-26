import java.io.*;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader userRead = new BufferedReader(new FileReader("users.txt"));
        BufferedReader carRead = new BufferedReader(new FileReader("cars.txt"));
        HashMap<Integer, Integer> age = new HashMap<>();
        String users = userRead.readLine();
        String cars = carRead.readLine();
        int usersId =0;
        int userAge[] = new int[80];
        int k = 0;
        while (userRead.readLine() != null) {
            k++;
        }
        int ownersIds[] = new int[k + 1];
        int ages;
        for (int i = 0; i < ownersIds.length; i++) {
            ownersIds[i] = Integer.parseInt(cars.split(" ")[2]);
            cars = carRead.readLine();
        }
        users=userRead.readLine();
        carRead.close();
        while (userRead.readLine() != null) {
            usersId = Integer.parseInt(users.split(" ")[0]);
            ages = Integer.parseInt(users.split(" ")[2]);
            for (int ownersId : ownersIds) {
                if (usersId == ownersId) {
                    userAge[ages]++;
                }
            }
            users = userRead.readLine();
            System.out.println(ages + " " + userAge[ages]);
        }
    }
}