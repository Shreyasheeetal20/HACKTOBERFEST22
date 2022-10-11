import java.util.*;
class Identical {
static class Node
{
	int data;
	Node left, right;
}
static boolean areIdentical(Node root1, Node root2)
{
	if (root1 == null && root2 == null) return true;
	if (root1 == null || root2 == null) return false;
	Queue<Node > q1 = new LinkedList<Node> ();
	Queue<Node> q2 = new LinkedList<Node> ();
	q1.add(root1);
	q2.add(root2);
	while (!q1.isEmpty() && !q2.isEmpty())
	{
		Node n1 = q1.peek();
		Node n2 = q2.peek();
		if (n1.data != n2.data)
		return false;
		q1.remove();
		q2.remove();
		if (n1.left != null && n2.left != null)
		{
			q1.add(n1.left);
			q2.add(n2.left);
		}
		else if (n1.left != null || n2.left != null)
			return false;
		if (n1.right != null && n2.right != null)
		{
			q1.add(n1.right);
			q2.add(n2.right);
		}
		else if (n1.right != null || n2.right != null)
			return false;
	}
	return true;
}
static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = null;
	temp.right = null;
	return temp;
}
public static void main(String[] args)
{
	Node root1 = newNode(1);
	root1.left = newNode(2);
	root1.right = newNode(3);
	root1.left.left = newNode(4);
	root1.left.right = newNode(5);
   Node root2 = newNode(1);
	root2.left = newNode(2);
	root2.right = newNode(3);
	root2.left.left = newNode(4);
	root2.left.right = newNode(5);
   if(areIdentical(root1, root2) == true)
	System.out.println("Yes");
	else
	System.out.println("No");
}
}
