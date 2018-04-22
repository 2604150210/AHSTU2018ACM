package E;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class E {
    public static final String INPUT_FILE = "./src/E/e10.in";
    public static final String OUTPUT_FILE = "./src/E/e10.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    void run() {
        String a = cin.nextLine();
        String b = cin.nextLine();
        if(a.length() != b.length()){
            System.out.println(1);
        }
        else if (a.equals(b)){
            System.out.println(2);
        }
        else if (a.toUpperCase().equals(b.toUpperCase())){
            System.out.println(3);
        }
        else if (a.toUpperCase().equals(new StringBuffer(b.toUpperCase()).reverse().toString())){
            System.out.println(4);
        }
        System.out.println(5);
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
        new E().run();
    }
}