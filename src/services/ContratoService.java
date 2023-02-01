package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Parcela;

public class ContratoService {
	private ServicoPagamentoOnline servicoOline;

	public ContratoService(ServicoPagamentoOnline servicoOline) {
		this.servicoOline = servicoOline;
	}

	public void processaContrato(Contrato contrato, Integer meses) {
		Double parcelaBase = contrato.getValorTtl() / meses;

		for (int i = 1; i <= meses; i++) {
			LocalDate vencimento = contrato.getData().plusMonths(i);
			double juros = servicoOline.juros(parcelaBase, i);
			double taxas = servicoOline.taxaPagamento(juros + parcelaBase);
			double parcelaTotal = taxas + juros + parcelaBase;

			contrato.getParcelas().add(new Parcela(vencimento, parcelaTotal));
		}
	}

	public ServicoPagamentoOnline getServicoOline() {
		return servicoOline;
	}

}
