package 算法;

import java.util.*;

public class dfs_求最短路径及总共路径数量{
    public static Scanner in=new Scanner(System.in);
    public static int min=9999;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};
    public static Deque<int[]> Stack=new ArrayDeque<>();
    public static Deque<int[]> S=new ArrayDeque<>();

    public static void dfs(int x, int y, int[][] map, boolean[][] vis, int ex, int ey, int step){
        if(x==ex&&y==ey){
            if(min>=step){
                min=step;
            }
            return;
        }
//        System.out.println("%"+" "+"%");
//        System.out.println("测试"+x+" "+y);
        for(int k=0;k<=3;k++){
            int tx=x+dx[k];
            int ty=y+dy[k];
            if((0<=tx&&tx<map.length)&&(0<=ty&&ty<map[0].length)&&map[tx][ty]==1&&vis[tx][ty]==true){
                Stack.push(new int[]{tx,ty});
                vis[tx][ty]=false;
                dfs(tx,ty,map,vis,ex,ey,step+1);
                vis[tx][ty]=true;
                S.push(Stack.peek());
            }
        }
        return;
    }
    public static void main(String arg[]){
        int n=in.nextInt(),m=in.nextInt();
        //System.out.println(n+" "+m);
        int[][] map=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=in.nextInt();
                vis[i][j]=true;//true代表未访问
            }
        }
        //System.out.println(map);
        int ex=in.nextInt(),ey=in.nextInt();
        vis[0][0]=false;
        //System.out.println(ex+" "+ey);
        dfs(0,0,map,vis,ex,ey,0);
        System.out.println("\t"+min);
        //System.out.println(S);
        for(int[] i:S){
            System.out.println(i.toString());
        }
    }
}


