package A;

import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class A {
    public static final String INPUT_FILE = "./src/A/a.in";
    public static final String OUTPUT_FILE = "./src/A/a.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);

    void run() {
        while (cin.hasNext()){
            int a = cin.nextInt();
            int b = cin.nextInt();
            if( a == 0 && b == 0)break;
            if((a+b)%7==0)
            System.out.println(7);
            else System.out.println((a+b)%7);
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
        new A().run();
    }
}