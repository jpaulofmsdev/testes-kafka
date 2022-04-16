package br.mat.jpaulofms.ms.kafka.teste.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TesteSemNome {

	private String id;
	private LocalDateTime dataHora;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataHora, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteSemNome other = (TesteSemNome) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "TesteSemNome [id=" + id + ", dataHora=" + dataHora + "]";
	}
	
}
