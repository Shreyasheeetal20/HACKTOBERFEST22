//size of the link list can be arranged
//insertion and deletion in linked list is much easier then array
//take more merory
//non continous memory location
//link list is created in heap


//implement link list and delete an element into the list

#include<iostream>
using namespace std;

    //SELF REFFERENTIAL DATA STRUCTURE
    //which includes at least one member that is a pointer
    //to the same structure


    struct node{ 
    //structure can store many different data types
        int data;
        node*next; //self refrencing structure
    };

    node*head = NULL; //initial linked list is empty

   
    void insert_at_beginning(int new_data)
    {
        node* ptr=new node;//dynamically alloted new node
        ptr->data = new_data;
        ptr->next = head;
        head = ptr;
    };

    void insert_at_end(int new_data)
    {
        node* ptr=new node;//create a new node by dynamically allocation
        ptr->data = new_data;
        ptr->next = NULL ;
        //if head is NULL, i.e linked list is empty
        if(head==NULL)
            {
                head = ptr;
            }
        else
        { 
            node *temp = head;
            while(temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = ptr ;
        }
        
    };

    void insert_at_given_index(int new_data , int position)
    {
        node *ptr = new node;
        ptr->data = new_data;
        ptr->next = NULL;
        if(head == NULL)
        {
            head = ptr;
        }
        else
        {
            node *temp = head ;
            for(int i=0 ; i<position-1;i++)
            {
                temp = temp->next;
            }
            ptr->next=temp->next;
            temp->next = ptr;
        }

    };


    void display()
    {
        node*ptr;
        ptr=head;
        while(ptr != NULL)
        {
            cout<<ptr->data<<" ";
            ptr = ptr->next;
        }
    };

    void deletion()
    {
        node *temp = head;
        int dlt;
        cout<<"Enter the index you want to delete :";
        cin>>dlt;
        for (int i = 0; i < dlt-1; i++)
        {
            temp=temp->next;
        }
        node *temp2 = head;
        for(int i = 0; i<dlt;i++)
        {
            temp2 = temp2->next;
        }
        temp->next = temp2->next ;
        

    }

    int main()
    {
        int n;
        cout<<"Enter the number of elements of the linked list : ";
        cin>>n;
        int element;
        for(int i=0;i<n;i++)
        {
            cout<<"Enter the"<<" "<<i+1<<" "<<"element of the link list : ";
            cin>>element;
            insert_at_end(element);
        }
        cout<<"Our link list is : "<<endl;
        display();
        cout<<endl;

        //insertion in the beginning
        int operation1;
        cout<<"If you want to insert elements in the beginning, then enter 1 otherwise 0. ";
        cin>>operation1;
        if(operation1==1)
        {
            int inserting;
            cout<<"Enter the element you want to insert :"<<endl;
            cin>>inserting;
            insert_at_beginning(inserting);
        }
        cout<<"Resultant link list is :"<<endl;
        display();

        //insertion at end
        cout<<endl;
        int operation2;
        cout<<"If you want to insert elements in the end, then enter 1 otherwise 0. ";
        cin>>operation2;
        if(operation2==1)
        {
            int inserting;
            cout<<"Enter the element you want to insert :"<<endl;
            cin>>inserting;
            insert_at_end(inserting);
        }
        cout<<"Resultant link list is :"<<endl;
        display();

        //insertion at a specific place
        cout<<endl;
        int operation3;
        cout<<"If you want to insert elements somewhere between the linked list, then enter 1 otherwise 0. ";
        cin>>operation3;
        if(operation3==1)
        {
            int inserting;
            cout<<"Enter the element you want to insert :"<<endl;
            cin>>inserting;
            int position;
            cout<<"Enter the index of the new element : ";
            cin>>position;
            insert_at_given_index(inserting , position);
        }
        display();

        int operation4;
        cout<<"Enter 1 if you want to delete any element :";
        cin>>operation4;
        if(operation4 = 1)
        {
            deletion();
        }
        cout<<"Resultant link list is :"<<endl;
        display();



        return 0;
    }

   
