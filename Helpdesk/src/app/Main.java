package app;
import model.*;
import service.Helpdesk;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static PrioridadeChamado escolherPrioridade(Scanner entrada){
        System.out.println("1 - Baixa | 2 - Média | 3 - Alta");
        int opcao = entrada.nextInt();
        entrada.nextLine();
        if (opcao == 1) return PrioridadeChamado.BAIXA;
        if (opcao == 2) return PrioridadeChamado.MEDIA;
        if (opcao == 3) return PrioridadeChamado.ALTA;
        return null;
    }

    public static StatusChamado alterarStatus (Scanner entrada){
        System.out.println("1 - ABERTO | 2 - EM_ANDAMENTO | 3 - RESOLVIDO | 2 - CANCELADO |");
        int opcao = entrada.nextInt();
        entrada.nextLine();
        if (opcao == 1) return StatusChamado.ABERTO;
        if (opcao == 2) return StatusChamado.EM_ANDAMENTO;
        if (opcao == 3) return StatusChamado.RESOLVIDO;
        if (opcao == 3) return StatusChamado.CANCELADO;
        return null;
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Helpdesk hd = new Helpdesk();

        int opcao;
        do{
            System.out.println("---Sistema HelpDesk---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Abrir Chamado");
            System.out.println("3 - Alterar Status");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao){
                case 1: {
                    System.out.println("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.println("Email: ");
                    String email = entrada.nextLine();
                    hd.cadastrarCliente(nome, email);
                    System.out.println("Cliente cadastrado!");
                    break;
                }
                case 2: {
                    System.out.println("Número do chamado: ");
                    Integer numero = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("Título: ");
                    String titulo = entrada.nextLine();
                    System.out.println("Descrição: ");
                    String descricao = entrada.nextLine();

                    System.out.println("Email do cliente: ");
                    String email = entrada.nextLine();

                    Cliente cli = hd.buscarCliente(email);
                    if (cli == null){
                        System.out.println("Cliente não foi encontrado");
                        break;
                    }
                    entrada.nextLine();

                    PrioridadeChamado prio = escolherPrioridade(entrada);

                    hd.abrirChamado(numero, titulo, descricao, prio, cli);
                    System.out.println("Chamado foi aberto!");
                    break;
                }
                case 3: {
                    //alterar o status de um chamado aberto
                    System.out.printf("digite o numero do chamado");
                    int numero = entrada.nextInt();
                    entrada.nextLine();
                    Chamado ch = hd.buscarChamado(numero);

                    if (ch == null){
                        System.out.printf("Nenhum chamaddo foi aberto");
                        break;
                    }
                    StatusChamado novoStatus = alterarStatus(entrada);
                    hd.alterarStatus(numero, novoStatus);
                    System.out.println("Status alterado com sucesso!");
                }

            }

        } while(opcao != 0);

    }
}
