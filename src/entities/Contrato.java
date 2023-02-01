package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

	private Integer numero;
	private LocalDate data;
	private Double valorTtl;
	private List<Parcela> parcelas = new ArrayList<>();

	public Contrato() {
	}

	public Contrato(Integer numero, LocalDate data, Double valorTtl, List<Parcela> parcelas) {
		this.numero = numero;
		this.data = data;
		this.valorTtl = valorTtl;
		this.parcelas=parcelas;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorTtl() {
		return valorTtl;
	}

	public void setValorTtl(Double valorTtl) {
		this.valorTtl = valorTtl;
	}

}
