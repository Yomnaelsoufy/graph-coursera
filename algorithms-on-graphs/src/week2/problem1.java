package week2;

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
        }
        System.out.println(Checking_Consistency_of_CS_Curriculum(adj));
    }

    private static int Checking_Consistency_of_CS_Curriculum(List[] adj) {
        for (int i=0;i<adj.length;i++){
            if(!visit[i]){if (Explore(i,i,adj)==1){
                return 1;
            }
            }
        }
        return 0;

    }

    private static int Explore(int start, int ind, List[] adj) {
        if (start==ind&&visit[ind])
            return 1;
        visit[ind]=true;
        for (int i=0;i<adj[ind].size();i++){
            if (!visit[(int)adj[ind].get(i)]){
                int ex= Explore(start,(int)adj[ind].get(i),adj);
                if (ex==1)return 1;
            }
            else if (visit[(int)adj[ind].get(i)]&&(int)adj[ind].get(i)==start){return 1;}
        }
        return 0;
    }
}
