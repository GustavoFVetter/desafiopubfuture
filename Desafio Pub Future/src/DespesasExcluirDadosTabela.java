import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DespesasExcluirDadosTabela {

	/**
	 * M�todo para excluir uma linha de despesas da tabela despesas, onde o usu�rio
	 * informa qual item da tabela quer excluir e a partir desta seq (seq � o nome
	 * da coluna que serve de chave prim�ria para a linha) a exclus�o � efetuada.
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
			System.out.println("Exclus�o efetuada!");
		} else {
			System.out.println("N�o foi poss�vel efetuar a exclus�o.");
			System.out.println("Por favor, reveja seus dados e tente novamente.");
		}

		leia.close();
		conexao.close();

	}

}
