
/**
 * Write a description of class AKeAt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AKeAt{
   
    public void aKeAt  (String sumber, String sasaran) throws IOException {
        FileInputStream masukan = null;
        FileOutputStream keluaran = null;

        // Deklarasi variabel
        try {
            // Object stream untuk masukkan
            masukan = new FileInputStream(sumber);
            keluaran = new FileOutputStream(sasaran);// ambil objek abestu bukak nama berkasnya kalaok ga ada dia throw excepytion 

            // Coba baca  dari stream
            int karakter = masukan.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {// kalau minus 1 dia selesai
                // Lakukan sesuatu dengan data yang dibaca => Tampikan
                
                
                if((karakter == 'a')|| (karakter == 'A')){
                    karakter='@';
                    keluaran.write(karakter);
                }
                else{keluaran.write(karakter);}
                // Coba baca lagi dari stream
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
