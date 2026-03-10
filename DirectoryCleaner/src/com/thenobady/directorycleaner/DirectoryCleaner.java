package com.thenobady.directorycleaner;

import java.io.File;
import java.util.Scanner;

public class DirectoryCleaner {
	
	private static String dirAddress;
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("\t\tWelcome the The Directory Cleaner");
		System.out.print("Enter \'Start\' to begin \nenter \'help\' to tutorial and \'exit\' to exit the program at anypoint:");
		String input = in.next();
		while(!(input.equalsIgnoreCase("Exit"))) {
			input = input.toLowerCase();
			switch(input) {
			case "help" -> tutorialHelp();
			case "start" -> cleaningProcess();
			default -> System.out.println("Invaild input");
			}
			System.out.print("\nPlease add an vaild input: ");
			input = in.next();
		}
	}

	private static void cleaningProcess() {
		System.out.println("\n\tStarting the cleaning process\n");
		String directoryPath = getDirectory();
		stepupDirectory(directoryPath);
	}


	private static void stepupDirectory(String directoryPath) {
		System.out.print("\nEnter the name of the folder you want to create: ");
		String folderName = in.next();
		if(folderName.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
		File subDirectory = new File(directoryPath + File.pathSeparator + folderName);
		subDirectory.mkdir();
		
	}

	private static String getDirectory() {
	
			System.out.print("Enter the exact directory path that you want to clean :-  ");
			String pathinput = in.next();
			while(true) {
			if(pathinput.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			File path = new File(pathinput);
			if(path.isDirectory()) {
				return pathinput;
			}
			else {
				System.out.println("Invalid name!!!!!");
				System.out.print("\nPlease enter a valid path- ");
				pathinput = in.next();
			}
		}
	}

	private static void tutorialHelp() {
		System.out.println("\nThis is the directory cleaner cli tool, very easy to use.This will care a sub directory inside the directory you point to and move a specifc type of file( specific name such as \"game1\",\"game2\" or extension \".jpg\",\".pdf\") to that directory. ");
		System.out.println("\nIt's very easy to use, All you have to do is enter the first add the address of the directory you want to clean(exact address only) and then add the name of the sub directory and then the specfic type of file that's it ");
		
	}
}
