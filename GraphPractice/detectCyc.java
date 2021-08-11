import java.util.ArrayList;
import java.util.List;

public class detectCyc
{
    int V;
    List<Integer> list[];

    detectCyc(int Vertex)
    {
        V = Vertex;
        list = new List[V];
        for(int i=0;i<V;i++)
        {
            list[i] =  new ArrayList<>();
        }
    }
    public void addEdge3(int a , int b)
    {
        list[a].add(b);
        list[b].add(a);
    }
    public boolean iscyclic(int a , boolean[] visited , int parent)
    {
        visited[a] = true;

        for(int u : list[a])
        {
            if(!visited[u])
            {
                iscyclic(u ,  visited , a);
            }
            else if(parent!=u)
                return  true;
        }
        return false;
    }
    public boolean isCyclic()
    {
        boolean[] visited =  new boolean[V];
        boolean result = false;
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
                result  = iscyclic(i , visited , -1);
        }
        return result;
    }
    public static void main(String[] args)
    {
    detectCyc cycle = new detectCyc(5   );
    cycle.addEdge3(1,0);
    cycle.addEdge3(0,2);
    cycle.addEdge3(2,1);
    cycle.addEdge3(0,3);
    cycle.addEdge3(3,4);
    if(cycle.isCyclic())
    {
        System.out.println("Cyclic ");
    }
    else
    {
        System.out.println("Not Cyclic ");
    }



    }
}
