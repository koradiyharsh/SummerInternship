
import java.util.LinkedList;

public class prepostTime
{
    int Item;
    LinkedList<Integer> list[];

    prepostTime(int n)
    {
        Item = n ;
        list = new LinkedList[Item];

        for(int i=0;i<Item;i++)
        {
            list[i] =  new LinkedList();
        }

    }
    public void AddEdge(int a , int b)
    {
        list[a].add(b);
    }
    int counter=0;

    public void dfsUntil(int a , boolean[] visited , int[] pre , int[] post)
    {
        visited[a] = true;
        pre[a] = counter++;

        for(int u : list[a])
        {
            if(!visited[u])
            {
                dfsUntil(u , visited , pre ,post);
            }

        }
        post[a] = counter++;


    }
    void dfsPrePost()
    {
        boolean[] visited = new boolean[Item];
        int Pre[] = new int[Item];
        int Post[] = new int[Item];

        for(int i=0;i<Item;i++)
        {
            if(!visited[i])
            {
                dfsUntil(i , visited,  Pre , Post);
            }
        }
        for(int i=0;i<Item;i++)
        {
            System.out.println("  "+i+" Pre  " +Pre[i]+  "  Post  "+Post[i]);
        }
    }

    public static void main(String[] args)
    {
        prepostTime prepost = new prepostTime(5);
        prepost.AddEdge(0,1);
        prepost.AddEdge(0,3);
        prepost.AddEdge(1,2);
        prepost.AddEdge(3,2);
        prepost.AddEdge(3,4);


        prepost.dfsPrePost();

    }
}
