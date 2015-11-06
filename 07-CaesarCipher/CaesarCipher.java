
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class CaesarCipher
{
    private int shift;
    public CaesarCipher(int shift){
        this.shift=shift;
    }

    public void enkripsi(String sumber, String sasaran)throws IOException {   

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
                karakter=karakter+shift;
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
    
     public void dekripsi(String sumber, String sasaran)throws IOException {

    

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
                karakter=karakter-shift;
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
     public static void main(String[] args)  {
        try {
            CaesarCipher ko = new CaesarCipher(3);
            ko.enkripsi("ola.txt","inkripsi.txt");
            ko.dekripsi("ola.txt","dekripsi.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
}
