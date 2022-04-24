public class Feladat {
    int szama;
    int utem;
    boolean fagyasztot;
    int Fifoidx;

    Feladat(int szam){
        szama = szam;
        utem = 0;
        fagyasztot = false;
        Fifoidx = 0;
    }

    public void lep(){
        if(utem == 3){
            fagyasztot = false;
        }
        utem++;
    }
}
