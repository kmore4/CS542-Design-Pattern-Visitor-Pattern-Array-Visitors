package arrayvisitors.adt;

import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.validations.UndefinedBehaviourException;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI, Cloneable {
	
	private int size=10,currentLen=0;
	private MyArrayI origArr[] = new MyArrayI[10];
	private DebugLevel debugLevel;
	
	
	/**
	 * MyArrayList constructor calls myLogger
	 *
	 * @return 	NULL
	 * 
	 */
	public MyArrayList() {
		this.debugLevel = DebugLevel.MY_ARRAY_LIST;
		MyLogger.writeMessage("in MyArrayList class empty constructor", debugLevel);
	}
	
	
	/**
	 * MyArrayList constructor stores given MyArrayI array
	 *
	 * @return 	NULL
	 * 
	 */
	public MyArrayList(MyArrayI[] val) {
		origArr = val;
	}
	
	
	/**
	 * if array is full then increase the size and add new element 
	 * to given index
	 *
	 * @return	NULL
	 * 
	 */
	public void addMyArrObj(MyArrayI o, int i) {
		if(currentLen == size) {
			MyArrayI[] resizedArray = new MyArrayI[size + (size/2)];
			System.arraycopy(origArr, 0, resizedArray, 0, origArr.length);
			origArr = resizedArray;
			setSize();
		}
		origArr[i] = o;
		setCurrentLen();
		
	}
	
	/**
	 * get size of MyArrayI[] of given MyArrayList Object
	 *
	 * @return	int	Size
	 * 
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * increases size of MyArrayI[] of given MyArrayList Object
	 * when array is full
	 *
	 * @return	NULL
	 * 
	 */
	public void setSize() {
		size += (size/2);
	}
	
	
	/**
	 * increases currentLen of MyArrayI[] of given MyArrayList Object
	 * when array is full
	 *
	 * @return	int currentLen
	 * 
	 */
	public int getCurrentLen() {
		return currentLen;
	}
	
	
	/**
	 * increases currentLen of MyArrayI[] of given MyArrayList Object 
	 * when new item is added
	 *
	 * @return	NULL
	 * 
	 */
	public void setCurrentLen() {
		currentLen += 1;
	}
	
	
	/**
	 * get MyArrayI[] array of given MyArrayList Object
	 *
	 * @return	MyArrayI[]	origArr
	 * 
	 */
	public MyArrayI[] getMyArrayList() {
		return origArr;
	}
	
	
	/**
	 * accepts appropriate visit method
	 *
	 * @return	NULL
	 * 
	 */
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		try {
			v.visit(this);
		} catch (UndefinedBehaviourException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * for better design principles
	 *
	 * @return	NULL
	 * 
	 */
	public void finalize() {
		
	}
	
	
	/**
	 * clone a MyArrayList
	 *
	 * @return	MyArrayList Object
	 * 
	 */
	public MyArrayList clone()
	{
		return new MyArrayList(this.getMyArrayList());
	}
	
	
	/**
     * Default toString, needed for debugging here.
     * 
     * @return String
     */
    public String toString() {
        return ("debugLevel: " + debugLevel);
    }
}
