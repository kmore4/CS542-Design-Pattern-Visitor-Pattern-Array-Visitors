package arrayvisitors.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import arrayvisitors.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private static String commonString="Common input values are----> \n\n", missingString="";
	private String commonFile,missingFile;
	
	
	/**
	 * Results constructor calls myLogger
	 *
	 * @return 	NULL
	 * 
	 */
	public Results() {
		
		MyLogger.writeMessage("in Results class constructor", DebugLevel.RESULTS);
	}
	
	/**
	 * Sets OutputFileName for storing common integers
	 *
	 * @param  String  filename
	 * @return NULL	   
	 */
	public void setcommonFile(String out1) {
		commonFile = out1;
	}
	
	/**
	 * Sets OutputFileName for storing missing integers
	 *
	 * @param  String  filename
	 * @return NULL	   
	 */
	public void setmissingFile(String out2) {
		missingFile = out2;
	}
	
	/**
	 * Get Output for common integers
	 *
	 * @param  NULL
	 * @return String  commonString	   
	 */
	public static String getcommonString() {
		return commonString;
	}
	
	/**
	 * Get Output for missing integers
	 *
	 * @param  NULL
	 * @return String  missingString	   
	 */
	public static String getmissingString() {
		return missingString;
	}
	
	/**
	 * appends result
	 *
	 * @param  String	Output of line processor
	 * @return NULL   
	 */
	public void store(String lineToAdd) {
		commonString += lineToAdd + "\n";
	}
	
	/**
	 * appends result
	 *
	 * @param  String	Output of line processor
	 * @return NULL   
	 */
	public void store2(String lineToAdd) {
		missingString += lineToAdd + "\n";
	}
	
	/**
	 * Writes generated output on console.
	 *
	 * @param  null
	 * @return null
	 */
	@Override
	public void writeToStdout() {
		// TODO Auto-generated method stub
		System.out.println(commonString);
		
		System.out.println(missingString);
	}

	
	/**
	 * Writes generated output to corresponding output files
	 *
	 * @param  null
	 * @return null
	 */
	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(commonFile, false));
            writer.write(commonString);
            writer.close();
            
            writer = new BufferedWriter(new FileWriter(missingFile, false));
            writer.write(missingString);
            writer.close();
            
        } catch(IOException e) {
            System.err.println("IO Exception: Filename was not a proper name.");
            System.exit(1);
        } finally {
            try {
                writer.close();
            } catch(IOException e) {
                System.err.println("BufferedWriter not found.");
                System.exit(1);
            }
        }
	}
	
	
	/**
     * Default toString, needed for debugging here.
     * @return String with values that will be stored by Result
     */
    public String toString() {
        return ("Commmon String: " + commonString + "\nCommon Filename: " + commonFile + "\n");
    }
    
}
