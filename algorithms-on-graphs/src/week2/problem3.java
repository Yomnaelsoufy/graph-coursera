package week2;

import java.util.*;

public class problem3 {
    static boolean[]visit;
    static boolean []rev_visit;
    static SortedMap<Integer,Integer> s=new TreeMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        List[]adj=new List[v];
        List[]rev=new List[v];
        visit=new boolean[v];
        rev_visit=new boolean[v];
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList();rev[i]=new ArrayList();}
        int ed=sc.nextInt();
        for (int i=0;i<ed;i++){
            int a=sc.nextInt()-1,b=sc.nextInt()-1;
            adj[a].add(b);
            rev[b].add(a);
        }
        SCCs(adj,rev);
    }

    private static void SCCs(List[] adj,List[]rev) {

        for (int i=0;i<rev.length;i++){
            if (!rev_visit[i]){
                Explore(i,rev);
            }

        }
        Object[] a=s.values().toArray();
        int l=0;
        for (int i=a.length-1;i>=0;i--)
        {
            if (!visit[(int)a[i]]){
                rexplore((int)a[i],adj);
                l++;
            }
        }
        System.out.println(l);
        return ;
    }

    private static void rexplore(int from, List[] adj) {
        visit[from]=true;
        for (int i=0;i<adj[from].size();i++){
            if (!visit[(int)adj[from].get(i)]){
                rexplore((int)adj[from].get(i),adj);
            }
        }
        return;
    }

    private static void Explore(int from, List[]rev) {
        rev_visit[from]=true;
        preorder(from);
        for (int i=0;i<rev[from].size();i++){
            if (!rev_visit[(int)rev[from].get(i)]){
                Explore((int)rev[from].get(i),rev);
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