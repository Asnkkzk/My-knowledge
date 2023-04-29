package 算法.积性函数;

public class 莫比乌斯函数 {
    static final int N=10000;
    static int[] prime=new int[N+10];
    static int[] mu=new int[N];
    static boolean[] vis=new boolean[N];
    static int idx=0;
    static void getMöbius(){
        mu[1]=1;
        for(int i=2;i<=N;i++){
            if(!vis[i]){
                mu[i]=-1;
                prime[idx++]=i;
            }
            for(int j=0;i*prime[j]<=N;j++){
                int m=i*prime[j];
                vis[m]=true;
                if(i%prime[j]==0){
                    mu[m]=0;
                    break;
                }
                else mu[m]=-mu[i];
            }
        }
    }
    public static void main(String[] args) {

    }
}
