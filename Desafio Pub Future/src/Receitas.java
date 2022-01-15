
public class Receitas {

	/**
	 * Classe criada para determinar as variáveis, método construtor e getters and
	 * setteres de Receitas.
	 */
	int seq; // nr para sequenciar a lista de receitas
	String descricaoReceita;
	double valorDaReceita;
	int dataRecebimento; // formato esperado ddmmaa
	int dataRecebimentoPrevisto; // formato esperado dddmmaa
	String conta;
	String tipoReceita; // salário, presente, prêmio, outros

	/**
	 * Abaixo criar o método construtor de Receitas com a definição de suas
	 * variáveis.
	 */
	public Receitas(int seq, String tipoReceita, String descricaoReceita, double valorDaReceita, int dataRecebimento,
			int dataRecebimentoPrevisto, String conta) {
		super();
		this.seq = seq;
		this.tipoReceita = tipoReceita;
		this.descricaoReceita = descricaoReceita;
		this.valorDaReceita = valorDaReceita;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoPrevisto = dataRecebimentoPrevisto;
		this.conta = conta;

	}

	/**
	 * Abaixo criar o método construtor padrão para Receitas
	 */
	public Receitas() {
	}

	/**
	 * Abaixo criar métodos getteres and setteres da classe Receitas.
	 * 
	 * @return seq -> sequencia numérica das linhas da tabela.
	 * @return descricaoReceita -> descrição para a receita auferida.
	 * @return valorDaReceita -> valor da receita auferida.
	 * @return dataRecebimento -> data que a receita foi auferida. Formato DDMMAA.
	 * @return dataRecebimentoPrevisto -> data de previsão de entrada da receita
	 *         auferida. Formato DDMMAA.
	 * @return conta -> conta da receita auferida.
	 * @return tipoReceita -> tipo de receita auferida (salário, bônus, presente,
	 *         etc...).
	 */
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public double getValorDaReceita() {
		return valorDaReceita;
	}

	public void setValorDaReceita(double valorDaReceita) {
		this.valorDaReceita = valorDaReceita;
	}

	public int getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(int dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public int getDataRecebimentoPrevisto() {
		return dataRecebimentoPrevisto;
	}

	public void setDataRecebimentoPrevisto(int dataRecebimentoPrevisto) {
		this.dataRecebimentoPrevisto = dataRecebimentoPrevisto;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

}
