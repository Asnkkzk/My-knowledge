package 算法.KMP;

public class KMP__常规 {
    public static int[] next(String s){
        int[] next=new int[s.length()];
        next[0]=-1;
        int k=-1,j=0;
        while(j<s.length()-1){
            if(k==-1||s.charAt(j)==s.charAt(k)){
                ++k;
                ++j;
                next[j]=k;
            }
            else k=next[k];
        }
        return next;
    }
    public static int SearchSubstring(String sub,String Maj){
        int[] next=next(sub);
        int k=0,i=0;
        while(k<sub.length()&&i<Maj.length()){
            if(k==-1||sub.charAt(k)==Maj.charAt(i)){
                ++k;
                ++i;
            }
            else k=next[k];
        }
        if(k==sub.length()) return i-k;
        else return -1;
    }
    public static void main(String arg[]){
        System.out.println(SearchSubstring("abcaabd","abdcabcaabd"));
    }
}