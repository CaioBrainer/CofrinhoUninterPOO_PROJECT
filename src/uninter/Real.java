package uninter;

public class Real extends Moeda {

    public Real() {
        this.valor = 0.0;
    }

    /**
     * Imprime no console o nome e valores da moeda presente no cofrinho.
     */
    @Override
    void info() {
        String valorString = String.format("%.2f", valor);
        System.out.printf("| Moeda: Real | Valor: " + valorString + String.valueOf(' ').repeat(
                56 - 23 - valorString.length()) + "|\n" );
    }

    /** Retorna o Valor em Reais [R$]
     * @return valor em Reais [R$]
     */
    @Override
    double converter() { //implementação necessária por conta da classe abstrata moedas
                return valor;
    }
}
