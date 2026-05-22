import java.util.Map;

public class FileResult {
    private String fileName;
    private Map<String,Integer> multiWordCount;
    private long processingTimeMs;

    public FileResult() {};
    public FileResult(String fileName, Map<String,Integer> multiWordCount, long processingTimeMs) {
        this.fileName = fileName;
        this.multiWordCount = multiWordCount;
        this.processingTimeMs = processingTimeMs;
    };

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, Integer> getMultiWordCount() {
        return multiWordCount;
    }

    public void setMultiWordCount(Map<String, Integer> multiWordCount) {
        this.multiWordCount = multiWordCount;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(long processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    @Override
    public String toString(){
        return fileName+ " has "+
                multiWordCount +" key words and costs "+
                processingTimeMs+" ms to search";
    }
}
