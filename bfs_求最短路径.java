package 算法;

import java.util.*;

public class bfs_求最短路径 {
    public static int[][] map={
                                {0,1,0,1,1},
                                {0,1,0,0,0},
                                {0,1,0,0,0},
                                {0,1,0,1,0},
                                {0,0,0,0,0},
                                {0,0,1,1,0}
                               };

    public static boolean[][] vis=new boolean[map.length][map[0].length];//false代表未访问
    public static Queue<int[]> Q=new LinkedList<>();
    public static int[][] step=new int[map.length][map[0].length];
    public static int move[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public static void bfs(int startx,int starty,int endx,int endy) {
        int x=startx,y=starty;
        vis[x][y]=true;
        Q.add(new int[]{x, y});
        if (x== endx && y == endy) {
            System.out.println(0);
            return;
        }
        while(!Q.isEmpty()){
            x=Q.peek()[0];
            y=Q.peek()[1];
            Q.poll();
            for(int i=0;i<4;i++){
                int tx=x+move[i][0];
                int ty=y+move[i][1];
                if((0<=tx&&tx<map.length)&&(0<=ty&&ty<map[0].length)&&map[tx][ty]==0&&vis[tx][ty]==false){
                    step[tx][ty]=step[x][y]+1;
                    vis[tx][ty]=true;
                    if(tx==endx&&ty==endy){
                        System.out.println(step[tx][ty]);
                        return;
                    }
                    Q.add(new int[]{tx,ty});
                }
            }

        }
    }

    public static void main(String arg[]){
        Scanner in=new Scanner(System.in);
        // System.out.println("输入终点坐标");
        //int endx=in.nextInt(),endy=in.nextInt();
        bfs(0,0,1,3);
    }
}
