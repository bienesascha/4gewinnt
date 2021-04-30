import java.util.*;
public class Hauptprogramm {
    public static void initialisiereSpielmenue(int zeile, int spalte)
    {
        Spielfeld sp1 = new Spielfeld(zeile,spalte);
        Spieler spieler1 = new Spieler("Sabrina", 1);
        Spieler spieler2 = new Spieler("Kalle", 2);
        Spieler aktuellerSpieler = spieler1;
        
        Scanner sc = new Scanner(System.in);
         
        // Spielfeld ausgaben
        do
        {
        System.out.println(aktuellerSpieler.getName() + ", Sie sind an der Reihe!");
        System.out.println();
         
        sp1.ausgabeSpielfeld();
         
        System.out.println();
        System.out.println("Bitte wählen Sie die Spalte aus! (Wert zwischen 0 und " + spalte + ")");
        System.out.println("bei Eingaben über " + spalte + " wird das Spiel beendet!");
         
        int eingabe = sc.nextInt();
        if(eingabe >= 0 && eingabe < spalte)
        {
            sp1.setzeSpielstein(aktuellerSpieler.getSpielerNr(), eingabe);
            if(aktuellerSpieler.getSpielerNr() == 1)
                {
                aktuellerSpieler = spieler2;
                }
            else
            {
                aktuellerSpieler = spieler1;
            }
        }
        else
        {
            beendeSpiel();
        }
        } while(sp1.unentschieden() == false && sp1.testeReihe(aktuellerSpieler.getSpielerNr()) == false);
         
        System.out.println("Herzlichen Glückwunsch, " + aktuellerSpieler.getName() + " hat gewonnen!!");
         
        beendeSpiel();
         sc.close();
    }
    public static void initialisiereMenue()
    {
     
        System.out.println("Willkommen bei 4 Gewinnt!");
        System.out.println();
        System.out.println("Spiel beginnen: [1]");
        System.out.println("Spiel beenden:  [beliebige Eingabe]");
         
        Scanner sc = new Scanner(System.in);
         
        int eingabe = sc.nextInt();
        if(eingabe == 1)
        {
            Hauptprogramm.initialisiereSpielmenue(6,7);
        }
        else
        {
            beendeSpiel();
        }
         sc.close();
    }
     
    public static void beendeSpiel()
    {
        System.exit(0);
    }
}

