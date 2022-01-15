import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FazerConexao {

	/**
	 * M�todo usado para criar uma conex�o com o bandco de dados.
	 * 
	 * @return DriverManager far� esta conex�o com o banco de dados.
	 */
	public static Connection getConexao() {
		try {
			String url = "jdbc:mysql://localhost/desafio_publica?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "17031967";

			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
