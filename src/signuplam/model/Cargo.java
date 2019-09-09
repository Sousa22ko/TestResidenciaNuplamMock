package signuplam.model;

/**
 *
 * Entidade que representa os cargos dos colaboradores do nuplam
 * 
 * @author Reinaldo Sousa
 *
 */

public class Cargo extends GenericEntity {

	private static final long serialVersionUID = 8378759123289683164L;
	/**
	 * Denominação do cargo
	 */
	
	private String denominacao;

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((denominacao == null) ? 0 : denominacao.hashCode());
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
		Cargo other = (Cargo) obj;
		if (denominacao == null) {
			if (other.denominacao != null)
				return false;
		} else if (!denominacao.equals(other.denominacao))
			return false;
		return true;
	}
	
	

}
