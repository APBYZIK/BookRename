import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажиье путь к директории: ");
        String path = scanner.nextLine();

        FileRenamer renamingFiles = new FileRenamer();
        renamingFiles.FileRename(path);
    }
}
