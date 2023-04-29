package 算法;

import java.util.Scanner;

public class LCS最长公共子序列 {
    public static Scanner in=new Scanner(System.in);
    public static final int N=5010;
    public static int[][] f=new int[N][N];
    public static int[][] p=new int[N][N];
    public static char[] a=new char[N];
    public static char[] b=new char[N];
    public static void LCS(String s1,String s2){
        int i,j;
        int m=s1.length(),n=s2.length();
        a=s1.toCharArray();
        b=s2.toCharArray();
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(a[i-1]==b[j-1]){
                    f[i][j]=f[i-1][j-1]+1;
                    p[i][j]=1;
                }
                else if(f[i][j-1]>f[i-1][j]){
                    f[i][j]=f[i][j-1];
                    p[i][j]=2;
                }
                else{
                    f[i][j]=f[i-1][j];
                    p[i][j]=3;
                }
            }
        }
        System.out.println(f[m][n]);
    }
    public static void getLCS(String s1,String s2){
        int i,j,k;
        char[] s=new char[200];
        int m=s1.length(),n=s2.length();
        i=m;
        j=n;
        k=f[m][n];
        while(i>0&&j>0){
            if(p[i][j]==1){
                s[k--]=a[i-1];
                i--;
                j--;
            }
            else if(p[i][j]==2) j--;
            else i--;
        }
        for(i=1;i<=f[m][n];i++){
            System.out.print(s[i]);
        }
    }

    public static void main(String[] args) {
        String s1=in.next();
        String s2=in.next();
//        System.out.println("s1->"+s1+"<-s1");
//        System.out.println("s2->"+s2+"<-s2");
        LCS(s1,s2);
        //getLCS(s1,s2);
    }
}
