package avl;
import java.io.Writer;
import java.util.ArrayList;

public class Avl implements AvlTypes{
	private static Node root;
	private int height;
	//create new AVL tree with initial root node
	public Avl()
	{
		height = 0;
		root = null;
	}
	//rotations
	private void leftRightRotation(Node n)
	{
		Node a, b, c, d;
		a = n;
		b = n.getParent();
		c = n.getParent().getParent();
		d = n.getParent().getParent().getParent();
		if(d != null)
		{
			if(c == d.getRightChild())//LR in right branch
			{
				d.setRightChild(a);
			}
			else//LR in left branch
			{
				d.setLeftChild(a);
			}
			a.setParent(d);//all set, rotate children
			if(b.getRightChild() == a)
			{
				b.setRightChild(a.getLeftChild());
				if(a.getLeftChild() != null)
				{
					a.getLeftChild().setParent(b);
				}
			}
			a.setLeftChild(b);
			if(c.getLeftChild() == b)
			{
				c.setLeftChild(a.getRightChild());
				if(a.getRightChild() != null)
				{
					a.getRightChild().setParent(c);
				}
			}
			a.setRightChild(c);
			b.setParent(a);
			c.setParent(a);
			d.setBalance(BALANCE_INITIAL);
		}
		else
		{
			a.setParent(null);
			root = a;
			if(b.getRightChild() == a)
			{
				b.setRightChild(a.getLeftChild());
				if(a.getLeftChild() != null)
				{
					a.getLeftChild().setParent(b);
				}
			}
			a.setLeftChild(b);
			if(c.getLeftChild() == b)
			{
				c.setLeftChild(a.getRightChild());
				if(a.getRightChild() != null)
				{
					a.getRightChild().setParent(c);
				}
			}
			a.setRightChild(c);
			b.setParent(a);
			c.setParent(a);
		}
		a.setBalance(BALANCE_INITIAL);
		b.setBalance(BALANCE_INITIAL);
		c.setBalance(BALANCE_INITIAL);
	}
	private void leftLeftRotation(Node n)
	{
		Node a, b, c, d;
		a = n;
		b = n.getParent();
		c = n.getParent().getParent();
		d = n.getParent().getParent().getParent();
		if(d != null)
		{
			if(c == d.getRightChild())
			{
				d.setRightChild(b);
			}
			else
			{
				d.setLeftChild(b);
			}
			b.setParent(d);
			if(c.getLeftChild() == b)
			{
				c.setLeftChild(b.getRightChild());
				if(b.getRightChild() != null)
				{
					b.getRightChild().setParent(c);
				}
			}
			b.setRightChild(c);
			c.setParent(b);
			a.setParent(b);
			d.setBalance(BALANCE_INITIAL);
		}
		else
		{
			b.setParent(null);
			root = b;

			if(c.getLeftChild() == b)
			{
				c.setLeftChild(b.getRightChild());
				if(b.getRightChild() != null)
				{
					b.getRightChild().setParent(c);
				}
			}
			b.setRightChild(c);
			c.setParent(b);
			a.setParent(b);
		}
		a.setBalance(BALANCE_INITIAL);
		b.setBalance(BALANCE_INITIAL);
		c.setBalance(BALANCE_INITIAL);
	}
	private void rightLeftRotation(Node n)
	{
		Node a, b, c, d;
		a = n;
		b = n.getParent();
		c = n.getParent().getParent();
		d = n.getParent().getParent().getParent();
		if(d != null)
		{
			if(c == d.getRightChild())
			{
				d.setRightChild(a);
			}
			else
			{
				d.setLeftChild(a);
			}
			a.setParent(d);
			if(c.getRightChild() == b)
			{
				c.setRightChild(a.getLeftChild());
				if(a.getLeftChild() != null)
				{
					a.getLeftChild().setParent(c);
				}
			}
			a.setLeftChild(c);
			if(b.getLeftChild() == a)
			{
				b.setLeftChild(a.getRightChild());
				if(a.getRightChild() != null)
				{
					a.getRightChild().setParent(b);
				}
			}
			a.setRightChild(b);
			b.setParent(a);
			c.setParent(a);
			d.setBalance(BALANCE_INITIAL);
		}
		else
		{
			a.setParent(null);
			root = a;
			
			if(b.getLeftChild() == a)
			{
				b.setLeftChild(a.getRightChild());
				if(a.getRightChild() != null)
				{
					a.getRightChild().setParent(b);
				}
			}
			a.setRightChild(b);
			if(c.getRightChild() == b)
			{
				c.setRightChild(a.getLeftChild());
				if(a.getLeftChild() != null)
				{
					a.getLeftChild().setParent(c);
				}
			}
			a.setLeftChild(c);
			b.setParent(a);
			c.setParent(a);
		}
		a.setBalance(BALANCE_INITIAL);
		b.setBalance(BALANCE_INITIAL);
		c.setBalance(BALANCE_INITIAL);
	}
	private void rightRightRotation(Node n)
	{
		Node a, b, c, d;
		a = n;
		b = n.getParent();
		c = n.getParent().getParent();
		d = n.getParent().getParent().getParent();
		if(d != null)
		{
			if(c == d.getRightChild())
			{
				d.setRightChild(b);
			}
			else
			{
				d.setLeftChild(b);
			}
			b.setParent(d);
			if(c.getRightChild() == b)
			{
				c.setRightChild(b.getLeftChild());
				if(b.getLeftChild() != null)
				{
					b.getLeftChild().setParent(c);
				}
			}
			b.setLeftChild(c);
			a.setParent(b);
			c.setParent(b);
			d.setBalance(BALANCE_INITIAL);
		}
		else
		{
			b.setParent(null);
			root = b;
			
			if(c.getRightChild() == b)
			{
				c.setRightChild(b.getLeftChild());
				if(b.getLeftChild() != null)
				{
					b.getLeftChild().setParent(c);
				}
			}
			b.setLeftChild(c);
			a.setParent(b);
			c.setParent(b);		
		}
		a.setBalance(BALANCE_INITIAL);
		b.setBalance(BALANCE_INITIAL);
		c.setBalance(BALANCE_INITIAL);
	}
	//this checks if a disbalance occurred by inserting a node

	//same as checkDisbalance but given is the top node, children are checked
	private boolean checkImbalanceTop(Node top_node)
	{
		int threshold, threshold_left, threshold_right;
		threshold = calculateBalance(top_node);
		if(threshold >= 2)
		{
			threshold_left = calculateBalance(top_node.getLeftChild());
			if(threshold_left >= 0)
			{
				leftLeftRotation(top_node.getLeftChild().getLeftChild());
			}
			else if(threshold_left <= 0)
			{
				leftRightRotation(top_node.getLeftChild().getRightChild());
			}
			return true;
		}
		else if(threshold <= -2)
		{
			threshold_right = calculateBalance(top_node.getRightChild());
			if( threshold_right >= 0 )
			{
				rightLeftRotation(top_node.getRightChild().getLeftChild());
			}
			else if(threshold_right <= 0)
			{
				rightRightRotation(top_node.getRightChild().getRightChild());
			}
			return true;
		}
		return false;
	}
	//insert node into tree starting from node n
	//insert node into a binary tree(binary insert, starting from root)
	public Node insertNode(int value)
	{
		Node parent, current;
		Node newNode;
		newNode = new Node(value);
		parent = current = root;
		if(root == null)//first node
		{
			root = newNode;
			breadthFirstPrint();
			return root;
		}
		while(current != null)
		{
			//go left
			if(newNode.getValue() < current.getValue())
			{
				parent = current;
				current = current.getLeftChild();
				if(current == null)//this is the point of insertion then
				{
					parent.setLeftChild(newNode);
					newNode.setParent(parent);
					newNode.setBalance(BALANCE_INITIAL);
					break;
				}
			}//go right, greater or EQUAL!
			else
			{
				parent = current;
				current = current.getRightChild();
				if(current == null)
				{
					parent.setRightChild(newNode);
					newNode.setParent(parent);
					newNode.setBalance(BALANCE_INITIAL);
					break;
				}
			}
		}//insertion done
		recalculateAllBalances();
		breadthFirstPrint();
		return root;
	}
	private Node backToOrigin(Node origin, Node curr)
	{
		Node current = curr;
		while(current != origin)
		{
			current.setVisited(0);
			if(current.getParent() != null)
			{
				current = current.getParent();
			}
			else
			{
				break;
			}
		}
		return current;
	}
	//count edges to the left of the origin as far as possible
	private int countLeftHeight(Node n)
	{
		//marker points to place where a possible right branch exists
		//it is necessary to verify that nodes from this point to the right
		//are not indeed a part of much longer branch
		Node parent, current, marker = null;
		int tmp_counter = 0;
		int max = -1;
		
		parent = current = n;
		if(current.getLeftChild() == null || current == null)
		{
			return 0;
		}
		current.setVisited(1);
		while((current != null && parent != n.getParent()))
			// && current != null)
		{
			if(current.getLeftChild() != null && 
				current.getLeftChild().getVisited() == 0)
			{
				parent = current;
				current = current.getLeftChild();
				tmp_counter++;
				current.setVisited(1);
			}
			else if(current.getLeftChild() != null && 
					current.getLeftChild().getVisited() == 1 &&
					current.getRightChild() != null
					&& current != n//avoid right branch
					&& current.getRightChild().getVisited() == 0
					&& current == marker )
			{
				parent = current;
				current = current.getRightChild();
				marker = null;
				tmp_counter++;
				current.setVisited(1);
			}
			else if(current.getLeftChild() != null && 
					current.getLeftChild().getVisited() == 1 &&
					current.getRightChild() != null
					&& current != n//avoid right branch
					&& current.getRightChild().getVisited() == 0
					&& marker == null)
			{
				current.setVisited(0);
				marker = current;
				current = backToOrigin(n, current);
			}
			else if(current.getRightChild() != null
					&& current != n//avoid right branch
					&& current.getRightChild().getVisited() == 0)
			{
				parent = current;
				current = current.getRightChild();
				tmp_counter++;
				current.setVisited(1);
			}
			else//I am at the bottom, go up
			{
				current = parent;
				if(parent != null)
				{
					parent = parent.getParent();
				}
				max = Math.max(max, tmp_counter);
				tmp_counter = 0;
			}
		}
		return max;
	}
	//count edges to the right of the current
	private int countRightHeight(Node n)
	{
		Node parent, current, marker = null;
		int tmp_counter = 0;
		int max = -1;
		
		parent = current = n;
		if(current.getRightChild() == null || current == null)
		{
			return 0;
		}
		n.setVisited(1);
		while((current != null && parent != n.getParent()))
		{
			if(current.getRightChild() != null
					&& current.getRightChild().getVisited() == 0)
			{
				parent = current;
				current = current.getRightChild();
				tmp_counter++;
				current.setVisited(1);
			}
			else if(current.getRightChild() != null && 
					current.getRightChild().getVisited() == 1 &&
					current.getLeftChild() != null &&
					current != n
					&& current.getLeftChild().getVisited() == 0
					&& current == marker )
			{
				parent = current;
				current = current.getLeftChild();
				marker = null;
				tmp_counter++;
				current.setVisited(1);
			}
			else if(current.getRightChild() != null && 
					current.getRightChild().getVisited() == 1 &&
					current.getLeftChild() != null
					&& current != n
					&& current.getLeftChild().getVisited() == 0
					&& marker == null)
			{
				current.setVisited(0);
				marker = current;
				current = backToOrigin(n, current);
			}
			else if(current.getLeftChild() != null && 
					current != n && //avoid left branch
					current.getLeftChild().getVisited() == 0)
			{
				parent = current;
				current = current.getLeftChild();
				tmp_counter++;
				current.setVisited(1);
			}
			else//I am at the bottom, go up
			{
				current = parent;
				if(parent != null)
				{
					parent = parent.getParent();
				}
				max = Math.max(max, tmp_counter);
				tmp_counter = 0;
			}
		}
		return max;
	}
	//given node n calculate it's balance
	public int calculateBalance(Node n)
	{
		int leftCount, rightCount;
		setUnvisited(n);
		leftCount = countLeftHeight(n);
		setUnvisited(n);
		rightCount = countRightHeight(n);
		setUnvisited(n);
		return (leftCount-rightCount);
	}
	private int calculateBalanceSetHeight(Node n)
	{
		int leftCount, rightCount;
		setUnvisited(n);
		leftCount = countLeftHeight(n);
		setUnvisited(n);
		rightCount = countRightHeight(n);
		setUnvisited(n);
		height = Math.max(leftCount, rightCount);
		return (leftCount-rightCount);
	}
	//works over root and recalculates every node's balance
	//return 0 if all ok, 1 if imbalance detected
	private void recalculateAllBalances()
	{
		Node parent, current;
		parent = current = root;
		resetBalances(root);
		do	 
		{
			//calculate and visit if not already done so
			if(current.getBalance() == BALANCE_INITIAL&& current != root)
			{
				current.setBalance(calculateBalance(current));
			}//root has two children
			else if(current == root && 
					current.getLeftChild() != null &&
					current.getRightChild() != null)
			{
				if(current.getLeftChild().getBalance() != BALANCE_INITIAL 
					&& current.getRightChild().getBalance() != BALANCE_INITIAL )
				{
					current.setBalance(calculateBalanceSetHeight(current));
				}
			}//root has only one - left child
			else if(current == root &&
					current.getLeftChild() != null &&
					current.getRightChild() == null)
			{
				if(current.getLeftChild().getBalance() == BALANCE_INITIAL)
				{
					current.setBalance(calculateBalanceSetHeight(current));
				}
			}//root has only on - right child
			else if(current == root &&
					current.getLeftChild() == null &&
					current.getRightChild() != null)
			{
				if(current.getRightChild().getBalance() == BALANCE_INITIAL)
				{
					current.setBalance(calculateBalanceSetHeight(current));
				}
			}//root has no child
			else if(current == root &&
					current.getRightChild() == null &&
					current.getLeftChild() == null)
			{
				current.setBalance(calculateBalanceSetHeight(current));
			}
			//check if some imbalance is detected
			if(checkImbalanceTop(current))
			{
				current = backToOrigin(root, current);
			}
			//proceed lower left
			if(current.getLeftChild() != null && 
				current.getLeftChild().getBalance() == BALANCE_INITIAL)
			{
				parent = current;
				current = current.getLeftChild();
			}//lower right
			else if(current.getRightChild() != null
					&& current.getRightChild().getBalance() == BALANCE_INITIAL)
			{
				parent = current;
				current = current.getRightChild();
			}
			else
			{//proceed upwards if all calculated so far
				current = parent;
				if(parent != null)
				{
					parent = parent.getParent();
				}
			}
		}while(current != null);
	}
	//set balances to -999999 -> reset balances to recalculate them
	private void resetBalances(Node n)
	{
		Node parent, current;
		parent = current = n;
		n.setBalance(BALANCE_INITIAL);
		do
		{
			if(current.getLeftChild() != null && 
			   current.getLeftChild().getBalance() != BALANCE_INITIAL)
			{
				parent = current;
				current = current.getLeftChild();
				current.setBalance(BALANCE_INITIAL);
			}
			else if(current.getRightChild() != null
					&& current.getRightChild().getBalance() != BALANCE_INITIAL)
			{
				parent = current;
				current = current.getRightChild();
				current.setBalance(BALANCE_INITIAL);
			}
			else
			{
				current = parent;
				if(parent != null)
				{
					parent = parent.getParent();
				}
			}
		}while(current != null);
	}
	//set every node under starting node to unvisited
	private void setUnvisited(Node n)
	{
		Node parent, current;
		parent = current = n;
		n.setVisited(0);
		do
		{
			if(current.getLeftChild() != null && 
			   current.getLeftChild().getVisited() == 1)
			{
				parent = current;
				current = current.getLeftChild();
				current.setVisited(0);
			}
			else if(current.getRightChild() != null
					&& current.getRightChild().getVisited() == 1)
			{
				parent = current;
				current = current.getRightChild();
				current.setVisited(0);
			}
			else
			{
				current = parent;
				if(parent != null)
				{
					parent = parent.getParent();
				}
			}
		}while(current != null);
	}
	private void breadthFirstPrint()
	{
		Node tmp;
		Queue q = new Queue();
		int iteration = 0, level = 0;
		//maximum nodes on a given level, multiply by 2 each lvl
		int maxNodes = 1;
		tmp = root;
		while(level <= height)
		{
			if(tmp != null)
			{
				System.out.print(tmp.getValue());
				q.enqueue(tmp.getLeftChild());
				q.enqueue(tmp.getRightChild());
			}
			else
			{
				System.out.print('_');
			}
			iteration++;
			if(iteration >= maxNodes)//next level
			{
				iteration = 0;
				maxNodes = maxNodes * 2;
				level++;
				if(level <= height)
				{
					System.out.print('|');
				}
				if(q.getSize() == 0)//queue is empty the end
				{
					break;
				}
			}
			else
			{
				System.out.print(' ');
			}
			if(q.getSize() != 0)
			{
				tmp = q.getTop();
				q.dequeue();
			}
			else
			{
				tmp = null;
			}
		}
		System.out.println();
	}
	public int getHeight()
	{
		return height;
	}
	public static Node getRoot() {
		return root;
	}
	
}
