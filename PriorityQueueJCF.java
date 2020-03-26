/**
 * @author Diana Zaray Corado Lopez #191025
 * @version 26/03/2020
 */
import java.util.*;
import java.util.PriorityQueue;
public class PriorityQueueJCF<E> {
	
	 // the data, kept in heap order
	PriorityQueue<E> data;

	public PriorityQueueJCF()
	// post: constructs a new priority queue
	{
		data = new PriorityQueue<E>();
	}

	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.offer(value);
	}

	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		return data.poll();
	}

}


