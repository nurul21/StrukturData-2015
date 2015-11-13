import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class KopiBerkas{
   public static void main(String[] args)  {
        try {
            KopiBerkas ko = new KopiBerkas();
            ko.kopi("ola.txt.txt","baru.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
    public void kopi (String sumber, String sasaran) throws IOException {
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
                keluaran.write(karakter);
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
