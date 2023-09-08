import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class RenamingFiles {
    public void FileRename(String path){

        File dir = new File(path);
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("fb2")  || pathname.getName().endsWith("zip");
            }
        });


        for (File file : files)
        {
            Path bookName = null;

            if (file.getName().endsWith(".fb2")){
                bookName = getPathFb2(file);
            }else {
                bookName = getPathZip(file);
            }

            if(bookName == null)
            {
                continue;
            }

            try{
                file.renameTo(new File(bookName.toUri()));
            }
            catch (Exception exp){
                System.out.println("Error rename the file " + file.getName() + ": " + exp.toString());
            }

        }

    }

    private Path getPathZip(File file) {

        Path bookName = null;

        try {

            FileInputStream fileZip = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fileZip);
            ZipInputStream stream = new ZipInputStream(bis);

            ZipEntry entry = null;
            while((entry = stream.getNextEntry()) != null){

                if(entry.isDirectory())
                    continue;

                System.out.println(entry.getName());

                byte[] content = stream.readAllBytes();

                BookInfo bookInfo = new BookInfo();
                bookInfo.readFb2Info(content);

                bookName = Paths.get(file.getParent(), bookInfo.getBookName() + ".fb2.zip");

            }

            stream.close();
            bis.close();
            fileZip.close();

        }catch(Exception exp){
            System.out.println("Ошибка обработки файла: " + exp.getStackTrace());
        }

        return bookName;
    }

    private Path getPathFb2(File file) {
        Path bookName;
        System.out.println(file.getName());

        BookInfo bookInfo = new BookInfo();

        try{
            bookInfo.readFb2Info(file);
        }
        catch (Exception exp){
            System.out.println("Error read the file " + file.getPath() + ": " + exp.toString());
            return null;
        }

        bookName = Paths.get(file.getParent(), bookInfo.getBookName() + ".fb2");
        return bookName;
    }


}
