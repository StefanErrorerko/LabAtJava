import java.io.*;
import java.util.Scanner;

public class FilePerformer implements Runnable {

    public File currentFile;
    public File editableDir;

    public FilePerformer(File currentFile, File editableDir){
        this.currentFile = currentFile;
        this.editableDir = editableDir;
    }

    @Override
    public void run() {
        try {
            var newPath = makeJava(currentFile);
            moveReversed(currentFile.getAbsolutePath(), newPath);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private String makeJava(File file)
            throws IOException {

        var newPath = editableDir.getAbsolutePath() + "\\" + file.getName();
        var newFile = new File(newPath);
        var created = newFile.createNewFile();
        return newPath;
    }

    private void moveReversed(String oldPath, String newPath)
            throws Exception {

        var fileContext = readFile(oldPath);
        writeFile(newPath, fileContext.toString());
    }

    private StringBuilder readFile(String path)
            throws Exception {

        var fileReader = new FileReader(path);
        var scanner = new Scanner(fileReader);
        var fileContext = new StringBuilder();

        while (scanner.hasNextLine()) {

            var line = reverse(scanner.nextLine());
            fileContext.append(line);
            fileContext.append('\n');
        }
        scanner.close();
        fileReader.close();
        return fileContext;
    }

    private void writeFile(String path, String context)
            throws Exception{

        var fileWriter = new FileWriter(path);
        fileWriter.write(context);
        fileWriter.close();
    }

    private static String reverse(String str) {

        var stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        return stringBuilder.reverse().toString();
    }
}
