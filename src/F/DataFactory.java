package F;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class DataFactory {
    public static final String INPUT_FILE = "./bin/in.txt";
    public static final String OUTPUT_FILE = "./src/F/f2.in";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner sc = new Scanner(System.in);
    Random r;
    void run() {
        r = new Random();
        int T = r.nextInt(5000);
        System.out.println(T);
        for(int i = 1; i <= T; i ++){
            String str = getStr();
            System.out.println(str);
        }
    }

    private String getStr() {
        char[]chars = new char[18];
        chars[0] = (char) (r.nextInt(9)+1 + '0');
        for (int i = 1; i < chars.length; i++){
            chars[i] = (char) (r.nextInt(10) + '0');
        }
        return String.valueOf(chars);
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