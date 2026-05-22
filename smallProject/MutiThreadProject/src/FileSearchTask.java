
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class FileSearchTask implements Callable<FileResult> {
    private File targetFile;
    private String[] targetWord;

    public FileSearchTask(File targetFile, String[] targetWord) {
        this.targetFile = targetFile;
        this.targetWord = targetWord;
    }

    @Override
    public FileResult call() throws Exception {
        long start = System.currentTimeMillis();
        Map<String,Integer> countMap= new HashMap<>();


        for(String word: targetWord){
            countMap.put(word, 0);
        }


        try(FileReader fileReader = new FileReader(targetFile)) {
            char[] buf = new char[1024];
            int len;
            while((len = fileReader.read(buf)) != -1){
                String content = new String(buf, 0, len);
                if(!AppConfig.IS_CASE_SENSITIVE){
                    content = content.toLowerCase();
                }
                for(String key: targetWord){
                    String targetKey = AppConfig.IS_CASE_SENSITIVE ? key : key.toLowerCase();
                    int num = getCount(content, key);
                    countMap.put(key, countMap.get(key)+num);
                }
            }
        }

        long cost = System.currentTimeMillis() - start;
        return new FileResult(targetFile.getAbsolutePath(), countMap, cost);
    }

    private int getCount(String text ,String key){
        int cnt = 0, idx = 0;
        while ((idx = text.indexOf(key, idx)) != -1) {
            cnt++;
            idx += key.length();
        }
        return cnt;
    }
}
