import java.util.Scanner;

class Nodeee
{
    int rollno;
    Nodeee next;
}
public class PSinglyLinkedList 
{
    
    Nodeee Start;
    PSinglyLinkedList()
    {
        Start=null;
    }
    void addnode()
    {
       
        int count=0;
        System.out.println("Enter your rollno");
        
        Scanner sc2 = new Scanner(System.in);
        int rn=sc2.nextInt();
        int s=rn;
        
        for(int i=2;i<=rn;i++)
        {
            if(s%i==0)
            {
                count++;
            }
        }  
       if(count==1)
       {
        
            Nodeee newnode=new Nodeee();
            newnode.rollno=rn;
            newnode.next=null;

            if(Start==null)
            {
                Start=newnode;
            }
            else
            {
                Nodeee current=Start;
                while(current.next!=null)
                {
                    current=current.next;
                }
                current.next=newnode;
            }
            System.out.println("Data inserted");
        }
        else
        {
            System.out.println("rn is not prime");
        }
    }
    
    void deletenode()
    {
        if(Start==null)
        {
            System.out.println("List is empty");
        }
        /*else
        {
            System.out.println("Deleted element :"+ Start.rollno);
            Start=Start.next;
        }
        */
        
        else
        {
            Nodeee current=Start;
            while(current.next.next!=null)
            {
                current=current.next;
            }
            current.next=null;
        }
        
    }
    void traversenode()
    {
        if(Start==null)
        {
            System.out.println("List empty");
        }
        else
        {
            for(Nodeee current=Start;current!=null;current=current.next)
            {
                System.out.print(" "+current.rollno);
            }
        }
            
    }
    void searchnode()
    {
        if(Start==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            Scanner in=new Scanner(System.in);
            System.out.println("Enter searching element");
            
            int se=in.nextInt();
            
            Nodeee current;
            int count=0;
            for(current=Start;current!=null;current=current.next)
            {
                if(current.rollno==se)
                {
                    count=count+1;
                    break;
                }
            }
            if(count>0)
            {
                System.out.println("Roll number found");
            }
            else
            {
                System.out.println("Roll number not found");
            }
        }
    }
    
    public static void main(String args[])
    {
        PSinglyLinkedList obj = new PSinglyLinkedList();
        
        while(true)
        {
            System.out.println("\npress 1 for insert");
            System.out.println("press 2 for delete");
            System.out.println("press 3 for traverse");
            System.out.println("press 4 for search");
            System.out.println("press 5 for exit");
            
            
            System.out.println("\nEnter your choice");
            Scanner sc =new Scanner(System.in);
            int ch=sc.nextInt();
            
            switch(ch)
            {
                case 1:
                    obj.addnode();
                    break;
                case 2:
                    obj.deletenode();
                    break;
                case 3:
                    obj.traversenode();
                    break;
                case 4:
                    obj.searchnode();
                    break;
                case 5:
                    System.exit(0);
                    break;
               
                default:
                    System.out.println("Wrong choice ");
                
            }

        }
    }
}
