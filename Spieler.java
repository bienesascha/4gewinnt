
public class Spieler {
	int spielernummer;
	String speilername;
	public Spieler(String name, int nummer){
		spielernummer=nummer;
		speilername=name;
	}
	public String getName(){
		return speilername;
	}
	public int getSpielerNr(){
		return spielernummer;
	}
}
