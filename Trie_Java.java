package 算法;

import java.util.Scanner;

class Node{
    int cnt=0;
    Node[] son;
    public Node() {
        this.cnt =0;
        this.son =new Node[26];
    }
}

public class Trie_Java {
    private static void insert(String s,Node trie){
        int n=s.length();
        for(int i=0;i<n;i++){
            int id=s.charAt(i)-'a';
            if(trie.son[id]==null) trie.son[id]=new Node();
            trie=trie.son[id];
        }
        trie.cnt++;
    }
    private static void query(String s,Node trie,StringBuffer sb){
        int ans=0;
        for(int i=0;i<s.length();i++){
            int id=s.charAt(i)-'a';
            if(trie==null) break;
            ans+=trie.cnt;
            trie=trie.son[id];
        }
        if(trie!=null) ans+=trie.cnt;
        sb.append(ans);
        sb.append("\n");
    }
    public static void main(String arg[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        in.nextLine();
        Node trie=new Node();
        for(int i=0;i<n;i++){
            String s=in.nextLine();
            insert(s,trie);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<m;i++){
            String s=in.nextLine();
            query(s,trie,sb);
        }
        in.close();
        System.out.println(sb);
    }
}
