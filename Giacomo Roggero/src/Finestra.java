import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Finestra extends JFrame implements ActionListener{
	
	public JMenuBar barra;
	public JMenu menu,visualizza,aggiungi;
	public JMenuItem salva,importa,visualizzaS,visualizzaD,visualizzaI,aggiungiD,aggiungiS,aggiungiI;
	public DefaultTableModel dtm;
	public JTable table;
	public JScrollPane jsp;
	public Elenco elenco;
	public DialogoStudente ds;
	public DialogoDocente dd;
	public DialogoImpiegato di;
	

	public Finestra() {
		initC();
	}

	public void initC() {
		Object[][] data = {};
		String[] columnNames = {"Nome","Cognome","Codice Fiscale"};
		barra=new JMenuBar();
		dtm=new DefaultTableModel(data, columnNames);
		table=new JTable(dtm);
		jsp=new JScrollPane(table);
		this.setLayout(new FlowLayout());//non mi servono particolari layout
		visualizza=new JMenu("Visualizza");
		visualizzaS=new JMenuItem("Visualizza Studenti");
		visualizzaS.addActionListener(this);
		visualizzaD=new JMenuItem("Visualizza Docenti");
		visualizzaD.addActionListener(this);
		visualizzaI=new JMenuItem("Visualizza Impiegati");
		visualizzaI.addActionListener(this);
		visualizza.add(visualizzaS);
		visualizza.add(visualizzaD);
		visualizza.add(visualizzaI);
		menu=new JMenu("Gestione");
		salva=new JMenuItem("Salva");
		salva.addActionListener(this);
		importa=new JMenuItem("Importa");
		importa.addActionListener(this);
		menu.add(salva);
		menu.add(importa);
		aggiungi=new JMenu("Aggiungi");
		aggiungiS=new JMenuItem("Aggiungi Studente");
		aggiungiS.addActionListener(this);
		aggiungiD=new JMenuItem("Aggingi Docente");
		aggiungiD.addActionListener(this);
		aggiungiI=new JMenuItem("Aggiungi Impiegato");
		aggiungiI.addActionListener(this);
		aggiungi.add(aggiungiS);
		aggiungi.add(aggiungiD);
		aggiungi.add(aggiungiI);
		barra.add(menu);
		barra.add(aggiungi);
		barra.add(visualizza);
		this.setJMenuBar(barra);
		this.add(jsp);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(salva)) {
			elenco.salvacsv(this);
		}
		if(e.getSource().equals(importa)) {
			elenco.deserializza(this);
		}
		if(e.getSource().equals(aggiungiS)) {
			ds=new DialogoStudente(this,true);
			elenco.add(ds.ritornaStudente());
		}
		if(e.getSource().equals(aggiungiD)) {
			dd=new DialogoDocente(this,true);
			elenco.add(dd.ritornaDocente());
		}
		if(e.getSource().equals(aggiungiI)) {
			di=new DialogoImpiegato(this,true);
			elenco.add(di.ritornaImpiegato());
		}
		if(e.getSource().equals(visualizzaD)) {
			for(int i=0; i<elenco.size();i++) {
				if(elenco.get(i) instanceof Docente) {
					Object[] insertRowData = {elenco.get(i).nome,elenco.get(i).nome,elenco.get(i).cognome,elenco.get(i).codice};//ho messo solo questi 3 per fare in fretta
					dtm.addRow(insertRowData);
				}
			}
		}
		
		if(e.getSource().equals(visualizzaS)) {
			for(int i=0; i<elenco.size();i++) {
				if(elenco.get(i) instanceof Studente) {
					Object[] insertRowData = {elenco.get(i).nome,elenco.get(i).nome,elenco.get(i).cognome,elenco.get(i).codice};//ho messo solo questi 3 per fare in fretta
					dtm.addRow(insertRowData);
				}
			}
		}
		if(e.getSource().equals(visualizzaI)) {
			for(int i=0; i<elenco.size();i++) {
				if(elenco.get(i) instanceof Impiegato) {
					Object[] insertRowData = {elenco.get(i).nome,elenco.get(i).nome,elenco.get(i).cognome,elenco.get(i).codice};//ho messo solo questi 3 per fare in fretta
					dtm.addRow(insertRowData);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Finestra f=new Finestra();
		f.setSize(800,800);
		f.setVisible(true);
	}

}
