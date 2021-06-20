package hashmapproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CmdArgsCheckerTest {
    
    public CmdArgsCheckerTest() {
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
     * Test of checkArguments method, of class CmdArgsChecker.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheckArguments() throws Exception {
        System.out.println("checkArguments");
        String[] args = new String[] {
                "Z:/_DICOM.LOG",
                "magistersimon@mail.ru"
            };
        boolean result;
        try {
            result = CmdArgsChecker.checkArguments(args);
        } catch (Exception thrown) {
            assertNotEquals(thrown.getMessage(), "");
        }
        args = new String[] {
            "Z:/_DICOM.LOG",
            "something",
            "something else"
        };
        try {
            result = CmdArgsChecker.checkArguments(args);
            assertFalse(result);
        } catch (Exception thrown) {
            assertEquals(thrown.getMessage(), Strings.ERR_PARAM);
        }
    }
    
}
