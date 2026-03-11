package com.thenobady.directorycleaner;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class DirectoryCleaner {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\t\tWelcome the The Directory Cleaner");
		System.out.print(
				"Enter \'Start\' to begin \nenter \'help\' to tutorial and \'exit\' to exit the program at anypoint:");
		String input = in.next();
		while (!(input.equalsIgnoreCase("Exit"))) {
			input = input.toLowerCase();
			switch (input) {
			case "help" -> tutorialHelp();
			case "start" -> cleaningProcess();
			default -> System.out.println("Invalid input");
			}
			System.out.print("\nPlease add an valid input: ");
			input = in.next();
		}
	}

	private static void cleaningProcess() {
		System.out.println("\n\tStarting the cleaning process\n");
		String directoryPath = getDirectory();
		File subDirectory = stepupDirectory(directoryPath);
		movingProcess(directoryPath,subDirectory);
		System.out.println("Cleaning complete!!");
	}

	private static void movingProcess(String directoryPath, File subDirectory) {
		System.out.print("\nEnter the type of files you want to move(extension or part of their name be specific) : ");
		String filterCriteria = in.next();
		if (filterCriteria.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		File path = new File(directoryPath);
		String[] filesToMove = path.list(new FileType(filterCriteria));
		for (String eachFile : filesToMove) {
			File initPath =  new File(directoryPath + File.separator + eachFile);
			File destPath = new File(subDirectory,eachFile);
			initPath.renameTo(destPath);
			System.out.println("\nFile moved");
		}
	}

	private static File stepupDirectory(String directoryPath) {
		System.out.print("\nEnter the name of the folder you want to create: ");
		String folderName = in.next();
		if (folderName.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		File subDirectory = new File(directoryPath + File.separator + folderName);
		subDirectory.mkdir();
		return subDirectory;

	}

	private static String getDirectory() {

		System.out.print("Enter the exact directory path that you want to clean :-  ");
		String pathinput = in.next();
		while (true) {
			if (pathinput.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			File path = new File(pathinput);
			if (path.isDirectory()) {
				return pathinput;
			} else {
				System.out.println("Invalid name!!!!!");
				System.out.print("\nPlease enter a valid path- ");
				pathinput = in.next();
			}
		}
	}

	private static void tutorialHelp() {
		System.out.println(
				"\nThis is the directory cleaner CLI tool, very easy to use.This will care a sub directory inside the directory you point to and move a specifc type of file( specific name such as \"game1\",\"game2\" or extension \".jpg\",\".pdf\") to that directory. ");
		System.out.println(
				"\nIt's very easy to use, All you have to do is enter the first add the address of the directory you want to clean(exact address only) and then add the name of the sub directory and then the specfic type of file that's it ");

	}
}

class FileType implements FilenameFilter{
	
	String fileType;
	String fileTypeLowerCase;
	public FileType() {}
	
	public FileType(String fileType) {
		this.fileType = fileType;
		fileTypeLowerCase =  fileType.toLowerCase();
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.contains(fileType) || name.contains(fileTypeLowerCase);
	}
	
}
