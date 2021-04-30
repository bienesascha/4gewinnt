
public class Spielfeld {
	 private int feld[][] = null;     
	    public Spielfeld(int x, int y)
	    {
	        feld = new int[x][y];
	        for(int i=0; i < feld.length; i++)
	        {
	            for(int j=0; j < feld[i].length; j++)
	            {
	                feld[i][j] = 0;
	            }
	        }
	    }
	    public void setzeSpielstein(int spielerNr, int spalte)
	    {
	        int x = feld.length-1;
	        boolean fortsetzen = true;
	        while(x >= 0 && fortsetzen == true)
	        {
	            if(feld[x][spalte] == 0 )
	            {
	            feld[x][spalte] = spielerNr;
	            fortsetzen = false;
	            }
	            x--;
	        }
	        if(x < 0)
	        {
	            System.out.println("Der Stein konnte nicht gesetzt werden!");
	        }
	    }
	    public void ausgabeSpielfeld()
	    {
	        for(int i=0; i < feld.length; i++)
	        {
	            for(int j=0; j < feld[i].length; j++)
	            { 
	                System.out.print("| " + feld[i][j] + " |");
	            }
	            System.out.println();
	        }
	    }
	    public boolean unentschieden()
	    {
	        boolean returnwert = false;
	        if(getAnzahlGesetzterSteine() == feld.length*feld[0].length)
	        {
	            returnwert = true;
	        }
	        return returnwert;
	    }
	    public int getAnzahlGesetzterSteine()
	    {
	        int anzSteine = 0;
	        for(int i=0; i < feld.length; i++)
	        {
	            for(int j=0; j < feld[i].length; j++)
	            {
	                if(feld[i][j] != 0)
	                {
	                    anzSteine++;
	                }
	            }
	        }
	        return anzSteine;
	    }
	    public boolean testeReihe(int spielerNr)
	    {
	        boolean returnwert = false;
	        if(getAnzahlGesetzterSteine() >= 7)
	        {
		        for(int i=0; i < feld.length; i++)
		        {
		            for(int j=0; j < feld.length; j++)
		            {
		                if(testeHorizontal(i,j,spielerNr) == true || testeVertikal(i,j,spielerNr) == true || testeQuer(i,j,spielerNr) == true )
		                {
		                    returnwert = true;
		                }
		                 
		            }
		        }
	        }
	        else
	        {
	        	return returnwert;
	        }
	        return returnwert;
	    }
	    public boolean testeHorizontal(int x, int y, int Spieler)
	    {
	        boolean returnwert = false;
	        if(y + 3 < feld[x].length)
	        {
	            if(feld[x][y] == Spieler && feld[x][y+1] == Spieler && feld[x][y+2] == Spieler && feld[x][y+3] == Spieler)
	            {
	            returnwert = true;
	            }
	        }   
	        return returnwert;
	    }
	    public boolean testeVertikal(int x, int y, int Spieler)
	    {
	        boolean returnwert = false;
	        if(x + 3 < feld.length)
	        {
	            if(feld[x][y] == Spieler && feld[x+1][y] == Spieler && feld[x+2][y] == Spieler && feld[x+3][y] == Spieler)
	            {
	            returnwert = true;
	            }
	        }   
	        return returnwert;
	    }
	    public boolean testeQuer(int x, int y, int Spieler)
	    {
	        boolean returnwert = false;
	        if(x + 3 < feld.length && y + 3 < feld.length)
	        {
	            if(feld[x][y] == Spieler && feld[x+1][y+1] == Spieler && feld[x+2][y+2] == Spieler && feld[x+3][y+3] == Spieler)
	            {
	            returnwert = true;
	            }
	        }   
	        if(x - 3 >= 0 && y + 3 < feld.length)
	        {
	            if(feld[x][y] == Spieler && feld[x-1][y+1] == Spieler && feld[x-2][y+2] == Spieler && feld[x-3][y+3] == Spieler)
	            {
	            returnwert = true;
	            }
	        }   
	        return returnwert;
	    }
}
