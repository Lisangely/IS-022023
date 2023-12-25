import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import javax.swing.*;
import java.awt.event.*;

	class Data{
    String desc;
    int ct;
    double mu;
    int dd;
    int mm;
    int aaaa;
    String nf;
    String ci;
	boolean visited= true;

    public Data(String desc, int ct,double mu, int dates, String nf,String ci){
		this.desc = desc;
        this.ct=ct;
        int dia = dates % 100;          
        int mes = (dates / 100) % 100;  
        int anio = dates / 10000;
		if(dia>=1 && dia<=31){
        this.dd=dia;
        }
        if(mes>=1 && mes<=31){
        this.mm=mes;
        }
        if(anio>=1968){
        this.aaaa=anio;
        }
        this.nf = nf;
        this.ci=ci;
	}
    int getCt(){
        return ct;
    }
    double getMu(){
        return mu;
    }
    String getCi(){
        return ci;
    }
	boolean getVisited(){
		return visited;
	}
	void visit(boolean visited){
		this.visited=visited;
	}
}
class Frame1 extends JFrame implements ActionListener {
	String[] desc=new String[100], nf=new String[100], ci=new String[100], fecha=new String[100];
    String[] ct=new String[100], dd=new String[100], mm=new String[100], aaaa=new String[100];
    String[] mu=new String[100];
	int[] visit =  new int[100];
	public JLabel type;
	public JLabel totality;
	public JLabel totality1;
	public JLabel totality2;
	public JLabel teacher;
	public JTextField teacherText;
	public JRadioButton election1;
	public JRadioButton election2;
	public JButton total;
	public JButton continu;
	public ButtonGroup group;
	public JScrollPane panel;
	public JTextArea report2;
	public JPanel organization;
	int cont;

	public Frame1(int cont, String[] desc, String[] nf, String[] ci, String[] fecha,String[] ct, String[] dd, String[] mm, String[] aaaa, String[] mu){
		super("Reporte del Inventario del Centro de Investigacion");
		setLayout(null);
        for(int i=0; i<100;i++){
			visit[i]=0;
		}
		this.desc = desc;
        this.nf = nf;
        this.ci = ci;
        this.fecha = fecha;
        this.ct = ct;
        this.dd = dd;
        this.mm = mm;
        this.aaaa = aaaa;
        this.mu = mu;
		this.cont=cont;

		report2 = new JTextArea("C.I. Responsable	 Cantidad equipos	Monto total(Bs.)");
		panel = new JScrollPane(report2);
		panel.setBounds(10, 50, 100, 180);

		type = new JLabel("Tipo reporte:");
		type.setBounds(15, -230, 200, 500);
		teacher = new JLabel("C.I. del Responsable de equipos:");
		teacher.setBounds(10, -190, 300, 500);
		totality = new JLabel("Totalizacion:");
		totality1 = new JLabel("___ equipos");
		totality2 = new JLabel("_______ Bs.");
		totality.setBounds(40, -100, 200, 500);
		totality1.setBounds(40, -80, 200, 500);
		totality2.setBounds(40, -60, 200, 500);

		add(type);
		add(teacher);
		add(totality);
		add(totality1);
		add(totality2);
	
		teacherText = new JTextField();
		teacherText.setBounds(220, 50, 100, 20);

		add(teacherText);

		total = new JButton("Totalizar");
		total.setBounds(340, 50, 120, 20);
		total.addActionListener(this);
		continu = new JButton("Continuar");
		continu.setBounds(300, 250, 100, 20);
		continu.addActionListener(this);

		add(continu);
		add(total);

		election1 = new JRadioButton();
		election2 = new JRadioButton(); 
		election1.setText("Individual");
		election2.setText("General");
		election1.setBounds(100, -5, 100, 50);
		election2.setBounds(230, -5, 100, 50);
		election2.addActionListener(this);

		add(election1);
		add(election2);

		election1.setSelected(true);

		group = new ButtonGroup();
        group.add(election1);
        group.add(election2);
			
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==total && election1.isSelected()){
			String ci1 = teacherText.getText();
			System.out.println(ci1);
			double summary=0;
        	int totality=0;
            for(int i=0 ; i<=cont ; i++){
				System.out.println("//"+cont);
                if(ci1.equals(ci[i])){
					System.out.println("==");
			        totality += Integer.parseInt(ct[i]);
					summary += Double.parseDouble(mu[i])*(Integer.parseInt(ct[i]));
                }
            }
			totality1.setText(totality+" equipos");
			totality2.setText(summary+" Bs.");
		}
		if(election2.isSelected()){
			remove(total);
			remove(teacherText);
			remove(teacher);
			add(report2);
			add(panel);
	}
		if(e.getSource()==continu &&election2.isSelected()){
			double summary=0;
        	int totality=0;
            for(int i=0 ; i<=cont ; i++){
				if(visit[i]!=-1){
					String ci2 = ci[i];
					visit[i]=-1;
					totality += Integer.parseInt(ct[i]);
					summary += Double.parseDouble(mu[i])*totality;
					for(int j=0 ; j<=cont ; j++){
            		    if(ci2.equals(ci[j])&& (visit[j]!=-1)){
			 		        totality += Integer.parseInt(ct[j]);
							summary += Double.parseDouble(mu[j])*totality;
							visit[j]=-1;
           	    		}
          		  	}
				report2.append(ci2+" 	"+totality+"	"+summary);	
           		}
			}	
		}
	}
}

 class Frame extends JFrame implements ActionListener {
	static String[] desc=new String[100], nf=new String[100], ci=new String[100], fecha=new String[100];
    static String[] ct=new String[100], dd=new String[100], mm=new String[100], aaaa=new String[100];
    static String[] mu=new String[100];
	public JLabel data;
	public JLabel description;
	public JLabel amount;
	public JLabel cost;
	public JLabel date;
	public JLabel dateSub;
	public JLabel nomber;
	public JLabel teacher;
	public JButton exit;
	public JButton register;
	public JButton report;
	public JTextField descriptionText;
	public JTextField amountText;
	public JTextField costText;
	public JTextField dateText;
	public JTextField nomberText;
	public JTextField teacherText;
	int cont=0;

	public Frame() {
		super("Registro y Control de Equipos en Centro de Investigacion");
		setLayout(null);

		data = new JLabel("Ingrese data del equipo:");
		data.setBounds(10, -230, 200, 500);
		description = new JLabel("Descripcion:");
		description.setBounds(20, -200, 150, 500);
		amount = new JLabel("Cantidad:");
		amount.setBounds(40, -160, 150, 500);
		cost = new JLabel("Costo Unitario(Bs.):");
		cost.setBounds(200, -160, 150, 500);
		date = new JLabel("Fecha de adquisicion:");
		dateSub = new JLabel("dd/mm/aaaa");
		date.setBounds(20, -130, 150, 500);
		dateSub.setBounds(35, -120, 150, 500);
		nomber = new JLabel("Nro. de factura:");
		nomber.setBounds(250, -130, 150, 500);
		teacher = new JLabel("C.I. del Responsable del equipo:");
		teacher.setBounds(10, -80, 200, 500);
		
		add(teacher);
		add(nomber);
		add(dateSub);
		add(date);
		add(cost);
		add(data);
		add(description);
		add(amount);

		exit = new JButton("Salir");
		exit.setBounds(380, 250, 75, 20);
		add(exit);
		exit.addActionListener(this);
		register = new JButton("Registrar data");
		register.setBounds(100, 250, 120, 20);
		add(register);
		register.addActionListener(this);
		report = new JButton("Generar Reporte");
		report.setBounds(230, 250, 140, 20);
		add(report);
		report.addActionListener(this);

		descriptionText = new JTextField();
		descriptionText.setBounds(100, 40, 350, 20);
		amountText = new JTextField();
		amountText.setBounds(100, 80, 30, 20);
		costText = new JTextField();
		costText.setBounds(320, 80, 130, 20);
		dateText = new JTextField();
		dateText.setBounds(150, 115, 90, 20);
		nomberText = new JTextField();
		nomberText.setBounds(345, 115, 105, 20);
		teacherText = new JTextField();
		teacherText.setBounds(200, 165, 105, 20);

		add(teacherText);
		add(nomberText);
		add(dateText);
		add(costText);
		add(descriptionText);
		add(amountText);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==exit){
			System.exit(0);
		}
		if(e.getSource()==register){
			desc[cont] = descriptionText.getText();
			ct[cont] = amountText.getText();
			fecha[cont] = dateText.getText();
			dd[cont]=fecha[cont].substring(0, 2);
    	    mm[cont]=fecha[cont].substring(3, 5);
       		aaaa[cont]=fecha[cont].substring(6, 10);
			mu[cont] = costText.getText();
			nf[cont] = nomberText.getText();
			ci[cont] = teacherText.getText();
			cont++;
		}
		if(e.getSource()==report){
		Frame1 frameReport = new Frame1(cont, desc, nf, ci, fecha, ct,  dd,  mm,  aaaa,  mu);
		frameReport.setBounds(0, 0, 500, 350);
		frameReport.setResizable(false);
		frameReport.setLocationRelativeTo(null);
		frameReport.setVisible(true);
		}
	}
 }

 class Pantallas {
    public static void main(String[] args) {
		//Data datas[] = new Data[100];
		Frame frameData = new Frame();
		frameData.setBounds(0, 0, 500, 350);
		frameData.setResizable(false);
		frameData.setLocationRelativeTo(null);
		frameData.setVisible(true);
       
	}

}

