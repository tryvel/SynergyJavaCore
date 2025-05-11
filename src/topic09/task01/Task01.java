package topic09.task01;

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        BufferedReader systemBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String line;
        FileOutputStream fileOutputStream;
        FileReader fileReader;
        BufferedReader fileBufferedReader;
        StringBuilder fileContent = new StringBuilder();
        try {
            System.out.println("Введите название файла без расширения");
            fileName = systemBufferedReader.readLine() + ".txt";
            fileOutputStream = new FileOutputStream(fileName);

            System.out.println("Введите текст для записи в файл, для завершения введите \"--EOF\"");
            while (!(line = systemBufferedReader.readLine()).equalsIgnoreCase("--eof")) {
                fileContent.append(line);
                fileContent.append("\n");
            }
            fileOutputStream.write(fileContent.toString().getBytes());
            fileOutputStream.close();

            fileReader = new FileReader(fileName);
            fileBufferedReader = new BufferedReader(fileReader);
            System.out.println("Содержимое файла:");
            while ((line = fileBufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();

            fileOutputStream = new FileOutputStream(fileName);
            for (byte b : fileContent.toString().getBytes()) {
                if (b != 32) {
                    fileOutputStream.write(b);
                }
            }

            fileReader = new FileReader(fileName);
            fileBufferedReader = new BufferedReader(fileReader);
            System.out.println("Содержимое файла без пробелов:");
            while ((line = fileBufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
