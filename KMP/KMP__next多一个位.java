package 算法.KMP;

import java.util.Arrays;
import java.util.Scanner;

public class KMP__next多一个位 {
    public static int[] getNext(String s){
        int[] next=new int[s.length()+1];
        next[0]=-1;
        int k=-1,j=0;
        while(j<s.length()){
            if(k==-1||s.charAt(k)==s.charAt(j)){
                ++k;
                ++j;
                next[j]=k;
            }
            else k=next[k];
        }
        return next;
    }

    public static int KMP(String Maj,String Sub){
        int ans=0;
        int[] next=getNext(Sub);
        int i=0,j=0;
        while(i<Maj.length()){
            if(j==-1||Maj.charAt(i)==Sub.charAt(j)){
                ++i;
                ++j;
            }
            else j=next[j];
            if(j==Sub.length()){
                ans++;
                j=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        System.out.println(Arrays.toString(getNext(s)));
    }
}
