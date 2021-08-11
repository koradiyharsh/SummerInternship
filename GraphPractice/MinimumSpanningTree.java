public class MinimumSpanningTree
{
    public static int  tsp(int[][] graph , boolean[] visited , int start  , int end , int counter , int cost , int answer)
    {

            if(counter == end && graph[start][0] > 0 )
            {
                    answer = Math.min(answer ,  cost+graph[start][0]);
                    return answer;

            }
            for(int i =0 ;i<end ; i++) {
                if (visited[i] == false && graph[start][i] > 0 ) {

                    visited[i] = true;
                    answer = tsp(graph, visited, i, end, counter + 1, cost+graph[start][i], answer);

                    visited[i] = false;
                }
            }

        return answer;
    }
    public static void main(String[] args)
    {
     MinimumSpanningTree tree = new MinimumSpanningTree();
     int n = 4;
     int[][] graph  =new int[][]
        {
                {0,10,15,20},
                {10,0,35,25},
                {15,35,0,30},
                {20,25,30,0}

        };

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int ans = Integer.MAX_VALUE;
        ans  = tsp(graph , visited , 0 , n , 1 , 0 , ans);
        System.out.println(" === >   "+ans);


    }
}
