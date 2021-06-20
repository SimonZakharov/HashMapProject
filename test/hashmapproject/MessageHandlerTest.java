package hashmapproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageHandlerTest {
    
    public MessageHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateMessage method, of class MessageHandler.
     */
    @Test
    public void testGenerateMessage_3args() {
        System.out.println("generateMessage");
        int added = 561;
        int deleted = 148;
        int changed = 78;
        MessageHandler instance = new MessageHandler();
        String[] expResult = new String[] {
            Strings.GREETINGS,
            Strings.DESCRIPTION,
            Strings.DELETED_PAGES + "148",
            Strings.ADDED_PAGES + "561",
            Strings.MODIFIED_PAGES + "78",
            Strings.REGARDS
        };
        String[] result = instance.generateMessage(added, deleted, changed);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of generateMessage method, of class MessageHandler.
     */
    @Test
    public void testGenerateMessage_6args() {
        System.out.println("generateMessage");
        int added = 2;
        String[] namesAdded = new String[] {"a.html", "b.html"};
        int deleted = 0;
        String[] namesDeleted = new String[0];
        int changed = 0;
        String[] namesChanged = null;
        MessageHandler instance = new MessageHandler();
        String[] expResult = new String[]
        {
            Strings.GREETINGS,
            Strings.DESCRIPTION,
            Strings.DELETED_PAGES + "0",
            Strings.ADDED_PAGES + "2" + Strings.NAMELY,
            "a.html",
            "b.html",
            Strings.MODIFIED_PAGES + "0",
            Strings.REGARDS,
            null
        };
        String[] result = instance.generateMessage(added, namesAdded, deleted, namesDeleted, changed, namesChanged);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of send method, of class MessageHandler.
     */
    @Test
    public void testSend_StringArr() {
        System.out.println("send");
        String[] msg = new String[] {
            "Test of sending a message to console output", 
            "Successful if seen :)"
        };
        MessageHandler instance = new MessageHandler();
        instance.send(msg);
    }

    /**
     * Test of send method, of class MessageHandler.
     */
    @Test
    public void testSend_StringArr_String() {
        System.out.println("send via email");
        String[] msg = new String[0];
        String email = "";
        MessageHandler instance = new MessageHandler();
        instance.send(msg, email);
    }
    
}
