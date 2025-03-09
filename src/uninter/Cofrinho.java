package uninter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cofrinho {
    private ArrayList<Moeda> listaMoedas;

    public Cofrinho(ArrayList<Moeda> listaMoedas) {
        this.listaMoedas = listaMoedas;
    }

    /**
     * Adiciona um valor 'n' de uma moeda específica no cofrinho.
     * */
    public void adicionarMoeda() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                    OPÇÕES DO MOEDAS                   |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 0 - Real [R$]                                         |");
        System.out.println("| 1 - Euro [€]                                          |");
        System.out.println("| 2 - Dolar [$]                                         |");
        System.out.println("+-------------------------------------------------------+");

        try {
            // Seleção de opção e valor com validação para impedir erros
            int opcao = 42;
            boolean validacaoOpcao = false;
            do {
                try {
                    System.out.println("Selecione uma moeda para adicionar: ");
                    opcao = teclado.nextInt();

                    if (opcao < 0 || opcao > 2) {
                        System.out.println("Opção inválida");
                        System.out.println("Digite uma opção válida: ");
                        opcao = teclado.nextInt();
                    } else {
                        validacaoOpcao = true;
                    }

                } catch (Exception InputMismatchException) {
                    System.out.println("Digite um valor inteiro ou decimal!");
                    teclado.next();
                }
            }    while (!validacaoOpcao);


            double valor;
            boolean validacao = false;
            do {
                try {
                    System.out.println("Selecione o valor para adicionar: ");
                    valor = teclado.nextDouble();

                    if (valor < 0) {
                        System.out.println("Digite um valor inteiro ou decimal não negativo!");
                    } else {
                        if (opcao == 0) {
                            listaMoedas.get(0).valor += valor;
                        } else if (opcao == 1) {
                            listaMoedas.get(1).valor += valor;
                        } else {
                            listaMoedas.get(2).valor += valor;
                        }
                        System.out.println("Valor adicionado com sucesso");
                        validacao = true;
                    }

                } catch (Exception InputMismatchException) {
                    System.out.println("Digite um valor inteiro ou decimal!");
                    teclado.next();
                }
            } while (!validacao);


        } catch (Exception e) {
            System.out.println("Erro Insperado: " + e.getMessage());
        }
    }

    /**
     * Rremove um valor 'n' a uma moeda específica no cofrinho.
     * */
    public void removerMoeda() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                    OPÇÕES DO MOEDAS                   |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| 0 - Real [R$]                                         |");
        System.out.println("| 1 - Euro [€]                                          |");
        System.out.println("| 2 - Dolar [$]                                         |");
        System.out.println("+-------------------------------------------------------+");

        try {
            // Seleção de opção e valor com validação para impedir erros
            System.out.println("Selecione uma moeda para adicionar: ");
            int opcao = teclado.nextInt();
            while (opcao < 0 || opcao > 2) {
                System.out.println("Opção inválida");
                System.out.println("Digite uma opção válida: ");
                opcao = teclado.nextInt();
            }

            System.out.println("Selecione o valor para retirado: ");
            double valor = teclado.nextDouble();
            while (valor < 0) {
                System.out.println("Valor inválida");
                System.out.println("Digite um valor positivo: ");
                valor = teclado.nextDouble();
            }

            if (opcao == 0) { // Real
                if (listaMoedas.get(0).valor - valor < 0) {
                    System.out.println("Saldo insuficiente");
                } else {
                    listaMoedas.get(0).valor -= valor;
                }
            } else if (opcao == 1) { // Euro
                if (listaMoedas.get(1).valor - valor < 0) {
                    System.out.println("Saldo insuficiente");
                } else {
                    listaMoedas.get(1).valor -= valor;
                }
            } else { // Dólar
                if (listaMoedas.get(2).valor - valor < 0) {
                    System.out.println("Saldo insuficiente");
                } else {
                    listaMoedas.get(2).valor -= valor;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro Insperado: " + e.getMessage());
        }
    }

    /**
    * Lista as moedas no cofrinho e seus respectivos valores.
    * */
    public void listarMoedas() {
        System.out.println("+-------------------------------------------------------+"); // 57 chars
        System.out.println("|                   MOEDAS NO COFRINHO                  |");
        System.out.println("+-------------------------------------------------------+");
        for(Moeda m: listaMoedas) {
            m.info();
        }
        System.out.println("+-------------------------------------------------------+\n\n");
    }

    /**
     * Lista o valor total das moedas no cofrinho cinvertido em real [R$].
     * */
    public void listarValorReal() {
        System.out.println("+-------------------------------------------------------+"); // 57 chars
        System.out.println("|                TOTAL DE MOEDAS EM REAIS               |");
        System.out.println("+-------------------------------------------------------+");
        double total = 0;
        for(Moeda m: listaMoedas) {
            total += m.converter();
        }
        String valorString = String.format("%.2f", total);
        System.out.printf("| Total de moedas em Reais [R$]: " + valorString + String.valueOf(' ').repeat(
                56 - 33 - valorString.length()) + "|\n" );
        System.out.println("+-------------------------------------------------------+\n\n");
    }
}
