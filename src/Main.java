import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String path = "C:\\Users\\ANDREY\\OneDrive\\Рабочий стол\\Книги тест";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажиье путь к директории: ");
        String path = scanner.nextLine();

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
                bookInfo.readFileInfo(file);
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
    }
}