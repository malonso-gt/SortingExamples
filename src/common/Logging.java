/**
 * 
 */
package common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

/**
 * @author moise
 *
 */
public class Logging {
	
	/***
	 * This method create a new file to save logs
	 * @return the name of the file
	 * @throws IOException if file exists or cannot be created, will throw an exception
	 */
	public static String createFile() throws IOException{
		String fileName = "Log_" + java.lang.System.currentTimeMillis() + ".txt";
		File LoggingFile = new File(fileName);
		LoggingFile.createNewFile();
		return fileName;
	}

	/***
	 * This method create a new file to save logs using the filename provided
	 * @param filename the name of the file customer needs
	 * @return the filename and extension .txt
	 * @throws IOException
	 */
	public static String createFile(String fileName) throws IOException{
		File LoggingFile = new File(fileName + ".txt");
		LoggingFile.createNewFile();
		return fileName + ".txt";
	}
	
	/***
	 * This method insert a new line into a file
	 * @param fileName Filename where you want to add the line
	 * @param newLine the new line needs to be append to the file
	 * @throws IOException If issue occuer
	 */
	public static void appendTextInNewLine(String fileName, String newLine) throws IOException{
		Files.write(Paths.get(fileName), newLine.getBytes(), StandardOpenOption.APPEND);
	}
}
