import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DespesasInserirDadosTabela {

	/**
	 * Método para o usuário inserir as despesas no banco de dados, a partir de
	 * informações que serão atribuidas nas variáveis e inseridas na tabela DESPESAS
	 * do banco de dados. Insere informações de despesas no banco de dados, a partir
	 * de informações do usuário. Ao final, caso tudo ocorra perfeitamente, exibirá
	 * uma mensagem ao usuário dizendo que as informações foram incluídas no
	 * sistema.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		System.out.println("Informe o tipo desta despesa: ");
		System.out.println("Ex: alimentação, combustível, educação, roupas, etc... ");
		String tipoDespesa = leia.nextLine();
		System.out.println("Informe o valor desta despesa: ");
		Double valorDaDespesa = leia.nextDouble();
		System.out.println("Informe a data do pagamento desta despesa "
				+ "(formato DDMMAA): ");
		int dataPagto = leia.nextInt();
		System.out.println("Informe a data do pagamento previsto desta despesa "
				+ "(formato DDMMAA): ");
		int dataPagtoPrevisto = leia.nextInt();
		System.out.println("Informe a conta desta despesa: ");
		String conta = leia.nextLine();

		Connection conexao = FazerConexao.getConexao();

		String inserirDespesas = "INSERT INTO despesas (tipoDespesa, "
				+ "valorDaDespesa, dataPagto, dataPagtoPrevisto, " 
				+ "conta) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(inserirDespesas);
		stmt.setString(1, tipoDespesa);
		stmt.setDouble(2, valorDaDespesa);
		stmt.setInt(3, dataPagto);
		stmt.setInt(4, dataPagtoPrevisto);
		stmt.setString(5, conta);

		stmt.execute();

		System.out.println("Registro de despesa incluído com sucesso!");

		leia.close();
		conexao.close();
	}
}
