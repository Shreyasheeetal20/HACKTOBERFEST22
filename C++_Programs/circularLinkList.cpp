//basic implementation of CircularLinklist
// Construct,Insert at the begining of circular linklist,inert at the End of Circular Linklist,delete Kth Node,Display Linklist
// for insert and delete Two Approach Navie and Efficient
#include<iostream>
using namespace std;
struct node
{
    int data;
    node*next;
    node(int x)
    {
        data=x;
        next=NULL;
    }
};
node *insertAtbegining(node*head,int x)
{
    node*temp=new node(x);
    if(head==NULL) return temp;
    node*curr=head->next;
    while (curr->next!=head)
    {
        curr=curr->next;
    }
    curr->next=temp;
    temp->next=head;
    return temp;
    
}
void display(node *head)
{
    if(head==NULL) return ;
    node *curr=head->next;
    cout << head->data << " ";
    while (curr!=head)
    {
        cout<<curr->data<<" ";
        curr=curr->next;
    }
    
}
node *insertBeginEff(node *head,int x)
{
    node *newHead=new node(x);
    if(head==NULL) return NULL;
    newHead->next=head->next;
    head->next=newHead;
   int t=head->data;
   head->data=newHead->data;
   newHead->data=t;
   return head;
}
node *insertatend(node*head,int x)
{
    node*temp=new node(x);
    if(head==NULL) return temp;
    node*curr=head->next;
    while (curr->next!=head)
    {
        curr=curr->next;
    }
     curr->next=temp;
     temp->next=head;
     return head;
}
node *insertEndEff(node*head,int x)
{
    node*temp=new node(x);
    if (head==NULL)
    {
        return temp;
    }
    temp->next=head->next;
    head->next=temp;
   swap(head->data,temp->data);
    return temp;
    
}
node *deleteHead(node*head)
{
    if(head==NULL) return head;
    if(head->next==NULL){
        delete head;
        return NULL;
    }
    swap(head->data,head->next->data);
    node *temp=head->next;
    head->next=head->next->next;
    delete temp;
    return head;
}
node*deleteKthNode(node*head,int k)
{
    if(k==0) {
        deleteHead(head);
    }
    node *curr=head;
    while (k!=1)
    {
        curr=curr->next;
        k--;
    }
    node *temp=curr->next;
    curr->next=curr->next->next;
    delete temp;
    return head;
}
int main()
{
    node *head=new node(10);
    head->next=new node(20);
   node *temp=new node(30);
   head->next->next=temp;
   temp->next=head;
   display(head);
   cout<<"\nInsert At the Begining ->"<<endl;
   head=insertAtbegining(head,40);
   display(head);
   cout << "\nInsert At the Begining EFF ->" << endl;
   head = insertBeginEff(head, 50);
   display(head);
   cout << "\nInsert At the End ->" << endl;
head=insertatend(head,60);
display(head);
cout << "\nInsert At the End Eff ->" << endl;
head = insertEndEff(head, 70);
head = insertEndEff(head, 80);
display(head);
cout<<"\nDelete Head-->"<<endl;
head=deleteHead(head);
display(head);
cout << "\nDelete K-->" << endl;
head=deleteKthNode(head,3);
display(head);
return 0;
}
