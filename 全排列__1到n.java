package 算法;


import java.util.Scanner;

public class 全排列__1到n {
    static Scanner in=new Scanner(System.in);
    public static final int N=100010;
    public static int[] p=new int[N];
    public static boolean[] vis= new boolean[N];
    public static void dfs(int x,int e){
        if(x==e){
            for(int i=0;i<e;i++){
                System.out.print(p[i]+" ");
            }
            System.out.print("\n");
            return;
        }
        for(int i=1;i<=e;i++){
            if(!vis[i]){
                p[x]=i;
                vis[i]=true;
                dfs(x+1,e);
                vis[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        int n=in.nextInt();
        dfs(0,n);
    }
}
