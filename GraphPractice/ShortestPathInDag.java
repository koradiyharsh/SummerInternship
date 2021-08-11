import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathInDag
{
    static final  int  INF =Integer.MAX_VALUE;


    class adjList
    {
        public int v;
        public int weigth;

        adjList(int vertex , int w)
        {
            v = vertex;
            weigth = w;
        }
            int getInt()
            {
                return v;
            }
            int getWeight()
            {
                return weigth;
            }
    }
    class Graph3
    {
        public int v;
        public LinkedList<adjList> lists[];
        Graph3(int size)
        {
            v =size;
            lists = new LinkedList[v];
            for(int i =0 ;i<v;i++)
            {
                lists[i] = new LinkedList<adjList>();
            }

        }
        void addEdge(int u , int v , int weight)
        {
            adjList new_node = new adjList( v ,weight);
            lists[u].add(new_node);
        }
        public void Topologiuntil(int a , Stack<Integer> stack ,boolean[] visited )
        {
            visited[a] = true;

            Iterator<adjList> interor = lists[a].listIterator();

            if(interor.hasNext())
            {
                adjList i = interor.next();
                if(!visited[i.getInt()])
                {
                    Topologiuntil(i.getInt() , stack , visited);
                }
            }
            stack.push(new Integer(a));
        }

         void shortestPath1(int a)
        {
            Stack<Integer> stack = new Stack<Integer>();
            boolean[] visited = new boolean[v];
            int[] Destination = new int[v];

            for(int i=0;i<v;i++)
            {
                Destination[i] = Integer.MAX_VALUE;
            }
            Destination[a] =0;
            for(int i=0;i<v;i++)
            {
                visited[i] = false;
            }


            for(int i=0;i<v;i++)
            {
                if(!visited[i])
                {
                    Topologiuntil(i , stack , visited);
                }
            }

            while(stack.empty() == false)
            {
                int u =  stack.pop();

                Iterator<adjList> it;

                if(Destination[u]!=INF)
                {
                            it = lists[u].listIterator();
                            if(it.hasNext())
                            {
                                adjList x = it.next();

                                if(Destination[x.getInt()] > Destination[u]+x.getWeight())
                                {
                                    Destination[x.getInt()] = Destination[u] + x.getWeight();
                                }
                            }
                }

            }

            for(int i=0;i<v ;i++)
            {
                if(Destination[i]==INF)
                {
                        System.out.print("INF");
                }
                else
                {
                    System.out.print(Destination[i]+" ");
                }
            }

        }

    }



    public static void main(String[] args)
    {
     ShortestPathInDag dagg = new ShortestPathInDag();
        Graph3 g =  dagg.new Graph3(6);
        g.addEdge(0,1,5);
        g.addEdge(0,2,3);
        g.addEdge(1,3,6);
        g.addEdge(1,2,2);
        g.addEdge(2,4,4);
        g.addEdge(2,5,2);
        g.addEdge(2,3,7);
        g.addEdge(3,4,-1);
        g.addEdge(4,5,-2);

        int s = 1;
        System.out.println("Following are Shortest distance from source  "+s);
        g.shortestPath1(s);
    }
}
