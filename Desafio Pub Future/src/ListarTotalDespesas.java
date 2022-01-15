import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarTotalDespesas {

	/**
	 * M�todo para listar o valor total das despesas da tabela Despesas.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = FazerConexao.getConexao();

		String sql = "select sum(valorDespesa) as 'totDespesas' from despesas where valorDespesa > 0";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, 0);

		ResultSet totDespesas = stmt.executeQuery();

		System.out.println("O valor total das receitas � R$ " + totDespesas);

		conexao.close();
		stmt.close();
	}

}
