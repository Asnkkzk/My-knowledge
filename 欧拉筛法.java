package 算法;

import java.util.ArrayList;

public class 欧拉筛法 {
    public static final int N= 100;
    public static boolean[] num=new boolean[N+1];
    public static ArrayList<Integer> list=new ArrayList<>();

    public static void Method(){

        for(int i=2;i<=N;i++){

            if(!num[i]) list.add(i);

            for(int j=0;j<list.size();j++){
                if(i*list.get(j)>N) break;
                num[i*list.get(j)]=true;
                if(i%list.get(j)==0) break;
            }

        }
    }


    public static void main(String arg[]){
        Method();
        int j=0;
        for(int i=2;i<=100;i++){
            if(!num[i])
            System.out.println(i+" "+list.get(j++));
        }

    }
}
