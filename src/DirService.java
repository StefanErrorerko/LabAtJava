import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class DirService implements Runnable {

    private File readableDir;
    private File editableDir;
    private File currentFile;

    public DirService(File currentDir, File readablePath, File editablePath) {

        this.currentFile = currentDir;
        this.readableDir = readablePath;
        this.editableDir = editablePath;
    }

    @Override
    public void run(){

        if(currentFile.isDirectory()) {

            for(File item : currentFile.listFiles()) {
                if(item.isDirectory()) {

                    makeDir(item.getAbsolutePath());
                }
                DirService service = new DirService(item, readableDir, editableDir);
                Thread subThread = new Thread(service);
                subThread.start();
            }
        }
        else if(currentFile.isFile() && isJava(currentFile)) {

            try {

                String newJava = makeJava(currentFile.getAbsolutePath());
                moveReversed(currentFile.getAbsolutePath(), newJava);
            }
            catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }

    private String makeJava(String path) {

        String newPath = path.replace(readableDir.getAbsolutePath(), editableDir.getAbsolutePath());
        File newFile = new File(newPath);
        try {

            boolean created = newFile.createNewFile();
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
        return newPath;
    }

    private void moveReversed(String oldPath, String newPath) throws Exception {

        StringBuilder fileContext = readFile(oldPath);
        writeFile(newPath, fileContext.toString());
    }

    private StringBuilder readFile(String path) throws Exception {

        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);
        StringBuilder fileContext = new StringBuilder();

        while (scanner.hasNextLine()) {

            String line = reverse(scanner.nextLine());
            fileContext.append(line);
            fileContext.append('\n');
        }
        scanner.close();
        fr.close();
        return fileContext;
    }

    private void writeFile(String path, String context) throws Exception{

        FileWriter fw = new FileWriter(path);
        fw.write(context);
        fw.close();
    }

    private static String reverse(String str) {

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }

    private void makeDir(String path) {

        String newPath = path.replace(readableDir.getAbsolutePath(), editableDir.getAbsolutePath());
        File newFile = new File(newPath);
        boolean created = newFile.mkdir();
    }

    private static boolean isJava(File fileName) {

        Pattern pattern = Pattern.compile("\\w+\\.java");
        Matcher matcher = pattern.matcher(fileName.getName());
        return matcher.find();
    }
}
