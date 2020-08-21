package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem2 {
    static boolean[]visit;
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
            adj[b].add(a);
        }
        System.out.println(Adding_Exits_to_a_Maze(adj));
    }

    private static int Adding_Exits_to_a_Maze(List[] adj) {
        int c=0;
        for (int i=0;i<adj.length;i++){
            if (!visit[i]){
                Explore(i,adj);
                c++;}

        }
        return c;
    }

    private static void Explore(int from, List[] adj) {
        visit[from]=true;
        for (int i=0;i<adj[from].size();i++){
            if (!visit[(int)adj[from].get(i)]){
                Explore((int)adj[from].get(i),adj);
            }
        }
        return;
    }
}
