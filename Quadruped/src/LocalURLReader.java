
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

/**
 * Reads the text on a url. Helps us know about the acknowledgement from the bot once it moves
 * @author lakshbhambhani
 * @date 5/26/19
 */

public class LocalURLReader {

	/**
	 * Used to get text from a specific url
	 * @param action
	 * @return
	 */
	public static boolean readFromURL(String action) {
		try {
			StringExtractor se = new StringExtractor("http://localhost:8080/" + action);
			String content = se.extractStrings(false);
			System.out.println(content);
			System.out.println("================================================");
			if(content.equals("Quadruped Status\n" + action)) {
				return true;
			}
			else {
				return false;
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return false;
	}
}