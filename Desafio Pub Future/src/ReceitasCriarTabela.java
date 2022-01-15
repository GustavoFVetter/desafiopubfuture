import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReceitasCriarTabela {

	/**
	 * Método para criar uma tabela de receitas no banco de dados, a partir de
	 * informações que foram determinadas no projeto. Ao final, se bem sucedida,
	 * envia uma mensagem ao usuário.
	 * 
	 * @param args cria a tabela receitas no banco de dados.
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = FazerConexao.getConexao();

		String TabelaReceitas = "CREATE TABLE IF NOT EXISTS receitas (" 
				+ "seq INT AUTO_INCREMENT PRIMARY KEY,"
				+ "descricaoReceita VARCHAR(100) NOT NULL," 
				+ "valorDaReceita DOUBLE NOT NULL,"
				+ "dataRecebimento DATE(6) NOT NULL," 
				+ "dataRecebimentoPrevisto DATE(6) NOT NULL,"
				+ "conta VARCHAR(50) NOT NULL" 
				+ "tipoReceita VARCHAR(50) NOT NULL" + ")";

		Statement stmt = conexao.createStatement();

		stmt.execute(TabelaReceitas);

		System.out.println("Tabela " + TabelaReceitas + "criada com sucesso!");

		conexao.close();

	}

}
