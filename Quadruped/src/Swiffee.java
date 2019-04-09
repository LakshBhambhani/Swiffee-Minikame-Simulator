import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Swiffee {
	
	private String text;
	private static List<Integer> values = new ArrayList<Integer>();
	private static List<String> names = new ArrayList<String>();
	

	private static void moveForward() {
		Body.moveForward();
	}
	
	private static void moveBackward() {
		Body.moveBackward();
	}
	
	private static void turnLeft() {
		Body.turnLeft();
	}
	
	private static void turnRight() {
		Body.turnRight();
	}
	
	private static void createInt(String name, int value) {
		names.add(name);
		values.add(value);
	}
	
	public static String process(String text) throws InterruptedException {
		if(text.equals("moveForward()")){
			moveForward();
			return "Moving Forward";
		}
		else if(text.equals("moveBackward()")){
			moveBackward();
			return "Moving Backward";
		}
		else if(text.equals("turnLeft()")){
			turnLeft();
			return "Turning Left";
		}
		else if(text.equals("turnRight()")){
			turnRight();
			return "Turning Right";
		}
		else if(text.contains("=")){
			System.out.println("Variable Created:");
			System.out.println("Name: " + text.substring(0, text.indexOf("=")).trim());
			System.out.println("Value: " + Integer.parseInt(text.substring(text.indexOf("=")+1).trim()));
			createInt(text.substring(0, text.indexOf("=")).trim(), Integer.parseInt(text.substring(text.indexOf("=")+1).trim()));
			return "";
		}
		else if(text.contains("echo")) {
			String name = text.substring(text.indexOf("o") + 2).trim();
			System.out.println(name);
			System.out.println(names.indexOf(name));
			return String.valueOf(values.get(names.indexOf(name)));
		}
		else if(text.contains("time.sleep(")) {
			int timeDelay = Integer.parseInt(text.substring(text.indexOf("(")+1, text.length()-1));
			TimeUnit.SECONDS.sleep(timeDelay);
			return "In sleep for " + timeDelay + " seconds";
		}
		return "";
	}
	
	public static List<String> processFile(String fileText) throws InterruptedException {
		
		System.out.println("Processing from file");
		String[] linesOfCode;
		linesOfCode = fileText.split(";");
		System.out.println(Arrays.toString(linesOfCode));
		System.out.println("Lines of Code: " + linesOfCode.length);
		
		List<String> returnValues = new ArrayList<String>();

		
		for(int i = 0; i < linesOfCode.length; i++) {
			String currentLine = linesOfCode[i];
			System.out.println("Current Line + Output: " + currentLine.trim() + process(currentLine.trim()).trim());
			returnValues.add(process(currentLine.trim()).trim());
		}
		
		return returnValues;
	}
}
