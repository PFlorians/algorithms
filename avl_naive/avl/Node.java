package avl;

public class Node implements AvlTypes{
	private int value;//value stored in node
	private Node parent, left_child, right_child; 
	private int balance; //is it a balanced node?
	private int visited; //AVL uses this to make sure it visited the node

	public Node(int value)
	{
		this.value = value;
		left_child = null;
		right_child = null;
		balance = BALANCE_INITIAL;
		parent = null;
		setVisited(0);
	}
	//getter & setters
	public Node getParent()
	{
		return parent;
	}
	public void setParent(Node new_parent)
	{
		parent = new_parent;
	}
	public Node getLeftChild()
	{
		return left_child;
	}
	public void setLeftChild(Node new_left_child)
	{
		left_child = new_left_child;
	}
	public Node getRightChild()
	{
		return right_child;
	}
	public void setRightChild(Node new_right_child)
	{
		right_child = new_right_child;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(int new_value)
	{
		value = new_value;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int new_balance)
	{
		balance = new_balance;
	}
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
}
