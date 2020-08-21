package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem1 {

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
        int from=sc.nextInt()-1;
        int to=sc.nextInt()-1;
        System.out.println(Finding_an_Exit_from_A_Maze(adj,from,to));
    }

    private static int Finding_an_Exit_from_A_Maze(List[] adj, int from, int to) {
        return Explore(from,to,adj);

    }

    private static int Explore(int from, int to, List[] adj) {
        visit[from]=true;
        if (from==to)
            return 1;
        for (int i=0;i<adj[from].size();i++){
            if (!visit[(int)adj[from].get(i)]){
                int ex= Explore((int)adj[from].get(i),to,adj);
                if (ex==1)return 1;
            }
        }
        return 0;
    }
}
