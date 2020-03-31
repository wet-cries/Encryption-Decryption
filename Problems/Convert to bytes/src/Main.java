import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] bytes = inputStream.readAllBytes();
        for (byte x : bytes) {
            System.out.print(x);
        }
    }
}