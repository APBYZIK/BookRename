import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
//         C:\\Users\\ANDREY\\OneDrive\\Рабочий стол\\Книги тест         | пусть для теста


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Укажиье путь к директории: ");
//        String path = scanner.nextLine();
        String path = "C:\\Users\\ANDREY\\OneDrive\\Рабочий стол\\Книги тест";

        RenamingFiles renamingFiles = new RenamingFiles();
        renamingFiles.FileRename(path);




    }
}