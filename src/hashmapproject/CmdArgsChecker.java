package hashmapproject;

import java.io.*;

public final class CmdArgsChecker extends ArgsChecker {
        
    /**
     * Method checks command line arguments against given requirements.
     * @param args Command line arguments from main method.
     * @return True if argument match the requirements, false otherwise.
     * @throws Exception
     */
    public static boolean checkArguments(String args[]) throws Exception {
        boolean result = args.length == 2;
        if (result) {
            File f = new File(args[0]);
            result = f.exists() && !f.isDirectory();
            if (result) {
                String extension = f.getName().substring(f.getName().lastIndexOf('.')+1);
                result = extension.equalsIgnoreCase(Strings.FILE_EXT);
                if (!result)
                    throw new Exception(Strings.ERR_EXT);
                else {
                    result = args[1].matches(Strings.EMAIL_REGEX);
                    if (!result)
                        throw new Exception(Strings.ERR_EMAIL);
                }
            } else {
                throw new Exception(Strings.ERR_OPEN);
            }
        } else {
            throw new Exception(Strings.ERR_PARAM);
        }
        return result;
    }
}
