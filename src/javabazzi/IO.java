package javabazzi;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    private static void readUsingScannerByConsole() {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println("Input is " + number);
        scn.close();
    }

    private static void readUsingBufferedReaderByConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter your age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.println("You are " + age + " years old.");
        } catch (IOException ex) {
            System.out.println("An error occurred while reading input.");

        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void writeDataInFileUsingBufferedWriter() {
        String filename = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("hi there!!");
            writer.newLine();
            writer.write("Welcome!");
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    private static void readDataFromFileUsingBufferedReader() {
        String filename = "output.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while reading data from file.");
        }
    }
    

    public static void main(String[] args) {
        //readUsingScannerByConsole();
        //readUsingBufferedReaderByConsole();
        //writeDataInFileUsingBufferedWriter();
        //readDataFromFileUsingBufferedReader();
    }


}
