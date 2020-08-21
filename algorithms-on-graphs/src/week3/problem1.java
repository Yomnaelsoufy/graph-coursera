package week3;

import java.util.*;

public class problem1 {
    static int[]dist;
    static List[]adj;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        adj=new List[v];
        dist=new int[v];
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList();
        }
        for (int i=0;i<e;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int from=sc.nextInt()-1;
        int to=sc.nextInt()-1;
        int val=Computing_MinimumNum_Of_Flight_Segs(from,to);
        System.out.println(val);
    }

    private static int Computing_MinimumNum_Of_Flight_Segs(int from, int to) {
        dist[from]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(from);

        while (q.isEmpty()==false){
            int u=q.poll();
            List<Integer> l=adj[u];
            for (int i=0;i<l.size();i++){
                int v=l.get(i);
                if (dist[l.get(i)]==0){
                    q.add(v);
                    dist[v]=dist[u]+1;
                    if (v==to)return dist[v];
                }
            }
        }return -1;
    }

}
