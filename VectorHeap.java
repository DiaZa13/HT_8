/**
 * @author Diana Zaray Corado #191025
 * @author Duane A Bailey, (2001)
 * @version 2/01/2020
 * Adapted class  @see http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * Implements a PriorityQueue (Heap) into a Vector
 */
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order

	/**
	 * VectorHeap
	 * Constructs an empty VectorHeap
	 * @pre --
	 * @post constructs a new PriorityQueue
	 */
	public VectorHeap(){
		data = new Vector<E>();
	}

	/**
	 * VectorHeap
	 * Construct a new VectorHeap with the data given
	 * @pre --
	 * @post constructs a new PriorityQueue from an unordered vector
	 * @param v
	 */
	public VectorHeap(Vector<E> v){
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
	
	/**
	 * Parent
	 * Gets  index the parent
	 * @pre 0 <= i < size
	 * @post returns the parent of node at location i
	 * @param i
	 * @return the index of the parent
	 */
	protected static int parent(int i){
		return (i-1)/2;
	}
	
	/**
	 * left
	 * Gets the index of the left child
	 * @pre 0 <= i < size
	 * @post returns index of left child of node at location i
	 * @param i
	 * @return the index of the left child
	 */
	protected static int left(int i){
		return 2*i+1;
	}
	
	/**
	 * right
	 * Gets the index of the right child
	 * @pre 0 <= i < size
	 * @post returns index of right child of node at location i
	 * @param i
	 * @return index of the right child
	 */
	protected static int right(int i){
		return 2*(i+1);
	}

	/**
	 * percolateUp
	 * Moves a new added leaf to the appropriate position
	 * @pre 0 <= leaf < size
	 * @post moves node at index leaf up to appropriate position
	 * @param leaf
	 */
	protected void percolateUp(int leaf){
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
				(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	/**
	 * add
	 * Adds a new value to the VectorHeap 
	 * @pre value is non-null comparable
	 * @post value is added to PriorityQueue
	 */
	public void add(E value){
		data.add(value);
		percolateUp(data.size()-1);
	}

	/**
	 *Moves the root down to appropriate position to make the Vector
	 *a Min VectorHeap
	 *@pre 0 <= root < size
	 *@post moves the node at index root down to appropriate 
	 *position in subtree
	 * @param root
	 */
	protected void pushDownRoot(int root){
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
						((data.get(childpos+1)).compareTo
								(data.get(childpos)) < 0))
				{
					childpos++;
				}
				//Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo
						(value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // keep moving down
				} else { // found right location
					data.set(root,value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}
	
	/**
	 * remove
	 * Remove the first element on the VectorHeap
	 * @pre the VectorHeap is non empty
	 * @post returns and removes a minimum value from queue
	 * @return the minimum value in the VectorHeap
	 */
	public E remove(){
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	/**
	 * getFirst
	 * Get the first element in the VectorHeap, without eliminating
	 * @pre the Vector Heap is non empty
	 * @post returns the first element in the Vector
	 * @return the first element in the Vector
	 */
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return data.get(0);
	}

	/**
	 * isEmpty
	 * Verify if the VectorHeap is empty
	 * @pre --
	 * @post returns a boolean to know if the vector is empty
	 * @return if the VectorHeap is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return data.isEmpty();
	}

	/**
	 * size
	 * Obtain the size of the VectorHeap
	 * @pre --
	 * @post returns the size of the VectorHeap
	 * @return the size of the VectorHeap
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
