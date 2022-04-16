package br.mat.jpaulofms.ms.kafka.outroteste.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CreateOutroTesteDTO {

	private String outroNome;
	private Boolean outro;
	private List<String> miniTestes;
	
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
	public List<String> getMiniTestes() {
		return miniTestes;
	}
	public void setMiniTestes(List<String> miniTestes) {
		this.miniTestes = miniTestes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(miniTestes, outro, outroNome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateOutroTesteDTO other = (CreateOutroTesteDTO) obj;
		return Objects.equals(miniTestes, other.miniTestes) && Objects.equals(outro, other.outro)
				&& Objects.equals(outroNome, other.outroNome);
	}
	
	@Override
	public String toString() {
		return "CreateOutroTesteDTO [outroNome=" + outroNome + ", outro=" + outro + ", miniTestes=" + miniTestes + "]";
	}
	
	public OutroTeste toModel() {
		OutroTeste model = new OutroTeste();
		model.setOutro(getOutro());
		model.setOutroNome(getOutroNome());		
		Optional.of(getMiniTestes())
			.ifPresent((miniTestes) -> miniTestes.stream().forEach(
					miniTeste -> model.getMiniTestes().add(new MiniTeste(miniTeste))));
		return model;
	}
	
}
