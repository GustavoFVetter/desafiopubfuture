import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesasConsultarDadosTabelaPorTipo {

	/**
	 * Método para listar as despesas, por tipo de despesa.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection conexao = FazerConexao.getConexao();

		String sql = "select * from despesas as 'despesas por tipo' where tipoDespesa";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		String tipoDesp = null;
		stmt.setString(1, tipoDesp);
		ResultSet listaConsulta = stmt.executeQuery();

		List<Despesas> listaDespesas = new ArrayList<>();

		while (listaConsulta.next()) {
			int seq = listaConsulta.getInt("Seq");
			String tipoDespesa = listaConsulta.getString("Tipo de despesa");
			double valorDespesa = listaConsulta.getDouble("Valor da despesa");
			int dataPagto = listaConsulta.getInt("Data do Pagamento");
			int dataPagtoPrevisto = listaConsulta.getInt("Data Prevista do Pagamento");
			String conta = listaConsulta.getString("Conta");
			listaDespesas.add(new Despesas(seq, tipoDespesa, valorDespesa, dataPagto, dataPagtoPrevisto, conta));
		}

		for (Despesas despesa : listaDespesas) {
			System.out.println("Seq " + despesa.getSeq() + "Tipo de Despesa " + despesa.getTipoDespesa()
					+ "Valor da Despesa R$ " + despesa.getValorDaDespesa() + "Data do Pagamento "
					+ despesa.getDataPagto() + "Data Prevista do Pagamento " + despesa.getDataPagtoPrevisto() + "Conta "
					+ despesa.getConta());
		}

		conexao.close();
		stmt.close();

	}

}
