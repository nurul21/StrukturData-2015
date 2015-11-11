import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class Merge{

    public void merge(String file1, String file2, String file3, String sasaran) throws IOException {
        FileInputStream fileKe1 = null;
        FileInputStream fileKe2 = null;
        FileInputStream fileKe3 = null;
        FileOutputStream keluaran= null;
        int karakter;
        // Deklarasi variabel
        try {  
            // Object stream untuk masukkan
            fileKe1 = new FileInputStream(file1);
            fileKe2 = new FileInputStream(file2);
            fileKe3 = new FileInputStream(file3);
            keluaran = new FileOutputStream(sasaran);
            
            karakter = fileKe1.read();
            // Selama masih adaata yangih bisa dibaca
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = fileKe1.read();
            }
            
            karakter = fileKe2.read();
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = fileKe2.read();
            }
            
            karakter = fileKe3.read();
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                keluaran.write(karakter);
                // Coba baca lagi dari stream
                karakter = fileKe3.read();
            }
            
            keluaran.flush();
        } 
        finally {
            // Tutup stream masukan
            if (file1 != null)           
                fileKe1.close();
            if (file2 != null)           
                fileKe2.close();
            if (file3 != null)           
                fileKe3.close();
            if (keluaran != null)
                keluaran.close();

        }
    }
    
}
