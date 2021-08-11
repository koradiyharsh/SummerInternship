package task1;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import task1.Redblackgeneric.Node;

public class main {
	public static Scanner input = new Scanner(System.in);
	public static void menu(int menuType){
		if(menuType==1){
			/*System.out.println("Menu 1");
			System.out.println("Choose data type of your red black tree");
			System.out.println("1. Integer");
			System.out.println("2. String");
			System.out.println("3. Double");*/
			System.out.println("Menu 2");
			System.out.println("Choose a task that you want to perform");
			System.out.println("1. Find");
			System.out.println("2. Insert");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("5. check Height");
			System.out.println("0. exit");
		
		
		}
	}
	public static void flow(int type){
		int choice;
		int Idata;
		double Ddata;
		String Sdata;
		if(type==1){
		
			//Integer
			//Redblackgeneric<Integer>.Node root = null;
			Redblackgeneric<Integer> redBlackTree = new Redblackgeneric<Integer>();
	        do{
				menu(1);
				choice = input.nextInt();
				switch(choice){
				case 1 : 
					//find
					System.out.print("Enter the Integer you want to find : ");
					Idata = input.nextInt();
					
					Node result =  redBlackTree.searchTree(Idata);
					if(result.data == null)
					{
						
						System.out.println("element not found");
					}
					else {
						System.out.println("element found");
					}
					
					break;
				case 2 :  
					//insert				
					System.out.print("Enter the Integer you want to insert : ");
					Idata = input.nextInt();

					result =  redBlackTree.searchTree(Idata);
					if(result.data == null)
					{
						
						redBlackTree.insert(Idata);
						System.out.println("element inserted!!");
					}
					
					else{
						System.out.println("element found");
					}
					
					
					break;
				case 3 :
					//delete
					System.out.print("Enter the Integer you want to delete : ");
					Idata = input.nextInt();
					
					result = redBlackTree.searchTree(Idata);
					if(result.data == null)
					{
						System.out.println("element doesnot exits!!!");
						
					}
					
					else{
						redBlackTree.deleteNode(Idata); 
						System.out.println("element deteted!!");
						
					}
					
					break;
				case 4:
					System.out.println("Display red black Tree as Below");
					redBlackTree.prettyPrint();
					break;
				case 5:
					Node root = redBlackTree.getRoot();
					 int Height = redBlackTree.treeHeight(root);
					 System.out.println("High of The Tree is -> "+Height);
					break;
				case 0 : 
					break;
				default :
					System.out.println("Please enter a valid input");
					break;
				}
				
				
			}while(choice!=0);
	        
		}
		else if(type==2){
			//String
			Redblackgeneric<String>.Node root = null;
			Redblackgeneric<String> redBlackTree = new Redblackgeneric<String>();
	        do{
				menu(1);
				choice = input.nextInt();
				switch(choice){
				case 1 : 
					
					System.out.print("Enter the String you want to find : ");
					Sdata = input.next();
					
					Node result = redBlackTree.searchTree(Sdata);
					
					if(result.data==null)
					{
						System.out.println("element not found ");
					}
					
					else{
						System.out.println("element found");
					}
					break;
				case 2 :  
					//insert				
					System.out.print("Enter the String you want to insert : ");
					Sdata = input.next();
					result = redBlackTree.searchTree(Sdata);
					
					if( Sdata.equals(result.data) )
					{
						System.out.println("element already exits!!!");
					}
					/*if(redBlackTree.find(root, Sdata)){
						
					}*/
					else{
						redBlackTree.insert(Sdata);
						System.out.println("element inserted!! ");
					}
					
					
					break;
				case 3 :
					//delete
					System.out.print("Enter the String you want to delete : ");
					Sdata = input.next();
					
					result = redBlackTree.searchTree(Sdata);
					
					if(result.data == null)
					{
						System.out.println("element doesnot exits!!!");
					}
					else {
						redBlackTree.deleteNode(Sdata);
						System.out.println("element deteted!!");
					}
					
					
					break;
				case 4:
					System.out.println("Display red black Tree as Below");
					redBlackTree.prettyPrint();
					break;
				case 5:
					 root = redBlackTree.getRoot();
					 int Height = redBlackTree.treeHeight(root);
					 System.out.println("High of The Tree is -> "+Height);
					break;
				case 0 : 
					break;
				default :
					System.out.println("Please enter a valid input");
					break;
				}
				
				
			}while(choice!=0);
	        
		}
		else if(type==3){
		
			//Double
			Redblackgeneric<Double>.Node root = null;
	        Redblackgeneric<Double> redBlackTree = new Redblackgeneric<Double>();
	        do{
				menu(1);
				choice = input.nextInt();
				switch(choice){
				case 1 : 
					//find
					System.out.print("Enter the Double you want to find : ");
					Ddata = input.nextDouble();
					Node result  = redBlackTree.searchTree(Ddata);
					
					if(result.data==null)
					{
						
						System.out.println("element not found");
					}
					
					else{
						System.out.println("element found");
					}
					break;
				case 2 :  
					//insert				
					System.out.print("Enter the Double you want to insert : ");
					Ddata = input.nextDouble();
					result =  redBlackTree.searchTree(Ddata);
					
					if(result.data==null)
					{
						
						redBlackTree.insert(Ddata);
						System.out.println("element inserted!!");
					}
					
					else{
						System.out.println("element already exits!!!");
					}
					
					
					break;
				case 3 :
					//delete
					System.out.print("Enter the Double you want to delete : ");
					Ddata = input.nextDouble();
					result =  redBlackTree.searchTree(Ddata);
					if(result.data==null)
					{
						System.out.println("element doesnot exits!!!");
						
					}
					else{
						redBlackTree.deleteNode(Ddata);
						
					}
					
					break;
				case 4:
					System.out.println("Display red black Tree as Below");
					redBlackTree.prettyPrint();
					break;
				case 5:
						root = redBlackTree.getRoot();
						int Height = redBlackTree.treeHeight(root);
						System.out.println("High of The Tree is -> "+Height);
					break;
				case 0 : 
					break;
				default :
					System.out.println("Please enter a valid input");
					break;
				}
				
				
			}while(choice!=0);
	        
		}
		else if(type==0){}
		else{
			System.out.println("Please enter a valid input");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
		public static void main(String[] args) {
			
			System.out.println("Red Black Tree Provide facility to store different Type of data element ");
	        System.out.println("1 . Integer");
	        System.out.println("2 . String");
	        System.out.println("3 . Double");
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter Your choice for Type");
	        int choice  =  scanner.nextInt();
	        main.flow(choice);
			
	        /*redBlackTree.insert(10);
	        redBlackTree.insert(20);
	        redBlackTree.insert(-4);
	        redBlackTree.insert(-90);
	        redBlackTree.insert(25);
	        redBlackTree.insert(63);
			redBlackTree.prettyPrint();
			
			int data = 20;
			Node result=  redBlackTree.searchTree(data);
			
			if(result.data == null)
			{
				System.out.print("Item Not Found In Tree");
			}
			else{
				System.out.print("Item Found In Tree");
			}*/
			
			
			
			
			/*if(data != (int)result.data)
			{
				System.out.print("Element Not Found in Tree");
			}
			else{
				System.out.print("Element Found in Tree");
			}*/
			/*if((int)result.data == data)
			{
				
			}*/
			/*else{
				
			}*/
			
		}
}
