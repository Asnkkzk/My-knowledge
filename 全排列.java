package 算法;
import java.util.*;

public class 全排列 {
    public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list=new ArrayList<>();
    Deque<Integer> path=new ArrayDeque<>();
    if(nums.length==0){
        return list;
    }
    //Arrays.sort(nums);
    int[] vis=new int[nums.length];
    dfs(nums,vis,0, nums.length, path,list);
    return list;
    }
    public static void dfs(int[] nums,int[] vis,int depth,int len,Deque<Integer> path,List<List<Integer>> list){
        if(depth==len){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(vis[i]==0){
                vis[i]=1;
                path.add(nums[i]);
                dfs(nums,vis,depth+1,len,path,list);
                vis[i]=0;
                path.removeLast();
            }
        }
    }
    public static void main(String arg[]){
    int[] nums={1,2,6,3};
    System.out.println(permute(nums));
    }
}
