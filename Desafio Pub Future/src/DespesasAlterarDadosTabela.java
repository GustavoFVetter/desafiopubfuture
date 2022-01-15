import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DespesasAlterarDadosTabela {

	/**
	 * Método para alterar dados da tabela despesas, onde o usuário informa qual
	 * item da tabela quer alterar e a partir desta seq (seq é o nome da coluna que
	 * serve de chave para a linha) informa os novos valores dos devidos campos.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		System.out.println("Informe a seq da despesa a ser alterada: ");
		int seq = leia.nextInt();

		String selectSQL = "select seq from despesas where seq = ?";
		String updateSQL = "update despesas " + "set tipoDespesa, " + "set valorDespesa, " + "set dataPagto, "
				+ "set dataPagtoPrevisto, " + "set conta, " + "where seq = ?";

		Connection conexao = FazerConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, seq);
		ResultSet listSeq = stmt.executeQuery();

		if (listSeq.next()) {
			Despesas desp = new Despesas();
			System.out.println(" "); // linha por causa no nextInt da linha 21
			System.out.println("Informações atuais desta despesa: " + "Seq " + desp.getSeq() + "Tipo da despesa "
					+ desp.getTipoDespesa() + "Valor da despesa R$ " + desp.getValorDaDespesa() + "Data do Pagamento "
					+ desp.getDataPagto() + "Data Prevista do Pagamento " + desp.getDataPagtoPrevisto() + "Conta "
					+ desp.getConta());

			System.out.println("Informe os novos parâmetros para:");
			System.out.println("Tipo da despesa:");
			System.out.println("Ex: alimentação, combustível, educação, roupas, etc... ");
			String tipoDespesa = leia.next();
			System.out.println("Valor da despesa:");
			Double valorDespesa = leia.nextDouble();
			System.out.println("Data da despesa:");
			int dataPagto = leia.nextInt();
			System.out.println("Data de pagamento previsto para a despesa:");
			int dataPagtoPrevisto = leia.nextInt();
			System.out.println("Conta:");
			String Conta = leia.next();

			stmt.close();

			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, tipoDespesa);
			stmt.setDouble(2, valorDespesa);
			stmt.setInt(3, dataPagto);
			stmt.setInt(4, dataPagtoPrevisto);
			stmt.setString(5, Conta);
			stmt.execute();

			System.out.println("Dados da despesa alterados com sucesso.");
		} else {
			System.out.println("Não foi possível fazer as alterações.");
			System.out.println("Verifique se informou a seq correta.");
		}
		leia.close();
		conexao.close();
		stmt.close();
	}
}
