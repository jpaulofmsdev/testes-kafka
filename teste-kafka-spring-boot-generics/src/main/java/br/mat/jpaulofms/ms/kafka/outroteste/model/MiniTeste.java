package br.mat.jpaulofms.ms.kafka.outroteste.model;

import java.util.Objects;

public class MiniTeste {

	private String miniTesteId;
	private String miniTesteNome;
	
	public MiniTeste() {
		this(null);
	}
	
	public MiniTeste(String miniTesteNome) {
		this.miniTesteNome = miniTesteNome;
	}
	public String getMiniTesteId() {
		return miniTesteId;
	}
	public void setMiniTesteId(String miniTesteId) {
		this.miniTesteId = miniTesteId;
	}
	public String getMiniTesteNome() {
		return miniTesteNome;
	}
	public void setMiniTesteNome(String miniTesteNome) {
		this.miniTesteNome = miniTesteNome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(miniTesteId, miniTesteNome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniTeste other = (MiniTeste) obj;
		return Objects.equals(miniTesteId, other.miniTesteId) && Objects.equals(miniTesteNome, other.miniTesteNome);
	}
	@Override
	public String toString() {
		return "MiniTeste [miniTesteId=" + miniTesteId + ", miniTesteNome=" + miniTesteNome + "]";
	}
}
