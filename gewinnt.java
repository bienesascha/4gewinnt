import java.util.*;
 
public class gewinnt {
    static String[] [] spielfeld = new String[6] [7];
    static Scanner scanner = new Scanner(System.in); 
     
    public static void main (String[] args) {
        boolean sp = true;
         
        //Spielfeld mit leeren Strings füllen
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                spielfeld[i][j] = "";
            }
        }
         
        do
        {
            spielfeldausgeben();
            if(sp == true) {
                einwurf(1);
            } else {
                einwurf(2);
            }
            //Spielerwechsel nach Zug
            sp = !sp;
             
            if(feldVoll() == true) break;
             
        }while(gewonnen() == false);
        spielfeldausgeben();
    }
 
    public static String diagonal() {
        int var = 0;
        String spieler = "";
        int counter = 0;
         
        for(int mögl = 0; mögl < 4; mögl++) {
            for(int felder = 5; felder >= 0; felder--) {
                 
                //damit keine OutOfRangeException
                if((mögl + var) > 6) break;
                 
                //setze counter auf 1, wenn kein leeres Feld
                if(spieler != spielfeld[felder][mögl+var]) {
                    spieler = spielfeld[felder][mögl + var];
                    counter = 1;
                } else counter++; //wenn spieler mit dem Eintrag im Spielfeld übereinstimmt, soll der Counter hochgezählt werden
                 
                //wenn 4 aufeinander folgen, soll der Spieler zurückgegeben werden
                if((counter == 4) && (spieler != "")) return spieler;
                 
                //Variable hochzählen für die richtigen Felder
                var++;
            }
            //alles zurücksetzen für den neuen Durchgang
            var = 0;
            counter = 0;
            spieler = "";
        }
         
        //untenlinks nach oben rechts + verschiebung nach oben
        //3 Möglichkeiten
        for(int mögl = 0; mögl < 3; mögl++) {
            int zahl = 0;
            for(int felder = 5; felder >= 0; felder--) {
                 
                //damit keine OutOfRangeException
                if((felder - var) < 0 ) break;
                 
                //setze counter auf 1, wenn kein leeres Feld
                if(spieler != spielfeld[felder - var][zahl]) {
                    spieler = spielfeld[felder - var][zahl];
                    counter = 1;
                } else counter++; //wenn spieler mit dem Eintrag im Spielfeld übereinstimmt, soll der Counter hochgezählt werden
                 
                //wenn 4 aufeinander folgen, soll der Spieler zurückgegeben werden
                if((counter == 4) && (spieler != "")) return spieler;
                 
                //Zahl hochzählen für die richtigen Felder
                zahl++;
            }
            //Variable hochzählen für die richtigen Felder
            var++;
             
            //alles zurücksetzen für den neuen Durchgang
            counter = 0;
            spieler = "";
        }
        //Var zurücksetzen
        var = 1;
         
        //untenrechts nach oben links + verschiebung nach links
        //4 Möglichkeiten
        for(int mögl = 0; mögl < 4; mögl++) {
            //5 Felder
            for(int reihe = 5; reihe >= 0; reihe--) {
                 
                //damit keine OutOfRangeException
                if((reihe+var) < 0) break;
                 
                //setze counter auf 1, wenn kein leeres Feld
                if(spieler != spielfeld[reihe][reihe+var]) {
                    spieler = spielfeld[reihe][reihe+var];
                    counter = 1;
                } else counter++; //wenn spieler mit dem Eintrag im Spielfeld übereinstimmt, soll der Counter hochgezählt werden
                 
                //wenn 4 aufeinander folgen, soll der Spieler zurückgegeben werden
                if((counter == 4) &&(spieler != "")) return spieler;
            }
            //Variable runterzählen für die richtigen Felder
            var--;
             
            //alles zurücksetzen für den neuen Durchgang
            counter = 0;
            spieler = "";
        }
         
        //Variable zurücksetzen
        var = 0;
         
        //untenrechts nach oben links + verschiebung nach oben
        //3 Möglichkeiten
        for(int mögl = 0; mögl < 3; mögl++) {
            //Variable für die richtigen Felder
            int zahl = 6;
             
            //5 Felder
            for(int reihe = 5; reihe >= 0; reihe--) {
                 
                //damit keine OutOfRangeException
                if((reihe-var) < 0) break;
                 
                //setze counter auf 1, wenn kein leeres Feld
                if(spieler != spielfeld[reihe-var][zahl]) {
                    spieler = spielfeld[reihe-var][zahl];
                    counter = 1;
                }else counter++; //wenn spieler mit dem Eintrag im Spielfeld übereinstimmt, soll der Counter hochgezählt werden
                 
                //wenn 4 aufeinander folgen, soll der Spieler zurückgegeben werden
                if((counter == 4) && (spieler != "")) return spieler;
 
                //Variable runterzählen für die richtigen Felder
                zahl--; 
            }
            //Variable hochzählen für die richtigen Felder
            var++;
        }
         
        //nichts zurückgeben, wenn nichts davon zutrifft
        return "";
    }
     
    public static String horizontal() {
        int counter = 0;
        String spieler = "";
         
        for(int reihe = 5; reihe >= 0; reihe--) {
            for(int spalte = 0; spalte < 7; spalte++) {
                if(spieler != spielfeld[reihe][spalte]) {
                    spieler = spielfeld[reihe][spalte];
                    counter = 1;
                } else counter++;
                 
                if(counter == 4 && spieler != "") {
                    return spieler;
                }
            }
            counter = 0;
            spieler = "";
        }
        return "";
    }
         
    public static String vertikal() {
        int counter = 0;
        String spieler = "";
 
        for(int spalte = 0; spalte < 7; spalte++) {
            for(int reihe = 5; reihe >= 0; reihe--) {
                if(spieler != spielfeld[reihe][spalte]) {
                    spieler = spielfeld[reihe][spalte];
                    counter = 1;
                } else counter++;
                 
                if((counter == 4) && (spieler != "")) {
                    return spieler;
                }
            }
            counter = 0;
            spieler = "";
        }
        return "";
    }
     
    public static boolean gewonnen() {
        if(vertikal() != "") return true;
        else if(horizontal() != "") return true;
        else if(diagonal() != "") return true;
        else return false;
    }
 
    public static boolean feldVoll() {
        int counter = 0;
         
        for(int i = 0; i < 7; i++) {
            if(spielfeld[0][i] != "") {
                counter++;
            }
        }
         
        if(counter == 7) {
            System.out.println("Das Spielfeld ist voll! Unentschieden!");
            return true;
        }
        else return false;
    }
     
    public static boolean spalteVoll(int spalte) {
        if(spielfeld[0][spalte] != "") {
            return true;
        } else return false;
    }
     
    public static void einwurf(int spieler) {
        int spalte;
        boolean gilt = false;
         
        do
        {
            System.out.println("Spieler " + spieler + " ist dran!");
            System.out.print("Spalte:\t");
            spalte = scanner.nextInt() - 1;
             
            if(spalteVoll(spalte) == false) {
                for(int i = 5; i >= 0; i--) {
                    if(spielfeld[i][spalte] == "") {
                        if(spieler == 1) {
                            spielfeld [i][spalte] = "1";
                        } else {
                            spielfeld [i][spalte] = "2";
                        }
                        gilt = true;
                        break;
                    }
                }
            } else System.out.println("Spalte voll!");
        }while(gilt == false);
    }
     
    public static void spielfeldausgeben() {
        for(int i = 0; i < 6; i++) {
             
            for(int j = 0; j < 7; j++) {
                System.out.print(" | ");
                switch (spielfeld[i][j]) {
                case "":
                    System.out.print(" ");
                    break;
                case "1":
                    System.out.print("X");
                    break;
                case "2":
                    System.out.print("O");
                    break;
                }
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println(" -----------------------------");
    }
}
