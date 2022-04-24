import java.util.ArrayList;

public class SC {

    ArrayList<Feladat> aktiv = new ArrayList<>();
    ArrayList<Character> FIFO = new ArrayList<>();
    boolean[] jelolt = {false,false,false};

    public void add(Feladat feladat) {
        feladat.fagyasztot = true;
        if (aktiv.size() == 0) {
            aktiv.add(Main.feladatok.get(0));
            aktiv.get(0).Fifoidx = 0;
            Main.feladatok.remove(0);
            FIFO.add('A');
            Main.output += "A";
        } else if (aktiv.size() == 1) {
            if (aktiv.get(0).szama == feladat.szama) {
                Main.feladatok.remove(0);
                Main.output += "-";
                jelolt[0] = true;
            } else {
                aktiv.add(Main.feladatok.get(0));
                Main.feladatok.remove(0);
                aktiv.get(1).Fifoidx = 1;
                FIFO.add('B');
                Main.output += "B";
                jelolt[0] = false;
            }
        } else if (aktiv.size() == 2) {
            if (aktiv.get(0).szama == feladat.szama || aktiv.get(1).szama == feladat.szama) {
                Main.feladatok.remove(0);
                Main.output += "-";
                if(aktiv.get(0).szama == feladat.szama){
                    jelolt[0] = true;
                }
                else {
                    jelolt[1] = true;
                }
            } else {
                aktiv.add(Main.feladatok.get(0));
                Main.feladatok.remove(0);
                aktiv.get(2).Fifoidx = 2;
                FIFO.add('C');
                Main.output += "C";
                for(int i = 0; i < 2; i++){
                    jelolt[i] = false;
                }
            }
        } else if (aktiv.size() == 3) {
            for (int i = 0; i < aktiv.size(); i++) {
                if (aktiv.get(i).szama == feladat.szama) {
                    Main.feladatok.remove(0);
                    Feladat f = aktiv.get(i);
                    jelolt[f.Fifoidx] = true;
                    Main.output += "-";
                    for (Feladat fl : aktiv) {
                        fl.lep();
                    }
                    return;
                }
            }
            if (aktiv.get(0).fagyasztot && aktiv.get(1).fagyasztot && aktiv.get(2).fagyasztot) {
                Main.feladatok.remove(0);
                Main.output += "*";
            } else {
                int proba = 0;
                for (int i = 0; i < aktiv.size(); i++) {
                    if (aktiv.get(i).fagyasztot == false && jelolt[aktiv.get(i).Fifoidx] == false) {
                        feladat.Fifoidx = aktiv.get(i).Fifoidx;
                        aktiv.remove(i);
                        aktiv.add(feladat);
                        if (Main.feladatok.size() != 0) {
                            Main.feladatok.remove(0);
                        }

                        for(int fifo = 0; fifo <= i; fifo++){
                            FIFO.add(FIFO.get(0));
                            FIFO.remove(0);
                            boolean temp = jelolt[0];
                            jelolt[0] = jelolt[1];
                            jelolt[1] = jelolt[2];
                            jelolt[2] = temp;
                            int max = 3;
                            for(int hanyadik = 0; hanyadik < max; hanyadik++){
                                if(aktiv.get(hanyadik).Fifoidx == 0){
                                    if(i > 0){
                                        max = 2;
                                        aktiv.get(hanyadik).Fifoidx = 2;
                                        aktiv.add(aktiv.get(hanyadik));
                                        aktiv.remove(hanyadik);
                                        hanyadik--;
                                    }
                                    else {
                                        aktiv.get(hanyadik).Fifoidx = 2;
                                    }
                                }else {
                                    aktiv.get(hanyadik).Fifoidx--;
                                }
                            }
                        }

                        Main.output += FIFO.get(2).toString();
                        break;
                    }
                    if(i == 2){
                        int truecount = 0;
                        for(int x = 0; x < 3; x++){
                            if(jelolt[x] == true){
                                truecount++;
                            }
                        }
                        if(truecount >= 2){
                            jelolt[0] = false;
                        }
                        else {
                            jelolt[0] = false;
                            jelolt[1] = false;
                            jelolt[2] = false;
                        }
                        return;
                    }
                }
            }
        }
        for (Feladat f : aktiv) {
            f.lep();
        }
    }
}
