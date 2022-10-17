import java.io.*;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args){

        File readablePath = new File("C:\\Users\\Errorerko\\javaprojects\\Lab1Java\\readable");
        File editablePath = new File("C:\\Users\\Errorerko\\javaprojects\\Lab1Java\\editable");

        System.out.println("Lab1 | Java | IS-02 Stefan Muzyka | 5th variant \n");
        System.out.printf("A program is up to start working with directory: \n %s", readablePath.toString());
        System.out.printf("Your changes will be found there: \n %s", editablePath.toString());

        DirService service = new DirService(readablePath, readablePath, editablePath);
        Thread thread = new Thread(service);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(thread);
        thread.start();
        threadPool.shutdown();
    }
}
