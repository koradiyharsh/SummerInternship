import java.util.LinkedList;
import java.util.Queue;

public class bfsAdjancy
{
    int arr[][];
    public void graph(int vertex , int Edge)
    {
        arr = new int[vertex][Edge];
        for(int i=0;i<vertex;i++)
        {
            for(int j=0;j<Edge;j++)
            {
                arr[i][j] = 0;
            }
        }
    }
    public void addEdge(int vertex, int Edge)
    {
        arr[vertex][Edge]=1;
        arr[Edge][vertex]=1;
    }
    public void BFSTree(int start)
    {
        boolean[] visited = new boolean[5];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int temp = queue.peek();
            queue.poll();
            System.out.print(temp + " ");
            for(int i=0;i<4;i++)
            {
                if(arr[temp][i]==1 && visited[i]==false)
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }


        }
    }
    public static void main(String[] args)
    {
            bfsAdjancy BFS = new bfsAdjancy();
            int v = 5 ;
            int e = 4;
            BFS.graph(v ,e);
            BFS.addEdge(0,1);
            BFS.addEdge(0,2);
            BFS.addEdge(1,3);

            BFS.BFSTree(0);

    }
}
