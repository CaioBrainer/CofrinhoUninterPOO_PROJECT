package uninter;

public class Dolar extends Moeda{

    public Dolar() {
        this.valor = 0.0;
    }

    /**
     * Imprime no console o nome e valores da moeda presente no cofrinho.
     */
    @Override
    void info() {
        String valorString = String.format("%.2f", valor);
        System.out.printf("| Moeda: Dólar | Valor: " + valorString + String.valueOf(' ').repeat(
                55 - 23 - valorString.length()) + "|\n" );
    }

    /** Retorna o valor convetido de Dolar para Reais
     * @return Valor convertido em Reais [R$]
     */
    @Override
    double converter() {
        return valor * 5.68;
    }
}
