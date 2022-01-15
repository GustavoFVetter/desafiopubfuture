import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoDados {

	/**
	 * Método para criar um banco de dados e sua conexão com o programa.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/desafio_publica?verifyServerCertificate=false&useSSL=true";
		String usuario = "root";
		String senha = "12345678";

		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE desafio-publica");

		conexao.close();
	}

}
