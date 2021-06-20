package hashmapproject;

public class MessageHandler implements IMessageHandler {
    
    @Override
    public String[] generateMessage(int added, int deleted, int changed) {
        String[] result = new String[]
        {
            Strings.GREETINGS,
            Strings.DESCRIPTION,
            Strings.DELETED_PAGES + deleted,
            Strings.ADDED_PAGES + added,
            Strings.MODIFIED_PAGES + changed,
            Strings.REGARDS
        };
        
        return result;
    }
    
    public String[] generateMessage(int added, String[] namesAdded, 
            int deleted, String[] namesDeleted, 
            int changed, String[] namesChanged) {
        String[] result 
                = new String[7 + namesAdded.length + namesDeleted.length];
        int i = 0, j, k;
        result[i] = Strings.GREETINGS;
        result[i+1] = Strings.DESCRIPTION;
        result[i+2] = (deleted > 0) ? Strings.DELETED_PAGES + deleted + Strings.NAMELY 
                                    : Strings.DELETED_PAGES + deleted;
        if (null == namesDeleted) {
        } else {
            for (i = 3; i < namesDeleted.length+3; i++)
                result[i] = namesDeleted[i-3];
        }
        result[i] = (added > 0) ? Strings.ADDED_PAGES + added + Strings.NAMELY
                                : Strings.ADDED_PAGES + added;
        if (namesAdded == null) {
            j = i + 1;
        } else {
            for (j = i+1; j < namesAdded.length+i+1; j++)
                result[j] = namesAdded[j-i-1];
        }
        result[j] = (changed > 0) ? Strings.MODIFIED_PAGES + changed + Strings.NAMELY
                                    : Strings.MODIFIED_PAGES + changed;
        if (namesChanged == null) {
            k = j+1;
        } else {
        for (k = j+1; k < namesChanged.length+j+1; k++)
            result[k] = namesChanged[k-j-1];
        }
        result[k] = Strings.REGARDS;
        
        return result;
    }
    
    @Override
    public void send(String[] msg) {
        System.out.println(String.join("\n", msg));
    }
    //  TODO sending via email
    @Override
    public void send(String[] msg, String... par) {
        /*
        String from = "auto@mail.net";
        String host = "localhost";
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(prop);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, 
                new InternetAddress(par));
            message.setText(String.join("\n", msg));
            Transport.Send(message);
            System.out.println("Email successfully sent.");
        } catch (MessagingException exc) {
            exc.PrintStackTrace();
        }
        */
    }
}
