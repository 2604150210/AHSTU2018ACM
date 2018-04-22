package B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class B {
    public static final String INPUT_FILE = "./src/B/b.in";
    public static final String OUTPUT_FILE = "./src/B/b.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);

    void run() {
        while (cin.hasNext()){
            int a = cin.nextInt();
            int b = cin.nextInt();
            int []rose = {1634, 8208, 9474};
            int sum = 0;
            for(int i = 0; i < rose.length; i++){
                if (rose[i] >= a && rose[i] <= b){
                    sum++;
                }
            }
            System.out.println(sum);
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
        new B().run();
    }
}