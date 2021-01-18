package arrayvisitors.visitors;

import java.util.Arrays;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.validations.UndefinedBehaviourException;

public class CommonIntsVisitor implements Visitor{
	
	Results resObj;
	private DebugLevel debugLevel;
	
	
	/**
	 * CommonIntsVisitor constructor calls myLogger
	 *
	 * @return 	NULL
	 * 
	 */
	public CommonIntsVisitor() {
		this.debugLevel = DebugLevel.COMMON_INT_VISITOR;
		MyLogger.writeMessage("in CommonIntsVisitor class constructor", debugLevel);
	}
	
	
	/**
	 * Sets Results object to store output
	 *
	 * @param  Results  Results Object
	 * @return NULL	   
	 */
	public void setResultsObject(Results r) {
		resObj = r;
	}
	
	
	/**
	 * Overrides visit method
	 *
	 * @param  MyArrayI 
	 * @return NULL	   
	 */
	@Override
	public void visit(MyArrayI arr) throws UndefinedBehaviourException {
		// TODO Auto-generated method stub
		throw new UndefinedBehaviourException("Visit method with MyArrayI as parameter is undefined for CommonIntsVisitor");
	}

	
	/**
	 * Overrides visit method and runs through all the MyArrayI object's 
	 * int[] arrays to find common integers in those arrays
	 *
	 * @param  MyArrayListI 
	 * @return NULL	   
	 */
	@Override
	public void visit(MyArrayListI list1) throws UndefinedBehaviourException{
		// TODO Auto-generated method stub
		MyArrayI[] currentList = list1.getMyArrayList();
		
		int[] arr1=new int[currentList[0].getCurrentLen()];
		int[] arr2=new int[currentList[1].getCurrentLen()];
		
		System.arraycopy(currentList[0].getMyArray(), 0, arr1, 0, currentList[0].getCurrentLen());

		Arrays.sort(arr1);
		System.arraycopy(currentList[1].getMyArray(), 0, arr2, 0, currentList[1].getCurrentLen());

		Arrays.sort(arr2);
		
		int i = 0, j = 0;
	    while(i < arr1.length && j < arr2.length){
	      // compare and increment
	      if(arr1[i] > arr2[j] || (j>0 && arr2[j] == arr2[j-1])){
	        j++;
	      }else if (arr2[j] > arr1[i] || (i>0 && arr1[i] == arr1[i-1])){
	        i++;
	      }else{
	    	  if(arr1[i]<10) {
	    		  String x = "0" + Integer.toString(arr1[i]);
	    		  resObj.store(x);
	    	  }
	    	  else{
	    		  resObj.store(Integer.toString(arr1[i]));
	    	  }
	        i++;
	        j++;
	      }
	    }
	}

	
	/**
     * Default toString, needed for debugging here.
     * @return NULL
     */
    public String toString() {
        return null;
    }
}
