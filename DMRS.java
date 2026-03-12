import java.util.*;

/* PATIENT CLASS */

class Patient{
    int id;
    String name;
    int age;

    Patient(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
}

/* LINKED LIST */

class Node{
    Patient data;
    Node next;

    Node(Patient data){
        this.data=data;
        next=null;
    }
}

class PatientList{

    Node head;

    void insert(Patient p){

        Node newNode=new Node(p);

        if(head==null)
            head=newNode;

        else{
            Node temp=head;

            while(temp.next!=null)
                temp=temp.next;

            temp.next=newNode;
        }

        System.out.println("Patient Added Successfully");
    }

    void display(){

        Node temp=head;

        System.out.println("\nPatient Records");

        while(temp!=null){

            System.out.println(temp.data.id+" "+temp.data.name+" "+temp.data.age);
            temp=temp.next;

        }
    }

    void delete(int id){

        Node temp=head,prev=null;

        while(temp!=null){

            if(temp.data.id==id){

                if(prev==null)
                    head=temp.next;

                else
                    prev.next=temp.next;

                System.out.println("Patient Deleted");
                return;
            }

            prev=temp;
            temp=temp.next;
        }

        System.out.println("Patient not found");
    }

}

/* SEARCHING */

class Searching{

    static int linear(int arr[],int key){

        for(int i=0;i<arr.length;i++)
            if(arr[i]==key)
                return i;

        return -1;
    }

    static int binary(int arr[],int key){

        int low=0,high=arr.length-1;

        while(low<=high){

            int mid=(low+high)/2;

            if(arr[mid]==key)
                return mid;

            if(arr[mid]<key)
                low=mid+1;

            else
                high=mid-1;

        }

        return -1;
    }
}

/* SORTING */

class Sorting{

    static void bubble(int arr[]){

        for(int i=0;i<arr.length-1;i++)
            for(int j=0;j<arr.length-i-1;j++)

                if(arr[j]>arr[j+1]){

                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
    }

    static void selection(int arr[]){

        for(int i=0;i<arr.length-1;i++){

            int min=i;

            for(int j=i+1;j<arr.length;j++)

                if(arr[j]<arr[min])
                    min=j;

            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }

    }

    static void insertion(int arr[]){

        for(int i=1;i<arr.length;i++){

            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key){

                arr[j+1]=arr[j];
                j--;

            }

            arr[j+1]=key;

        }

    }

}

/* MAIN PROGRAM */

public class DMRS{

    static Stack<String> logs=new Stack<>();
    static Queue<String> queue=new LinkedList<>();
    static HashMap<Integer,Patient> database=new HashMap<>();

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        PatientList list=new PatientList();

        int choice;

        do{

            System.out.println("\n--- DIGITAL MEDICAL RECORD SYSTEM ---");

            System.out.println("1 Add Patient (Linked List)");
            System.out.println("2 Delete Patient (Linked List)");
            System.out.println("3 Display Patients");
            System.out.println("4 Stack Logs");
            System.out.println("5 Queue Workflow");
            System.out.println("6 Sorting Demo");
            System.out.println("7 Searching Demo");
            System.out.println("8 HashMap Lookup");
            System.out.println("0 Exit");

            choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.print("Enter ID: ");
                    int id=sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name=sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age=sc.nextInt();

                    Patient p=new Patient(id,name,age);

                    list.insert(p);

                    database.put(id,p);

                    logs.push("Added patient "+name);

                    break;

                case 2:

                    System.out.print("Enter ID to delete: ");
                    int did=sc.nextInt();

                    list.delete(did);

                    database.remove(did);

                    break;

                case 3:

                    list.display();

                    break;

                case 4:

                    logs.push("File Uploaded");
                    logs.push("Patient Record Viewed");

                    System.out.println("Latest Log: "+logs.pop());

                    break;

                case 5:

                    queue.add("Patient1");
                    queue.add("Patient2");

                    System.out.println("Serving "+queue.poll());

                    break;

                case 6:

                    int arr[]={5,2,9,1,3};

                    Sorting.bubble(arr);

                    System.out.println("Sorted Array");

                    for(int x:arr)
                        System.out.print(x+" ");

                    break;

                case 7:

                    int a[]={10,20,30,40,50};

                    int index=Searching.linear(a,30);

                    System.out.println("Element found at "+index);

                    break;

                case 8:

                    System.out.print("Enter ID to search: ");

                    int sid=sc.nextInt();

                    Patient result=database.get(sid);

                    if(result!=null)
                        System.out.println(result.name+" "+result.age);

                    else
                        System.out.println("Patient not found");

                    break;

            }

        }while(choice!=0);

        sc.close();

    }

}