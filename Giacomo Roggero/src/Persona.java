import java.util.Calendar;
import java.util.GregorianCalendar;

/*Realizzare un programma che implementi il software di gestione di una scuola. Tutte le
persone presenti all’interno dell’Istituto hanno in comune cognome, nome, codice fiscale-
e data di nascita. Non è possibile implementare una persona se non nelle figure
professionali del docente (con classe di concorso), impiegato ATA (con inquadramento:
segreteria, assistente tecnico, operatore) e dell’alunno (con classe e sezione). Non è
possibile inserire una persona con una data di nascita inferiore al 1/1/1940 (è necessario
inserire una eccezione opportuna). Nella finestra principale deve essere presente una
combobox, in cui è possibile scegliere l’inquadramento ed avere tutti i dati delle diverse
figure presenti nel database. Da un menù file è possibile salvare su file csv i dati o
importarli da un file serializzato. Da un menù aggiungi è possibile aggiungere un elemento
o modificare le sue caratteristiche. (30 punti)*/
public class Persona {
	
	public Persona(String nome, String cognome, String codice, GregorianCalendar calendario) throws AgeEception {
		super();
		c2=new GregorianCalendar();
		c2.set(Calendar.YEAR, 1940);
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DATE, 1);
		this.nome = nome;
		this.cognome = cognome;
		this.codice = codice;
		if(calendario.before(c2)) {
			throw new AgeEception();
		}else {
			this.calendario=calendario;
		}
	}

	public String nome,cognome,codice,nascita;
	public GregorianCalendar calendario,c2;
}
