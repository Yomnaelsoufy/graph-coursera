package week3;

import java.util.*;

public class problem2 {    static int[]dist;
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
        int val=Computing_MinimumNum_Of_Flight_Segs(0);
        System.out.println(val);
    }

    private static int Computing_MinimumNum_Of_Flight_Segs(int from) {
        dist[from]=2;
        Queue<Integer> q=new LinkedList<>();

        int w=2,b=3,vl;
        boolean visit[]=new boolean[adj.length];

        for (int j=0;j<adj.length;j++){ from=j; q.add(from);
            if (!visit[j]){
                visit[from]=true;
                while (q.isEmpty()==false){
                    int u=q.poll();
                    if(dist[u]==w)vl=b;
                    else vl=w;
                    List<Integer> l=adj[u];
                    for (int i=0;i<l.size();i++){
                        int v=l.get(i);
                        visit[v]=true;
                        if (dist[v]==0){
                            q.add(v);
                            dist[v]=vl;
                        }
                        else if (dist[v]!=vl)return 0;
                    }}}
        }return 1;
    }
}
