package 算法;

public class 乘法逆元 {
    public static int p;
    public static int N=100;
    /*
    定义:
        对于两个数a,p 若gcd(a,p)=1,则一定存在另一个数b,使得  ab恒等1(mod p)  ----> ab%p=1 ---> ab=kp+1
        满足条件的最小正整数b称为a关于1模p的乘法逆元


    计算逆元的方法
    一:费马小定理
        当有两数 a,p 满足gcd(a,p)=1,p是质数时，有 a^p恒等a(mod p)
        变形为-->a*(a ^ p-2)恒等1(mod p)
        使用快速幂计算出a^p-2,即是a的逆元
     */
    public static long powMod(int a,int b){//b=p-2
        long res=1;
        while(b!=0){
            if((b&1)==1) res=res*a%p;
            a=a*a%p;
            b>>=1;
        }
        return res;
    }

    /*
    二:扩展欧几里得
        具体见扩展欧几里得算法
     */

    /*
    三:递推计算阶乘的逆元
    令 f[i]=i!
    有 inv(f[i])=inv(f[i+1])*(i+1)(mod p)
     */
    public static void solve(){
        int[] f=new int[N+1];
        long[] inv=new long[N+1];
        f[0]=1;
        for(int i=1;i<=N;i++){
            f[i]=f[i-1]*i%p;
        }
        inv[0]=1;
        inv[N]=powMod(f[N],p-2);
        for(int i=N-1;i>0;i--){
            inv[i]=inv[i+1]*(i+1)%p;
        }
    }

    /*
    四:递推计算连续数的逆元
    inv(i)=(p-p/i)*inv(p mod i)mod p;
     */
    public static void method(){
        int[] inv=new int[N+1];
        inv[1]=1;
        for(int i=2;i<=N;i++){
            inv[i]=(p-p/i)*inv[p%i]%p;
        }
    }

}
