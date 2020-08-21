package week4;

import java.util.*;

public class problem1
{
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
        int from=sc.nextInt()-1;
        dist[from]=0;
        int to=sc.nextInt()-1;
        int val=Computing_Minimum_CostOf_Flight(from,to);
        System.out.println(val);
    }

    private static int Computing_Minimum_CostOf_Flight(int from, int to) {
        SortedMap<Integer,List<Integer>> q=new TreeMap<>();//dist,node`to`
        List l=new ArrayList();
        l.add(from);
        q.put(0,l);
        while (!q.isEmpty()){
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
                if (dist[v]>distnode+wt||dist[v]==-1){
                    dist[v]=distnode+wt;
                    List <Integer>tem=q.getOrDefault(dist[v],new ArrayList<>());
                    tem.add(v);
                    q.put(dist[v],tem);
                }

            }
        }
        return dist[to];
    }

}
class Edge{
    int to,wt;
    Edge(){}
    Edge(int to,int wt){
        this.to=to;
        this.wt=wt;
    }
}