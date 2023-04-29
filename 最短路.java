package 算法;

import java.util.*;

import java.util.Arrays;

import static java.lang.System.out;

public class 最短路 {
    static final int N=510;
    static final int inf=0x3f3f3f3f;
    static Scanner in=new Scanner(System.in);
    static int[][] g=new int[N][N];
    static int[] dist=new int[N];
    static boolean[] st=new boolean[N];
    static int[] h=new int[N];
    static int[] ne=new int[N];
    static int[] e=new int[N];
    static int[] w=new int[N];
    static int idx=0;
    static void add(int a,int b,int c){
        e[idx]=b;
        w[idx]=c;
        ne[idx]=h[a];
        h[a]=idx++;
    }


    public static void main(String[] args) {
        for(int[] i:g){
            Arrays.fill(i,inf);
        }
        Arrays.fill(h,-1);
        int n,m,a,b,c;
        String[] op=in.nextLine().split(" ");
        n=Integer.parseInt(op[0]);
        m=Integer.parseInt(op[1]);
        for(int i=0;i<m;i++){
            op=in.nextLine().split(" ");
            a=Integer.parseInt(op[0]);
            b=Integer.parseInt(op[1]);
            c=Integer.parseInt(op[2]);
            add(a,b,c);
            g[a][b]=Math.min(g[a][b],c);
        }
        //Dijkstra Dij=new Dijkstra(dist,st,n,g);
        DijkstraHeap DH=new DijkstraHeap(dist,st,n,h,ne,e,w);
    }

}
class Dijkstra{
    public Dijkstra(int[] dist,boolean[] st,int n,int[][] g) {
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1]=0;
        for(int i=0;i<n;i++){
            int t=-1;
            for(int j=1;j<=n;j++){
                if(!st[j]&&(t==-1||dist[t]>dist[j])) t=j;
            }
            st[t]=true;
            for(int j=1;j<=n;j++){
                dist[j]=Math.min(dist[j],dist[t]+g[t][j]);
            }
        }
        if(dist[n]==0x3f3f3f3f) {
            out.println(-1);
        }
        else{
            out.println(dist[n]);
        }
    }
}
class DijkstraHeap{
    public DijkstraHeap(int[] dist,boolean[] st,int n,int[] h,int[] ne,int[] e,int[] w) {
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,1});
        while(!pq.isEmpty()){
            int[] t=pq.peek();
            pq.poll();
            int val=t[1],distance=t[0];
            if(st[val]) continue;
            st[val]=true;
            for(int i=h[val];i!=-1;i=ne[i]){
                int j=e[i];
                if(dist[j]>distance+w[i]){
                    dist[j]=distance+w[i];
                    pq.offer(new int[]{dist[j],j});
                }
            }
        }
        if(dist[n]==0x3f3f3f3f) out.println(-1);
        else out.println(dist[n]);
    }
}

