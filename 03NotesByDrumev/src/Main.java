import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println();
        System.out.println();
        System.out.println();
        if (!doesFileExist()) {
            File file = new File("C:/NotesByDrumev.txt");
            if (file.createNewFile())
            {
                System.out.println("******************************");
                System.out.println("******************************");
                System.out.println();
                System.out.println("NotesByDrumev.txt is created!");
                System.out.println();
                System.out.println("******************************");
                System.out.println("******************************");
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println("******************************");
            System.out.println("******************************");
            System.out.println();
            System.out.println("NotesByDrumev.txt loaded!");
            System.out.println();
            System.out.println("******************************");
            System.out.println("******************************");
            System.out.println();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("---- Welcome to DrumevNotes ----");
        System.out.println("--------------------------------");
        printCommands();

        boolean flag = true;

        String input = scanner.nextLine().toLowerCase();
        while (!input.equals("exit")) {
        switch (input) {
            case "view":
                System.out.println("----Your notes----");
                read();
                break;
            case "add":
                flag = true;
                add(flag);
                break;
            case "new":
                flag = false;
                newNotes(flag);
                break;
            case "clear":
                flag = false;
                clear(flag);
                break;
            case "commands":
                printCommands();
                break;
            default:
                System.out.println();
                System.out.println("Unknown command!");
                System.out.println();
                System.out.println("Please enter a valid command: ");
        }
            input = scanner.nextLine().toLowerCase();
        }
    }

    public static void read() {
        String fileName = "C:/NotesByDrumev.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
            if ((strCurrentLine = br.readLine()) == null) {
                System.out.println();
                System.out.println("You don't have any notes.");
                System.out.println();
            }
            System.out.println("------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Enter a command:");
        System.out.println();
    }

    public static void printCommands() {
        System.out.println("View -> View your notes");
        System.out.println("Add -> Add more notes");
        System.out.println("New -> Clear your notes and start adding new notes");
        System.out.println("Clear -> Clear all your notes");
        System.out.println("Commands -> Show all commands");
        System.out.println("Exit -> Exit");
        System.out.println();
        System.out.println("Please enter one of the following commands: ");
        System.out.println();
    }

    public static void newNotes(boolean flag) throws IOException {
        System.out.println("All previous notes have been cleared.");
        System.out.println();
        System.out.println("----New notes file is created.----");
        System.out.println();
        System.out.println("Whenever you have noted everything, enter the command: save");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        FileWriter fileWriter = new FileWriter("C:/NotesByDrumev.txt", flag);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(" -" + text);
        while (!text.equals("save")) {
            writer.write("- " + text);
            writer.newLine();
            text = scanner.nextLine();
        }

        writer.close();
        System.out.println();
        System.out.println("New note has been added!");
        System.out.println();
        System.out.println("Enter a command:");
        System.out.println();
    }
    public static void add(boolean flag) throws IOException {
        System.out.println("Whenever you have noted everything, enter the command: save");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        FileWriter fileWriter = new FileWriter("C:/NotesByDrumev.txt", flag);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        while (!text.equals("save")) {
            writer.write("- " + text);
            writer.newLine();
            text = scanner.nextLine();
        }

        writer.close();
        System.out.println();
        System.out.println("New note has been added!");
        System.out.println();
        System.out.println("Enter a command:");
        System.out.println();
    }
    public static void clear(boolean flag) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete everything, Y/N");
        String check = scanner.nextLine().toLowerCase();
        if (check.equals("y")) {
            FileWriter fileWriter = new FileWriter("C:/NotesByDrumev.txt", flag);
            fileWriter.close();
            System.out.println("All notes have been deleted");
        }
        System.out.println();
        System.out.println("Enter a command:");
        System.out.println();
    }

    static boolean doesFileExist() {
        File tmpDir = new File("C:/NotesByDrumev.txt");
        return tmpDir.exists();
    }
}
