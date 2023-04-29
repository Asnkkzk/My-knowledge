package 算法;

import java.util.Arrays;
import java.util.Scanner;

public class 扩展欧几里得 {
    /*
    扩展欧几里得用来解决
    |
    1.ax+by=gcd(a,b) 的一组x,y解

    2.通解   x=x0+(b/gcd(a,b))*t;
            y=y0-(a/gcd(a,b))*t;
            x0,y0分别为（1）中求的一组特解

    3.若gcd(a,b)=1,则ax+by=1 --> ax=(-y)b+1 --> ax恒等1(mod b)
      即x是a关于1模b的乘法逆元

      由于x,y可能某个为负,而逆元为最小正整数,故求出通解中的最小值即可
      （1).直接循环通解找出最小正整数(不建议用)
       (2).套公式
           ans=(b+x%b)%b;
     */

    public static long[] solve(long a,long b){
        if(b==0){
            return new long[]{1,0,a};//x' y' gcd(a,b)
        }
        long[] ans=solve(b,a%b);
        return new long[]{ans[1],ans[0]-(a/b)*ans[1],ans[2]};
        /*
        0:x=y'
        1:y=x'-a/b*y'
        2:最大公约数
         */
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long a=in.nextLong(),b=in.nextLong();
        long[] res=solve(a,b);

        System.out.println(Arrays.toString(res));

        long x0=res[0];

        //套公式
        long ans=(b+x0%b)%b;

//       通解求最小
//        long ans=x0;
//        Flag:
//        while(true){
//            for(int i=1;i<=100;i++){
//                if(ans>0) break Flag;
//                else ans=x0+(b/res[2])*i;
//            }
//        }

        System.out.println(ans);
    }
}
