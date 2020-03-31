import java.util.Scanner;

public class Main {
    static String strArg = "";
    public static void print(String strArg) {
        System.out.println(String.format("print(\"%s\")", strArg));
    }

    public static void print(String strArg, int intArg) {
        System.out.println(String.format("print(\"%s\", %d)", strArg, intArg));
    }

    Main(String strArg){
        strArg = strArg;
    }



    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
        Main a = new Main("sdfafad");
        a.print(str);
        print(str);
        print(str, val);
    }
}