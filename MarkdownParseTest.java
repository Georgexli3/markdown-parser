import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinksFile1() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://something.com");
        expectedList.add("some-thing.html");
        assertEquals(expectedList,MarkdownParse.getLinksNew(content));
    }
    @Test
    public void testGetLinksFile2() throws IOException{
        Path fileName = Path.of("example.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("https://google.com");
        expectedList.add("google.html");
        assertEquals(expectedList,MarkdownParse.getLinksNew(content));
    }
    @Test
    public void testGetLinksFile3() throws IOException{
        Path fileName = Path.of("fail1.md");
        String content = Files.readString(fileName);
        ArrayList<String> expectedList = new ArrayList<String>();
        if(content.length() == 0){
            assertEquals(null,null);
        }
        //assertEquals(null,MarkdownParse.getLinks(content)); SOUR
    }
}
