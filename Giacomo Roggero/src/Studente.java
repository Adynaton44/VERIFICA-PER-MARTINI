import java.util.GregorianCalendar;

public class Studente extends Persona{
	
	public Studente(String nome, String cognome, String codice, GregorianCalendar calendario,int classe, String sezione) throws AgeEception {
		super(nome, cognome, codice, calendario);
		this.classe=classe;
		this.sezione=sezione;
	}
	public int classe;
	public String sezione;

}
