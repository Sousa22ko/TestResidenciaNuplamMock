package signuplam.model;

import java.util.Date;

/**
 * Entidade que define o vinculo ao qual o colaborador exerce
 * 
 * @author Reinaldo Sousa
 * 
 */
public class Vinculo extends GenericEntity {

	private static final long serialVersionUID = 8378759123289683164L;

	/**
	 * Status do Vínculo: Ativo ou Inativo
	 */
	private Boolean statusVinculo;

	/**
	 * Define o tipo de vinculo que a pessoa tem com a instituição, podendo ser
	 * estatutario, clt, bolsista, resindente, estagiario
	 */
	private String denominacao;

	/**
	 * Numero da matricula da pessoa
	 */
	private String matricula;

	/**
	 * Data que a pessoa começou as atividades na instituição
	 */
	private Date dataAdmissao;

	/**
	 * Data que a pessoa foi demitida da instituição (pode não existir uma data caso
	 * a pessoa ainda esteja trabalhando, ou não tenha previsão de saida)
	 */
	private Date dataDemissao;

	/**
	 * Referencia do cargo do colaborador
	 */
	private Cargo cargo;

	/**
	 * Referencia a instituição do vinculo. Ex.: FUNPEC, UFRN, SERVIC, CRIART
	 */
	private PessoaJuridica pessoaJuridica;

	/**
	 * Referencia ao setor onde o colaborador trabalha
	 */
	private Setor setor;

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(java.sql.Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Boolean getStatusVinculo() {
		return statusVinculo;
	}

	public void setStatusVinculo(Boolean statusVinculo) {
		this.statusVinculo = statusVinculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + ((dataDemissao == null) ? 0 : dataDemissao.hashCode());
		result = prime * result + ((denominacao == null) ? 0 : denominacao.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((pessoaJuridica == null) ? 0 : pessoaJuridica.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((statusVinculo == null) ? 0 : statusVinculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinculo other = (Vinculo) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (dataDemissao == null) {
			if (other.dataDemissao != null)
				return false;
		} else if (!dataDemissao.equals(other.dataDemissao))
			return false;
		if (denominacao == null) {
			if (other.denominacao != null)
				return false;
		} else if (!denominacao.equals(other.denominacao))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (pessoaJuridica == null) {
			if (other.pessoaJuridica != null)
				return false;
		} else if (!pessoaJuridica.equals(other.pessoaJuridica))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (statusVinculo == null) {
			if (other.statusVinculo != null)
				return false;
		} else if (!statusVinculo.equals(other.statusVinculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vinculo [statusVinculo=" + statusVinculo + ", denominacao=" + denominacao + ", matricula=" + matricula
				+ ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + ", cargo=" + cargo
				+ ", listFuncoes=" + ", pessoaJuridica=" + pessoaJuridica + ", setor=" + setor + "]";
	}

}
