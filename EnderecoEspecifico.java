public class EnderecoEspecifico {
	private int idEnderecoEspecifico;
	private String cepEndereco;
	private String numeroEndereco;
	private String complementoEndereco;
	private Endereco endereco = new Endereco();

	public Endereco getEndereco(){
		return this.endereco;
	}
	public void setEndereco(Endereco e){
		this.endereco = e;
	}
	public int getIdEnderecoEspecifico() {
		return idEnderecoEspecifico;
	}
	public void setIdEnderecoEspecifico(int idEnderecoEspecifico) {
		this.idEnderecoEspecifico = idEnderecoEspecifico;
	}
	public String getCepEndereco() {
		return cepEndereco;
	}
	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	public String getComplementoEndereco() {
		return complementoEndereco;
	}
	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}
	
}
