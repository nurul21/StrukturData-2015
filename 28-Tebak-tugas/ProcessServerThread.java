import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class ProcessServerThread implements Runnable {
    private Socket koneksi;
    private String aTebakan;

    public ProcessServerThread(Socket koneksiKiriman, int aTebakan) {
        koneksi = koneksiKiriman;
        this.aTebakan=""+aTebakan;
    }

    public void run()
    {
        try{
            if (koneksi != null)
                prosesPermintaanClient();
        }
        catch(IOException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient() throws IOException 
    {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);
        int u;
        String pesanServer=null;
        OutputStream keluaran=null;
        BufferedWriter keluaranBuf=null;

        for(u =0; u<3; u++)
        {
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();
            System.out.println("angka tebakan client : "+baris);

            if(aTebakan.equalsIgnoreCase(baris))
                pesanServer="Benar";
            else
                pesanServer="Salah";

            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran)); 
            keluaranBuf.write(pesanServer);
            keluaranBuf.newLine();
            keluaranBuf.flush();

            if(pesanServer.equalsIgnoreCase("Benar"))
                break;
        }
        if(u==3){
            pesanServer="Anda Kalah, Angka Sebenarnya adalah "+aTebakan;
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran)); 
            keluaranBuf.write(pesanServer);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
    }
}