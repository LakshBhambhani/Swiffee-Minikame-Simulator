import java.util.List;
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
	
	public static String process(String text) {
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
		return "";
	}
	
	public static String processFile(String fileText) {
		
		System.out.println("Processing from file");
		String[] linesOfCode;
		linesOfCode = fileText.split(";");
		System.out.println(Arrays.toString(linesOfCode));
		
		for(int i = 0; i < linesOfCode.length; i++) {
			String currentLine = linesOfCode[0];
			process(currentLine);
		}
		return "processed 1";
	}
}
