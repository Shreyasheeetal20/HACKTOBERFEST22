#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* left;
    Node* right;
    int height;
    Node(int x){
        this->data = x;
        left=NULL;
        right=NULL;
        height=0;
    }
};

int height(Node* node)
{
    if(!node)return 0;
    return node->height;
}

int balance(Node* node)
{
    if(!node)return 0;
    return height(node->left) - height(node->right);
}

Node* leftRotate(Node* node)
{
    Node* rightNode = node->right;
    Node* leftOfRight = rightNode->left;
    
    node->right = leftOfRight;
    rightNode->left = node;

    node->height = 1+ max(height(node->left),height(node->right));
    rightNode->height = 1+ max(height(rightNode->left),height(rightNode->right));

    return rightNode;
}

Node* rightRotate(Node* node)
{
    Node* leftNode = node->left;
    Node* rightOfLeft = leftNode->right;

    node->left = rightOfLeft;
    leftNode->right = node;

    node->height = 1+ max(height(node->left),height(node->right));
    leftNode->height = 1+ max(height(leftNode->left),height(leftNode->right));

    return leftNode;
}

Node* insert(Node* root,int x)
{
    if(!root)
        return new Node(x);
    if(root->data>x)
        root->left=insert(root->left,x);
    else 
        root->right=insert(root->right,x);

    root->height=1+max(height(root->left),height(root->right));

    int bal=balance(root);

    // Left Left case
    if(bal > 1 && x < root->left->data)
        return rightRotate(root);
 
    // Right Right Case
    if(bal < -1 && x > root->right->data)
        return leftRotate(root);
 
    // Left Right Case
    if (bal > 1 && x > root->left->data)
    {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }
    
    // Right Left Case
    if (bal < -1 && x < root->right->data)
    {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }
 
    /* return the (unchanged) node pointer */
    return root;

}

Node* inorderSuccessor(Node* node)
{
    Node* cur=node;
    while(cur&&cur->right)
        cur=cur->right;
    return cur;
}

Node* remove(Node* root,int x)
{
    if(!root)return root;
    if(root->data>x)
        root->left=remove(root->left,x);
    else if(root->data<x)
        root->right=remove(root->right,x);
    else
    {
        if(!root->left&&!root->right)
            return NULL;
        if(!root->left)
        {
            Node* temp=root->right;
            free(root);
            return temp;
        }
        if(!root->right)
        {
            Node* temp=root->left;
            free(root);
            return temp;
        }

        Node* temp=inorderSuccessor(root->right);
        root->data=temp->data;
        root->right=remove(root->right,root->data);

        return root;
    }
}


void inorder(Node* root)
{
    if(!root)return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}


int main()
{
    ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);freopen("output.txt", "w", stdout);
    #endif

    Node* root=NULL;
    int n;cin>>n;
    while(n--)
    {
        int x;cin>>x;
        root=insert(root,x);
    }
    inorder(root);
    // root=remove(root,8);
    cout<<"\n";
    inorder(root);
    return 0; 
}

