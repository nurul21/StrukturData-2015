import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Upper{
    
    public void upper (String sumber, String sasaran) throws IOException {
        FileInputStream masukan   = null;
        FileOutputStream keluaran = null;

        try {
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);
            
            int karakter = masukan.read();
            
            while (karakter != -1) {
                karakter=Character.toUpperCase(karakter);
                
                keluaran.write(karakter);
                
                karakter = masukan.read();
            }
            keluaran.flush();
        } 
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if (keluaran != null)
                keluaran.close();

        }
    }
    
}
