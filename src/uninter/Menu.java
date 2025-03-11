package uninter;
import java.util.Scanner;

// Classe menu, implementada utilizando o padrão de desing 'Singleton' apresentado na aula 6.
/**
 * Classe que irá gerar o objeto que exibe o menu com as opções do Cofrinho.
 * */
public class Menu {

    private static Menu instancia = null;
    private boolean encerrar = false;
    private Scanner teclado = new Scanner(System.in);

    // construtor privado da classe
    private Menu() {}

    // metodo estático para criar a instancia..
    public static Menu getInstancia() {
        if (instancia == null) {
                if (instancia == null) {  // Double-check locking
                    instancia = new Menu();
                }
        }
        return instancia;
    }


    /**
     * Exibe o menu com as opções da classe cofrinho.
     * */
    public void exibirMenu(Cofrinho cofrinho) {
        do {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|                   OPÇÕES DO COFRINHO                  |");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("+-------------------------------------------------------+");
            System.out.println("| 1 - Adicionar Moeda                                   |");
            System.out.println("| 2 - Remover Moeda                                     |");
            System.out.println("| 3 - Listas Moedas                                     |");
            System.out.println("| 4 - Total de Moedas em Reais [R$]                     |");
            System.out.println("| 0 - Encerrar Cofrinho                                 |");
            System.out.println("+-------------------------------------------------------+");

            int opcao = 42;
            boolean checagem = false;

            do {
                try {
                    System.out.println("Digite uma opção: ");
                    opcao = teclado.nextInt();
                    checagem = true;

                } catch (Exception InputMismatchException) {
                    System.out.println("Selecione uma opção utilizando os valores inteiros.");
                    teclado.next();
                }
            } while (checagem == false);


            switch (opcao) {
                case 0: {
                    System.out.println("Encerrando o Cofrinho!");
                    encerrar = true;
                    break;
                }

                case 1: {
                    cofrinho.adicionarMoeda();
                    break;
                }

                case 2: {
                    cofrinho.removerMoeda();
                    break;
                }

                case 3: {
                    cofrinho.listarMoedas();
                    break;
                }

                case 4: {
                    cofrinho.listarValorReal();
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (!encerrar);

    }

}
