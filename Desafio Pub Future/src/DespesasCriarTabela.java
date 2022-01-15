import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DespesasCriarTabela {

	/**
	 * Método para criar uma tabela de despesas no banco de dados, a partir de
	 * informações que foram determinadas no projeto. Ao final, se bem sucedida,
	 * envia uma mensagem ao usuário.
	 * 
	 * @param args cria a tabela despesas no banco de dados.
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = FazerConexao.getConexao();

		String TabelaDespesas = "CREATE TABLE IF NOT EXISTS despesas (" 
				+ "seq INT AUTO_INCREMENT PRIMARY KEY,"
				+ "tipoDespesa VARCHAR(100) NOT NULL" 
				+ "valorDaDespesa DOUBLE NOT NULL,"
				+ "dataPagto DATE(6) NOT NULL," 
				+ "dataPagtoPrevisto DATE(6) NOT NULL," 
				+ "conta VARCHAR(50) NOT NULL"
				+ ")";

		Statement stmt = conexao.createStatement();

		stmt.execute(TabelaDespesas);

		System.out.println("Tabela " + TabelaDespesas + "criada com sucesso!");

		conexao.close();

	}

}
