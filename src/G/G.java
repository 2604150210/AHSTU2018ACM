package G;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import static java.util.Arrays.deepToString;

public class G {
    public static final String INPUT_FILE = "./src/G/g.in";
    public static final String OUTPUT_FILE = "./src/G/g.out";

    static boolean LOCAL = false;//System.getSecurityManager() == null;
    static boolean TO_FILE = false;
    Scanner cin = new Scanner(System.in);
    void run() {
        int t = Integer.parseInt(cin.nextLine());
        while (t-->0){
            char[]chars = cin.nextLine().toCharArray();
            Vector<Integer>vector = new Vector<>();
            vector.add(chars[0]-'0');
            int i = 1;
            int last = vector.lastElement();
            int temp = 0;
            String ts = "";
            boolean over = false;
            String s = ""+vector.get(0) + ",";
            while (i < chars.length){
                //s+=chars[i];
                ts += chars[i];
                temp = temp * 10 + chars[i] - '0';
                if(temp > last){
                    s += ts;
                    ts = "";
                    vector.add(temp);
                    last = vector.lastElement();
                    temp = 0;
                    if (i != chars.length - 1){
                        s+=",";
                    }
                     else {
                        over = true;
                    }
                }
                i++;
            }
            if(!over){
                s = s.substring(0, s.length() - 1);
                s += ts;
            }
            System.out.println(s);
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
        new G().run();
    }
}