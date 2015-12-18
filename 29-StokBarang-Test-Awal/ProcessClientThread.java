import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class ProcessClientThread implements Runnable {
    private String JUMLAH="JUMLAH";
    private String TAMBAH="TAMBAH";
    private String KURANG="KURANG";
    private String SELESAI="SELESAI";
    String Kirim= null;
    OutputStream keluaran =null;
    BufferedWriter keluaranBuf = null;
    int jumlah=0;
    public ProcessClientThread(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run() {
        try{
            if (koneksi != null)
                prosesPermintaanClient(koneksi);
        }   
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient(Socket koneksi) 
    throws InterruptedException, IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);

        // Ambil dan tampilkan masukan
        for(;;){
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();

            System.out.println(baris);

            OutputStream keluaran = koneksi.getOutputStream();
            BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));

            if (baris.equals(TAMBAH)){

                jumlah++;
                System.out.println("jumlah="+jumlah);


            }   

            else if(baris.equals(KURANG)){ 
                jumlah--;
                System.out.println("jumlah="+jumlah);
            }

            else if(baris.equals(JUMLAH)){
                Kirim=""+jumlah;
                keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write(Kirim);
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }

            else if(baris.equals(SELESAI)){
                keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write("SELESAI");
                keluaranBuf.newLine();
                keluaranBuf.flush();
                koneksi.close();
                
            }

            else{
                keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write("input salah");
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }

            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
    }

   

    private Socket koneksi; 
}