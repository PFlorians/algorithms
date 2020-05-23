package avl;

import java.util.ArrayList;

public class Queue {
	private ArrayList<Node> queue;
	
	public Queue()
	{
		queue = new ArrayList<Node>();
	}
	public ArrayList<Node> enqueue(Node n)
	{
		this.queue.add(n);
		return queue;
	}
	public ArrayList<Node> dequeue()
	{
		if(queue.isEmpty() == false)
		{
			queue.remove(0);
		}
		return queue;
	}
	public ArrayList<Node> getQueue()
	{
		return queue;
	}
	public Node getTop()
	{
		return queue.get(0);
	}
	public int getSize()
	{
		return queue.size();
	}
}
