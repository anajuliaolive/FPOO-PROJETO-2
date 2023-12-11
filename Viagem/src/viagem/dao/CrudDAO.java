package viagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import viagem.controller.site;
import viagem.model.localidades;

public class CrudDAO {
	//crud C-create R-read U-update D-delete
	//creat(inserir dados)
	public void create(localidades localidades) {
		String sql = "INSERT INTO localidades(Brasil,Italia,DiadeEntrada,DiadeSaida) VALUE (?,?,?,?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = site.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, localidades.getBrasil());
			p.setString(2, localidades.getItália());
			p.setString(2, localidades.getDiaEntrada());
			p.setString(2, localidades.getDiaSaida());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}//fim CREATE
	//************************************************
	//metodo U-update
	public void update(localidades localidades) {
		String sql = "UPDATE alunos SET Brasil = ?, italia = ? WHERE Brasil = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = site.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, localidades.getBrasil());
			p.setString(2, localidades.getItália());
			p.setString(3,localidades.getDiaEntrada());
			p.setString(4, localidades.getDiaSaida());
			p.execute();//"grava" dados no banco
			JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso");
			System.out.println("Dados atualizados com sucesso");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}//fim Update
	//************************************************
	//metodo R-read
	public List<localidades> read() {
		String sql = "SELECT * FROM localidades";
		List<localidades> localidades = new ArrayList<localidades>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = site.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			resultado = p.executeQuery();
			while(resultado.next()) {
				localidades var_local = new localidades();
				//recuperar local Brasil
				var_local.setBrasil(resultado.getString("Brasil"));
				//recuperar local Italia
				var_local.setItália(resultado.getString("itália"));
				//recuperar dia de entrada
				var_local.setDiaEntrada(resultado.getString("entrada"));
				//recuperar dia de saida
				var_local.setDiaSaida(resultado.getString("saida"));
				localidades.add(var_local);
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
			}finally {
				try {
					if(p != null);
					p.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		return localidades;
			
	}//fim Read
	//************************************************
	//metodo D-delete
	public boolean delete(String localidades) {
		String sql = "DELETE FROM viagens WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = site.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setString(1, localidades);
			p.setString(2, localidades);
			p.execute();
			JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso");
			System.out.println("Dados atualizados com sucesso");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nErro: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}//fim Delete 
}//fim classe CrudDAO