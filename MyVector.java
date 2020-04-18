/**
 * @author Jose De Jesus Gutierrez
 */
import java.util.ArrayList;
/**
 * Generic MyVector class, inherits from generic MyAbstractList class
 * @param <E>
 */
public class MyVector<E> extends MyAbstractList<E> {

    final int DEFAULT_CAPACITY = 10;
    final int INCREMENT_CAPACITY = 5;
    public int capacity;
    public int incrementCapacity;
    public E[] myList;

    //Default constructor
    @SuppressWarnings("unchecked")
    public MyVector() {
        this.capacity = DEFAULT_CAPACITY;
        this.incrementCapacity = INCREMENT_CAPACITY;
        myList = (E[]) new Object[this.capacity]; 
        size = 0;
    }

    /**
     * Constructor with capacity as parameter
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public MyVector(int capacity) {
        this.capacity = capacity;
        this.incrementCapacity = INCREMENT_CAPACITY;
        myList = (E[]) new Object[this.capacity]; 
        size = 0;
    }

    /**
     * Constructor with parameters: capacity and incrementCapacity
     * @param capacity
     * @param incrementCapacity
     */
    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int incrementCapacity) {
        this.capacity = capacity;
        this.incrementCapacity = incrementCapacity;
        myList = (E[]) new Object[capacity]; 
        size = 0;
    }

    /**
	 * Appends the specified element to the end of this list,
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param data
	 * @return boolean
	 */
    @SuppressWarnings("unchecked")
    public boolean add(E data) {
        if(capacity == size()) {
            capacity += incrementCapacity;
            E[] tempList = (E[]) new Object[capacity];
            for(int i = 0; i < size(); i++) {
                tempList[i] = myList[i];
            }
         myList = tempList;
        }
        myList[size()] = data;
        size++;
        return true;
    }
	  

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements by adding one to their indices.
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param index - index at which the specified element is to be inserted
	 * @param data - element to be inserted
	 * @return boolean
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 */
    @SuppressWarnings("unchecked")
	public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if(capacity == size()) {
            capacity += incrementCapacity;
            E[] tempList = (E[]) new Object[capacity];
            for(int i = 0; i < size(); i++) {
                tempList[i] = myList[i];
            }
         myList = tempList;
        }
        for(int i = size(); i > index; i--) {
         myList[i] = myList[i-1];
        }
        myList[index] = data;
        size++;
        return true;
    }
	
	/**
	 * Removes all of the elements from this list
	 */
	public void clear() {
        for(int i = 0; i < size(); i++) {
         myList[i] = null;
        }
        size = 0;

    }

	/**
	 * Returns the element at the specified position in this list
	 * @param index
	 * @return E
	 */
    public E get(int index) {
        return myList[index];
    }

	/**
	 * Returns true if this list contains no elements
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Removes the  element at the specified position in this list.
	 * Shifts any subsequent elements by subtracting one from their indices.
	 * @param index - index of the element to be removed
	 * @return E - the element that was removed from the list
	 * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public E remove(int index) {
        E element = myList[index];

        for(int i = index; i < size()-1; i++) {
         myList[i] = myList[i+1];
        }
        myList[size()-1] = null;
        size--;
        return element;
    }

	/**
	 * Trims the capacity of this MyVector instance to be the list's current size. An application 
         * can use this operation to minimize the storage of a MyVector instance.
	 */
    @SuppressWarnings("unchecked")
    public void trimToSize() {
        capacity = size();
        E[] tempList = (E[]) new Object[capacity];
        for(int i = 0; i < size(); i++) {
            tempList[i] = myList[i];
        }
        myList = tempList;
    }
	 
	/**
	 * Returns the number of elements in this list
	 * @return int
	 */
	@Override
	public int size() {
		return this.size;
    }
    
    /**Override the Object toString() method
    *@return String
    */
    @Override
    public String toString(){
        ArrayList<String> stringList = new ArrayList<>();
        for(int i = 0; i < size(); i++) {
            String strElement = myList[i].toString();
            stringList.add(strElement);
        }

        String tempString = String.join(", ", stringList);
        String tempString2 = "[" + tempString + "]";
        return tempString2;
    }
    
    /**
     * returns the capacity of the vector
     * @return int
     */
    public int getCapacity() {
        return capacity;
    } 
    
    /**
     * returns the capacity increment of the vector
     * @return int
     */
    public int getIncrement() {
        return incrementCapacity;
    } 

}
