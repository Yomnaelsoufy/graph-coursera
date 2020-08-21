package week2;

import java.util.*;

public class problem2 {
    static boolean[]visit;
    static SortedMap<Integer,Integer> s=new TreeMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        List[]adj=new List[v];
        visit=new boolean[v];
        for (int i=0;i<v;i++)
            adj[i]=new ArrayList();
        int ed=sc.nextInt();
        for (int i=0;i<ed;i++){
            int a=sc.nextInt()-1,b=sc.nextInt()-1;
            adj[a].add(b);
        }
        DetermininganOrderofCourses(adj);
    }

    private static void DetermininganOrderofCourses(List[] adj) {
        for (int i=0;i<adj.length;i++){
            if (!visit[i]){
                Explore(i,adj);
            }
        }
        Object[]set=s.values().toArray();
        for (int i=set.length-1;i>=0;i--){
            int val= (int) set[i];
            System.out.print(val+1+" ");
        }
    }

    private static void Explore(int from, List[] adj) {
        visit[from]=true;
        preorder(from);
        for (int i=0;i<adj[from].size();i++){
            if (!visit[(int)adj[from].get(i)]){
                Explore((int)adj[from].get(i),adj);
            }
        }
        postorder(from);
        return;
    }



    static int c=1;
    private static void postorder(int from) {
        s.put(c++,from);
    }
    private static void preorder(int from) {
        c++;
    }
}
