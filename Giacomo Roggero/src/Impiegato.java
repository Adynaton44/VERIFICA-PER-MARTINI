import java.util.GregorianCalendar;

public class Impiegato extends Persona {
	
	public String inquad;

	public Impiegato(String nome, String cognome, String codice, GregorianCalendar calendario,String inquad) throws AgeEception {
		super(nome, cognome, codice, calendario);
		this.inquad=inquad;
		// TODO Auto-generated constructor stub
	}

}
