import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceitasConsultarDadosTabelaPorData {

	/**
	 * Método para listar as receitas, onde o usuário determina os parâmetros de
	 * data inicial e data final para criar a lista de receitas.
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Scanner leia = new Scanner(System.in);

		Connection conexao = FazerConexao.getConexao();

		String sql = "select * from receitas where dataRecebimento like ?";

		System.out.println("Informe a data inicial da consulta (formato DDMMA): ");
		String dataInicial = leia.next();
		System.out.println("Informe a data final da consulta (formato DDMMA): ");
		String dataFinal = leia.next();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, dataInicial);
		stmt.setString(2, dataFinal);
		ResultSet listaConsulta = stmt.executeQuery();

		List<Receitas> listaReceitas = new ArrayList<>();

		while (listaConsulta.next()) {
			int seq = listaConsulta.getInt("Seq");
			String descricaoReceita = listaConsulta.getString("Descrição da receita");
			double valorDaReceita = listaConsulta.getDouble("Valor da receita");
			int dataRecebimento = listaConsulta.getInt("Data do Recebimento");
			int dataRecebimentoPrevisto = listaConsulta.getInt("Data Prevista do Recebimento");
			String conta = listaConsulta.getString("Conta");
			String tipoReceita = listaConsulta.getString("Tipo de Receita");
			listaReceitas.add(new Receitas(seq, tipoReceita, descricaoReceita, valorDaReceita, dataRecebimento,
					dataRecebimentoPrevisto, conta));
		}

		for (Receitas receita : listaReceitas) {
			System.out.println("Seq " + receita.getSeq() + "Descrição da Receita " + receita.getDescricaoReceita()
					+ "Valor da receita R$ " + receita.getValorDaReceita() + "Data do Recebimento "
					+ receita.getDataRecebimento() + "Data Prevista do Recebimento "
					+ receita.getDataRecebimentoPrevisto() + "Conta " + receita.getConta() + "Tipo de Receita "
					+ receita.getTipoReceita());
		}

		leia.close();
		conexao.close();
		stmt.close();
	}
}
