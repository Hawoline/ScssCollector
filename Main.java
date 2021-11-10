package scssbuilder;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> filesList = new ArrayList<String>();
    static ArrayList<String> code1 = new ArrayList<String>();
    static ArrayList<String> code2 = new ArrayList<String>();
    static ArrayList<String> code3 = new ArrayList<String>();
    static ArrayList<String> code4 = new ArrayList<String>();
    static ArrayList<String> code5 = new ArrayList<String>();
    static int filesCount = 0;
    static String resultFileName = "";

    public static void main(String[] args) {
        clearScreen();

        while (true) {
            System.out.print("Введите имя файла для сборки: ");
            String input = scanner.nextLine();

            if (!input.equals("")) {
                if (filesCount < 5) {
                    if (!input.equals("0")) {
                        if (input.endsWith(".scss")) {
                            filesList.add(input);
                            filesCount++;
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "scss");
                            filesCount++;
                        }
                        else if (input.endsWith(".s")) {
                            filesList.add(input + "css");
                            filesCount++;
                        }
                        else if (input.endsWith(".sc")) {
                            filesList.add(input + "ss");
                            filesCount++;
                        }
                        else if (input.endsWith(".scs")) {
                            filesList.add(input + "s");
                            filesCount++;
                        }
                        else {
                            filesList.add(input + ".scss");
                            filesCount++;
                        }
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
            else {
                continue;
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
            else {
                continue;
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            readScssFile(filesList.get(i), i + 1);
        }

        Boolean build = buildScssFile();

        if (build) {
            System.out.println("Sass Файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }
    } 

    public static Boolean readScssFile(String fileName, int fileIndex) {
        Boolean status = false;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            if (fileIndex == 1) {
                while (line != null) {
                    code1.add(line);
                    line = reader.readLine();
                }
            }
            else if (fileIndex == 2) {
                while (line != null) {
                    code2.add(line);
                    line = reader.readLine();
                }
            }
            else if (fileIndex == 3) {
                while (line != null) {
                    code3.add(line);
                    line = reader.readLine();
                }
            }
            else if (fileIndex == 4) {
                while (line != null) {
                    code4.add(line);
                    line = reader.readLine();
                }
            }
            else if (fileIndex == 5) {
                while (line != null) {
                    code5.add(line);
                    line = reader.readLine();
                }
            }

            status = true;
            reader.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            status = false;
        } 
        catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static Boolean buildScssFile() {
        Boolean status = false;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {
            if (filesCount == 1) {
                for (int i = 0; i < code1.size(); i++) {
                    writer.write(code1.get(i) + "\n");
                }

                writer.flush();
            }
            else if (filesCount == 2) {
                for (int i = 0; i < code1.size(); i++) {
                    writer.write(code1.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code2.size(); i++) {
                    writer.write(code2.get(i) + "\n");
                }

                writer.flush();
            }
            else if (filesCount == 3) {
                for (int i = 0; i < code1.size(); i++) {
                    writer.write(code1.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code2.size(); i++) {
                    writer.write(code2.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code3.size(); i++) {
                    writer.write(code3.get(i) + "\n");
                }
            }
            else if (filesCount == 4) {
                for (int i = 0; i < code1.size(); i++) {
                    writer.write(code1.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code2.size(); i++) {
                    writer.write(code2.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code3.size(); i++) {
                    writer.write(code3.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code4.size(); i++) {
                    writer.write(code4.get(i) + "\n");
                }
            }
            else if (filesCount == 5) {
                for (int i = 0; i < code1.size(); i++) {
                    writer.write(code1.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code2.size(); i++) {
                    writer.write(code2.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code3.size(); i++) {
                    writer.write(code3.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code4.size(); i++) {
                    writer.write(code4.get(i) + "\n");
                }

                writer.write("\n");

                for (int i = 0; i < code5.size(); i++) {
                    writer.write(code5.get(i) + "\n");
                }
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