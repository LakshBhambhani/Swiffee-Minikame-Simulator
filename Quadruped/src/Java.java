import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Programming class. This is what reads and compiles what the user has coded. 
 */
public class Java {
	
	// the list that is used to read the text from the textboxees
	private String text;
	private static List<Integer> values = new ArrayList<Integer>();
	private static List<String> names = new ArrayList<String>();
	
	// some constants
	private static final String EQUALS = "=";
	private static final String LESSTHAN  = "<";
	private static final String GREATERTHAN = ">";
	private static final String NOTEQUALTO = "!=";
	private static final String LESSTHANEQUALTO =  "<=";
	private static final String GREATERTHANEQUALTO = ">=";
	

	private static void moveForward() {
		FullBody.moveForward();
	}
	
	private static void moveBackward() {
		FullBody.moveBackward();
	}
	
	private static void turnLeft() {
		FullBody.turnLeft();
	}
	
	private static void turnRight() {
		FullBody.turnRight();
	}
	
	private static void homePos() {
		FullBody.homePos();
	}
	
	private static void bow() {
		FullBody.bow();
	}
	
	private static void bendBack() {
		FullBody.bendBack();
	}
	
	private static void pushUp() {
		FullBody.pushUp();
	}
	
	private static void jumpUp() throws InterruptedException {
		FullBody.jumpUp();
	}
	
	private static void jumpBack() {
		FullBody.jumpBack();
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
		if(text.equals("homePos()")){
			homePos();
			return "Returning to home Position";
		}
		else if(text.equals("bow()")){
			bow();
			return "Bowing";
		}
		else if(text.equals("bendBack()")){
			bendBack();
			return "Bending Back";
		}
		else if(text.equals("pushUp()")){
			pushUp();
			return "Completing 5 pushups";
		}
		else if(text.equals("jumpUp()")){
			jumpUp();
			return "Jumping Up";
		}
		else if(text.equals("jumpBack()")){
			jumpBack();
			return "Jumping Back";
		}
		else if(text.contains("=") && !text.contains("if")){
			System.out.println("Variable Created:");
			System.out.println("Name: " + text.substring(0, text.indexOf("=")).trim());
			System.out.println("Value: " + Integer.parseInt(text.substring(text.indexOf("=")+1).trim()));
			createInt(text.substring(0, text.indexOf("=")).trim(), Integer.parseInt(text.substring(text.indexOf("=")+1).trim()));
			return "";
		}
		else if(text.contains("System.out.println(")) {
			System.out.println("Printing something");
			String name = text.substring(text.indexOf("(") + 1, text.indexOf(")")).trim();
			System.out.println(name);
			System.out.println(names.indexOf(name));
			return String.valueOf(values.get(names.indexOf(name)));
		}
		else if(text.contains("time.sleep(")) {
			int timeDelay = Integer.parseInt(text.substring(text.indexOf("(")+1, text.length()-1));
			TimeUnit.SECONDS.sleep(timeDelay);
			return "In sleep for " + timeDelay + " seconds";
		}
		else if(text.contains("if")) {
			String conditionStatement = text.substring(text.indexOf("f") + 2).trim();
			System.out.println("Condition Statement: " + conditionStatement);
			String condition1 = "";
			String condition2 = "";
			String operator = "";
			int whitespaces = 0;
			for(int i = 0; i < conditionStatement.length(); i++) {
				if(Character.isWhitespace(conditionStatement.charAt(i))){
					whitespaces++;
					
				}
				else {
					if(whitespaces == 0) {
						condition1 = condition1 + conditionStatement.charAt(i);
					}
					else if(whitespaces == 1) {
						operator = operator + conditionStatement.charAt(i);
					}
					else if(whitespaces == 2) {
						condition2 = condition2 + conditionStatement.charAt(i);
					}
				}
			}
			
			System.out.println("condition1: " + condition1);
			System.out.println("operator: " + operator);
			System.out.println("condition2: " + condition2);
				
		}
		else {
			return "error";
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
