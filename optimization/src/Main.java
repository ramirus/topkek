import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String string = reader.readLine();
        int u = Integer.parseInt(string.split(" ")[0]);
        int j = Integer.parseInt(string.split(" ")[1]);

    }
}
