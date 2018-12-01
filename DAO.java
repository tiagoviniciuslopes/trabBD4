import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	public Cliente consultar(String documentoCliente, String cepEndereco, String numeroEndereco) throws Exception {
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		Cidade cidade = new Cidade();
		Rua rua = new Rua();
		Bairro bairro = new Bairro();
		Estado estado = new Estado();
		Hidrometro hidrometro = new Hidrometro();
		
		ArrayList<Email> emails = new ArrayList<Email>();
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		ArrayList<Fatura> faturas = new ArrayList<Fatura>();
		int i =0;
		
		SQLConnector connector = new SQLConnector();
		String query = "select cliente.*,fatura.idFatura,fatura.mesFatura,fatura.anoFatura,fatura.metrosCubicos,fatura.custoMetroCubico,fatura.esgoto,fatura.custoEsgoto,bairro.nomeBairro,rua.nomeRua,cidade.nomeCidade,cidade.idEstado,estado.nomeEstado,email.idEmail,endereco.idCidade,endereco.idRua,endereco.idBairro,email.enderecoEmail,telefone.idTelefone,telefone.numeroTelefone,hidrometro.idHidrometro,hidrometro.idEnderecoEspecifico,hidrometro.registroHidrometro,enderecoespecifico.numeroEndereco,enderecoespecifico.complemento,enderecoespecifico.idEndereco,enderecoespecifico.cepEndereco from cliente INNER JOIN telefone ON cliente.idCliente=telefone.idCliente INNER JOIN email ON cliente.idCliente=email.idCliente INNER JOIN hidrometro ON hidrometro.idCliente=cliente.idCliente INNER JOIN enderecoespecifico ON enderecoespecifico.idEnderecoEspecifico=hidrometro.idEnderecoEspecifico INNER JOIN endereco ON endereco.idEndereco=enderecoespecifico.idEndereco INNER JOIN bairro ON bairro.idBairro=endereco.idBairro INNER JOIN rua ON rua.idRua=endereco.idRua INNER JOIN cidade ON cidade.idCidade=endereco.idCidade INNER JOIN estado ON estado.idEstado=cidade.idEstado INNER JOIN fatura ON fatura.idHidrometro=hidrometro.idHidrometro where cliente.documentoCliente = '"+documentoCliente+"' AND enderecoespecifico.cepEndereco = '"+cepEndereco+"' AND enderecoespecifico.numeroEndereco = '"+numeroEndereco+"' ORDER BY anoFatura,mesFatura DESC;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Telefone telefone = new Telefone();
			Email email = new Email();
			Fatura fatura = new Fatura();
			
			if(i==0) {
				cliente.setIdCliente(result.getInt("idCliente"));
				cliente.setDocumentoCliente(result.getString("documentoCliente"));
				cliente.setPessoaJuridica(result.getBoolean("pessoaJuridica"));
				cliente.setNomeCliente(result.getString("nomeCliente"));
				enderecoEspecifico.setIdEnderecoEspecifico(result.getInt("idEnderecoEspecifico"));
				enderecoEspecifico.setCepEndereco(result.getString("cepEndereco"));
				enderecoEspecifico.setNumeroEndereco(result.getString("numeroEndereco"));
				enderecoEspecifico.setComplementoEndereco(result.getString("complemento"));
				cidade.setIdCidade(result.getInt("idCidade"));
				cidade.setNomeCidade(result.getString("nomeCidade"));
				estado.setIdEstado(result.getInt("idEstado"));
				estado.setNomeEstado(result.getString("nomeEstado"));
				bairro.setIdBairro(result.getInt("idBairro"));
				bairro.setNomeBairro(result.getString("nomeBairro"));
				rua.setIdRua(result.getInt("idRua"));
				rua.setNomeRua(result.getString("nomeRua"));
				hidrometro.setIdHidrometro(result.getInt("idHidrometro"));
				hidrometro.setRegistroHidrometro(result.getString("registroHidrometro"));
				i++;
			}
			
			telefone.setIdTelefone(result.getInt("idTelefone"));
			telefone.setNumeroTelefone(result.getString("numeroTelefone"));
			email.setIdEmail(result.getInt("idEmail"));
			email.setEnderecoEmail(result.getString("enderecoEmail"));
			fatura.setIdFatura(result.getInt("idFatura"));
			fatura.setCustoEsgoto(result.getFloat("custoEsgoto"));
			fatura.setCustoMetroCubico(result.getFloat("custoMetroCubico"));
			fatura.setEsgoto(result.getBoolean("esgoto"));
			fatura.setMesFatura(result.getInt("mesFatura"));
			fatura.setAnoFatura(result.getInt("anoFatura"));			
			fatura.setMetrosCubicos(result.getInt("metrosCubicos"));
				
			boolean flag=false;
			for(Telefone t:telefones){
				if(t.getIdTelefone()==telefone.getIdTelefone()) flag=true;
			}
			if(!flag)telefones.add(telefone);
			flag=false;

			for(Email e:emails){
				if(e.getIdEmail()==email.getIdEmail()) flag=true;
			}
			if(!flag)emails.add(email);
			flag=false;

			for(Fatura f:faturas){
				if(f.getIdFatura()==fatura.getIdFatura()) flag=true;
			}
			if(!flag)faturas.add(fatura);

		}
		
		cidade.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setRua(rua);
		enderecoEspecifico.setEndereco(endereco);
		hidrometro.setFaturas(faturas);
		hidrometro.setEnderecoEspecifico(enderecoEspecifico);
		cliente.setTelefones(telefones);
		cliente.setEmails(emails);
		cliente.setHidrometro(hidrometro);
		
		connector.close();
		return cliente;
	}
	
}
