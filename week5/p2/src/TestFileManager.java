//* 4. TestFileManager 测试类：
//        *    - 调用 countJavaFiles 统计你的 "E:/Java/javaProject/weekPractice" 目录。
//        *    - 调用 copyFile 复制一个图片文件或 TXT 文件，验证复制后的文件是否一致。
public class TestFileManager {
    public static void main(String[] args) {
        FileUtils temp = new FileUtils();
        System.out.println("the account of java files is " + temp.countJavaFiles("E:/Java/javaProject/weekProject"));

        temp.copFile("E:/Java/javaProject/weekProject/test/testText.txt","E:/Java/javaProject/weekProject/test/testText1.txt");
    }
}