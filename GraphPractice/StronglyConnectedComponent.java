import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

    int V;
    List<Integer> list[];
    StronglyConnectedComponent(int Item)
    {
        V = Item;
        list = new List[V];
        for(int i=0;i<V;i++)
        {
            list[i]= new ArrayList<>();
        }

    }
    public void addEdge(int a , int b)
    {
            list[a].add(b);
    }
    public void sscDFS(int a  , boolean[] visited)
    {
        visited[a]  = true;
        System.out.print(a+" ");
        for(int u : list[a])
        {
            if(!visited[u])
            {
                sscDFS(u , visited );
            }

        }
        //stack.push(a);
    }
    StronglyConnectedComponent changeEdge()
    {
        StronglyConnectedComponent gg = new StronglyConnectedComponent(V);
       for(int i=0;i<V;i++)
       {
           Iterator<Integer> g = list[i].listIterator();
           while(g.hasNext()){
                gg.list[g.next()].add(i);
           }
       }
       return  gg;

    }

    public void dfsCallsAnotherTime(int a , boolean[] visited , Stack<Integer> stack)
    {
        visited[a] = true;

        for(int u : list[a])
        {
            if(!visited[u])
            {
                dfsCallsAnotherTime(u,visited , stack);
            }
        }
        stack.push(a);
    }


    public void printSSC()
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<V;i++)
        {
            visited[i] = false;
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                sscDFS(i , visited );
            }
        }
        for(int i=0;i<V;i++)
        {
            visited[i] = false;
        }
        changeEdge();
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfsCallsAnotherTime(i , visited , stack);
            }
        }
        for(int x =0;x<V;x++)
        {
            visited[x] = false;
        }
        while(!stack.isEmpty())
        {
            int v = stack.pop();
            if(visited[v] == false)
            {
                sscDFS(v , visited);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        StronglyConnectedComponent connected = new StronglyConnectedComponent(5);
        connected.addEdge(1,0);
        connected.addEdge(0,2);
        connected.addEdge(2,1);
        connected.addEdge(0,3);
        connected.addEdge(3,4);
        System.out.println("Folling are Strongly Connected Component  In Given Graph ");
        connected.printSSC();
    }
}
