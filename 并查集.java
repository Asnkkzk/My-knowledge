package 算法;

public class 并查集 {
    private static int N=100000070;
    private static int[] p=new int[N];//p[x]存储x的祖宗节点
    private static int[] size=new int[N];//size[]只有祖宗节点的有意义，表示祖宗节点所在集合中的点的数量
    //初始化
    public static void Init(){
        for(int i=0;i<N;i++){
            p[i]=i;
            size[i]=1;
        }
    }
    //返回x的祖宗节点
    public static int find(int x){
        if(p[x]!=x) p[x]=find(p[x]);
        return p[x];
    }
    //合并A，B所在的集合
    public static void combine(int a,int b){
        p[find(a)]=find(b);
        size[find(b)]+=size[a];
    }

    public static void main(String[] args) {

    }
}
