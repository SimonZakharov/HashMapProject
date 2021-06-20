package hashmapproject;

public class HashMapProject {

    /**
     * Application entry point
     * @param args first argument is the absolute path to the config XML file
     *             second arg is the email address where a message must be sent
     */
    public static void main(String[] args) {
        try {
            if (CmdArgsChecker.checkArguments(args)) {
                XmlToMapReader reader = new XmlToMapReader();
                reader.parseFormat(args[0]);
                HashMapComparer comparer = new HashMapComparer();
                MessageHandler msgHandler = new MessageHandler();
                msgHandler.send(msgHandler.generateMessage
                    (
                        comparer.countAdded(reader.getToday(), reader.getYesterday()),
                        comparer.namesAdded(reader.getToday(), reader.getYesterday()),
                        comparer.countDeleted(reader.getToday(), reader.getYesterday()),
                        comparer.namesDeleted(reader.getToday(), reader.getYesterday()),
                        comparer.countChanged(reader.getToday(), reader.getYesterday()),
                        comparer.namesModified(reader.getToday(), reader.getYesterday())
                    ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
