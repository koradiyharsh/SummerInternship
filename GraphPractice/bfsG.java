import java.util.LinkedList;
import java.util.Queue;

public class bfsG {
    int V;
    LinkedList<Integer> list[];

    bfsG(int vertex)
    {
        V = vertex;
        list = new LinkedList[V];

        for(int i=0;i<V;i++)
        {
            list[i] =  new LinkedList<>();
        }
    }

    public void addEdge(int a , int b)
    {
        list[a].add(b);
        list[b].add(a);
    }
    public void bfss(int start)
    {
        boolean[] visited = new boolean[V];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int temp = queue.peek();
            queue.poll();
            System.out.print(temp+" ");
            for(int u : list[temp])
            {
                if(!visited[u])
                {
                    queue.add(u);
                    visited[u] =true;
                }
            }

        }
    }
    public static void main(String[] args) {
        bfsG g = new bfsG(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfss(2);


    }
}
