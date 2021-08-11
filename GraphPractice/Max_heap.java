public class Max_heap {

    public void buildHeap(int[] arr , int n)
    {
        int k = (n-1)/2;
        for(int i = k ;k>=0;k--)
        {
            Heapyfyy( i , arr ,n);
        }

    }

    private void Heapyfyy(int i, int[] arr, int n)
    {
        int  max =i;
        int L = (i*2)+1;
        int R = (i*2)+2;


        if(L < n && arr[max] < arr[L])
        {
            max = L;
        }
        if(R < n && arr[max] < arr[R])
        {
            max = R;
        }

        if(i!=max) {
        int temp =arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
                Heapyfyy(max , arr , n);
        }

    }


    public static void main(String[] args)
    {
        Max_heap max_heap = new Max_heap();
        int arr[] = {1, 3, 5, 4, 6, 13, 10,
                9, 8, 15, 17};
        int n  = arr.length;
        max_heap.buildHeap(arr , n );
        max_heap.printheap(arr , n);

    }

    private void printheap(int[] arr, int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
