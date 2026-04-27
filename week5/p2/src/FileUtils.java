//* 2. 实现方法 countJavaFiles(String dirPath):
//        *    - 递归遍历指定目录
// *    - 统计以 ".java" 结尾的文件数量
// *    - 打印每个找到的 .java 文件绝对路径
// *
//         * 3. 实现方法 copyFile(String srcPath, String destPath):
//        *    - 使用字节流 (FileInputStream / FileOutputStream)
// *    - 使用缓冲区 (byte[1024]) 提高性能
// *    - 必须使用 try-with-resources 自动关闭流
// *    - 处理 FileNotFoundException 和 IOException
import java .io.*;


public class FileUtils {
    public int countJavaFiles(String dirPath){
        File dir = new File(dirPath);

        // 1. 路径不存在或不是目录
        if(!dir.exists() || !dir.isDirectory()){
            System.out.println("路径不存在或不是目录: " + dirPath);
            return 0;
        }

        // 2. 获取目录下所有文件/文件夹
        File[] files = dir.listFiles();
        if(files == null) return 0;

        int javaNum = 0;

        // 3. 遍历每个文件/文件夹
        for(File f : files){
            if(f.isDirectory()){
                // 🔥 递归：如果是文件夹，继续深入查找
                javaNum += countJavaFiles(f.getAbsolutePath());
            } else if(f.getName().endsWith(".java")){
                // 找到 .java 文件
                System.out.println("Find Java file: " + f.getAbsolutePath());
                javaNum++;
            }
        }

        return javaNum;
    }

    public void copFile(String srcPath, String destPath){
        try(FileInputStream fis = new FileInputStream(srcPath);
            FileOutputStream fos = new FileOutputStream(destPath)){

            byte[] buffer = new byte[1024];
            int len;

            while((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            System.out.println("Successfully copied");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
