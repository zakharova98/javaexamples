package org.example.io;

import org.example.classes.Box;

import java.io.*;

public class IOExamples {

    public final String fileName = "src/main/java/org/example/io/test.txt";
    public final String copyFileName = "src/main/java/org/example/io/copy_test.txt";

    public IOExamples() {
    }

    public void consoleReaderExample() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();

        System.out.println("Enter some symbols:");

        char c;
        // чтение символов пока не введено 'e'
        do {
            c = (char) br.read();
            str.append(c);
        } while (c != 'e');

        System.out.println("Symbols are: " + str);
    }

    public void consoleReaderStringsExample() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String str;
        System.out.println("Enter some text:");
        do {
            str = br.readLine();
            text.append(str).append("\n");
        } while (!str.equals("exit"));

        System.out.println("Text: " + text);
    }

    public void fileReaderExample() {
        System.out.println("Reading file: " + fileName + "\n");

        FileInputStream fileInputStream;
        int i;

        // попытка открыть файл
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        // читаем символы до тех пор, пока не встретится EOF
        try {
            do {
                i = fileInputStream.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        // закрываем файл
        try {
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }

    public void fileReaderTryWithResourcesExample() {
        System.out.println("Reading file: " + fileName + "\n");
        StringBuilder text = new StringBuilder();

        try (InputStream fileInputStream = new FileInputStream(fileName)) {
            int data;
            do {
                data = fileInputStream.read();
                if (data != -1) {
                    text.append((char) data);
                }
            } while (data != -1);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println(text);
    }

    public void fileWriterExample() {
        System.out.println("Reading file: " + fileName + " and copy to: "  + copyFileName + "\n");

        int data;

        try (InputStream fileInputStream = new FileInputStream(fileName);
             OutputStream fileOutputStream = new FileOutputStream(copyFileName)) {
            do {
                data = fileInputStream.read();
                if (data != -1) {
                    fileOutputStream.write(data);
                }
            } while (data != -1);
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    public void fileClassDemo() {
        File file = new File(fileName);
        System.out.println("File name: " + file.getName());
        System.out.println("File absolute path: " + file.getAbsolutePath());
        System.out.println("Parent dir: " + file.getParent());
        System.out.println("File is exists: " + file.exists());
        System.out.println("File can write: " + file.canWrite());
        System.out.println("File can read: " + file.canRead());
        System.out.println("File is dir: " + file.isDirectory());
        System.out.println("File modification: " + file.lastModified());
        System.out.println("File size (bytes): " + file.length());
    }

    public void serializableExampleDemo() {

        // сериализация
        try(ObjectOutputStream objOStream =
                    new ObjectOutputStream(new FileOutputStream("box"))) {

            Box box = new Box(15, 45, 78, "My serializable box example");

            System.out.println("Object before serialization\n");
            System.out.println(box);

            objOStream.writeObject(box);

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // десериализация
        try (ObjectInputStream objIStream
                     = new ObjectInputStream(new FileInputStream("box"))) {

            Box disBox = (Box) objIStream.readObject();

            System.out.println("Object after deserialization\n");
            System.out.println(disBox);
        } catch (Exception e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
