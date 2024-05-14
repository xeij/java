
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.example.SkipList;
import static org.junit.Assert.*;

public class SkipListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private SkipList<Integer> list;

    @Before
    public void setUp() {
        list = new SkipList<>();
        System.setOut(new PrintStream(outContent)); 
    }

    @Test
    public void testInsertAndPrint() {
        list.insert(5);
        list.insert(10);
        list.insert(15);

        list.displayList();

        String result = outContent.toString();
        assertTrue(result.contains("5"));
        assertTrue(result.contains("10"));
        assertTrue(result.contains("15"));
    }

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(System.out); 
    }
}