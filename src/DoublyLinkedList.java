import java.util.Scanner;

class Nodee
{
    int rollno;
    Nodee previous;
    Nodee next;
}

public class DoublyLinkedList 
{
    Nodee Start;
    
    DoublyLinkedList()
    {
        Start=null;
    }
    void addnode()
    {
        
        System.out.println("Enter roll number");
        Scanner sc2=new Scanner(System.in);
        int rn=sc2.nextInt();
        
        Nodee newnode= new Nodee();
        newnode.rollno=rn;
        newnode.previous=null;
        newnode.next=null;
        
        if(Start==null)
        {
            Start=newnode;
        }
        else
        {
            Nodee current=Start;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newnode;
            newnode.previous=current;
        }
        System.out.println("---Data inserted---");
        
    }
    void deletenodebegin()
    {
        if(Start==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            System.out.println("deleted :" + Start.rollno);
            Start=Start.next;
            Start.previous=null;
            
        }
    }
    void deletenodelast()
    {
        if(Start==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            if(Start.next==null)
            {
                System.out.println("Deleted element :" + Start.rollno);
                Start=null;
            }
            else
            {
                Nodee ptr=Start;
                Nodee current=Start;
                while(current.next!=null)
                {
                    ptr=current;
                    current=current.next;
                }
                System.out.println("Delted element :"+current.rollno);
                ptr.next=null;
                
                
                /*Nodee current;
                for(current=Start;current!=null;current=current.next)
                {
                    if(current.next.next==null)
                    {
                        System.out.println("Deleted element :"+current.rollno);
                        current.next=null;
                    }
                }*/
            }
        }
    }
    void deleteanynode()
    {
        if (Start==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            boolean check = false;
            System.out.println("Enter the rollno you wants to delete :");
            Scanner sc4 =new Scanner(System.in);
            int dsea=sc4.nextInt();
            if(Start.rollno==dsea)
            {
                if(Start.next==null)
                {
                    Start = null;
                    check = true;
                }
                else
                {
                    Start = Start.next;
                    Start.previous = null;
                    check = true;
                }
            }
            else{
                for(Nodee current=Start;current!=null;current=current.next)
                {
                    if(current.rollno==dsea)
                    {
                        if(current.next==null){
                            current.previous.next = null;
                            return;
                        }
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                        check = true;
                    }
                }
            }
            if(check)
            {
                System.out.println("Element Deleted " + dsea);
            }
        }
    }
    void traverse()
    {
        if(Start==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            //forward
            System.out.println("-----Forward----");
            Nodee current=Start;
            Nodee tmp=current;
            
            for(current=Start; current!=null; current=current.next)
            {
                tmp=current;
                System.out.print(" "+current.rollno);
            }
            //reverse
            System.out.println("\n----Reverse----");
            Nodee temp;
            for(temp=tmp;temp!=null;temp=temp.previous)
            {
                System.out.print(" "+temp.rollno);
                
            }
        }
    }
    void search()
    {
        if(Start==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            int count=0;
            Scanner sc3=new Scanner(System.in);
            int sea=sc3.nextInt();
            
            for(Nodee current=Start;current!=null;current=current.next)
            {
                if(current.rollno==sea)
                {
                    count++;
                    break;
                }
            }
            if(count>0)
            {
                System.out.println("Found");
                
            }
            else
            {
                System.out.println("Not Found");
            }
        }
    }
    public static void main(String args[])
    {
       DoublyLinkedList obj=new DoublyLinkedList();
       
       while(true)
       {
           Scanner in = new Scanner(System.in);
           
           System.out.println("\nPress 1 for insert");
           System.out.println("Press 2 for deletenodebegin");
           System.out.println("Press 3 for traverse");
           System.out.println("Press 4 for search");
           System.out.println("Press 5 for deltenodelast");
           System.out.println("Press 6 for exit");
           System.out.println("Press 7 for deleteanynode");
           
           
           System.out.println("Enter your choice");
           int ch=in.nextInt();
           
           if(ch==1)
           {
               obj.addnode();
           }
           else if(ch==2)
           {
               obj.deletenodebegin();
           }
           else if(ch==3)
           {
               obj.traverse();
           }
           else if(ch==4)
           {
               obj.search();
           }
           else if(ch==5)
           {
               obj.deletenodelast();
           }
           else if(ch==6)
           {
               System.exit(0);
           }
           else if(ch==7)
           {
               obj.deleteanynode();
           }
           else
           {
               System.out.println("Wrong choice");
           }
       }
    }
    
    
}
