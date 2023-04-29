package 算法.积性函数;


import java.io.*;
import java.util.Scanner;

public class 求约数和 {
    static PrintWriter pw=new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st=new StreamTokenizer(re);
    static void read() throws IOException{
        st.nextToken();
    }
    static Scanner in=new Scanner(System.in);
    static int getSignal(int n){//单个数的约数和
        int ans=1;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                int sum=1,p=1;
                while(n%i==0){
                    p*=i;
                    sum+=p;
                    n/=i;
                }
                ans*=sum;
            }
        }
        if(n>1) ans*=n+1;
        return ans;
    }
    static final int N=(int)1e6;
    static int[] prime=new int[N+10];
    static boolean[] vis=new boolean[N+10];
    static int[] g=new int[N+10];
    static int[] ans=new int[N+10];
    static int idx;
    static void get(){//筛法求约数和
        g[1]=ans[1]=1;
        for(int i=2;i<=N;i++){
            if(!vis[i]){
                prime[idx++]=i;
                g[i]=i+1;
                ans[i]=i+1;
            }
            for(int j=0;i*prime[j]<=N;j++){
                int m=i*prime[j];
                vis[m]=true;
                if(i%prime[j]==0){
                    g[m]=g[i]*prime[j]+1;
                    ans[m]=ans[i]/g[i]*g[m];
                    break;
                }
                else{
                    g[m]=prime[j]+1;
                    ans[m]=ans[i]*g[m];
                }
            }
        }
    }
    public static void main(String[] args)throws Exception {
        get();
        read();
        int n=(int)st.nval,x,sum;
        for(int i=0;i<n;i++){
            read();
            x=(int)st.nval;
            sum=ans[x]-x;
            if(sum==x){
                pw.println("perfect");
            }
            else if(sum>x){
                pw.println("abundant");
            }
            else pw.println("deficient");
            pw.flush();
        }
    }
}
