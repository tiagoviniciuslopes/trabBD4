import java.io.BufferedReader;
import java.io.InputStreamReader;

public class simulaTransacao{

	public static void main(String[] args) throws Exception{
		DAO dao = new DAO();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nomeCliente = "Victor Hugo";

		String docCliente = "00978385942";

        int pj = 0;

        String email1 = "victor@gmail.com";
        String email2 = "victor@hotmail.com";

		System.out.println("1 - COMMIT | 0 - ROLLBACK");
        int opc = Integer.parseInt(reader.readLine().trim());
        
        if(opc == 1){
		    dao.cadastrarClienteEmailCommit(nomeCliente, docCliente, pj,email1,email2);
        }else{
            dao.cadastrarClienteEmailRollback(nomeCliente, docCliente, pj,email1,email2);
        }
	}


}
