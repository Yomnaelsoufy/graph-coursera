package week4;

import java.util.*;

public class problem2 {
    static List[]adj;
    static int[]dist;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        adj=new List[v];
        dist=new int[v];
        for (int i=0;i<v;i++){
            adj[i]=new ArrayList<Edge>();
            dist[i]=-1;
        }
        for (int i=0;i<e;i++){
            int from=sc.nextInt()-1;
            int to=sc.nextInt()-1;
            int wt=sc.nextInt();
            adj[from].add(new Edge(to,wt));
        }
        int val=Detecting(v);
        System.out.println(val);
    }

    private static int Detecting(int v) {
        for (int i=0;i<v;i++){
            int det=Detecting_Anomalies_in_Currency_Exchange_Rates(i);
            if (det==1)return 1;
        }return 0;
    }

    private static int Detecting_Anomalies_in_Currency_Exchange_Rates(int from) {
        SortedMap<Integer,List<Integer>> q=new TreeMap<>();//dist,node`to`
        List l=new ArrayList();boolean b=false;
        dist[from]=0;int ver=dist.length;
        l.add(from);
        q.put(0,l);
        int c=0;
        while (!q.isEmpty()){c++;b=false;
            int distnode=q.firstKey();
            List<Integer>lst=q.get(distnode);
            int node=lst.get(0);
            if (lst.size()==1)
                q.remove(distnode);
            else {lst.remove(0);q.put(distnode,lst);}
            for (int i=0;i<adj[node].size();i++){
                Edge ind= (Edge) adj[node].get(i);
                int v=ind.to;
                int wt=ind.wt;
                if (dist[v]>distnode+wt||dist[v]==-1){b=true;
                    dist[v]=distnode+wt;
                    List <Integer>tem=q.getOrDefault(dist[v],new ArrayList<>());
                    tem.add(v);
                    q.put(dist[v],tem);
                }

            }
            if (c==ver&&b)return 1;
            else if (c==ver&&!b)return 0;
        }return 0;
    }

}