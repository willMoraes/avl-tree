import java.util.Scanner;

class InstructionHandler {
  public void print() {
    System.out.println("Bem vindo ao sistema de árvore binária!");
    System.out.println("Operações disponíveis: ");
    System.out.println("i - Inserir");
    System.out.println("r - Remover");
    System.out.println("b - Buscar");
    System.out.println("pre - Pré Ordem");
    System.out.println("em - Em Ordem");
    System.out.println("pos - Pós Ordem");
    System.out.println("stop - Encerrar programa");
    System.out.println();
    System.out.println("======================================");
    System.out.println();
    System.out.println("Exemplo de uso:");
    System.out.println("Para inserir o valor 5, digite: i 5");
    System.out.println("Para remover o valor 5, digite: r 5");
    System.out.println("Para buscar o valor 5, digite: b 5");
    System.out.println("Para encerrar o programa, digite: stop");
    System.out.println();
    System.out.println("*Lembre-se de adicionar um espaço em branco entre a instrução e o valor.");
    System.out.println();
    System.out.println("======================================");
    System.out.println();
    System.out.println("Digite a operação desejada: ");
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinarySearchThree arvore = new BinarySearchThree();

    System.out.println("Bem-vindo ao Menu de Árvore Binária!");
    System.out.println("Comandos disponíveis:");
    System.out.println("i {int} - Inserir valor");
    System.out.println("r {int} - Remover valor");
    System.out.println("b {int} - Buscar valor");
    System.out.println("pre - Listar em pré-ordem");
    System.out.println("pos - Listar em pós-ordem");
    System.out.println("em - Listar em ordem");
    System.out.println("stop - Encerrar programa");

    while (true) {
      System.out.print("\nDigite um comando: ");
      String entrada = scanner.nextLine().trim();

      try {
        String[] partes = entrada.split(" ");

        switch (partes[0]) {
          case "i":
            if (partes.length != 2) {
              throw new IllegalArgumentException("Comando 'i' requer um valor inteiro.");
            }
            int valorInserir = Integer.parseInt(partes[1]);
            arvore.insert(valorInserir);
            System.out.println("Valor " + valorInserir + " inserido.");
            break;

          case "r":
            if (partes.length != 2) {
              throw new IllegalArgumentException("Comando 'r' requer um valor inteiro.");
            }
            int valorRemover = Integer.parseInt(partes[1]);
            arvore.remove(valorRemover);
            System.out.println("Valor " + valorRemover + " removido.");
            break;

          case "b":
            if (partes.length != 2) {
              throw new IllegalArgumentException("Comando 'b' requer um valor inteiro.");
            }
            int valorBuscar = Integer.parseInt(partes[1]);
            Nodo encontrado = arvore.search(valorBuscar);

            if (encontrado != null) {
              System.out.println("Valor " + valorBuscar + " encontrado");
            } else {
              System.out.println("Valor " + valorBuscar + " não encontrado");
            }
            break;

          case "pre":
            System.out.print("Árvore em pré-ordem: ");
            System.out.println(arvore.printPreOrder());
            break;

          case "pos":
            System.out.print("Árvore em pós-ordem: ");
            System.out.println(arvore.printPostOrder());

            break;

          case "em":
            System.out.print("Árvore em ordem: ");
            System.out.println(arvore.printInOrder());

            break;

          case "stop":
            System.out.println("Encerrando o programa...");
            scanner.close();
            System.exit(0);

          default:
            System.out.println("Comando inválido. Tente novamente.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Erro: Valor inválido. Certifique-se de usar um número inteiro.");
      } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }
}
