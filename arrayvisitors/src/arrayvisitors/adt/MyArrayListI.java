package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

public interface MyArrayListI extends Element{
	
	public void addMyArrObj(MyArrayI o, int i);
		
	public int getSize();
	
	public void setSize();
	
	public int getCurrentLen();
	
	public void setCurrentLen();
	
	public MyArrayI[] getMyArrayList();	
	
	public void finalize();
	
	public MyArrayList clone();
}
