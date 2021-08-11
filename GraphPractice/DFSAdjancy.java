public class DFSAdjancy
{
    int[][] arr;
    public void Graph(int Vertex , int Edge)
    {
        arr = new int[Vertex][Vertex];
        for(int i=0;i<Vertex;i++)
        {
            for(int j=0;j<Vertex;j++)
            {
                arr[i][j] = 0;
            }
        }
    }
    public void addEdge(int vertex , int Edge)
    {
        arr[vertex][Edge] = 1;
        arr[Edge][vertex] = 1;
    }
    public void DFSAdjancy(int i , boolean visited[])
    {
        visited[i] = true;
        System.out.print(i+"  ");
        for(int j=0;j<5;j++)
        {
            if(arr[i][j] == 1 && visited[j]==false)
            {
                DFSAdjancy(j , visited);
            }
        }
    }
    public static void main(String[] args)
    {
        DFSAdjancy dfs = new DFSAdjancy();
        int v = 5;
        int e = 4;

        dfs.Graph(v,e);
        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(0,3);
        dfs.addEdge(0,4);
        boolean[] visited = new boolean[v];
        dfs.DFSAdjancy(0  , visited);

    }
}
