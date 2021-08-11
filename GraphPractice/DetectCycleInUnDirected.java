import java.util.ArrayList;
import java.util.LinkedList;

public class DetectCycleInUnDirected
{
    int n;
    LinkedList<Integer> list[];

    DetectCycleInUnDirected(int Item)
    {
        n = Item;
        list = new LinkedList[n];

        for(int i=0;i<n;i++)
        {
            list[i] = new LinkedList<>();
        }
    }
    public void addEdge(int a ,int b)
    {
        list[a].add(b);
        list[b].add(a);
    }
    boolean isGraph()
    {
        boolean a = false;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                a=FindCycleUndirected(i , visited,-1);
            }
        }
        return a;

    }

    private boolean FindCycleUndirected(int i, boolean[] visited, int parent)
    {
        visited[i] = true;

        for(int u : list[i])
        {
            if(visited[u] && parent!=u)
            {
             return true;
            }
            if(!visited[u])
            {
                FindCycleUndirected(u , visited , i);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        DetectCycleInUnDirected cycle = new DetectCycleInUnDirected(5);
        cycle.addEdge(1,0);
        cycle.addEdge(0,2);
        cycle.addEdge(0,4);
        cycle.addEdge(0,3);
        cycle.addEdge(3,4);

        if(cycle.isGraph())
        {
            System.out.print("Found! ");
        }
        else
        {
            System.out.print("not Found ");
        }

    }
}
