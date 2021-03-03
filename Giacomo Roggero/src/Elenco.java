import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Elenco extends ArrayList<Persona>{

	public Elenco() {
		
	}
	
	public void salvacsv(Finestra f) {
		JFileChooser chooser=new JFileChooser();//no filtri
		int n=chooser.showSaveDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw=new FileWriter(chooser.getSelectedFile());
				for(int i=0;i<this.size();i++) {
					if(this.get(i) instanceof Docente) {
						fw.write("Docente "+this.get(i).nome+this.get(i).cognome);
						fw.write(Integer.parseInt(this.get(i).codice));
						fw.write(this.get(i).calendario.DATE);
						//fw.write(this.get(i).calendario.MONTH,this.get(i).calendario.YEAR);
					}
					if(this.get(i) instanceof Impiegato) {
						fw.write("Impiegato "+this.get(i).nome+this.get(i).cognome);
						fw.write(Integer.parseInt(this.get(i).codice));
						fw.write(this.get(i).calendario.DATE);
						fw.write(String.valueOf(this.get(i).calendario.MONTH));
					}
					if(this.get(i) instanceof Studente) {
						fw.write("Studente "+this.get(i).nome+this.get(i).cognome);
						fw.write(Integer.parseInt(this.get(i).codice));
						fw.write(this.get(i).calendario.DATE);
						//fw.write(this.get(i).calendario.MONTH,this.get(i).calendario.YEAR);
					}
					fw.flush();
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deserializza(Finestra f) {
		JFileChooser chooser=new JFileChooser();//no filtri
		int n=chooser.showSaveDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream obs=new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
				Elenco elenchino=(Elenco)obs.readObject();
				for(int i=0;i<elenchino.size();i++) {
					this.add(elenchino.get(i));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
