import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void chat() 
    throws UnknownHostException, IOException {
        Socket socket = new Socket("169.254.15.97", 33333);

        try {
            String baris=null;
            int u;
            Reader masukan=null;
            BufferedReader masukanBuff=null;
            System.out.println("Ayo tebak angkanya\n");
            for(u=0; u<3;u++)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.print("Masukkan angka tebakan : ");
                baris=keyboard.nextLine();

                Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
                BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
                keluaranBuff.write(baris);
                keluaranBuff.write("\n");
                keluaranBuff.flush();

                System.out.print("Dari server: ");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(baris);         

                if(baris.equalsIgnoreCase("Benar"))
                    break;

            }

            if(u==3){
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(""+baris);
            }
        }
        catch(IOException salah) {
            System.out.println(salah);
        }
        finally {
            if (socket != null)
                socket.close();
        }
    }
}
