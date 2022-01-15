import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReceitasInserirDadosTabela {

	/**
	 * Método para o usuário inserir as receitas no banco de dados, a partir de
	 * informações que serão atribuidas nas variáveis e inseridas na tabela RECEITAS
	 * do banco de dados. Insere informações de receitas no banco de dados, a partir
	 * de informações do usuário. Ao final, caso tudo ocorra perfeitamente, exibirá
	 * uma mensagem ao usuário dizendo que as informações foram incluídas no
	 * sistema.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		System.out.println("Informe a descrição desta receita: ");
		String descricaoReceita = leia.nextLine();
		System.out.println("Informe o valor desta receita: ");
		Double valorDaReceita = leia.nextDouble();
		System.out.println("Informe a data do recebimento desta receita "
				+ "(formato DDMMAA): ");
		int dataDoRecebimento = leia.nextInt();
		System.out.println("Informe a data do recebimento prevista desta receita "
				+ "(formato DDMMAA): ");
		int dataDoRecebimentoPrevisto = leia.nextInt();
		System.out.println("Informe a conta desta receita: ");
		String conta = leia.nextLine();
		System.out.println("Informe o tipo de receita: ");
		System.out.println("Ex: salário, bônus, presente, loterias, etc...");
		String tipoReceita = leia.nextLine();

		Connection conexao = FazerConexao.getConexao();

		String inserirReceitas = "INSERT INTO receitas (descricaoReceita, "
				+ "valorDaReceita, dataDoRecebimento, dataDoRecebimentoPrevisto, " 
				+ "conta, tipoReceita) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(inserirReceitas);
		stmt.setString(1, descricaoReceita);
		stmt.setDouble(2, valorDaReceita);
		stmt.setInt(3, dataDoRecebimento);
		stmt.setInt(4, dataDoRecebimentoPrevisto);
		stmt.setString(5, conta);
		stmt.setString(6, tipoReceita);

		stmt.execute();

		System.out.println("Registro de recebimento incluído com sucesso!");

		leia.close();
		conexao.close();
	}

}
