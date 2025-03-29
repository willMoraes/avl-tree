import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AvlTree arvore = new AvlTree();

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
    System.out.println("*Lembre-se de adicionar um espaço em branco entre a instrução e o valor.");

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
            System.out.println("Árvore em ordem: " + arvore.printInOrder());
            break;

          case "r":
            if (partes.length != 2) {
              throw new IllegalArgumentException("Comando 'r' requer um valor inteiro.");
            }
            int valorRemover = Integer.parseInt(partes[1]);
            arvore.remove(valorRemover);
            System.out.println("Valor " + valorRemover + " removido.");
            System.out.println("Árvore em ordem: " + arvore.printInOrder());
            break;

          case "b":
            if (partes.length != 2) {
              throw new IllegalArgumentException("Comando 'b' requer um valor inteiro.");
            }
            int valorBuscar = Integer.parseInt(partes[1]);
            System.out.println("Caminho percorrido: ");

            Nodo encontrado = arvore.search(valorBuscar);

            System.out.println();

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
