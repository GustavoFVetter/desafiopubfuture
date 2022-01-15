import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReceitasAlterarDadosTabela {

	/**
	 * Método para alterar dados da tabela receitas, onde o usuário informa qual
	 * item da tabela quer alterar e a partir desta seq (seq é o nome da coluna que
	 * serve de chave primária para a linha) informa os novos valores dos devidos
	 * campos.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		System.out.println("Informe a seq da receita a ser alterada: ");
		int seq = leia.nextInt();

		String selectSQL = "select seq from receitas where seq = ?";
		String updateSQL = "update receitas " + "set descricaoReceita, " + "set valorDaReceita, "
				+ "set dataRecebimento, " + "set dataRecebimentoPrevisto, " + "set conta, " + "set tipoReceita,"
				+ "where seq = ?";

		Connection conexao = FazerConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, seq);
		ResultSet listSeq = stmt.executeQuery();

		if (listSeq.next()) {
			Receitas rec = new Receitas();
			System.out.println(" "); // linha por causa no nextInt da linha 16
			System.out.println("Informações atuais desta receita: Seq " + rec.getSeq() + "Descrição da Receita "
					+ rec.getDescricaoReceita() + "Valor da receita R$ " + rec.getValorDaReceita()
					+ "Data do Recebimento " + rec.getDataRecebimento() + "Data Prevista do Recebimento "
					+ rec.getDataRecebimentoPrevisto() + "Conta " + rec.getConta() + "Tipo de Receita "
					+ rec.getTipoReceita());

			System.out.println("Informe os novos parâmetros para:");
			System.out.println("Descrição da receita:");
			String descricaoReceita = leia.next();
			System.out.println("Valor da receita:");
			Double valorDaReceita = leia.nextDouble();
			System.out.println("Data da receita:");
			int dataRecebimento = leia.nextInt();
			System.out.println("Data da prevista para a receita:");
			int dataRecebimentoPrevisto = leia.nextInt();
			System.out.println("Conta:");
			String Conta = leia.next();
			System.out.println("Tipo de Receita:");
			String tipoReceita = leia.next();

			stmt.close();

			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, descricaoReceita);
			stmt.setDouble(2, valorDaReceita);
			stmt.setInt(3, dataRecebimento);
			stmt.setInt(4, dataRecebimentoPrevisto);
			stmt.setString(5, Conta);
			stmt.setString(6, tipoReceita);
			stmt.execute();

			System.out.println("Dados da receita alterados com sucesso.");
		} else {
			System.out.println("Não foi possível fazer as alterações.");
			System.out.println("Verifique se informou a seq correta.");
		}

		leia.close();
		conexao.close();
		stmt.close();
	}

}
