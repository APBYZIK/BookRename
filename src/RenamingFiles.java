import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class RenamingFiles {
    public void FileRename(String path){

        File dir = new File(path);
        File[] files = dir.listFiles(f -> f.getName().endsWith(".fb2"));
        File[] files2 = dir.listFiles(f -> f.getName().endsWith(".zip"));


        for (File file : files)
        {
            BookInfo bookInfo = new BookInfo();

            try{
                bookInfo.readFb2Info(file);
            }
            catch (Exception exp){
                System.out.println("Error read the file " + file.getPath() + ": " + exp.toString());
                continue;
            }

            Path bookName = Paths.get(file.getParent(), bookInfo.getBookName() + ".fb2");

            try{
                file.renameTo(new File(bookName.toUri()));
            }
            catch (Exception exp){
                System.out.println("Error rename the file " + file.getName() + ": " + exp.toString());
            }

        }

        for (File file2 : files2){

        }
    }

}
