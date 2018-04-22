package J;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class DataFactory {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./src/J/j2.in";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    Random r;

    void run() {
        r = new Random();
        int T = 10;
        for (int k = 1; k <= T; k++) {
            int m = r.nextInt(100)+1;
            int n = r.nextInt(10)+1;
            System.out.println(m + " " + n);
            char[][]chars = new char[m][n];
            for (int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    boolean y = r.nextBoolean();
                    if (y){
                        chars[i][j] = 'H';
                    }else {
                        chars[i][j] = 'P';
                    }
                }
            }
            for (int i = 0; i < m; i++){
                System.out.println(String.valueOf(chars[i]));
            }
        }

    }

    public void debug(Object... objects) {
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
        new DataFactory().run();
    }
}