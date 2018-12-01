import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Fatura {
	private int idFatura;
	private int mesFatura;
	private int anoFatura;

	public int getMesFatura() {
		return this.mesFatura;
	}

	public void setMesFatura(int mesFatura) {
		this.mesFatura = mesFatura;
	}

	public int getAnoFatura() {
		return this.anoFatura;
	}

	public void setAnoFatura(int anoFatura) {
		this.anoFatura = anoFatura;
	}
	private int metrosCubicos;
	private float custoMetroCubico;
	private boolean esgoto;
	private float custoEsgoto;
	

	public int getIdFatura() {
		return this.idFatura;
	}

	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
	}

	public int getMetrosCubicos() {
		return this.metrosCubicos;
	}

	public void setMetrosCubicos(int metrosCubicos) {
		this.metrosCubicos = metrosCubicos;
	}

	public float getCustoMetroCubico() {
		return this.custoMetroCubico;
	}

	public void setCustoMetroCubico(float custoMetroCubico) {
		this.custoMetroCubico = custoMetroCubico;
	}

	public boolean isEsgoto() {
		return this.esgoto;
	}

	public boolean getEsgoto() {
		return this.esgoto;
	}

	public void setEsgoto(boolean esgoto) {
		this.esgoto = esgoto;
	}

	public float getCustoEsgoto() {
		return this.custoEsgoto;
	}

	public void setCustoEsgoto(float custoEsgoto) {
		this.custoEsgoto = custoEsgoto;
	}
	
	
	
}
