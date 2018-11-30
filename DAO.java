import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	public Cliente consultar(String cpfCliente, String mesFatura, String numeroTelefone) throws Exception {
		Cliente cliente = new Cliente();
		Fatura fatura = new Fatura();
		Endereco endereco = new Endereco();
		Telefone telefone = new Telefone();
		Cidade cidade = new Cidade();
		Rua rua = new Rua();
		Bairro bairro = new Bairro();
		Area area = new Area();
		Estado estado = new Estado();
		Plano plano = new Plano();
		
		ArrayList<Chamada> chamadas = new ArrayList<Chamada>();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		int i =0;
		
		SQLConnector connector = new SQLConnector();
		String query = "SELECT cliente.*,bairro.*,rua.*,estado.*,area.*,cidade.idCidade, cidade.nomeCidade,endereco.cepEndereco, endereco.numeroEndereco, endereco.complementoEndereco,telefone.idTelefone, telefone.numeroTelefone,plano.*,servico.*,chamada.*,faturaServico.mesServico, faturaServico.quantidadeServico,fatura.dataVencimentoFatura, fatura.mesFatura FROM cliente INNER JOIN endereco ON endereco.idEndereco = cliente.idEndereco INNER JOIN bairro ON bairro.idBairro=endereco.idBairro INNER JOIN rua ON rua.idRua = endereco.idRua INNER JOIN cidade ON cidade.idCidade = endereco.idCidade INNER JOIN estado ON estado.idEstado = cidade.idEstado INNER JOIN telefone ON cliente.idCliente = telefone.idCliente INNER JOIN area ON telefone.idArea = area.idArea INNER JOIN fatura ON fatura.idTelefone = telefone.idTelefone INNER JOIN plano ON fatura.idPlano = plano.idPlano INNER JOIN chamada ON fatura.idFatura = chamada.idFatura INNER JOIN faturaServico ON fatura.idFatura = faturaServico.idFatura INNER JOIN servico ON faturaServico.idServico = servico.idServico  WHERE fatura.mesFatura = '"+mesFatura+"' AND cliente.cpfCliente = '"+cpfCliente+"' AND telefone.numeroTelefone = '"+numeroTelefone+"';";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Chamada chamada = new Chamada();
			Servico servico = new Servico();
			if(i==0) {
				cliente.setIdCliente(result.getInt("idCliente"));
				cliente.setCpfCliente(result.getString("cpfCliente"));
				cliente.setRgCliente(result.getString("rgCliente"));
				cliente.setNomeCliente(result.getString("nomeCliente"));
				endereco.setIdEndereco(result.getInt("idEndereco"));
				endereco.setCepEndereco(result.getString("cepEndereco"));
				endereco.setNumeroEndereco(result.getString("numeroEndereco"));
				endereco.setComplementoEndereco(result.getString("complementoEndereco"));
				cidade.setIdCidade(result.getInt("idCidade"));
				cidade.setNomeCidade(result.getString("nomeCidade"));
				estado.setIdEstado(result.getInt("idEstado"));
				estado.setNomeEstado(result.getString("nomeEstado"));
				area.setIdArea(result.getInt("idArea"));
				area.setCodigoArea(result.getString("codigoArea"));
				bairro.setIdBairro(result.getInt("idBairro"));
				bairro.setNomeBairro(result.getString("nomeBairro"));
				rua.setIdRua(result.getInt("idRua"));
				rua.setNomeRua(result.getString("nomeRua"));
				telefone.setIdTelefone(result.getInt("idTelefone"));
				telefone.setNumeroTelefone(result.getString("numeroTelefone"));
				fatura.setIdFatura(result.getInt("idFatura"));
				fatura.setData(result.getString("dataVencimentoFatura"));
				fatura.setMesFatura(result.getString("mesFatura"));
				plano.setIdPlano(result.getInt("idPlano"));
				plano.setNomePlano(result.getString("nomePlano"));
				plano.setPrecoPlano(result.getFloat("precoPlano"));
				i++;
			}
			
			servico.setIdServico(result.getInt("idServico"));
			servico.setMesServico(result.getString("mesServico"));
			servico.setNomeServico(result.getString("nomeServico"));
			servico.setPrecoServico(result.getFloat("precoServico"));
			servico.setQuantidadeServico(result.getInt("quantidadeServico"));
			chamada.setData(result.getString("dataChamada"));
			chamada.setPrecoChamada(result.getFloat("precoChamada"));
			chamada.setTelefone1(telefone);
			chamada.setTelefone2(consultar(result.getInt("idTelefone2")));
			chamada.setHoraChamada(result.getTime("horaChamada").toLocalTime());
				
			Servico aux=null;
			
			for (Servico s:servicos) {
				if(s.getIdServico()==servico.getIdServico()){
					aux = s;
				}
			}
			servicos.remove(aux);
			
			servicos.add(servico);
			chamadas.add(chamada);		
		}
		
		fatura.setServico(servicos);
		fatura.setChamada(chamadas);
		fatura.setPlano(plano);
		fatura.setTelefone(telefone);
		telefone.setArea(area);
		cidade.setArea(area);
		cidade.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setRua(rua);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setFatura(fatura);
		
		connector.close();
		return cliente;
	}
	
	public Telefone consultar(int id) throws Exception{
		Telefone telefone = new Telefone();
		Area area = new Area();
		SQLConnector connector = new SQLConnector();
		String query = "SELECT * FROM telefone INNER JOIN area ON telefone.idArea=area.idArea WHERE idTelefone = "+id+";";
		ResultSet result = connector.executeQuery(query);
		while (result.next()) {
			telefone.setIdTelefone(result.getInt("idTelefone"));
			telefone.setNumeroTelefone(result.getString("numeroTelefone"));
			area.setIdArea(result.getInt("idArea"));
			area.setCodigoArea(result.getString("codigoArea"));
			telefone.setArea(area);	
		}
		return telefone;
	}
}
