import java.util.ArrayList;
import java.util.LinkedList;

public class DetectCycleInDirected
{
    int n ;
    LinkedList<Integer> list[];

    DetectCycleInDirected(int Item)
    {
        n = Item;
        list = new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            list[i] = new LinkedList<>();
        }


    }
    public void addEdge(int a , int b)
    {
        list[a].add(b);
    }

    boolean isCyclic()
    {
        boolean a = false;
        boolean[] visited = new boolean[n];
        boolean[] black = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
             a =  cyclicUntil(i , visited , black);
            }
        }
        return a;

    }

    private boolean cyclicUntil(int i, boolean[] visited, boolean[] black) {

        visited[i] = true;
        black[i] = true;

        for(int u : list[i])
        {
            if(visited[u]==true)
            {
                return true;
            }
            if(!visited[u])
            {
                cyclicUntil(u , visited, black);
            }
        }
        return false;

    }

    public static void main(String[] args)
    {
        DetectCycleInDirected detectcycle = new DetectCycleInDirected(4);
        detectcycle.addEdge(0,1);
        detectcycle.addEdge(0,2);
        detectcycle.addEdge(2,0);
        detectcycle.addEdge(2,3);
        detectcycle.addEdge(3,3);

        if(detectcycle.isCyclic())
        {
            System.out.println("Found !  ");
        }
        else
        {
            System.out.print("Not Found ! ");
        }

    }
}
