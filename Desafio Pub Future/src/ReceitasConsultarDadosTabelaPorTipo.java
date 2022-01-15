import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitasConsultarDadosTabelaPorTipo {

	/**
	 * Método para listar as receitas, por tipo de receita.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection conexao = FazerConexao.getConexao();

		String sql = "select * from receitas as 'receitas por tipo' where tipoDeReceita";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		String tipoDeReceita = null;
		stmt.setString(1, tipoDeReceita);
		ResultSet listaConsulta = stmt.executeQuery();

		List<Receitas> listaReceitas = new ArrayList<>();

		while (listaConsulta.next()) {
			int seq = listaConsulta.getInt("Seq");
			String tipoReceita = listaConsulta.getString("Tipo de Receita");
			String descricaoReceita = listaConsulta.getString("Descrição da receita");
			double valorDaReceita = listaConsulta.getDouble("Valor da receita");
			int dataRecebimento = listaConsulta.getInt("Data do Recebimento");
			int dataRecebimentoPrevisto = listaConsulta.getInt("Data Prevista do Recebimento");
			String conta = listaConsulta.getString("Conta");
			listaReceitas.add(new Receitas(seq, tipoReceita, descricaoReceita, valorDaReceita, dataRecebimento,
					dataRecebimentoPrevisto, conta));
		}

		for (Receitas receita : listaReceitas) {
			System.out.println(
					"Seq " + receita.getSeq() + "Tipo de Receita " + receita.getTipoReceita() + "Descrição da Receita "
							+ receita.getDescricaoReceita() + "Valor da receita R$ " + receita.getValorDaReceita()
							+ "Data do Recebimento " + receita.getDataRecebimento() + "Data Prevista do Recebimento "
							+ receita.getDataRecebimentoPrevisto() + "Conta " + receita.getConta());
		}

		conexao.close();
		stmt.close();

	}

}
