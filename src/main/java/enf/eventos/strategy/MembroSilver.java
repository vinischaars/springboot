package enf.eventos.strategy;

public class MembroSilver implements CalcularDesconto {

	public double percentualDesconto = 0.6; 
	
	@Override
	public double calcularValorDesconto(double valor) {
		return valor * (1 - percentualDesconto);
	}

}
