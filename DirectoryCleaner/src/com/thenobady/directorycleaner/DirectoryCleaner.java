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
		int osType = getOSType();
		getDirectory(osType);
	}


	private static int getOSType() {
		System.out.print("\nWhat type OS are you are you running 0 - for windows and 1 - Unix: ");
		int type = in.nextInt();
		while(!(type == 0 || type == 1)) {
			System.out.print("\nPlease enter a valid input: ");
			type = in.nextInt();
		}
		return type;
	}

	private static void getDirectory(int osType) {
		try {
			System.out.print("Enter the exact directory path that you want to clean :-  ");
			String pathinput = in.next();
			if(pathinput.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			File path = new File(pathinput);
			if(!(path.isDirectory())) {
				
			}
		}
		
	}

	private static void tutorialHelp() {
		System.out.println("\nThis is the directory cleaner cli tool, very easy to use.This will care a sub directory inside the directory you point to and move a specifc type of file( specific name such as \"game1\",\"game2\" or extension \".jpg\",\".pdf\") to that directory. ");
		System.out.println("\nIt's very easy to use, All you have to do is enter the first add the address of the directory you want to clean(exact address only) and then add the name of the sub directory and then the specfic type of file that's it ");
		
	}
}
