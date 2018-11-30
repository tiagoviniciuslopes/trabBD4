import java.util.ArrayList;

public class Hidrometro{
    private int idHidrometro;
    private EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
    private String registroHidrometro;
    private ArrayList<Fatura> faturas = new ArrayList<Fatura>();

    public ArrayList<Fatura> getFaturas() {
        return this.faturas;
    }

    public void setFaturas(ArrayList<Fatura> faturas) {
        this.faturas = faturas;
    }

    public int getIdHidrometro() {
        return this.idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return this.enderecoEspecifico;
    }

    public void setEnderecoEspecifico(EnderecoEspecifico enderecoEspecifico) {
        this.enderecoEspecifico = enderecoEspecifico;
    }

    public String getRegistroHidrometro() {
        return this.registroHidrometro;
    }

    public void setRegistroHidrometro(String registroHidrometro) {
        this.registroHidrometro = registroHidrometro;
    }

    
}