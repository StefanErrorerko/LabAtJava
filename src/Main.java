import java.io.*;

public class Main {

    public static void main(String[] args){

        var readableDir = new File("C:\\Users\\Errorerko\\javaprojects\\Lab1Java\\readable");
        var editableDir = new File("C:\\Users\\Errorerko\\javaprojects\\Lab1Java\\editable");

        System.out.println("Lab1 | Java | IS-02 Stefan Muzyka | 5th variant \n");
        System.out.printf("A program is up to start working with directory: \n %s", readableDir);
        System.out.printf("Your changes will be found there: \n %s", editableDir);

        var service = new DirService(editableDir, 3);
        service.recursiveSeek(readableDir);
        service.shutdownService();
    }
}
