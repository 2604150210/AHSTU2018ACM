package D;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class D {
    public static final String INPUT_FILE = "./src/D/d.in";
    public static final String OUTPUT_FILE = "./src/D/d.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    int []a;
    void run() {
        a = new int[41];
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        for(int i = 4; i <= 40; i++){
            a[i] = a[i-1] + a[i-3];
        }
        //debug(a);
        int T = cin.nextInt();
        while (T-->0){
            int n = cin.nextInt();
            System.out.println(a[n]);
        }
    }
    /*int s(int n){
        return n>2?s(n-1)+s(n-2):1;
    }*/
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
        new D().run();
    }
}