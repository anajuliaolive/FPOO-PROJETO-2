package viagem.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class site {
	//conectando com o BD
		private static final String USERNAME = "root";
		private static final String PASSWORD = "";
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/viagem";
		public static Connection criandoConexao() throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return conexao;
		}
		public static void main(String[] arg) throws Exception {
			Connection con = criandoConexao();
			if(con != null) {
				System.out.println("Conectado");
			}
			con.close();
		}

}
