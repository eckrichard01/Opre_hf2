import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final ArrayList<Feladat> feladatok = new ArrayList<>();
    private static SC sc= new SC();

    static String output = "";

    public static void beolvas(){
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if(!input.equals("")){
                String[] sor = input.split(",");
                for(int i = 0; i < sor.length; i++){
                    Feladat beolvastottFeladat;
                    if(sor[i].charAt(0) != '-'){
                        beolvastottFeladat = new Feladat(Integer.parseInt(String.valueOf(sor[i].charAt(0))));
                    }
                    else {
                        beolvastottFeladat = new Feladat(Integer.parseInt(String.valueOf(sor[i].charAt(1))));
                    }
                    feladatok.add(beolvastottFeladat);
                }
            }
            input = "";
        }
        if(!input.equals("")){
            String[] sor = input.split(",");
            for(int i = 0; i < sor.length; i++){
                Feladat beolvastottFeladat;
                if(sor[i].charAt(0) != '-'){
                    beolvastottFeladat = new Feladat(Integer.parseInt(String.valueOf(sor[i].charAt(0))));
                }
                else {
                    beolvastottFeladat = new Feladat(Integer.parseInt(String.valueOf(sor[i].charAt(1))));
                }
                feladatok.add(beolvastottFeladat);
            }
        }
    }


    public static void main(String[] args) {
        beolvas();

        while(feladatok.size() != 0){
            sc.add(feladatok.get(0));
        }

        System.out.println(output);
        int hiba = 0;
        for(int i = 0; i < output.length(); i++){
            if(output.charAt(i) != '-'){
                hiba++;
            }
        }
        System.out.print(hiba);
    }
}
