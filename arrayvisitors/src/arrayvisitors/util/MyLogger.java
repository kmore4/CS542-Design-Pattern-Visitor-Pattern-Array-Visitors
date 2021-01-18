package arrayvisitors.util;

public class MyLogger {

	public static enum DebugLevel { FILE_PROCESSOR, NONE, MY_ARRAY, RESULTS, MY_ARRAY_LIST, POPULATE_VISITOR, COMMON_INT_VISITOR, MISSING_INT_VISITOR };

    private static DebugLevel debugLevel;


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {

	switch (levelIn) {
	case 7: debugLevel = DebugLevel.MISSING_INT_VISITOR; break;
	case 6: debugLevel = DebugLevel.COMMON_INT_VISITOR; break;
	case 5: debugLevel = DebugLevel.MY_ARRAY; break;
	case 4: debugLevel = DebugLevel.MY_ARRAY_LIST; break;
	case 3: debugLevel = DebugLevel.RESULTS; break;
	case 2: debugLevel = DebugLevel.POPULATE_VISITOR; break;
	case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
	default: debugLevel = DebugLevel.NONE; break;
	}
    }

    
    /**
	 * set debug value
	 *
	 * @return 	NULL
	 * 
	 */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    
    /**
	 * writes given message to console
	 *
	 * @return 	NULL
	 * 
	 */
    public static void writeMessage (String message, DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
     * Default toString, needed for debugging here.
     * @return String
     */
    
    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
    
}
