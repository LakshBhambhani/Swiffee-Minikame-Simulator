
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;


public class URLReader {

	public static void main(String[] args) {
		try {
			StringExtractor se = new StringExtractor("http://172.20.10.3/walkForward");
			String content = se.extractStrings(false);
			System.out.println(content);
			System.out.println("================================================");
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
}