import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarTotalReceitas {

	/**
	 * Método para listar o valor total das receitas da tabela Receitas.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = FazerConexao.getConexao();

		String sql = "select sum(valorDaReceita) as 'totReceitas' from receitas where valorDaReceita > 0";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, 0);

		ResultSet totReceitas = stmt.executeQuery();

		System.out.println("O valor total das receitas é R$ " + totReceitas);

		conexao.close();
		stmt.close();
	}

}
