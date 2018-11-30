public class Cidade {
	private int idCidade;
	private String nomeCidade;
	private Estado estado = new Estado();
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
}
