package scssbuilder;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> filesList = new ArrayList<>();
    private static ArrayList<String>[] codes = new ArrayList[5];
    static int filesCount = 0;
    static String resultFileName = "";

    public static void main(String[] args) {
        for (int i = 0; i < codes.length; i++) {
            codes[i] = new ArrayList<>();
        }
        clearScreen();

        while (true) {
            System.out.print("Введите имя файла для сборки: ");
            String input = scanner.nextLine();

            if (!input.equals("")) {
                if (filesCount < 5) {
                    if (!input.equals("0")) {
                        if (input.endsWith(".scss")) {
                            filesList.add(input);
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "scss");
                        }
                        else if (input.endsWith(".s")) {
                            filesList.add(input + "css");
                        }
                        else if (input.endsWith(".sc")) {
                            filesList.add(input + "ss");
                        }
                        else if (input.endsWith(".scs")) {
                            filesList.add(input + "s");
                        }
                        else {
                            filesList.add(input + ".scss");
                        }
                        filesCount++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    System.out.println("Достигнут лимит файлов. Максимум - 5");
                    break;
                }
            }
        }

        while (true) {
            System.out.print("Введите имя итогового файла: ");
            String input = scanner.nextLine();

            if (!input.equals("")) {
                if (input.endsWith(".scss")) {
                    resultFileName = input;
                    break;
                }
                else if (input.endsWith(".")) {
                    resultFileName = input + "scss";
                    break;
                }
                else if (input.endsWith(".s")) {
                    resultFileName = input + "css";
                    break;
                }
                else if (input.endsWith(".sc")) {
                    resultFileName = input + "ss";
                    break;
                }
                else if (input.endsWith(".scs")) {
                    resultFileName = input + "s";
                    break;
                }
                else {
                    resultFileName = input + ".scss";
                    break;
                }
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            readScssFile(filesList.get(i), i + 1);
        }

        boolean build = buildScssFile();

        if (build) {
            System.out.println("Sass Файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }
    }

    public static boolean readScssFile(String fileName, int fileIndex) {
        boolean status;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                codes[fileIndex - 1].add(line);
                line = reader.readLine();
            }

            status = true;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static Boolean buildScssFile() {
        boolean status;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {

            for (int file = 0; file < filesCount; file++) {
                for (int i = 0; i < codes[file].size(); i++) {
                    writer.write(codes[file].get(i) + "\n");
                }
                writer.flush();
            }

            status = true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            status = false;
        }

        return status;
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}