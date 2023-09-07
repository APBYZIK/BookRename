import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//         C:\\Users\\ANDREY\\OneDrive\\Рабочий стол\\Книги тест пусть для теста

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажиье путь к директории: ");
        String path = scanner.nextLine();

        RenamingFiles renamingFiles = new RenamingFiles();
        renamingFiles.FileRename(path);






    }
}