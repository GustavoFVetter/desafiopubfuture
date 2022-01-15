import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DespesasExcluirDadosTabela {

	/**
	 * Método para excluir uma linha de despesas da tabela despesas, onde o usuário
	 * informa qual item da tabela quer excluir e a partir desta seq (seq é o nome
	 * da coluna que serve de chave primária para a linha) a exclusão é efetuada.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		System.out.println("Informe o nr da seq a excluir: ");
		int seq = leia.nextInt();

		Connection conexao = FazerConexao.getConexao();

		String SQL = "delete for despesas where seq = ?";

		PreparedStatement stmt = conexao.prepareStatement(SQL);
		stmt.setInt(1, seq);

		if (stmt.executeUpdate() > 0) {
			System.out.println("Exclusão efetuada!");
		} else {
			System.out.println("Não foi possível efetuar a exclusão.");
			System.out.println("Por favor, reveja seus dados e tente novamente.");
		}

		leia.close();
		conexao.close();

	}

}
