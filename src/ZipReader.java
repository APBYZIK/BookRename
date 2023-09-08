import java.io.File;
import java.util.zip.*;
public class ZipReader {
    public void ReadZipInfo(File file){
        try {
            ZipFile zipFile = new ZipFile(file);
        }catch (Exception exp){
            exp.printStackTrace();
        }

    }
}
