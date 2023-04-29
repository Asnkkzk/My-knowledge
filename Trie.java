package 算法;

public class Trie {
    public static final int N=100010;
    public static int[][] tree=new int[N][26];
    public static int[] cnt=new int[N];
    public static int idx=0;
    public static void insert(String s){
        int p=0;
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(tree[p][ch]==0) tree[p][ch]=++idx;
            p=tree[p][ch];
        }
        cnt[p]++;
    }
    public static int query(String s){
        int p=0;
        for(int i=0;i<s.length();i++){
            int u=s.charAt(i)-'a';
            if(tree[p][u]==0) return 0;
            p=tree[p][u];
        }
        return cnt[p];
    }
    public static void main(String[] args) {
        insert("abcde");
        insert("abc");
        insert("abcd");
        insert("axsd");
        insert("abc");
        int n=query("abc");
        System.out.println(n);
    }
}
