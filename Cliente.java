import java.util.ArrayList;

public class Cliente {
	private int idCliente;
	private String documentoCliente;
	private String nomeCliente;
	private boolean pessoaJuridica;
	private Hidrometro hidrometro = new Hidrometro();

	public Hidrometro getHidrometro() {
		return this.hidrometro;
	}

	public void setHidrometro(Hidrometro hidrometro) {
		this.hidrometro = hidrometro;
	}
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Email> emails = new ArrayList<Email>();

	public ArrayList<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}

	public ArrayList<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(ArrayList<Email> emails) {
		this.emails = emails;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDocumentoCliente() {
		return documentoCliente;
	}
	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}
	public void setPessoaJuridica(boolean pj){
		this.pessoaJuridica = pj;
	}
	public boolean getPessoaJuridica(){
		return this.pessoaJuridica;
	}
	public boolean isPessoaJuridica(){
		return this.pessoaJuridica;
	}
	
}
