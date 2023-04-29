package 算法;

import java.util.Scanner;

public class 马拉车Manacher算法 {
    public static int maxPalindrome(String s){
        int curCenter=0,curRight=0,maxLen=0;
        int n=s.length()*2+2;
        char[] sb=new char[n];
        int[] p=new int[n];
        sb[0]='$';
        sb[1]='#';
        int j=2;
        for(int i=0;i<s.length();i++){
            sb[j++]=s.charAt(i);
            sb[j++]='#';
        }
        for(int i=1;i<n;i++){
            p[i]=curRight>i?Math.min(p[2*curCenter-i],curRight-i):1;
            while(i-p[i]>=0&&i+p[i]<n&&sb[i-p[i]]==sb[i+p[i]]) p[i]++;
            if(curRight<i+p[i]){
                curRight=i+p[i];
                curCenter=i;
            }
            if(maxLen<p[i]){
                maxLen=p[i];
            }
        }
        return maxLen-1;
    }



    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String s=in.next();
            int n=maxPalindrome(s);
            System.out.println(n);
        }
    }
}
