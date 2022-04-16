package br.mat.jpaulofms.ms.kafka.outroteste.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OutroTeste {

	private String outroId;
	
	private String outroNome;
	
	private Boolean outro;
	
	private List<MiniTeste> miniTestes = new ArrayList<>();

	public String getOutroId() {
		return outroId;
	}

	public void setOutroId(String outroId) {
		this.outroId = outroId;
	}

	public String getOutroNome() {
		return outroNome;
	}

	public void setOutroNome(String outroNome) {
		this.outroNome = outroNome;
	}

	public Boolean getOutro() {
		return outro;
	}

	public void setOutro(Boolean outro) {
		this.outro = outro;
	}

	public List<MiniTeste> getMiniTestes() {
		return miniTestes;
	}

	public void setMiniTestes(List<MiniTeste> miniTestes) {
		this.miniTestes = miniTestes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(miniTestes, outro, outroId, outroNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutroTeste other = (OutroTeste) obj;
		return Objects.equals(miniTestes, other.miniTestes) && Objects.equals(outro, other.outro)
				&& Objects.equals(outroId, other.outroId) && Objects.equals(outroNome, other.outroNome);
	}

	@Override
	public String toString() {
		return "OutroTeste [outroId=" + outroId + ", outroNome=" + outroNome + ", outro=" + outro + ", miniTestes="
				+ miniTestes + "]";
	}
}
