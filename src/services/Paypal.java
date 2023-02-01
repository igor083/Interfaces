package services;

public class Paypal implements ServicoPagamentoOnline{
	@Override
	public Double taxaPagamento(Double valor) {
		return valor*0.02;
	}
	
	@Override
	public Double juros (Double valor,Integer meses) {
		return 0.01*valor*meses;
	}
}
