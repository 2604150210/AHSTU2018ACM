package A;

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class A {
    public static final String INPUT_FILE = "./src/a.in";
    public static final String OUTPUT_FILE = "./src/a.in";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);

    void run() {
        for (int i = 1; i <= 10; i++)
        System.out.println(i);
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
        new A().run();
    }
}