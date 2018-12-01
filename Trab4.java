import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Trab4 {

	public static void main(String[] args) throws Exception{
		DAO dao = new DAO();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Digite o CPF ou CNPJ do cliente: ");
		String docCliente = reader.readLine().trim();
		System.out.println("Digite o mes da fatura: ");
		int mesFatura = Integer.parseInt(reader.readLine().trim());
		System.out.println("Digite o ano da fatura: ");
		int anoFatura = Integer.parseInt(reader.readLine().trim());
		System.out.println("Digite o cep do cliente: ");
		String cep = reader.readLine().trim();
		System.out.println("Digite o numero da casa do cliente: ");
		String num = reader.readLine().trim();

		Cliente c = dao.consultar(docCliente, cep, num);

		System.out.println("---------------FATURA DO MES DE "+getMes(mesFatura).toUpperCase()+"---------------\n");
		System.out.print("Cliente: " + c.getNomeCliente());
		if(c.isPessoaJuridica()){
			System.out.println("\tCNPJ: " +c.getDocumentoCliente() + "\t");
		}else{
			System.out.println("\tCPF: " +c.getDocumentoCliente() + "\t");
		}
		System.out.println("");
		System.out.println("Rua "+c.getHidrometro().getEnderecoEspecifico().getEndereco().getRua().getNomeRua() + ", " +c.getHidrometro().getEnderecoEspecifico().getNumeroEndereco());
		System.out.println("Cep: " + c.getHidrometro().getEnderecoEspecifico().getCepEndereco());
		System.out.println("Complemento: " + c.getHidrometro().getEnderecoEspecifico().getCepEndereco());
		System.out.println("Bairro " +c.getHidrometro().getEnderecoEspecifico().getEndereco().getBairro().getNomeBairro());
		System.out.println(c.getHidrometro().getEnderecoEspecifico().getEndereco().getCidade().getNomeCidade()+", "+ c.getHidrometro().getEnderecoEspecifico().getEndereco().getCidade().getEstado().getNomeEstado());
		System.out.println("");
		System.out.println("Telefones do cliente: ");
		for(Telefone t:c.getTelefones()){
			System.out.println("\t"+t.getNumeroTelefone());
		}
		System.out.println("");
		System.out.println("Emails do cliente: ");
		for(Email e:c.getEmails()){
			System.out.println("\t"+e.getEnderecoEmail());
		}
		
		System.out.println("\n\n---------------GASTOS DO MES---------------\n\n");
		System.out.println("Hidrometro: " + c.getHidrometro().getRegistroHidrometro());
		System.out.println("");

		float totalAgua=0;
		float totalEsgoto=0;
		for(Fatura f:c.getHidrometro().getFaturas()){
			if(f.getMesFatura() == mesFatura && f.getAnoFatura() == anoFatura){
				System.out.println("Metros Cubicos consumidos: "+f.getMetrosCubicos() + "\tPreco por metro cubico: R$"+f.getCustoMetroCubico());
				totalAgua = f.getMetrosCubicos()*f.getCustoMetroCubico();
				if(f.isEsgoto()){
					System.out.println("Custo Esgoto: "+f.getCustoEsgoto());
					totalEsgoto=f.getCustoEsgoto()*f.getMetrosCubicos();
				}
			}
		}

		System.out.println("\n\n---------------HISTORICO DE CONSUMO---------------\n\n");
		for(Fatura f:c.getHidrometro().getFaturas()){
			if((f.getAnoFatura() == anoFatura && f.getMesFatura() < mesFatura) || f.getAnoFatura() < anoFatura){
				System.out.println(getMes(f.getMesFatura()) + " --- "+ f.getAnoFatura()+ " --- " +f.getMetrosCubicos()+" metros cubicos");
			}

		}


		
		System.out.println("\n\n----------------------------------------");
		System.out.println("TOTAL AGUA: R$" + String.format("%.2f",totalAgua) + "\tTOTAL ESGOTO: R$" + String.format("%.2f",totalEsgoto));
		System.out.println("TOTAL: R$" + String.format("%.2f",(totalAgua+totalEsgoto)));

		
	}

	public static String getMes(int i){
		String mes = "";
		switch(i){
			case 1:
				mes = "janeiro";
				break;
			case 2:
				mes = "fevereiro";
				break;
			case 3:
				mes = "marco";
				break;
			case 4:
				mes = "abril";
				break;
			case 5:
				mes = "maio";
				break;
			case 6:
				mes = "junho";
				break;
			case 7:
				mes = "julho";
				break;
			case 8:
				mes = "agosto";
				break;
			case 9:
				mes = "setembro";
				break;
			case 10:
				mes = "outubro";
				break;
			case 11:
				mes = "novembro";
				break;
			case 12:
				mes = "dezembro";
				break;
		}

		return mes;
	}

}
