package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redController = new RedesController();
				
		String process = "";
		int opc = 0;

		while(opc != 3) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- M�todo IP \n2- M�todo Ping \n3- Encerrar"));
		switch(opc) {
		case 1: redController.ip(process);
		break;
		case 2: redController.ping(process);
		break;
		case 3: JOptionPane.showMessageDialog(null, "Finalizado");
		break;
		default: JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
		break;
		    }
		}
	}

}
