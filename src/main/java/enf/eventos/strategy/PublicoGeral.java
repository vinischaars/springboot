package enf.eventos.strategy;

public class PublicoGeral implements CalcularDesconto {

	@Override
	public double calcularValorDesconto(double valor) {
		return valor;
	}

}
