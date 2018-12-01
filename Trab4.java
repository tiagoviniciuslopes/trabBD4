import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Trab4 {

	public static void main(String[] args) throws Exception{
		DAO dao = new DAO();
		Cliente c = dao.consultar("09722879901", "85867530", "23");


		System.out.println("CLIENTE");
		System.out.println(c.getIdCliente());
		System.out.println(c.getNomeCliente());
		System.out.println(c.getPessoaJuridica());

		System.out.println("EMAILS");
		for(Email e:c.getEmails()){
			System.out.println(e.getEnderecoEmail());
		}
		System.out.println("TELEFONES");
		for(Telefone t:c.getTelefones()){
			System.out.println(t.getNumeroTelefone());
		}

		System.out.println("HIDROMETRO");
		Hidrometro h = c.getHidrometro();
		System.out.println(h.getRegistroHidrometro());

		System.out.println("FATURAS");
		for(Fatura f:h.getFaturas()){
			System.out.println(f.getIdFatura());
			System.out.println(f.getMesFatura());
		}

		System.out.println("ENDERECO");
		EnderecoEspecifico ee = h.getEnderecoEspecifico();
		System.out.println(ee.getCepEndereco());
		System.out.println(ee.getNumeroEndereco());
		Endereco e = ee.getEndereco();

		Cidade ci = e.getCidade();
		System.out.println("CIDADE");
		System.out.println(ci.getNomeCidade());

		Estado es = ci.getEstado();
		System.out.println("ESTADO");
		System.out.println(es.getNomeEstado());

		Rua ru = e.getRua();
		System.out.println("RUA");
		System.out.println(ru.getNomeRua());

		Bairro ba = e.getBairro();
		System.out.println("BAIRRO");
		System.out.println(ba.getNomeBairro());

		
	}

}
