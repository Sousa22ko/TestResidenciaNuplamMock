package signuplam.model;

import java.util.Date;

/**
 * Entidade descreve o documento de carteira de trabalho do funcionário
 * 
 * @author Reinaldo Sousa
 * 
 */

public class Ctps extends GenericEntity {

	private static final long serialVersionUID = 8378759123289683164L;

	/**
	 * Numeração da carteira de trabalho
	 */
	private String numero;

	/**
	 * Data em que o documento Ctps foi emitido
	 */
	private Date dataDeEmissao;

	/**
	 * Numeração do Pis na carteira de trabalho
	 */
	private String numeroPis;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataDeEmissao() {
		return dataDeEmissao;
	}

	public void setDataDeEmissao(Date dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}

	public String getNumeroPis() {
		return numeroPis;
	}

	public void setNumeroPis(String numeroPis) {
		this.numeroPis = numeroPis;
	}

}
