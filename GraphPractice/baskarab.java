import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
public class baskarab {
    int m_v;
    List<Integer>[] ArrayList;
    baskarab(int n)
    {
        m_v = n;
        ArrayList = new List[m_v];
        for(int i=0;i<m_v;i++)
        {
            ArrayList[i]  = new ArrayList<>();
        }

    }
    public void addEdge(int a , int b)
    {
        ArrayList[a].add(b);
    }
    public void DFSrecur(int a , boolean[] visited , Stack<Integer> stack)
    {
        visited[a] = true;

        for( int u:  ArrayList[a])
        {
            if(!visited[u]){

                DFSrecur(u , visited , stack);
            }
        }
        stack.push(a);
    }

    public void DFS()
    {
        boolean[] visited = new boolean[m_v];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<m_v;i++)
        {
            if(!visited[i]){
                DFSrecur(i,visited,stack);
            }
        }
        System.out.println();

        while(!stack.empty())
        {
            System.out.print(stack.peek()+"  ");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        baskarab g = new baskarab(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.DFS();


    }
}