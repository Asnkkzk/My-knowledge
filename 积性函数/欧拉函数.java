package 算法.积性函数;

public class 欧拉函数 {
    static final int N=(int)1e6;
    static int[] Prime=new int[N];
    static boolean[] vis=new boolean[N];
    static int[] Phi=new int[N];
    static int idx=0;
    static void get_Phi(int n){
        vis[1]=true;
        Phi[1]=1;
        for(int i=2;i<=n;i++){
            if(!vis[i]){
                Prime[idx++]=i;
                Phi[i]=i-1;
            }
            for(int j=0;j<idx&&i*Prime[j]<=n;j++){
                vis[i*Prime[j]]=true;
                if(i%Prime[j]==0){
                    Phi[i*Prime[j]]=Prime[j]*Phi[i];
                    break;
                }
                Phi[i*Prime[j]]=(Prime[j]-1)*Phi[i];
            }
        }
    }

    static int getSignalPhi(int n){//求单个数的欧拉函数
        int ans=n;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                ans=ans*(i-1)/i;
                do n/=i;while (n%i==0);
            }
        }
        if(n>1) ans=ans*(n-1)/n;
        return ans;
    }

    public static void main(String[] args) {
        get_Phi(12);
        for(int i=1;i<=12;i++){
            System.out.println(!vis[i] ?(i+"是质数,欧拉函数值为"+Phi[i]):(i+"不是质数,欧拉函数值为"+Phi[i]));
            System.out.println(i+"->"+getSignalPhi(i));
            System.out.println();
        }
    }
}
