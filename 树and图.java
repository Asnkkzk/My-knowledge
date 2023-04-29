package 算法;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 树and图 {
    private static final int N=100010;
    private static int idx;
    private static int[] e=new int[N];
    private static int[] h=new int[N];
    private static int[] ne=new int[N];
    private static boolean[] vis=new boolean[N];
    private static int[] dis=new int[N];
    private static int[] q=new int[N];//队列

    public static void add(int a,int b){
        e[idx]=b;
        ne[idx]=h[a];
        h[a]=idx++;
    }
    public static void dfs(int u){
        vis[u]=true;
        for(int i=h[u];i!=-1;i=ne[i]){
            int j=e[i];
            if(!vis[j]) dfs(j);
        }
    }

    public static int bfs(int n){//求一个点的层次
        Arrays.fill(dis,-1);
        Queue<Integer> Q=new ArrayDeque<>();
        Q.offer(1);
        dis[1]=0;
        while(!Q.isEmpty()){
            int p=Q.poll();
            for(int i=h[p];i!=-1;i=ne[i]){
                int j=e[i];
                if(dis[j]==-1){
                    dis[j]=dis[p]+1;
                    Q.offer(j);
                }
            }
        }
        return dis[n];
    }
    private static int[] R=new int[N];//每个点的入度
    public static boolean topSort(int n){
        int hh=0,tt=-1;
        for(int i=1;i<=n;i++){
            if(R[i]==0){
                q[++tt]=i;
            }
        }
        while(hh<=tt){
            int t=q[hh++];
            for(int i=h[t];i!=-1;i=ne[i]){
                int j=e[i];
                R[j]--;
                if(R[j]==0) q[++tt]=j;
            }
        }
        return tt==n-1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Arrays.fill(h,-1);
//        int n=in.nextInt(),m=in.nextInt();//n个点（编号为1-n），m组数据
//        for(int i=0;i<m;i++) {
//            int a = in.nextInt(), b = in.nextInt();
//            add(a, b);   //a->b这是单向边，若是无向边，则需要再加入add(b,a)
//            R[b]++;
//        }
//       if(topSort(n)){
//            for(int i=0;i<n;i++){
//                System.out.print(q[i]+" ");
//            }
//        }
//        else System.out.println("-1");
        int[][] map={
                {1,3},
                {1,2},
                {1,4},
                {2,3},
                {2,4},
                {3,4},

        };
        for(int i=0;i<map.length;i++){
            add(map[i][0],map[i][1]);
        }
        topSort(3);
    }
}
