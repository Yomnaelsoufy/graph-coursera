package week5;

import java.util.*;

public class problem1 {
    static int x[],y[],v,set[],cyc;
    static SortedMap<Double, List<Ed>> e=new TreeMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        x=new int[v];
        y=new int[v];cyc=v;
        set=new int[v];
        for (int i=0;i<v;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        Caldist(v);
        makesets();
        double v=Building_Roads_to_Connect_Cities();
        System.out.println(v);
    }

    private static double Building_Roads_to_Connect_Cities() {
        double val=0;
        while (!e.isEmpty()){
            double t=e.firstKey();
            List l=e.get(t);
            Ed ed= (Ed) l.get(0);
            if (l.size()==1){
                e.remove(t);
            }
            else {
                l.remove(0);
                e.put(t,l);
            }
            if (find(ed.to)!=find(ed.from)){
                val+=t;
                union(ed.from,ed.to);
            }
        }
        return val;
    }
    static int find(int i){
        while (set[i]!=i){
            set[i]=set[set[i]];
            i=set[i]; }
        return i;
    }
    static void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if (pa!=pb){
            set[pa]=pb ;}
    }
    private static void makesets() {
        for (int i=0;i<v;i++){
            set[i]=i;
        }
    }
    private static void Caldist(int v) {
        for (int i=0;i<x.length-1;i++){
            for (int j=i+1;j<x.length;j++){
                double wt=Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2));
                List<Ed>l=e.getOrDefault(wt,new ArrayList<>());
                l.add(new Ed(i,j));
                e.put(wt,l);
            }
        }
    }

}
class Ed{
    int from,to;
    Ed(int from,int to){
        this.from=from;
        this.to=to;
    }
}