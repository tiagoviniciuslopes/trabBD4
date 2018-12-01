import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	public Cliente consultar(String documentoCliente, String cepEndereco, String numeroEndereco) throws Exception {
		Cliente cliente = new Cliente();
		Fatura fatura = new Fatura();
		Endereco endereco = new Endereco();
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		Hidrometro hidrometro = new Hidrometro();
		Cidade cidade = new Cidade();
		Rua rua = new Rua();
		Bairro bairro = new Bairro();
		Estado estado = new Estado();
		
		ArrayList<Email> emails = new ArrayList<Email>();
		ArrayList<Telefone> telefones = new ArrayList<Telefones>();
		int i =0;
		
		SQLConnector connector = new SQLConnector();
		String query = "select cliente.*,bairro.nomeBairro,rua.nomeRua,cidade.nomeCidade,cidade.idEstado,estado.nomeEstado,email.idEmail,endereco.idCidade,endereco.idRua,endereco.idBairro,email.enderecoEmail,telefone.idTelefone,telefone.numeroTelefone,hidrometro.idHidrometro,hidrometro.idEnderecoEspecifico,hidrometro.registroHidrometro,enderecoespecifico.numeroEndereco,enderecoespecifico.complemento,enderecoespecifico.idEndereco,enderecoespecifico.cepEndereco from cliente INNER JOIN telefone ON cliente.idCliente=telefone.idCliente INNER JOIN email ON cliente.idCliente=email.idCliente INNER JOIN hidrometro ON hidrometro.idCliente=cliente.idCliente INNER JOIN enderecoespecifico ON enderecoespecifico.idEnderecoEspecifico=hidrometro.idEnderecoEspecifico INNER JOIN endereco ON endereco.idEndereco=enderecoespecifico.idEndereco INNER JOIN bairro ON bairro.idBairro=endereco.idBairro INNER JOIN rua ON rua.idRua=endereco.idRua INNER JOIN cidade ON cidade.idCidade=endereco.idCidade INNER JOIN estado ON estado.idEstado=cidade.idEstado where cliente.documentoCliente = '"+documentoCliente+"' AND enderecoespecifico.cepEndereco = '"+cepEndereco+"' AND enderecoespecifico.numeroEndereco = '"+numeroEndereco+"';";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Telefone telefone = new Telefone();
			Email email = new Email();
			if(i==0) {
				cliente.setIdCliente(result.getInt("idCliente"));
				cliente.setDocumentoCliente(result.getString("documentoCliente"));
				cliente.setPessoaJuridica(result.getBoolean("pessoaJuridia"));
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
				i++;
			}
			
			telefone.setIdTelefone(result.getInt("idTelefone"));
			telefone.setNumeroTelefone(result.getString("numeroTelefone"));
			email.setIdEmail(result.getInt("idEmail"));
			email.setEnderecoEmail(result.getString("enderecoEmail"));
			hidrometro.setIdHidrometro(result.getInt("idHidrometro"));
			hidrometro.setRegistroHidrometro(result.getString("registroHidrometro"));
			fatura.setIdFatura(result.getInt("idFatura"));
			fatura.setCustoEsgoto(result.getFloat("custoEsgoto"));
			fatura.setCustoMetroCubico(result.getFloat("custoMetroCubico"));
			fatura.setEsgoto(result.getBoolean("esgoto"));
			fatura.setMesFatura(result.getString("mesFatura"));			
			fatura.setMetrosCubicos(result.getInt("metrosCubicos"));
				

			for(Telefone t:telefones){
				if(t.getIdTelefone()==telefone.getIdTelefone()) telefones.remove(t);
			}
			telefones.add(telefone);
			for(Email t:emails){
				if(t.getIdEmail()==email.getIdEmail()) emails.remove(t);
			}
			emails.add(email);
			for(Fatura t:faturas){
				if(t.getIdFatura()==fatura.getIdFatura()) faturas.remove(t);
			}
			faturas.add(fatura);

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
		cliente.setHidrometros(hidrometros);
		
		connector.close();
		return cliente;
	}
	
}
