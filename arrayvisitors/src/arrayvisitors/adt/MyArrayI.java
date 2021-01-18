package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

public interface MyArrayI extends Element{
	
	public int getSize();
	
	public void setSize();
	
	public int getCurrentLen();
	
	public void setCurrentLen();
	
	public void addElement(int val,int index);
	
	public int[] getMyArray();
	
	public void finalize();
}
