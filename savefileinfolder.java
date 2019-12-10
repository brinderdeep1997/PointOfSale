
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class savefileinfolder {

    savefileinfolder(File file, String newfilename) {

        FileInputStream fis = null;
        try {
            long filesize = file.length();
            fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("src/uploaded_pics/" + newfilename);
            byte b[] = new byte[10000];
            long count = 0;
            int r;
            while (true) {
                r = fis.read(b, 0, 10000);
                count = count + r;
                fos.write(b, 0, r);

                if (count == filesize) {
                    break;
                }
            }
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(savefileinfolder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(savefileinfolder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
