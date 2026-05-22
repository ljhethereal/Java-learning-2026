import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        String scanPath = AppConfig.DEFAULT_SCAN_PATH;
        String[] keywords = AppConfig.DEFAULT_KEYWORD;
        int maxThreads = AppConfig.MAX_THREAD_NUM;
        String[] fileSuffix = {".txt",".java",".code"};

        File rootDir = new File(scanPath);
        List<File> targetFiles = FileUtils.listTargetFiles(rootDir, fileSuffix);
        if(targetFiles.isEmpty()){
            System.out.println("didnt find the proper files");
        }

        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<FileResult>> futures = new ArrayList<>();


        for (File file : targetFiles) {
            FileSearchTask task = new FileSearchTask(file, keywords);
            Future<FileResult> future = executor.submit(task);
            futures.add(future);
        }


        for (Future<FileResult> future : futures) {
            try {
                FileResult result = future.get();
                System.out.println(result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }
}
