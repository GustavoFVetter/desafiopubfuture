import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DespesasConsultarDadosTabelaPorData {

	/**
	 * Método para listar as despesas, onde o usuário determina os parâmetros de
	 * data inicial e data final para criar a lista de despesas.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		Connection conexao = FazerConexao.getConexao();

		String sql = "select * from despesas where dataRecebimento like ?";

		System.out.println("Informe a data inicial da consulta (formato DDMMA): ");
		String dataInicial = leia.next();
		System.out.println("Informe a data final da consulta (formato DDMMA): ");
		String dataFinal = leia.next();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, dataInicial);
		stmt.setString(2, dataFinal);
		ResultSet listaConsulta = stmt.executeQuery();

		List<Despesas> listaDespesas = new ArrayList<>();

		while (listaConsulta.next()) {
			int seq = listaConsulta.getInt("Seq");
			String tipoDespesa = listaConsulta.getString("Tipo da despesa");
			double valorDespesa = listaConsulta.getDouble("Valor da despesa");
			int dataPagto = listaConsulta.getInt("Data do Pagamento");
			int dataPagtoPrevisto = listaConsulta.getInt("Data Prevista do Pagamento");
			String conta = listaConsulta.getString("Conta");

			listaDespesas.add(new Despesas(seq, tipoDespesa, valorDespesa, dataPagto, dataPagtoPrevisto, conta));
		}

		for (Despesas desp : listaDespesas) {
			System.out.println("Seq " + desp.getSeq() + "Tipo de Despesa " + desp.getTipoDespesa()
					+ "Valor da despesa R$ " + desp.getValorDaDespesa() + "Data do Pagamento " + desp.getDataPagto()
					+ "Data Prevista do Pagamento " + desp.getDataPagtoPrevisto() + "Conta " + desp.getConta());
		}

		leia.close();
		conexao.close();
		stmt.close();
	}

}
