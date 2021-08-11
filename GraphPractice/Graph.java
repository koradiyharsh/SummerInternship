import javax.swing.*;

class Graph1 {
        class Edge
        {
            int src , destination , weight;
            Edge()
            {
                src =0;
                destination =0;
                weight = 0;
            }
        }
    int Vertex ,Edge;
    Edge edge[];
    Graph1(int v , int e)
    {
        Vertex =v;
        Edge = e;
        edge = new Edge[e];
        for(int i=0;i < Edge;i++)
        {
            edge[i] = new Edge();
        }
    }

    public void bellford(Graph1 g , int start)
    {
        int V = g.Vertex ;
        int E  = g.Edge;

        int[] Destination = new int[V];

        for(int i=0;i<V;i++)
        {
            Destination[i] = Integer.MAX_VALUE;
        }

        Destination[start] =0;

        for(int i=1;i<V;i++)
        {
            for(int j=0;j<E;j++)
            {
                int src = edge[j].src ;
                int dest  = edge[j].destination;
                int weight = edge[j].weight;

                if(Destination[dest] > weight+Destination[src] && Destination[src] !=Integer.MAX_VALUE)
                {
                    Destination[dest] = weight + Destination[src];
                }
            }

            for(int j = 0 ;j<Edge;j++)
            {
                int src = edge[j].src;
                int dest = edge[j].destination;
                int weight = edge[j].weight;

                if(Destination[dest] > weight + Destination[src] && Destination[src]!=Integer.MAX_VALUE)
                {
                    System.out.print("Found Cycle ");
                    return;
                }

            }

        }
        printArr(Destination , V);
    }
    public void printArr(int[] Dest , int vertext)
    {
        for(int i=0;i<vertext;i++)
        {
            System.out.println(i + "  "+Dest[i]+" ");
        }
    }

     public static void main(String[] args)
     {
         int V = 5;
         int E = 8;

         Graph1 graph = new Graph1(V ,E);
         graph.edge[0].src =0;
         graph.edge[0].destination =1;
         graph.edge[0].weight =-1;
         graph.edge[1].src =0;
         graph.edge[1].destination =2;
         graph.edge[1].weight =4;
         graph.edge[2].src =1;
         graph.edge[2].destination =2;
         graph.edge[2].weight =3;
         graph.edge[3].src =1;
         graph.edge[3].destination =3;
         graph.edge[3].weight =2;
         graph.edge[4].src =1;
         graph.edge[4].destination =4;
         graph.edge[4].weight =2;
         graph.edge[5].src =3;
         graph.edge[5].destination =2;
         graph.edge[5].weight =5;
         graph.edge[6].src =3;
         graph.edge[6].destination =1;
         graph.edge[6].weight =1;
         graph.edge[7].src =4;
         graph.edge[7].destination =3;
         graph.edge[7].weight =-3;

         graph.bellford(graph , 0);


     }
}
