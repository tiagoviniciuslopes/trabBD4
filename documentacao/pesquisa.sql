select cliente.*,bairro.nomeBairro,rua.nomeRua,cidade.nomeCidade,cidade.idEstado,estado.nomeEstado,email.idEmail,endereco.idCidade,endereco.idRua,endereco.idBairro,
email.enderecoEmail,telefone.idTelefone,telefone.numeroTelefone,hidrometro.idHidrometro,hidrometro.idEnderecoEspecifico,hidrometro.registroHidrometro,
enderecoespecifico.numeroEndereco,enderecoespecifico.complemento,enderecoespecifico.idEndereco,enderecoespecifico.cepEndereco from cliente 
INNER JOIN telefone ON cliente.idCliente=telefone.idCliente 
INNER JOIN email ON cliente.idCliente=email.idCliente 
INNER JOIN hidrometro ON hidrometro.idCliente=cliente.idCliente 
INNER JOIN enderecoespecifico ON enderecoespecifico.idEnderecoEspecifico=hidrometro.idEnderecoEspecifico 
INNER JOIN endereco ON endereco.idEndereco=enderecoespecifico.idEndereco 
INNER JOIN bairro ON bairro.idBairro=endereco.idBairro 
INNER JOIN rua ON rua.idRua=endereco.idRua 
INNER JOIN cidade ON cidade.idCidade=endereco.idCidade 
INNER JOIN estado ON estado.idEstado=cidade.idEstado 
where cliente.documentoCliente = '09722879901' 
AND enderecoespecifico.cepEndereco = '85867530' 
AND enderecoespecifico.numeroEndereco = '23';