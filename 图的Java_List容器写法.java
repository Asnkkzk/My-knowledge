package 算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 图的Java_List容器写法 {
    static class Node{
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

    }
    //list.get(x) 得到点x连接的所有点的list集合 list.get(x).get(i) 得到x连接的list集合中的第i个点，其实就是x->i.v这条路径
    public static List<List<Node>> list=new ArrayList<>();

    public static int ans=0;
    public static boolean[] vis=new boolean[50010];
    public static void dfs(int x,int d){
        vis[x]=true;

        if(list.get(x).size()==1&&vis[list.get(x).get(0).v]){
            ans=Math.max(ans,d);
            return;
        }

        for(int i=0;i<list.get(x).size();i++){
            if(!vis[list.get(x).get(i).v]){
                dfs(list.get(x).get(i).v,d+list.get(x).get(i).w);
            }
        }

    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),x=in.nextInt();
        int u,v,w,sum=0;

        //初始化各点的list集合
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            u=in.nextInt();
            v=in.nextInt();
            w=in.nextInt();
            list.get(u).add(new Node(v,w));
            list.get(v).add(new Node(u,w));
            sum+=w;
        }
        dfs(x,0);
        System.out.print(sum*2-ans);
    }
}
