package H;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class DataFactory {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./src/H/h2.in";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    Random r;
    void run() {
        r = new Random();
        int T = 10;
        for (int k = 1; k <= T; k++){
            int n = r.nextInt(50);
            if (n < 3)continue;
            System.out.println(n);
            int [][] a = new int[n][n];
            for(int i = 0; i < n; i ++){
                for(int j = 0; j <i; j++){
                    a[i][j] = r.nextInt(1000) + 1;
                    a[j][i] = a[i][j];
                }
            }
            for(int i = 0; i < n; i++){
                String str = "";
                str += a[i][0];
                for(int j = 1; j < n; j++){
                    str += " " + a[i][j];
                }
                System.out.println(str);
            }
            int q = r.nextInt(n * (n + 1) / 2) + 1;
            System.out.println(q);
            for(int i = 1; i <= q; i++){
                int x = r.nextInt(n) + 1;
                int b = r.nextInt(n) + 1;
                System.out.println(x + " " + b);
            }
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
        new DataFactory().run();
    }
}