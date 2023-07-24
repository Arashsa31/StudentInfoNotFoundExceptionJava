package LabProgram311;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class StudentInfoNotFound {
	public static String findID(String studentName, Scanner infoScnr) throws Exception {
		/* Type your code here. */
		/*
		 * Method findID() takes two parameters, a student's name and a Scanner object
		 * containing the text file's contents. Method findID() returns the ID
		 * associated with the student's name if the name is in the file, otherwise the
		 * method throws an Exception object with the message
		 * "Student ID not found for studentName", where studentName is the name of the
		 * student.
		 */
		String tempID = null;
		while (infoScnr.hasNext()) {
			if (infoScnr.next().equals(studentName)) {
				tempID = infoScnr.next();
				break;
			}
		}
		if (tempID == null)
			throw new Exception("Student ID not found for " + studentName);
		return tempID;
	}

	public static String findName(String studentID, Scanner infoScnr) throws Exception {
		/* Type your code here. */
		/*
		 * Method findName() takes two parameters, a student's ID and a Scanner object
		 * containing the text file's contents. Method findName() returns the name
		 * associated with the student's ID if the ID is in the file, otherwise the
		 * method throws an Exception object with the message
		 * "Student name not found for studentID", where studentID is the ID of the
		 * student.
		 */
		String tempName = null;
		while (infoScnr.hasNext()) {
			tempName = infoScnr.next();
			if (infoScnr.next().equals(studentID)) {
				break;
			}
			else tempName = null;
		}
		if (tempName == null)
			throw new Exception("Student name not found for " + studentID);
		return tempName;

	}

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		String studentName;
		String studentID;
		String studentInfoFileName;
		FileInputStream studentInfoStream = null;
		Scanner studentInfoScanner = null;

		// Read the text file name from user
		studentInfoFileName = scnr.next();

		// Open the text file
		studentInfoStream = new FileInputStream(studentInfoFileName);
		studentInfoScanner = new Scanner(studentInfoStream);

		// Read search option from user. 0: findID(), 1: findName()
		int userChoice = scnr.nextInt();

		// FIXME: findID() and findName() may throw an Exception.
		// Insert a try/catch statement to catch the exception and output the exception
		// message.

		try {
		if (userChoice == 0) {
			studentName = scnr.next();
			studentID = findID(studentName, studentInfoScanner);
			System.out.println(studentID);
		} else {
			studentID = scnr.next();
			studentName = findName(studentID, studentInfoScanner);
			System.out.println(studentName);
		}
		studentInfoStream.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}
}
