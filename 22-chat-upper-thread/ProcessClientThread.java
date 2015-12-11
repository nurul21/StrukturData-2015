import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.BindException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class ProcessClientThread implements Runnable {
    public ProcessClientThread(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run() {
        if (koneksi != null)
            prosesPermintaanClient();
    }

    private void prosesPermintaanClient() {
        try{ 
            String ip = koneksi.getInetAddress().getHostAddress();
            System.out.println("Dari: " + ip);

            // Ambil dan tampilkan masukan
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();
            System.out.println(baris);

            // Baca pesan dari keyboard
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Pesan kembali: ");
            baris = keyboard.nextLine();

            // Kirim ke client
            OutputStream keluaran = koneksi.getOutputStream();
            BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran)); 
            keluaranBuf.write(baris);
            keluaranBuf.newLine();
            keluaranBuf.flush();

            // Tunggu kirim balasan client
            masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            baris = masukanReader.readLine();
            System.out.println(baris);


            // Tunggu 2 detik
            System.out.println("Tunggu...");
            Thread.sleep(2000);
            System.out.println("Selesai tunggu...");

            //koneksi.close();

        }
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    private Socket koneksi; 
}