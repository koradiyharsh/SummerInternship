import java.util.ArrayList;
import java.util.Arrays;

public class BiaPirtedGraph
{
    public static void addEdge(ArrayList<ArrayList<Integer>> list , int source , int Destination)
    {
        list.get(source).add(Destination);
        list.get(Destination).add(source);
    }
    public static void main(String[] args)
    {
     BiaPirtedGraph graph = new BiaPirtedGraph();
        int N = 6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i <=N;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[N+1];
        int[] color = new int[N+1];
        Arrays.fill(color , -1);



        addEdge(list , 1 ,2);
        addEdge(list , 2 ,3);
        addEdge(list , 3 ,4);
        addEdge(list , 4 ,5);
        addEdge(list , 5 ,6);
        addEdge(list , 6 ,1);
        color[1]  = 0;
        visited[1] = true;
        color[1] =0;

        if(isBipirtedGraph(list , 1 , visited , color))
        {
            System.out.print("yes");
        }
        else
        {
            System.out.print("NO");
        }

    }

    private static boolean isBipirtedGraph(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited, int[] color)
    {

        for(int u : list.get(i))
        {

            if(!visited[u])
            {

                visited[u] = true;

                color[u] = 1 - color[i];

                if(!isBipirtedGraph(list,i,visited , color))
                    return false;
                if(color[u] ==color[i])
                    return false;
            }
        }
        return true;
    }
}
