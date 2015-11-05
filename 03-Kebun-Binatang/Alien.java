public class Alien extends Komodo implements Tumbuhan {
    public boolean berbuah (){
        boolean berbuah = true;
        return berbuah;
    }

    public boolean merayap (){
        boolean merayap = false;
        return merayap;
    }

    public String suara() {
        String suara = new String ("Bip");
        return suara;
    }

}