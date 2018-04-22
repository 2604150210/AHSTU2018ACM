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
            if(a >= 999){
                System.out.println(0);
                continue;
            }
            if(b <= 100){
                System.out.println(0);
                continue;
            }
            if(a <= 100){
                a = 100;
            }
            if(b >= 999){
                b = 999;
            }
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i  = 100; i <= 999; i++){
                if(f(i)){
                    list.add(i);
                }
            }
            debug(list);
            for(int i  = a; i <= b; i++){
                if (list.contains(i)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    private boolean f(int n) {
        int a = n / 100;
        int b = n % 100 / 10;
        int c = n % 10;
        return a*a*a + b*b*b + c*c*c == n;
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