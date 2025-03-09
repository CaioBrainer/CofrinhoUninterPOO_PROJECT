package uninter;

public class Euro extends Moeda{

    public Euro() {
        this.valor = 0.0;
    }

    /**
     * Imprime no console o nome e valores da moeda presente no cofrinho.
     */
    @Override
    void info() {
        String valorString = String.format("%.2f", valor);
        System.out.printf("| Moeda: Euro | Valor: " + valorString + String.valueOf(' ').repeat(
                56 - 23 - valorString.length()) + "|\n" );
    }

    /** Retorna o Valor em Reais [R$]
     * @return valor em Reais [R$]
     */
    @Override
    double converter() {
        return valor*6.26;
    }
}
