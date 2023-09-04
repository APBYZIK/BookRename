import java.io.File;
public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\ANDREY\\IdeaProjects\\BookName";

        File[] files = null;

        try{

            File dir = new File(path);
            files = dir.listFiles(f -> f.getName().endsWith(".fb2"));
        }catch (Exception exp){
            System.out.println(exp.toString());
            return;
        }

        for (File file : files)
        {
            BookInfo bookInfo = new BookInfo();

            try{
                bookInfo.readFileInfo(file.getName());
            }
            catch (Exception exp){
                System.out.println("Error read the file " + file.getName() + ": " + exp.toString());
                continue;
            }

            String bookName = bookInfo.getBookName() + ".fb2";

            try{
                file.renameTo(new File(bookName));
            }
            catch (Exception exp){
                System.out.println("Error rename the file " + file.getName() + ": " + exp.toString());
            }

        }
    }
}