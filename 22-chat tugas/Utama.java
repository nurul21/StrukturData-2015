import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Utama {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner (System.in);
            client tanya = new client();
            System.out.println("masukkan pesan anda:");
            String pesandatang = in.next();
            
            tanya.whois(pesandatang);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
