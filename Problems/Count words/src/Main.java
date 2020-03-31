import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        int counter = 0;
        int f;
        int s;
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            f = reader.read();
            if (f != ' ') {
                counter++;
            }
            while ((s = reader.read()) != -1) {
                if (f == ' ' && s != ' ') {
                    counter++;
                }
                f = s;
            }
            System.out.println(counter);
        }
    }
}