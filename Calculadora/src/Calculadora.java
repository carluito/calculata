import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener{
	
	JFrame marco;
	
	JTextField texto;
	
	JButton[] botonesnum= new JButton[10];
	
	JButton[] botonesfun= new JButton[8];
	
	JButton addButton,subButton,mulButton,divButton;
	
	JButton decButton, equButton, delButton, clrButton;
	
	JPanel panel;
	
	Font fuente= new Font("Ink Free", Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	
	char operator;
	
	
	Calculadora(){
		 marco = new JFrame("Calculadora");
		 marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 marco.setSize(420,550);
		 marco.setLayout(null);
		 
		 texto=new JTextField();
		 texto.setBounds(50, 25, 300, 50);
		 texto.setFont(fuente);
		 texto.setEditable(false);
		 
		 addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		 divButton = new JButton("/");
		 decButton = new JButton(".");
		equButton = new JButton("=");
		 delButton = new JButton("Borrar");
		 clrButton = new JButton("Limpiar");
		 
		 botonesfun[0]=addButton;
		 botonesfun[1]=subButton;
		 botonesfun[2]=mulButton;
		 botonesfun[3]=divButton;
		 botonesfun[4]=decButton;
		 botonesfun[5]=equButton;
		 botonesfun[6]=delButton;
		 botonesfun[7]=clrButton;
		 
		 
		 
		 for(int x=0;x<botonesfun.length;x++) {
			 
			botonesfun[x].addActionListener(this);
			botonesfun[x].setFont(fuente);
			botonesfun[x].setFocusable(false);
				 
		 }
		 
	
		 
		 for(int x=0;x<botonesnum.length;x++) {
			 
			
			botonesnum[x]= new JButton(String.valueOf(x));
			 
			botonesnum[x].addActionListener(this);
			botonesnum[x].setFont(fuente);
			botonesnum[x].setFocusable(false);
		 }
		 
		 delButton.setBounds(50,430,145,50);
		 clrButton.setBounds(205,430,145,50);
		 
		 panel = new JPanel();
		 panel.setBounds(50, 100, 300, 300);
		 panel.setLayout(new GridLayout(4,4,10,10));
		 //panel.setBackground(Color.GRAY);
		 
		
		 panel.add(botonesnum[1]);
		 panel.add(botonesnum[2]);
		 panel.add(botonesnum[3]);
		 panel.add(addButton);
		 
		 panel.add(botonesnum[4]);
		 panel.add(botonesnum[5]);
		 panel.add(botonesnum[6]);

		 panel.add(subButton);
		 panel.add(botonesnum[7]);
		 panel.add(botonesnum[8]);
		 panel.add(botonesnum[9]);
		 panel.add(mulButton);
		 panel.add(decButton);
		 panel.add(botonesnum[0]);
		 panel.add(equButton);
		 panel.add(divButton);
		 
		 
		 marco.add(panel);
		 marco.add(delButton);
		 marco.add(clrButton);
		 marco.add(texto);
		 marco.setVisible(true);
		 
		 
			 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculadora calcu =new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int x=0;x<botonesnum.length;x++) {
			
			if(e.getSource()==botonesnum[x]) {
				
				texto.setText(texto.getText().concat(String.valueOf(x)));  // La magia
				
			}
				 
		 }	
		
		if(e.getSource()== decButton) {
				texto.setText(texto.getText().concat("."));
			}
		
		if(e.getSource()== addButton) {
			num1 = Double.parseDouble(texto.getText());
			operator='+';
			texto.setText("");
			
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(texto.getText());
			operator='-';
			texto.setText("");	
			
		}
		
		if(e.getSource()== mulButton) {
			num1 = Double.parseDouble(texto.getText());
			operator='*';
			texto.setText("");
						
		}
		
		if(e.getSource()== divButton) {
			num1 = Double.parseDouble(texto.getText());
			operator='/';
			texto.setText("");
			
		}
		
		if(e.getSource()== equButton) {
			num2= Double.parseDouble(texto.getText());
			

			switch(operator) {
			
			case '+':
				result=num1+num2;
				break;
				
			case '-':
				result=num1-num2;
				break;
				
			case '*':
				result=num1*num2;
				break;
				
			case '/':
				result=num1/num2;
				break;
				
			}
			
			texto.setText(String.valueOf(result));
			num1=result;
			
		}
		
		if(e.getSource()== delButton) {					//mucha más magia
			String string=texto.getText();
			texto.setText("");
			for(int i = 0;i<string.length()-1;i++) {
				
				//texto.setText(string.charAt(i));

				texto.setText(texto.getText()+string.charAt(i)); //origi
				
			}
				
		}
		
		if(e.getSource()== clrButton) {
			texto.setText("");
		}
	}

}
