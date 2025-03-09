package uninter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Instanciando as moedas do codrinho
        ArrayList<Moeda> minhasMoedas = new ArrayList<>() {{
            add(new Real());
            add(new Euro());
            add(new Dolar());
        }};

        // Criando o objeto Cofrinho
        Cofrinho cofrinho = new Cofrinho(minhasMoedas);

        // Criando o menu
        Menu menu = new Menu();
        menu.exibirMenu(cofrinho);
    }
}