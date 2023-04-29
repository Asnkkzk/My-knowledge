package 算法;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 状态压缩 {
    /*
    原题连接:  https://ac.nowcoder.com/acm/contest/50350/C

    状态压缩:
        本题中有两个状态，有钥匙和无钥匙，记录当前钥匙状态之后，去检索下一步的四个方向是否能得到钥匙
        如果能得到钥匙，那么有钥匙的状态去继承当前的步数

        本质就是多个状态在满足一定条件时状态的转换
     */
    public static int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
    public static int bfs(char[][] map,int sx,int sy){
        int n=map.length,m=map[0].length;
        boolean[][][] vis=new boolean[n][m][2];
        int[][][] status=new int[n][m][2];
        Queue<int[]> path=new ArrayDeque<>();
        path.add(new int[]{sx,sy,0});
        while(!path.isEmpty()){
            int x= path.peek()[0];
            int y=path.peek()[1];
            int Flag=path.peek()[2];
            path.poll();
            for(int i=0;i<=3;i++){
                int isHaveKey=Flag;
                int tx=x+dir[i][0];
                int ty=y+dir[i][1];
                if(tx>=1&&tx<n-1&&ty>=1&&ty<m-1&&!vis[tx][ty][isHaveKey]&&map[tx][ty]!='W'){
                    if(map[tx][ty]=='D')
                        if(isHaveKey==1)
                            status[tx][ty][isHaveKey]=status[x][y][isHaveKey]+1;
                        else continue;
                    else if(map[tx][ty]=='K') {
                        status[tx][ty][1]=status[x][y][0]+1;
                        isHaveKey=1;
                        vis[tx][ty][0]=true;
                    }
                    else {
                        status[tx][ty][isHaveKey]=status[x][y][isHaveKey]+1;
                    }
                    vis[tx][ty][isHaveKey]=true;
//                    if(isHaveKey==1){
//                        System.out.println("tx "+tx+" ty "+ty+" 步数 "+status[tx][ty][isHaveKey]);
//                    }
                    if(map[tx][ty]=='E') return status[tx][ty][isHaveKey];
                    path.add(new int[]{tx,ty,isHaveKey});

                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int sx=0,sy=0;
        char[][] map=new char[n][m];
        in.nextLine();
        for(int i=0;i<n;i++){
            String s=in.nextLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='S'){
                    sx=i;
                    sy=j;
                }
            }
            map[i]=s.toCharArray();
        }
        int ans=bfs(map,sx,sy);
        System.out.println(ans);
    }
}
