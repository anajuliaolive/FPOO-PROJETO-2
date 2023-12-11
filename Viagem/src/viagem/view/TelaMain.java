package viagem.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

import viagem.model.localidades;
import viagem.dao.CrudDAO;

public class TelaMain {
	public static void main(String[] args) {
		//instanciar um obj da classe crudDAO
		CrudDAO inserir_local = new CrudDAO();
		
		//instanciar um obj local	
		localidades local1 = new localidades();
		
	
		inserir_local.update(local1);
		System.out.println("Local: " + local1.getBrasil() + "\nEntrada: " + local1.getBrasil() + "\nSaída: " + local1.getBrasil() +
		"Local: " + local1.getItália() + "\nEntrada: " + local1.getItália() + "\nSaída: " + local1.getItália());
		//***********************************************
		
		int opcao;
		String valor;
		Scanner entrada = new Scanner(System.in);
		
		do {
			valor = JOptionPane.showInputDialog("O que deseja realizar?" +
		    "\n 1-Adicionar Local \n 2-Atualizar local \n 3-Visualizar local \n 4-DELETAR");
			opcao = Integer.parseInt(valor);
			switch(opcao) {
			case 1:
				
				String b;
				b = JOptionPane.showInputDialog("Digite o local para criar:");
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/yyyy");
				Date data = null;
				
			    local1.setBrasil(b);
				String entrada1;
		    	entrada1 = JOptionPane.showInputDialog("Digite o dia para entrar:");
		        //int e = Integer.parseInt(entrada1);
				local1.setDiaEntrada(entrada1);
				System.out.println("local adicionado " + b);
				
			
				String i;
				i = JOptionPane.showInputDialog("Digite o local para criar:");
			    local1.setItália(i);
				System.out.println("entrada:");
				String saida1;
		    	saida1 = JOptionPane.showInputDialog("Digite o dia para sair:");
		    	//int s = Integer.parseInt(saida1);
				local1.setDiaEntrada(saida1);
				inserir_local.create(local1);
				System.out.println("local adicionado " + i);
				break;
			
			case 2:
				JOptionPane.showMessageDialog(null, "lendo a lista...");
				for(localidades olho : inserir_local.read()) {
					JOptionPane.showMessageDialog(null, "Dados do aluno: "+ olho.getBrasil()
					+ olho.getItália() + olho.getDiaEntrada() + olho.getDiaSaida());}
				break;
			
			 case 3:
				    String e;
					e = JOptionPane.showInputDialog("");
			    	CrudDAO remover_local = new CrudDAO();
			    	String entr1;
			    	entr1 = JOptionPane.showInputDialog("Digite dia de entrada que voce deseja deletar:");
					local1.setDiaEntrada(entr1);
					remover_local.delete(e);
					
			    	String said1;
			    	said1 = JOptionPane.showInputDialog("Digite dia de entrada que voce deseja deletar:");
			    	//int s1 = Integer.parseInt(said1);
					local1.setDiaEntrada(said1);
					remover_local.delete(said1);
					break;
			 case 4:
			    	CrudDAO remover_local1 = new CrudDAO();
			    	String l1;
			    	l1 = JOptionPane.showInputDialog("Digite o local que voce deseja deletar:");
			    	//String lo1 = Integer.parseInt(l1);
					local1.setBrasil(l1);
					local1.setItália(l1);
					remover_local1.delete(l1);
					break;
			}
			
			System.out.println();
		}while(opcao != 0);
	}//fim main
	public static void exibirMenu() {
		System.out.println("Selecione uma opcao");
		System.out.println("1 - Adicionar local");
		System.out.println("2 - Deletar local");
		System.out.println("3 - Atualizar local");
		System.out.println("0 - SAIR");
	}

}

 
 