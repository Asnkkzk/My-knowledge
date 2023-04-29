package 算法.积性函数;

public class 求约数个数 {
    //单个数的约数个数
    static int getFactorsNumber(int n){
        int ans=1;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                int k=1;
                while(n%i==0){
                    ++k;
                    n/=i;
                }
                ans*=k;
            }
        }
        if(n>1) ans*=2;
        return ans;
    }
    static final int N=100;
    static boolean[] vis=new boolean[N+10];
    static int[] k=new int[N+10];//某数最小质因子的指数
    static int[] ans=new int[N+10];
    static int[] prime=new int[N+10];//存素数
    static int idx=0;

    static int[] getFactorsNumber(){//筛法求约数个数
        k[1]=1;
        ans[1]=1;
        vis[1]=true;
        for(int i=2;i<=N;i++){
            if(!vis[i]){
                prime[idx++]=i;
                k[i]=1;
                ans[i]=2;
            }
            for(int j=0;j<idx;j++){
                int m=prime[j]*i;
                if(m>N) break;
                vis[m]=true;
                if(i%prime[j]==0){
                    k[m]=k[i]+1;
                    ans[m]=ans[i]*(k[i]+2)/(k[i]+1);
                    break;
                }
                k[m]=1;
                ans[m]=2*ans[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res=getFactorsNumber();
        for(int i=1;i<=100;i++){
            System.out.println(i+"->"+res[i]);
        }
    }
}
