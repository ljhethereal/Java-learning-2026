import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<File> listTargetFiles(File rootDir, String... suffixArr){
        List<File> realTargetFiles = new ArrayList<>();
        if(!rootDir.isDirectory()||!rootDir.exists()) return realTargetFiles;
        File[] tempFiles = rootDir.listFiles();
        if(tempFiles == null) return realTargetFiles;

        for(File f: tempFiles){
            if(f.isDirectory()){
                realTargetFiles.addAll(listTargetFiles(f, suffixArr));
            }else {
                String name = f.getName();
                for(String buf: suffixArr){
                    if(name.endsWith(buf)){
                        realTargetFiles.add(f);
                    }
                }
            }
        }
        return realTargetFiles;
    }
}
