package 算法;

import java.util.Scanner;

public class 背包 {

   public static Scanner in=new Scanner(System.in);
   public static int[] F=new int[10010];

    public static void main(String[] args) {
        int n=in.nextInt();//n为物品个数
        int v=in.nextInt();//v为背包总空间
        Pack_01pack p1=new Pack_01pack(n,v,in,F);
        Pack_completePack p2=new Pack_completePack(n,v,in,F);
        Pack_groupPack p3=new Pack_groupPack(n,v,in,F);
        Pack_多重Pack p4=new Pack_多重Pack(n,v,in,F);
    }
}
class Pack_01pack{
    /*
    每种物品至多选一个
     */
    public Pack_01pack(int n, int v, Scanner in,int[] F) {
        for(int i=0;i<n;i++){
            int c=in.nextInt();
            int w=in.nextInt();
            for(int j=v;j>=c;j--){
                F[j]=Math.max(F[j],F[j-c]+w);
            }
        }
    }
    //结果为F[v]
}
class Pack_completePack{
    /*
    每种物品都有无数件可选
     */
    public Pack_completePack(int n, int v, Scanner in,int[] F) {
        for(int i=0;i<n;i++){
            int c=in.nextInt();
            int w=in.nextInt();
            for(int j=c;j<=v;j++){
                F[j]=Math.max(F[j],F[j-c]+w);
            }
        }
    }
    //结果为F[v]
}

class Pack_groupPack{
    /*
    有n组物品,每组物品有s件，每组物品只能选一个，每个物品的空间和价值不尽相同
     */
    public static int[] c=new int[10010];
    public static int[] w=new int[10010];

    public Pack_groupPack(int n, int v, Scanner in,int[] F) {
        for(int i=0;i<n;i++){          //--------物品
            int s=in.nextInt();
            for(int j=1;j<s;j++){
                c[j]=in.nextInt();
                w[j]=in.nextInt();
            }
            for(int j=v;j>=1;j--){     //--------体积
                for(int k=0;k<=s;k++){ //--------决策
                    if(j>=c[k]){
                        F[j]=Math.max(F[j],F[j-c[k]]+w[k]);
                    }
                }
            }
        }
    }
    //结果为F[v]
}

class Pack_多重Pack{
    /*
    每件物品至多选s件
    时间复杂度为O(mn)
     */
    public static int[] g=new int[10010];//备份数组
    public static int[] q=new int[10010];//队列

    public Pack_多重Pack(int n, int v, Scanner in,int[] F) {
        for(int i=0;i<n;i++){
            g=F.clone();            //-------备份
            int c=in.nextInt();     //-------体积
            int w=in.nextInt();     //-------价值
            int s=in.nextInt();     //-------个数
            for(int j=0;j<c;j++){   //对每个类使用单调队列
                int h=0,t=-1;
                for(int k=j;k<=v;k+=c){
                    //q[h]不在窗口 [k-s*c,k-c]内，队头出队
                    if(h<=t&&q[h]<k-s*c) h++;
                    //使用队头最大值更新F
                    if(h<=t) F[k]=Math.max(g[k],g[q[h]]+(k-q[h])/c*w);
                    //当前值比队尾值更有价值，队尾出队
                    while(h<=t&&g[k]>=g[q[t]]+(k-q[t])/c*w) t--;
                    //下标入队，便于队头出队
                    q[++t]=k;
                }
            }
        }
    }
    //结果为F[v]
}

