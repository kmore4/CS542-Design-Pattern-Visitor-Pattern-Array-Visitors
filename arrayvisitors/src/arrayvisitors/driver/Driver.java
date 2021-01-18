package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.validations.FileNotExistException;
import arrayvisitors.validations.SameFileException;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;

/**
 * @author Kasturi T. More
 *
 */

/**
 * The Driver class
 */
public class Driver {
	/**
	 * An int variable to acceptable number of command line arguments
	 */
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;
	

	public static void main(String[] args) throws FileNotExistException, InvalidPathException, SecurityException, FileNotFoundException, IOException {

		int debugLevel = -1;
		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}")) || (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}")) || (args[4].equals("${debug}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		
		try {
			if(args[0].equals(args[1]) || args[2].equals(args[3])) {
				throw new SameFileException("Both the Input/Output file Path is same..!!");
			}
		} catch(SameFileException e) {
			e.printStackTrace();
			System.exit(1);
		}
		debugLevel = Integer.parseInt(args[4]);

		MyLogger.setDebugValue(debugLevel);
		
		MyArrayI m1 = new MyArray();
		MyArrayI m2 = new MyArray();
		
		MyArrayListI list = new MyArrayList();
		Results rs = new Results();
		rs.setcommonFile(args[2]);
		rs.setmissingFile(args[3]);
		
		Visitor vis = new PopulateMyArrayVisitor();
		PopulateMyArrayVisitor vis1 = (PopulateMyArrayVisitor)vis;
		
		Visitor miv = new MissingIntsVisitor();
		MissingIntsVisitor mvis = (MissingIntsVisitor)miv;
		mvis.setResultsObject(rs);
		vis1.setList(list);
		
		vis1.setFileName(args[0]);
	
		m1.accept(vis);

		m1.accept(miv);

		vis1.setFileName(args[1]);
		
		m2.accept(vis);

		m2.accept(miv);

		Visitor civ = new CommonIntsVisitor();
		CommonIntsVisitor cvis = (CommonIntsVisitor)civ;
		cvis.setResultsObject(rs);
		
		list.accept(civ);
		

		rs.writeToStdout();
		rs.writeToFile();
	}
}

