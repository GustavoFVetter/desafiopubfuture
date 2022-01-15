
public class Despesas {

	/**
	 * Classe criada para determinar as variáveis, método construtor e getters and
	 * setteres de Despesas.
	 */
	int seq;
	String tipoDespesa; // alimentação, educação, lazer, moradia, roupa, saúde,
						// transporte, outros
	double valorDespesa;
	int dataPagto; // formato esperado ddmmaa
	int dataPagtoPrevisto; // formato esperado ddmmaa
	String conta;

	/**
	 * Abaixo criado o contrutor despesas com a definição das suas variáveis.
	 */
	public Despesas(int seq, String tipoDespesa, double valorDaDespesa, int dataPagto, int dataPagtoPrevisto,
			String conta) {
		super();
		this.seq = seq;
		this.tipoDespesa = tipoDespesa;
		this.valorDespesa = valorDaDespesa;
		this.dataPagto = dataPagto;
		this.dataPagtoPrevisto = dataPagtoPrevisto;
		this.conta = conta;
	}

	/**
	 * Abaixo criado o construtor padrão para Despesas
	 * 
	 */
	public Despesas() {

	}

	/**
	 * Abaixo criar os getters and setters de Despesas
	 * 
	 * @return seq -> sequencia numérica das linhas da tabela.
	 * @return tipoDespesa -> tipo de despesa (combustível, alimentação, educação,
	 *         moradia, lazer, roupas, calçados, transporte público, etc...).
	 * @return valorDaDespesa -> valor da despesa.
	 * @return dataPagto -> data que a despesa foi paga. Formato DDMMAA.
	 * @return dataPagtoPrevisto -> data de previsão de pagamento da despesa.
	 *         Formato DDMMAA.
	 * @return conta -> conta da despesa.
	 * 
	 */
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public double getValorDaDespesa() {
		return valorDespesa;
	}

	public void setValorDaDespesa(double valorDaDespesa) {
		this.valorDespesa = valorDaDespesa;
	}

	public int getDataPagto() {
		return dataPagto;
	}

	public void setDataPagto(int dataPagto) {
		this.dataPagto = dataPagto;
	}

	public int getDataPagtoPrevisto() {
		return dataPagtoPrevisto;
	}

	public void setDataPagtoPrevisto(int dataPagtoPrevisto) {
		this.dataPagtoPrevisto = dataPagtoPrevisto;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

}
