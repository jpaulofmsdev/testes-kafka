package br.mat.jpaulofms.ms.kafka.teste.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Teste {
	
	private String id;
	private String nome;
	private LocalDateTime dataHora;
	
	public Teste() {
		super();
	}
	public Teste(String id, String nome, LocalDateTime dataHora) {
		setId(id);
		setNome(nome);
		setDataHora(dataHora);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataHora, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teste other = (Teste) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "Teste [id=" + id + ", nome=" + nome + ", dataHora=" + dataHora + "]";
	}

}