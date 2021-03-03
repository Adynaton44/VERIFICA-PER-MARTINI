import java.util.GregorianCalendar;

public class Docente extends Persona{

	public String concorso;
	public String getConcorso() {
		return concorso;
	}
	public void setConcorso(String concorso) {
		this.concorso = concorso;
	}
	public Docente(String nome, String cognome, String codice, GregorianCalendar calendario, String concorso) throws AgeEception {
		super(nome, cognome, codice, calendario);
		this.concorso=concorso;
		// TODO Auto-generated constructor stub
	}

}
