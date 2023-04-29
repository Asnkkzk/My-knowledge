package 算法;

import java.util.Arrays;
import java.util.Scanner;

public class N皇后 {
    public static final int N=1000;
    public static int ans=0;
    public static char[][] map=new char[N][N];
    public static boolean[] row=new boolean[N],Maj=new boolean[N],Sub=new boolean[N];
    public static void dfs(int x,int n){
        if(x==n){
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    System.out.print(map[i][j]+" ");
//                    ans++;
//                }
//                System.out.print("\n");
//            }
//            System.out.print("\n");
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!row[i]&&!Maj[x+i]&&!Sub[n-x+i]){//两个对角线
                map[x][i]='Q';
                row[i]=Maj[x+i]=Sub[n-x+i]=true;
                dfs(x+1,n);
                row[i]=Maj[x+i]=Sub[n-x+i]=false;
                map[x][i]='.';
            }
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]='.';
            }
        }
        dfs(0,n);
        System.out.print(ans);
    }
}
