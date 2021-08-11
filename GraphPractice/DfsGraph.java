import java.util.ArrayList;
import java.util.LinkedList;

public class DfsGraph
{
    int n;
    LinkedList<Integer> list[];

    DfsGraph(int Item)
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
    public void DFS()
    {
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                DFSutil(i,visited);
            }
        }
    }

    private void DFSutil(int i, boolean[] visited)
    {
        visited[i] = true;
        System.out.print(i+" ");

        for(int u : list[i])
        {
            if(!visited[u])
            {
                DFSutil(u ,visited);
            }
        }
    }

    public static void main(String[] args)
    {
        DfsGraph dfs = new DfsGraph(4);
        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,0);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        System.out.println("Depth First Traversal  ");
        dfs.DFS();


    }
}
