package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.validations.UndefinedBehaviourException;

public class MissingIntsVisitor implements Visitor{
	int num = 0;
	
	Results resObj;
	private DebugLevel debugLevel;
	
	
	/**
	 * MissingIntsVisitor constructor calls myLogger
	 *
	 * @return 	NULL
	 * 
	 */
	public MissingIntsVisitor() {
		this.debugLevel = DebugLevel.MISSING_INT_VISITOR;
		MyLogger.writeMessage("in MissingIntsVisitor class constructor", debugLevel);
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
	 * Overrides visit method and find all the integers from 00 to 
	 * 99 which are not present in given MyArrayI object's int[] array
	 *
	 * @param  MyArrayI 
	 * @return NULL	   
	 */
	@Override
	public void visit(MyArrayI arrObj) throws UndefinedBehaviourException {
		// TODO Auto-generated method stub
		resObj.store2("\n\nMissing input values for array " + (num+1) + " are----> \n\n"); 
		
		int[] arr=new int[arrObj.getCurrentLen()];
		System.arraycopy(arrObj.getMyArray(), 0, arr, 0, arrObj.getCurrentLen());
		
		int[] register = new int[100];
		
		for (int z : arr) { 
			register[z] = 1; 
		}

		for (int i = 0; i < register.length; i++) { 
			if (register[i] == 0) { 
				if(i<10) {
					String x = "0" + Integer.toString(i);
		    		  resObj.store2(x);
				}
				else{
					resObj.store2(Integer.toString(i)); 
				}
			} 
		}
		num++;
	}

	
	/**
	 * Overrides visit method 
	 *
	 * @param  MyArrayListI 
	 * @return NULL	   
	 */
	@Override
	public void visit(MyArrayListI list1) throws UndefinedBehaviourException {
		// TODO Auto-generated method stub
		throw new UndefinedBehaviourException("Visit method with MyArrayListI as parameter is undefined for MissingIntsVisitor");
	}

	
	/**
     * Default toString, needed for debugging here.
     * @return NULL
     */
    public String toString() {
        return null;
    }
}
