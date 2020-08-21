package week4;

import java.util.*;

public class problem3 {

    static List[]adj;
    static Long[]dist;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        adj=new List[v];
        dist=new Long[v];
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList<Edge>();
            dist[i]=Long.MAX_VALUE;
        }
        for (int i=0;i<e;i++){
            int from=sc.nextInt()-1;
            int to=sc.nextInt()-1;
            int wt=sc.nextInt();
            adj[from].add(new Edge(to,wt));
        }
        int from=sc.nextInt()-1;
        Detecting_Anomalies_in_Currency_Exchange_Rates(from);
    }
    static List<Integer>reacable=new ArrayList<>();
    static List<Edge> vi=new ArrayList<>();
    private static void Detecting_Anomalies_in_Currency_Exchange_Rates(int from) {
        reacable.add(from);
        sourceBFS(from);
        dist[from]=(long)0;
        for (int i=0;i<dist.length-1;i++){
            RelaxAllEdges(from,false);
        }
        visit=new boolean[dist.length];
        RelaxAllEdges(from,true);
        for (int i=0;i<vi.size();i++){
            if (!visit[vi.get(i).to])
                BFS(vi.get(i).to);
        }
        for (int i=0;i<dist.length;i++){
            if (dist[i] == Long .MAX_VALUE) {
                System.out.println("*");
            } else if (dist[i] == Long.MIN_VALUE) {
                System.out.println("-");

            } else if (i == from) System.out.println(0);
            else System.out.println(dist[i]);
        }
    }

    private static void sourceBFS(int from) {
        Queue<Integer> q=new LinkedList<>();
        q.add(from);
        int[]temdist=new int[dist.length];
        while (q.isEmpty()==false){
            int u=q.poll();
            List<Edge> l=adj[u];
            for (int i=0;i<l.size();i++){
                Edge v=l.get(i);
                if (temdist[v.to]==0){
                    q.add(v.to);reacable.add(v.to);
                    temdist[v.to]=temdist[u]+1;
                }
            }
        }
    }

    static boolean[]visit;
    private static void RelaxAllEdges(int from, boolean b) {

        for (int i=0;i<reacable.size();i++){
            int x=reacable.get(i);
            for (int j=0;j<adj[x].size();j++){
                int u=x;
                Edge e= (Edge) adj[x].get(j);
                int v=e.to;
                if (dist[v]>dist[u]+e.wt){
                    dist[v]=dist[u]+e.wt;
                    if (b){vi.add(e);}
                }
            }
        }
    }
    private static void BFS(Integer from) {
        Queue<Integer> q=new LinkedList<>();
        q.add(from);
        int[]temdist=new int[dist.length];
        while (q.isEmpty()==false){
            int u=q.poll();
            visit[u]=true;
            List<Edge> l=adj[u];
            for (int i=0;i<l.size();i++){
                Edge v=l.get(i);
                if (temdist[v.to]==0){
                    q.add(v.to);
                    dist[v.to]=Long.MIN_VALUE;
                    temdist[v.to]=temdist[u]+1;
                }
            }
        }
    }
}
