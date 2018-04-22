package C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class C {
    public static final String INPUT_FILE = "./src/C/c3.in";
    public static final String OUTPUT_FILE = "./src/C/c3.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);

    void run() {
        int T = Integer.parseInt(cin.nextLine());
        while (T-- > 0){
            char []chars = cin.nextLine().toCharArray();
            Arrays.sort(chars);
            if(chars[0] == chars[chars.length-1]){
                System.out.println("Y");
            }else System.out.println("N");
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