import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoDocente extends JDialog implements ActionListener{

	public JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	public JButton chiudi,salva;
	public Docente s;
	public GregorianCalendar c;
	
	public DialogoDocente(Finestra f,boolean modal) {
		super(f,modal);
		initCC();
		this.setSize(500,500);
		this.setVisible(true);
	}



	public void initCC() {
		this.setLayout(new GridLayout(8,2));
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(10);
		t7=new JTextField(10);
		l1=new JLabel("inserire nome");
		l2=new JLabel("inserire cognome");
		l3=new JLabel("inserire codice");
		l4=new JLabel("inserire giorno");
		l5=new JLabel("inserire mese");
		l6=new JLabel("inserire anno");
		l7=new JLabel("inserire concorso");
		chiudi=new JButton("Chiudi");
		salva=new JButton("salva");
		this.add(l1);this.add(t1);
		this.add(l2);this.add(t2);
		this.add(l3);this.add(t3);
		this.add(l4);this.add(t4);
		this.add(l5);this.add(t5);
		this.add(l6);this.add(t6);
		this.add(l7);this.add(t7);
		this.add(chiudi);this.add(salva);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(chiudi)) {
			dispose();
		}
		if(e.getSource().equals(salva)) {
			c.set(Integer.parseInt(t6.getText()),Integer.parseInt(t5.getText()),Integer.parseInt(t4.getText()));
			try {
				s=new Docente(t1.getText(),t2.getText(),t3.getText(),c,t7.getText());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (AgeEception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public Docente ritornaDocente() {
		return s;
	}

}