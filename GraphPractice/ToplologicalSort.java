import java.util.*;

public class ToplologicalSort
{
    int V;
    List<Integer> list[];

    ToplologicalSort(int size)
    {
        this.V  = size;
        list = new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            list[i] =  new ArrayList<>();
        }
    }
    public void addEdge1(int a , int b)
    {
        list[a].add(b);

        for(int i=0;i<V;i++);

    }



    public void toposort()
    {


        int[] indegree = new int[V];
        for(int i=0;i<V;i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) list[i];

            for (int node : temp) {
                ++indegree[node];
            }
        }

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int j=0;j<V;j++)
            {
                if(indegree[j]==0)
                {

                    queue.add(j);
                }

            }
            int cnt=0;
            Vector<Integer> toporder = new Vector<Integer>();
            while (!queue.isEmpty())
            {

                int temp1 = queue.poll();
                toporder.add(temp1);
                for(int node: list[temp1])
                {
                    if(--indegree[node]==0)
                    {
                        queue.add(node);
                    }
                }
                cnt++;
            }
            if(cnt !=V )
            {
                System.out.println("Cycle Exist ");
                return;
            }

            for(int ii :toporder)
            {
                System.out.print(ii+" ");
            }

        }


    public static void main(String[] args)
    {
        ToplologicalSort topo  = new ToplologicalSort(6);
        topo.addEdge1(5,2);
        topo.addEdge1(5,0);
        topo.addEdge1(4,0);
        topo.addEdge1(4,1);
        topo.addEdge1(2,3);
        topo.addEdge1(3,1);

        topo.toposort();


    }
}
