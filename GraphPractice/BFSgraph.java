import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BFSgraph
{
    int n;
    LinkedList<Integer> list[];

    BFSgraph(int Size) {
        n = Size;
        list = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }
    }
    public void addEdge(int a , int b)
    {
        list[a].add(b);
    }
    public void BFS(int start)
    {
        System.out.println(" ");
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty())
        {

            int s  = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = list[s].listIterator();

            while(i.hasNext())
            {
                int n = i.next();
                {

                    if(visited[n]==false)
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }

            }

        }



    }
    public static void main(String[] args)
    {
        BFSgraph graph = new BFSgraph(6);
            graph.addEdge(0,1);
            graph.addEdge(0,2);
            graph.addEdge(1,2);
            graph.addEdge(2,0);
            graph.addEdge(2,3);
            graph.addEdge(3,3);
        System.out.print("Start from The 2 ");

        graph.BFS(2);


    }
}
