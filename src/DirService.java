import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class DirService{

    private File editableDir;
    private ExecutorService executor;

    public DirService(File editablePath, int poolAmount) {

        this.executor = Executors.newFixedThreadPool(poolAmount);
        this.editableDir = editablePath;
    }

    public void recursiveSeek(File currentFile) {

        if(currentFile.isDirectory()) {

            for(var item : currentFile.listFiles()) {

                recursiveSeek(item);
            }
        }
        else if(currentFile.isFile() && isJava(currentFile)) {

            try {

                var filePerformer = new FilePerformer(currentFile, editableDir);
                executor.submit(filePerformer);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void shutdownService(){
        this.executor.shutdown();
    }

    private static boolean isJava(File fileName) {

        var pattern = Pattern.compile("\\w+\\.java");
        var matcher = pattern.matcher(fileName.getName());
        return matcher.find();
    }
}
