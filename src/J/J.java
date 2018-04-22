package I;

/**
 * Created by jal on 2018/4/13 0013.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class I {
    public static final String INPUT_FILE = "./src/I/i2.in";
    public static final String OUTPUT_FILE = "./src/I/i2.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    private int n;
    private int count = 0;
    private int[][]out;
    private int[]vis;
    void run() {
        count = 0;
        n = cin.nextInt();
        out = new int[1000][n];
        vis = new int[n];
        dfs(0);
        System.out.println(count);
        for(int i = 0; i < count; i++){
            for (int j = 0; j < n; j++){
                System.out.print(out[i][j]);
            }
            System.out.println();
        }
    }

    private void dfs(int r) {
        if( r >= n){
            for(int i = 0; i < n; i++)
                out[count][i] = vis[i];
            count++;
        }
        for(int i = 0; i < n; i++){
            if(check(r, i)){
                vis[r] = i;
                dfs(r+1);
                vis[r] = -1;
            }
        }
    }

    private boolean check(int r, int c) {
        for(int i = 0; i < r; i++){
            if(vis[i] == c)return false;
            if(vis[i] - c == i - r || vis[i] - c == r - i)return false;
        }
        return true;
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
        new I().run();
    }
}