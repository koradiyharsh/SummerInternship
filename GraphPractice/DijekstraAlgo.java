public class DijekstraAlgo
{
    static final  int V =9;

    public int findMinDist(int[] Distance , boolean[] bool)
    {
        int min  = Integer.MAX_VALUE , index_min =-1;
        for(int i=0;i<Distance.length;i++)
        {
            if(bool[i] ==false && min >= Distance[i])
            {
                min =Distance[i];
                index_min = i;
            }
        }
        return index_min;
    }
    public void dijekstra(int[][] graph , int source )
    {

        int[] distance = new int[V];
        boolean[] septset = new boolean[V];

        for(int i=0;i<V;i++)
        {
            distance[i] = Integer.MAX_VALUE;
            septset[i] = false;
        }
        distance[source] =0;

        for(int i=0;i<V-1;i++)
        {

            int u = findMinDist( distance,septset);
            septset[u] = true;
            for(int j=0;j<V;j++)
            {

                if(graph[i][j]!=0 && !septset[j] && distance[i]!=Integer.MAX_VALUE && distance[j] > distance[i]+graph[i][j])
                {
                    distance[j] = distance[i]+graph[i][j];
                }


            }

        }
        priintsolution(distance);

    }


    private void priintsolution(int[] distance)
    {
        for(int k =0;k < distance.length;k++)
        {
            System.out.print(distance[k]+" ");
        }
    }

    public static void main(String[] args)
    {
        DijekstraAlgo Dije = new DijekstraAlgo();
        int graph[][] = new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0   },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0  },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2   },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0  },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0  },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6   },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7  },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0   }
        };
        Dije.dijekstra(graph , 0 );
    }
}
