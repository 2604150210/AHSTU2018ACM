package G;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class DataFactory {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./src/G/g.in";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    Random r;
    void run() {
        r = new Random();
        System.out.println("1 1");
        for(int i = 1; i <= 20; i++){
            int a = r.nextInt(20);
            int b = r.nextInt(50);
            System.out.println(a + " " + b);
        }
        for(int i = 1; i <= 50; i++){
            int a = r.nextInt(10000);
            int b = r.nextInt(10000);
            System.out.println(a + " " + b);
        }
        for(int i = 1; i <= 30; i++){
            int a = r.nextInt(200);
            int b = r.nextInt(100);
            System.out.println(a + " " + b);
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