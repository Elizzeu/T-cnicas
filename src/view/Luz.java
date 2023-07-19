package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Luz extends JPanel{
// e tentei fazer pelo arqvou  	
	Color cor;
	
	public void ligaRefletor(ArrayList<String>ligar) {
		int num1=1;
		int num0=0;
		String strNumber = String.valueOf(num1);
		String strgNumber = String.valueOf(num0);
		
		for (String string : ligar) {
			
			if(string.equals(strNumber)) {
				this.setBackground(cor);
				
			}
			if(string.equals(strgNumber)){
				this.setBackground(Color.lightGray);
			}

		}
	
	}
// deveria try	

}
