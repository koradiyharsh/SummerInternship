class node1
{
    char data;
    node1 leftChild;
    node1 rightChild;

    node1(char c)
    {
        data = c;
        this.leftChild = null;
        this.rightChild = null;
    }
}
public class DepthRecursion
{
    node1 root;
    void DepthRecursion(node1 root , char goal)
    {

        if(root==null)
            return;
        else
        {
            if(root.data == goal)
                System.out.println("Success ");
            DepthRecursion(root.leftChild , goal);
            DepthRecursion(root.rightChild ,goal);
        }

        return;


    }

    public static void main(String[] args)
    {
            DepthRecursion depth = new DepthRecursion();
            depth.root = new node1('A');
            depth.root.leftChild = new node1('B');
            depth.root.rightChild = new node1('C');
            depth.root.leftChild.leftChild = new node1('D');
            depth.root.leftChild.rightChild = new node1('E');
            depth.root.rightChild.leftChild = new node1('F');

            depth.DepthRecursion(depth.root , 'F');
            /*if(Result!=null)
            {
                System.out.println("Success ");
            }
            else
            {
                System.out.println("Not Success  ");
            }*/


    }
}
