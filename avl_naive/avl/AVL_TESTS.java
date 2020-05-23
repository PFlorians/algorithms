/**
 * 
 */
package avl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author hackerman
 *
 */
class AVL_TESTS implements AvlTypes{
	private Avl cut;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cut = new Avl();
		
	}
	
	/**
	 * Test method for {@link avl.Avl#insertNode(int)}.
	 */
	@Test
	void testInsertNodeSimpleCase() {
		//		given
		Node returned;
		//when
		returned = cut.insertNode(0);
		//then
		assert(returned != null);
		assert(returned.getValue() == 0);
		assert(returned.getLeftChild() == null);
		assert(returned.getRightChild() == null);
		assert(returned.getBalance() == BALANCE_INITIAL);
		assert(returned.getParent() == null);
		assert(returned.getVisited() == 0);
	}
	/**
	 * Fundamental test for {@link avl.Avl#insertNode(int)}.
	 */
	@Test
	void testInsertNodeCaseFundamental()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(5);
		cut.insertNode(15);
		cut.insertNode(9);
		cut.insertNode(5);
		returned = cut.insertNode(155);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(9));
		model.add(new Node(5));
		model.add(new Node(15));
		model.add(null);
		model.add(new Node(5));
		model.add(null);
		model.add(new Node(155));
		//then
		assert(compareTwoArrayLists(returnedArray, model));
	}
	/**
	 * Easy difficulty test for {@link avl.Avl#insertNode(int)}
	 */
	@Test
	void testInsertNodeCaseEasy()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(12);
		cut.insertNode(9);
		cut.insertNode(10);
		cut.insertNode(11);
		cut.insertNode(7);
		cut.insertNode(8);
		cut.insertNode(14);
		cut.insertNode(13);
		cut.insertNode(16);
		cut.insertNode(15);
		returned = cut.insertNode(17);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(12));
		model.add(new Node(10));
		model.add(new Node(14));
		model.add(new Node(8));
		model.add(new Node(11));
		model.add(new Node(13));
		model.add(new Node(16));
		model.add(new Node(7));
		model.add(new Node(9));
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(new Node(15));
		model.add(new Node(17));
		//then
		assert(compareTwoArrayLists(returnedArray, model));
	}
	/**
	 * Hard difficulty test for {@link avl.Avl#insertNode(int)}
	 */
	@Test
	void testInsertNodeCaseHard()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(20);
		cut.insertNode(14);
		cut.insertNode(4);
		cut.insertNode(3);
		cut.insertNode(2);
		cut.insertNode(1);
		cut.insertNode(8);
		cut.insertNode(6);
		cut.insertNode(7);
		cut.insertNode(5);
		cut.insertNode(9);
		cut.insertNode(10);
		cut.insertNode(11);
		cut.insertNode(23);
		cut.insertNode(30);
		cut.insertNode(27);
		cut.insertNode(25);
		cut.insertNode(26);
		cut.insertNode(29);
		cut.insertNode(28);
		cut.insertNode(34);
		cut.insertNode(38);
		cut.insertNode(37);
		cut.insertNode(36);
		cut.insertNode(35);
		returned = cut.insertNode(17);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(27));
		
		model.add(new Node(14));
		model.add(new Node(34));
		
		model.add(new Node(8));
		model.add(new Node(25));
		model.add(new Node(29));
		model.add(new Node(37));
		
		model.add(new Node(4));
		model.add(new Node(10));
		model.add(new Node(23));
		model.add(new Node(26));
		model.add(new Node(28));
		model.add(new Node(30));
		model.add(new Node(36));
		model.add(new Node(38));
		model.add(new Node(10));

		model.add(new Node(2));
		model.add(new Node(6));
		model.add(new Node(9));
		model.add(new Node(11));
		model.add(new Node(20));
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(new Node(35));
		model.add(null);
		model.add(null);
		model.add(null);
		
		model.add(new Node(1));
		model.add(new Node(3));
		model.add(new Node(5));
		model.add(new Node(7));
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		
		//then
		assert(compareTwoArrayLists(returnedArray, model));
	}
	/**
	 * Ideal case for insert node {@link avl.Avl#insertNode(int)}
	 */
	@Test
	void testInsertNodeIdeal()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(40);
		cut.insertNode(20);
		cut.insertNode(10);
		cut.insertNode(25);
		cut.insertNode(30);
		cut.insertNode(22);
		returned = cut.insertNode(50);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(25));
		model.add(new Node(20));
		model.add(new Node(40));
		model.add(new Node(10));
		model.add(new Node(22));
		model.add(new Node(30));
		model.add(new Node(50));
		//then
		assert(compareTwoArrayLists(returnedArray, model));
	}
	/**
	 * Edge case repetition {@link avl.Avl#insertNode(int)}
	 */
	void testInsertNodeRepetition()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		cut.insertNode(5);
		returned = cut.insertNode(5);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(5));
		
		model.add(new Node(5));
		model.add(new Node(5));
		
		model.add(new Node(5));
		model.add(null);
		model.add(new Node(5));
		model.add(new Node(5));
		
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(new Node(5));
		model.add(null);
		model.add(null);
		model.add(new Node(5));
		
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(null);
		model.add(new Node(5));
		//then
		assert(compareTwoArrayLists(returnedArray, model));
	}
	/**
	 * Edge case negatives {@link avl.Avl#insertNode(int)}
	 */
	@Test
	void testInsertNodeNegatives()
	{
		//given
		Node returned;
		ArrayList<Node> returnedArray;
		ArrayList<Node> model;
		//when
		//initialize tested
		cut.insertNode(-1);
		cut.insertNode(-3);
		cut.insertNode(0);
		cut.insertNode(25);
		cut.insertNode(28);
		cut.insertNode(-13);
		cut.insertNode(-2);
		cut.insertNode(12);
		cut.insertNode(-4);
		cut.insertNode(5);
		returned = cut.insertNode(-24);
		returnedArray = treeToArray(cut.getHeight(), returned);
		//initialize model
		model = new ArrayList<Node>();
		model.add(new Node(0));
		model.add(new Node(-3));
		model.add(new Node(25));
		model.add(new Node(-13));
		model.add(new Node(-1));
		model.add(new Node(12));
		model.add(new Node(28));
		model.add(new Node(-24));
		model.add(new Node(-4));
		model.add(null);
		model.add(new Node(-2));
		model.add(new Node(5));
		model.add(null);
		model.add(null);
		model.add(null);
		//then
		assert(compareTwoArrayLists(returnedArray, model));	
	}
	/**
	 * Test method for {@link avl.Avl#calculateBalances(avl.Node)}.
	 */
	@Test
	void testCalculateBalances() {
		//given
		Node returned;
		//when
		cut.insertNode(5);
		cut.insertNode(15);
		cut.insertNode(9);
		cut.insertNode(5);
		returned = cut.insertNode(155);
		//then
		assert(cut.calculateBalance(returned) == 0);
		assert(cut.calculateBalance(returned.getLeftChild()) == -1);
		assert(cut.calculateBalance(returned.getRightChild()) == -1);
	}
	//helper methods
	private boolean compareTwoArrayLists(ArrayList<Node> tested, ArrayList<Node> model)
	{
		int i;
		if(tested.size() != model.size())//immediately it is clear they are not the same
		{
			return false;
		}
		else
		{
			for(i=0;i<tested.size();i++)
			{
				if(tested.get(i) != null && model.get(i) != null)
				{
					if(tested.get(i).getValue() == model.get(i).getValue())
					{
						continue;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			return true;
		}
	}
	private ArrayList<Node> treeToArray(int height, Node rootNode)
	{
		ArrayList<Node> treeArray = new ArrayList<Node>();
		Node tmp;
		Queue q = new Queue();
		int iteration = 0, level = 0;
		//maximum nodes on a given level, multiply by 2 each lvl
		int maxNodes = 1;
		tmp = rootNode;
		while(level <= height)
		{
			treeArray.add(tmp);
			if(tmp != null)
			{
				q.enqueue(tmp.getLeftChild());
				q.enqueue(tmp.getRightChild());
			}
			iteration++;
			if(iteration >= maxNodes)//next level
			{
				iteration = 0;
				maxNodes = maxNodes * 2;
				level++;
				if(q.getSize() == 0)//queue is empty the end
				{
					break;
				}
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
		return treeArray;
	}
}
