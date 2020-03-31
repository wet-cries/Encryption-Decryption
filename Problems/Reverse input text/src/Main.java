import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;




class Main {

    static void rec(Reader reader) throws IOException {
        int c = reader.read();;
        if (c == -1) {
            return;
        }
        rec(reader);
        System.out.print((char)(c));
    }

    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            rec(reader);
        }
    }
}