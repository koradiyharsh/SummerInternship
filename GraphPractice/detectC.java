import java.util.LinkedList;
import java.util.List;

public class detectC {

    int V;
    List<Integer> list[];

    detectC(int size)
    {
        this.V=size;
        list = new List[V];
        for(int i=0;i<V;i++)
        {
            list[i] = new LinkedList<>();
        }
    }
    public void AddEdge2(int a , int b)
    {
        list[a].add(b);
    }

    boolean[] visited = new boolean[4];

    boolean[] thestack = new boolean[4];
    public boolean isCyclic(int a)
    {



        visited[a] = true;
        thestack[a] = true;

        for(int u : list[a])
        {
            if(!visited[u] && !thestack[u]) {
                isCyclic(u);
                return  true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        detectC detect = new detectC(4);
        detect.AddEdge2(0,1);
        detect.AddEdge2(0,2);
        detect.AddEdge2(1,2);
        detect.AddEdge2(3,3);
        detect.AddEdge2(2,3);


        if(detect.isCyclic(0))
        {
            System.out.println("Cycle found ");
        }
        else
        {
            System.out.println("Cycle is not found ");
        }

    }
}
