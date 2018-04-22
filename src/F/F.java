package F;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class F {
    public static final String INPUT_FILE = "./src/F/f2.in";
    public static final String OUTPUT_FILE = "./src/F/f2.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    void run() {
        int n = Integer.parseInt(cin.nextLine());
        String[] ids = new String[n];

        for(int i = 0; i < n; i ++){
            ids[i] = cin.nextLine();
        }
        Arrays.asList(ids);
        Arrays.sort(ids, new Comparator<String>() {
            @Override
            public int compare(String o2, String o1) {
                if(o1.substring(6, 14).equals(o2.substring(6, 14)) )
                    return o1.compareTo(o2);
                else
                    return o1.substring(6, 14).compareTo(o2.substring(6, 14));
            }
        });
        for(int i = 0; i < n; i++ ){
            System.out.println(ids[i]);
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
        new F().run();
    }
}