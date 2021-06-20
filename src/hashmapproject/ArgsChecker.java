package hashmapproject;

/**
 * Contains virtual "checkArguments" method to be extended.
 */
public abstract class ArgsChecker {

    /**
     * Method checks command line arguments against given requirements.
     * @param args Command line arguments from main method.
     * @return True if argument match the requirements, false otherwise.
     * @throws Exception
     */
    public static boolean checkArguments(String args[]) throws Exception {
        return args.length > 0;
    }
}
