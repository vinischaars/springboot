package enf.eventos.strategy;

public class MembroGold implements CalcularDesconto {

	public double percentualDesconto = 0.75;
	
	@Override
	public double calcularValorDesconto(double valor) {
		return valor * (1 - percentualDesconto); 
	}

}
