public class Endereco {
	private int idEndereco;
	private Bairro bairro = new Bairro();
	private Rua rua = new Rua();
	private Cidade cidade = new Cidade();
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Rua getRua() {
		return rua;
	}
	public void setRua(Rua rua) {
		this.rua = rua;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	
}
