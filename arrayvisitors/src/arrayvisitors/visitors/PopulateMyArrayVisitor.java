package arrayvisitors.visitors;

import java.io.File;
import java.io.IOException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.util.Results;
import arrayvisitors.validations.EmptyFileException;
import arrayvisitors.validations.EmptyLineException;
import arrayvisitors.validations.FileNotExistException;
import arrayvisitors.validations.InvalidInputFormatException;
import arrayvisitors.validations.UndefinedBehaviourException;

public class PopulateMyArrayVisitor implements Visitor {
	
	private String filename;
	private DebugLevel debugLevel;
	public MyArrayListI list;
	
	
	/**
	 * PopulateMyArrayVisitor constructor calls myLogger
	 *
	 * @return 	NULL
	 * 
	 */
	public PopulateMyArrayVisitor() {
		this.debugLevel = DebugLevel.POPULATE_VISITOR;
		MyLogger.writeMessage("in PopulateMyArrayVisitor class constructor", debugLevel);
	}
	
	
	/**
	 * set Filename to create FileProcessor Object
	 *
	 * @param	String		filename
	 * @return 	NULL
	 * 
	 */
	public void setFileName(String name) {
		filename = name;
	}
	
	
	/**
	 * check if given file exist or not
	 *
	 * @param	String		filename
	 * @return 	Boolean
	 * 
	 */
	private static boolean checkIfFileExists(String inputfile) {
		if (inputfile == null)
			return false;
		File file = new File(inputfile);
		return file.exists();
	}
	
	
	/**
	 * File existence checking
	 *
	 * @param	String		filename
	 * @return 	NULL
	 * @exception FileNotExistException
	 */
	public void checkFile(String string) throws FileNotExistException {
		try {
			if(!checkIfFileExists(string)){
				throw new FileNotExistException(string + " does not exist.!");
			}
		} catch (FileNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}	
	}

	
	/**
	 * check if given string can be converted to Integer
	 *
	 * @param	String		strNum
	 * @return 	Boolean
	 * 
	 */
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	/**
	 * Overrides visit method  and Check if given file exists, 
	 * if yes create FileProcessor Object
	 * Reads Line in a file and store it in a MyArrayI
	 * Adds created MyArrayI to MyArrayListI
	 *
	 * @param	MyArrayI
	 * @param	MyArrayListI
	 * @return 	NULL
	 * 
	 */
	public void visit(MyArrayI arrObj) throws IOException {
		String line = "";
		int count = 0,num;
		try {
		checkFile(filename);
		FileProcessor fp = new FileProcessor(filename);
		
			
			while ((line = fp.poll()) != null)
			{
				count++;
				if (line.isEmpty()){
					throw new EmptyLineException("Line is NULL...!!!");
				}
				else {
					if(line.length() > 2 || line.length() < 0) {
						throw new InvalidInputFormatException("Input file should have 2 digit integer only");
					}
					if(isNumeric(line) == false) {
						throw new InvalidInputFormatException("String cannot be converted to Integer");
					}
					num = Integer.parseInt(line);

					arrObj.addElement(num, arrObj.getCurrentLen());
				}
			}
			if(count == 0) {
				throw new EmptyFileException("File is Empty..!!");
			}
			addToList(arrObj);
		} catch(EmptyLineException e) {
			e.printStackTrace();
			System.exit(1);	
		} catch (InvalidInputFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);	
		} catch (EmptyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);	
		} catch (FileNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	/**
	 * 
	 * Adds given MyArrayI to MyArrayListI
	 *
	 * @param	MyArrayI
	 * @param	MyArrayListI
	 * @return 	NULL
	 * 
	 */
	private void addToList(MyArrayI arrObj) {
		// TODO Auto-generated method stub
		list.addMyArrObj(arrObj, list.getCurrentLen());
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
		throw new UndefinedBehaviourException("Visit method with MyArrayListI as parameter is undefined for PopulateMyArrayVisitor");
	}


	
	/**
	 * set MyArrayListI object to store MyArray object in it
	 *
	 * @param  MyArrayListI 
	 * @return NULL	   
	 */
	public void setList(MyArrayListI list2) {
		// TODO Auto-generated method stub
		list = list2;
	}
	
	
	
	/**
     * Default toString, needed for debugging here.
     * @return NULL
     */
    public String toString() {
        return null;
    }
	
}
