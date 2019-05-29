import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programming class. This is what reads and compiles what the user has coded. 
 * @author lakshbhambhani
 * @date 5/26/19
 */
public class Java {
	
	// the list that is used to read the text from the textboxees
	private String text;
	private static List<Integer> values = new ArrayList<Integer>();		// 1 common list for values of integer variables
	private static List<String> names = new ArrayList<String>();		// 1 common list for names of Integer variables
	
	// some constants
	private static final String EQUALS = "=";							// equals constant. All constants are common for the class
	private static final String LESSTHAN  = "<";						// less than constant
	private static final String GREATERTHAN = ">";						// greater than constant
	private static final String NOTEQUALTO = "!=";						// not equal to constant
	private static final String LESSTHANEQUALTO =  "<=";				// less than equal to constant
	private static final String GREATERTHANEQUALTO = ">=";				// greater than equal to constant
	
	
	/**
	 * Helps full body move forward
	 */
	private static void moveForward() {
		FullBody.moveForward();
	}
	
	/**
	 * Helps full body move backward
	 */
	private static void moveBackward() {
		FullBody.moveBackward();
	}

	/**
	 * Helps full body turn left
	 */
	private static void turnLeft() {
		FullBody.turnLeft();
	}

	/**
	 * Helps full body turn right
	 */
	private static void turnRight() {
		FullBody.turnRight();
	}

	/**
	 * Helps full body move to home position
	 */
	private static void homePos() {
		FullBody.homePos();
	}

	/**
	 * Helps full body bow
	 */
	private static void bow() {
		FullBody.bow();
	}

	/**
	 * Helps full body bend back
	 */
	private static void bendBack() {
		FullBody.bendBack();	
	}

	/**
	 * Helps full body do 5 push ups
	 */
	private static void pushUp() {
		FullBody.pushUp();	
	}

	/**
	 * Helps full body jump up
	 */
	private static void jumpUp() {
		FullBody.jumpUp();
	}

	/**
	 * Helps full body jump back a.k.a flip
	 */
	private static void jumpBack() {
		FullBody.jumpBack();	
	}

	/**
	 * Used to create integers
	 * @param name
	 * @param value
	 */
	private static void createInt(String name, int value) {
		names.add(name);
		values.add(value);
	}
	
	/**
	 * used to process text from textbox
	 * @param text
	 * @return
	 * @throws InterruptedException
	 */
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
			String conditionStatement = text.substring(text.indexOf("f") + 2, text.indexOf("{") - 1).trim();
			System.out.println("Condition Statement: " + conditionStatement);
			String condition1 = "";
			String condition2 = "";
			String operator = "";
			String nextStatement = text.substring(text.indexOf("{") + 1, text.indexOf("}"));
			System.out.println("Next Statement: " + nextStatement);
			int whitespaces = 0;
			for(int i = 0; i < conditionStatement.length(); i++) {
				if(Character.isWhitespace(conditionStatement.charAt(i))){
					whitespaces++;
					// if hi == 5; {asdf};
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
			
			String value1 = condition1;
			String value2 = condition2;
			
			if (Character.isLetter(condition1.charAt(0))) {
				value1 = String.valueOf(values.get(names.indexOf(condition1)));
			}
			
			if (Character.isLetter(condition2.charAt(0))) {
				value2 = String.valueOf(values.get(names.indexOf(condition1)));
			}
			
			int numValue1 = Integer.parseInt(value1);
			int numValue2 = Integer.parseInt(value2);
			
			if (operator.equals("==") && numValue1 == numValue2) {
				return process(nextStatement);
			} else if (operator.contentEquals("<") && numValue1 < numValue2) {
				return process(nextStatement);
			} else if (operator.contentEquals(">") && numValue1 > numValue2) {
				return process(nextStatement);
			} else if (operator.contentEquals("!=") && numValue1 != numValue2) {
				return process(nextStatement);
			} else if (operator.contentEquals("<=") && numValue1 <= numValue2) {
				return process(nextStatement);
			} else if (operator.contentEquals(">=") && numValue1 >= numValue2) {
				return process(nextStatement);
			} else {
				return "Statement is false";
			}

		} else {
			return "error";

		}

	}
	
	/**
	 * Used to process text from a file so indrirectly get text from textbox and save it to a file and then process ut
	 * @param fileText
	 * @return
	 * @throws InterruptedException
	 */
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
