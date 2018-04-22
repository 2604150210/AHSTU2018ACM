package C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class C {
    public static final String INPUT_FILE = "./src/C/c3.in";
    public static final String OUTPUT_FILE = "./src/C/c3.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);

    void run() {
        int T = cin.nextInt();
        while (T-- > 0){
            int n = cin.nextInt();
            int m = cin.nextInt();
            if(m % 2 == 1){
                System.out.println("No answer");
                continue;
            }
            int y = m / 2 - n;
            int x = n - y;
            if(x < 0 || y < 0 ){
                System.out.println("No answer");
                continue;
            }
            System.out.println(x + " " + y);
        }
    }

    public void debug(Object ... objects){
        System.err.println(deepToString(objects));
    }
    public static void main(String[] args) {
        if (LOCAL) {
            try {
                System.setIn(new FileInputStream(INPUT_FILE));
            } catch (Throwable e) {
                LOCAL = false;
            }
        }
        if (TO_FILE) {
            try {
                System.setOut(new PrintStream(OUTPUT_FILE));
            } catch (FileNotFoundException e) {
                TO_FILE = false;
            }
        }
        new C().run();
    }
}