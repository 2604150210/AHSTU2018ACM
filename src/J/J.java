package J;

/**
 * Created by jal on 2018/4/13 0013.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class J {
    public static final String INPUT_FILE = "./src/J/j.in";
    public static final String OUTPUT_FILE = "./src/J/j.out";

    static boolean LOCAL = System.getSecurityManager() == null;
    static boolean TO_FILE = true;
    Scanner cin = new Scanner(System.in);
    int N,M;
    final int maxStateNumber = 100,MAXN = 20,MAXM = 110;
    char [][]mp;
    int []num,state,cur;
    int top;
    int dp[][][];
    boolean ok(int x){
        if((x & (x<<1)) != 0)return true;
        if((x & (x<<2)) != 0 )return false;
        return false;
    }
    void init(){
        top = 0;
        int total = (1 << N);
        for(int i = 0; i < total; i++){
            if(ok(i))state[++top] = i;
        }
    }
//计算x的二进制数的1的个数
    int cnt(int x){
        int ret = 0;
        while(x != 0){
            ret++;
            x&=(x-1);
        }
        return ret;
    }
    boolean fit(int state,int x){
        if((state&cur[x]) != 0)return false;
        return true;
    }
    void run() {

        while (cin.hasNext()){

            String s = cin.nextLine();
            M = Integer.parseInt(s.split(" ")[0]);
            N = Integer.parseInt(s.split(" ")[1]);
            if(N==0&&M==0)break;
            mp = new char[M+1][N+1];
            num = new int[maxStateNumber];
            state = new int[maxStateNumber];
            cur = new int[MAXM];
            dp = new int[MAXM][maxStateNumber][maxStateNumber];
            init();
            for(int i = 1; i <= M; i++){
                String str = cin.nextLine();
                str = "-" + str;
                mp[i] = str.toCharArray().clone();
            }
            for(int i =1; i <= M; i++){
                cur[i] = 0;
                for(int j = 1; j <= N; j++){

                    if(mp[i][j] == 'H')
                        cur[i] +=(1 << (N-j));
                }
            }

            for (int i = 0; i < dp.length; i++){
                for (int j = 0; j < dp[0].length; j++){
                    for (int k = 0; k < dp[0][0].length; k++){
                        dp[i][j][k] = -1;
                    }
                }
            }
            //初始化第一行的状态
            for(int i = 1; i <= top; i++){
                num[i] = cnt(state[i]);//state是满足条件的行的状态，找出该状态的1的个数，即为可以放置的大炮的个数
                if(fit(state[i],1)){//如果state[i]该状态可以放入第一行，则更细腻dp的值，否则dp仍为初始值-1
                    for(int j = 1; j<=top; j++)
                        dp[1][j][i] = num[i];
                }
            }
            for(int i = 2; i <= M; i++){
                for(int j = 1; j <= top; j++){
                    if(!fit(state[j],i))continue;
                    for(int k = 1; k <= top; k++){
                        if(!fit(state[k],i-1))continue;
                        if((state[j]&state[k])!= 0)continue;
                        for(int t = 1; t <= top; t++){
                            if(!fit(state[t],i-2))continue;
                            if((state[j]&state[t])!= 0)continue;
                            if((state[k]&state[t])!=0)continue;
                            //if(dp[i-1][t][k] == -1)continue;
                            dp[i][k][j] = Math.max(dp[i][k][j],dp[i-1][t][k] + num[j]);

                        }
                    }
                }
            }
            int maxvalue = -1;
            for(int i= 0; i <= top; i++){
                for(int j = 0; j<= top; j++){
                    maxvalue = Math.max(maxvalue,dp[M][i][j]);
                }
            }
            System.out.println(maxvalue);
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
        new J().run();
    }
}